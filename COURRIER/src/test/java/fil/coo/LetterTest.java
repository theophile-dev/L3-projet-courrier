package fil.coo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fil.coo.content.Content;
import fil.coo.letter.AcknowledgementOfReceipt;
import fil.coo.letter.DecoratingLetter;
import fil.coo.letter.Letter;
import fil.coo.letter.RegisteredLetter;

public abstract class LetterTest {

	private Inhabitant sender;
	private Inhabitant recipient;
	private City city;
	private Letter<?> testedLetter;

	public abstract Letter<?> getTestedLetter();

	/**
	 * Create: the recipient, the sender and the city in which they live for the
	 * testedLetter
	 */
	@Before
	public void letterSetup() {
		this.city = new City("cityTest");
		this.recipient = new Inhabitant("recipientTest", city, 10);
		this.sender = new Inhabitant("senderTest", city, 10);
		this.testedLetter = this.getTestedLetter();
	}

	public City getCity() {
		return city;
	}

	public Inhabitant getSender() {
		return sender;
	}

	public Inhabitant getRecipient() {
		return recipient;
	}

	@Test
	public void receivedLetterDoesAction() {
		InstrumentedLetter instrumentedLetter = new InstrumentedLetter(this.testedLetter);
		assertEquals(instrumentedLetter.getActionCounter(), 0);
		instrumentedLetter.getReceiver().receiveLetter(instrumentedLetter);
		assertEquals(instrumentedLetter.getActionCounter(), 1);
	}

	@Test
	public void acknowledgmentLetterSentTest() {
		City city = this.getCity();
		int numberOfPostedLetter = city.getMailBox().size();
		assertEquals("No letter should be posted yet", 0, numberOfPostedLetter);
		this.getSender().sendLetter(new RegisteredLetter(this.getTestedLetter()));
		city.distributeLetter();
		numberOfPostedLetter = city.getMailBox().size();
		assertEquals("There should be an AcknowledgementOfReceipt in the mailBox", 1, numberOfPostedLetter);
		Letter<?> letterInTheMailBox = this.getCity().getMailBox().get(0);
		assertTrue("The letter in the mailBox should be an instance of an AcknowledgementOfReceipt",
				letterInTheMailBox instanceof AcknowledgementOfReceipt);
	}

	public class InstrumentedLetter extends DecoratingLetter {

		private int actionCounter = 0;

		public InstrumentedLetter(Letter<?> insideLetter) {
			super(insideLetter, "Instrumented Letter");
		}

		public int getActionCounter() {
			return this.actionCounter;
		}

		@Override
		public void action() {
			super.action();
			this.actionCounter++;

		}

		@Override
		public Content copyContent() {
			return new InstrumentedLetter((Letter<?>) this.getContent().copyContent());
		}

	}
}

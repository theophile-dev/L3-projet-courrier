package fil.coo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public abstract class LetterTest {

	public abstract Letter<?> getTestedLetter();

	private Inhabitant sender;
	private Inhabitant recipient;
	private City city;
	private Letter<?> testedLetter;

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

	public class InstrumentedLetter extends DecoratingLetter {

		private int actionCounter = 0;

		public InstrumentedLetter(Letter<?> insideLetter) {
			super(insideLetter);
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

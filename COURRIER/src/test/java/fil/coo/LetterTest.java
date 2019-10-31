package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class LetterTest {

	public abstract Letter<?> getTestedLetter();
	
	private Inhabitant sender;
	private Inhabitant recipient;
	private City city;
	private Letter<?> testedLetter;
	
	/**
	 * Create: the recipient, the sender and the city in which they live for the testedLetter
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
		InstrumentedLetter<?> instrumentedLetter = new InstrumentedLetter<>(this.testedLetter);
		assertEquals(instrumentedLetter.getActionCounter(), 0);
		instrumentedLetter.getReceiver().receiveLetter(instrumentedLetter);
		assertEquals(instrumentedLetter.getActionCounter(), 1);
	}
	
	public class InstrumentedLetter<T extends Content> extends Letter<T> {

		private Letter<T> containedLetter; 
		private int actionCounter = 0;

		public InstrumentedLetter(Letter<T> letter) {
			super(null,null,null);
			this.containedLetter = letter;
		}
		
		public int getActionCounter() {
			return this.actionCounter;
		}

		@Override
		public void action() {
			this.actionCounter++;
			this.containedLetter.action();
		}

		@Override
		public int getLetterNumber() {
			return this.containedLetter.getLetterNumber();
		}

		@Override
		public Inhabitant getSender() {
			return this.containedLetter.getSender();
		}

		@Override
		public Inhabitant getReceiver() {
			return this.containedLetter.getReceiver();
		}

		@Override
		public T getContent() {
			return this.containedLetter.getContent();
		}

		@Override
		public double getCost() {
			return this.containedLetter.getCost();
		}
		
	}
}

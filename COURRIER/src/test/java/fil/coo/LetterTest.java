package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class LetterTest {

	public abstract Letter<?> getTestedLetter();
	
	@Test
	public void receivedLetterDoesAction() {
		Letter<?> letter = this.getTestedLetter();
		InstrumentedLetter<?> instrumentedLetter = new InstrumentedLetter<>(letter);
		Inhabitant inhabitant = new Inhabitant("inhabitantTest", null, 0);
		assertEquals(instrumentedLetter.getActionCounter(), 0);
		inhabitant.receiveLetter(instrumentedLetter);
		assertEquals(instrumentedLetter.getActionCounter(), 1);
	}
	
	public class InstrumentedLetter<T extends Content> extends Letter<T> {

		private Letter<T> containedLetter; 
		private int actionCounter = 0;

		public InstrumentedLetter(Inhabitant sender, Inhabitant receiver, T content) {
			super(sender, receiver, content);
			fail("This constructor can't be used");
		}
		
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
		public float getCost() {
			return this.containedLetter.getCost();
		}
		
		
		
	}
}

package fil.coo;



import org.junit.Test;

public class BillOfExchangeTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new BillOfExchange(this.getSender(), this.getRecipient(), new Money(3.5));
	}
}

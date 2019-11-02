package fil.coo;

public class BillOfExchangeTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new BillOfExchange(this.getSender(), this.getRecipient(), new Money(3.5));
	}
}

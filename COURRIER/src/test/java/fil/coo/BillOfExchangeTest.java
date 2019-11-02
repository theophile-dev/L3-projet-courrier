package fil.coo;

import fil.coo.content.Money;
import fil.coo.letter.BillOfExchange;
import fil.coo.letter.Letter;

public class BillOfExchangeTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new BillOfExchange(this.getSender(), this.getRecipient(), new Money(3.5));
	}
}

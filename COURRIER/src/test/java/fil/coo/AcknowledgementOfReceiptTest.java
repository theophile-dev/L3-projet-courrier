package fil.coo;

import fil.coo.letter.AcknowledgementOfReceipt;
import fil.coo.letter.Letter;

public class AcknowledgementOfReceiptTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new AcknowledgementOfReceipt(this.getSender(), this.getRecipient());
	}
}

package fil.coo;

public class AcknowledgementOfReceiptTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new AcknowledgementOfReceipt(this.getSender(), this.getRecipient());
	}
}

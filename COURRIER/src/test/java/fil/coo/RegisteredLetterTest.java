package fil.coo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegisteredLetterTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new RegisteredLetter(
				new SimpleLetter(this.getSender(), this.getRecipient(), new Text("letter content")));
	}

	@Test
	public void acknowledgmentLetterSentTest() {
		City city = this.getCity();
		int numberOfPostedLetter = city.getMailBox().size();
		assertEquals("No letter should be posted yet", 0, numberOfPostedLetter);
		this.getSender().sendLetter(this.getTestedLetter());
		city.distributeLetter();
		numberOfPostedLetter = city.getMailBox().size();
		assertEquals("There should be an AcknowledgementOfReceipt in the mailBox", 1, numberOfPostedLetter);
		Letter<?> letterInTheMailBox = this.getCity().getMailBox().get(0);
		assertTrue("The letter in the mailBox should be an instance of an AcknowledgementOfReceipt",
				letterInTheMailBox instanceof AcknowledgementOfReceipt);
	}

}

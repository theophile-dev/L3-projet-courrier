package fil.coo;

public class SimpleLetterTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new SimpleLetter(this.getSender(), this.getRecipient(), new Text("letter content"));
	}

}

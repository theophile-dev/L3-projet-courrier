package fil.coo;

public class UrgentLetterTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new UrgentLetter(new SimpleLetter(this.getSender(), this.getRecipient(), new Text("letter content")));
	}

}

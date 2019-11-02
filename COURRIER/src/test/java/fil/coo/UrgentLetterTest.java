package fil.coo;

import fil.coo.content.Text;
import fil.coo.letter.Letter;
import fil.coo.letter.SimpleLetter;
import fil.coo.letter.UrgentLetter;

public class UrgentLetterTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new UrgentLetter(new SimpleLetter(this.getSender(), this.getRecipient(), "Test Letter", new Text("text letter content test")));
	}

}

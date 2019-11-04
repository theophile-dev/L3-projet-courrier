package fil.coo;

import fil.coo.content.Text;
import fil.coo.letter.Letter;
import fil.coo.letter.SimpleLetter;

public class SimpleLetterTest extends LetterTest {

	@Override
	public Letter<?> getTestedLetter() {
		return new SimpleLetter(this.getSender(), this.getRecipient(), "Test Letter",
				new Text("text letter content test"));
	}

}

package fil.coo.letter;

import fil.coo.Inhabitant;
import fil.coo.content.Content;
import fil.coo.content.Text;

public class SimpleLetter extends Letter<Text> {

	private static final double COST = 2;

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, String letterName, Text content) {
		super(sender, receiver, letterName, content);
		this.setCost(COST);

	}

	/**
	 * SimpleLetter doesn't trigger any action
	 */
	@Override
	public void action() {
		// does nothing
	}

	@Override
	public Content copyContent() {
		return new SimpleLetter(this.getSender(), this.getReceiver(), this.getLetterName(),
				(Text) this.getContent().copyContent());
	}

}

package fil.coo.letter;

import fil.coo.Inhabitant;
import fil.coo.content.Content;
import fil.coo.content.Text;

public class ThankYouLetter extends SimpleLetter {

	public ThankYouLetter(Inhabitant sender, Inhabitant receiver) {
		super(sender, receiver, "Thank You Letter", new Text(
				sender.getName() + " remercie " + receiver.getName() + " pour l'argent qui lui a était envoyé"));
	}

	@Override
	public Content copyContent() {
		return new ThankYouLetter(this.getSender(), this.getReceiver());
	}

}

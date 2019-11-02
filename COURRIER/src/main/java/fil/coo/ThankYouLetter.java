package fil.coo;

public class ThankYouLetter extends Letter<Text> {

	public ThankYouLetter(Inhabitant sender, Inhabitant receiver) {
		super(sender, receiver, new Text(
				sender.getName() + " remercie " + receiver.getName() + " pour l'argent qui lui a était envoyé"));
	}

	@Override
	public void action() {
		// does nothing
	}

	@Override
	public Content copyContent() {
		return new ThankYouLetter(this.getSender(), this.getReceiver());
	}

}

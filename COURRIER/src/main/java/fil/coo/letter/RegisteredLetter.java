package fil.coo.letter;

import fil.coo.content.Content;

public class RegisteredLetter extends DecoratingLetter {

	private static final double OVERCOST_FACTOR = 1.15;

	public RegisteredLetter(Letter<?> insideLetter) {
		super(insideLetter, "Registered Letter");
	}

	@Override
	public double getCost() {
		return super.getCost() * RegisteredLetter.OVERCOST_FACTOR;
	}

	@Override
	public void action() {
		AcknowledgementOfReceipt acknowledgementOfReceipt = new AcknowledgementOfReceipt(this.getReceiver(),
				this.getSender());
		this.getReceiver().sendLetter(acknowledgementOfReceipt);
	}

	@Override
	public Content copyContent() {
		return new RegisteredLetter((Letter<?>) (this.getContent().copyContent()));
	}

}

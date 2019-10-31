package fil.coo;

public class RegisteredLetter extends DecoratingLetter {
	
	public static final double OVERCOST_FACTOR = 1.15;

	public RegisteredLetter(Letter<?> insideLetter) {
		super(insideLetter);
	}

	@Override
	public double getCost() {
		return super.getCost() * RegisteredLetter.OVERCOST_FACTOR;
	}
	
	
	@Override
	public void action() {
		AcknowledgementOfReceipt acknowledgementOfReceipt = new AcknowledgementOfReceipt(this.getReceiver(), this.getSender());
		this.getReceiver().sendLetter(acknowledgementOfReceipt);
	}
	
}

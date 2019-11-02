package fil.coo;

public class AcknowledgementOfReceipt extends Letter<Text> {

	public AcknowledgementOfReceipt(Inhabitant sender, Inhabitant receiver) {
		super(sender, receiver,
				new Text(sender.getName() + " accuse la reception de la lettre de " + receiver.getName()));

	}

	@Override
	public void action() {
		// does nothing
	}

	@Override
	public Content copyContent() {
		return new AcknowledgementOfReceipt(this.getSender(), this.getReceiver());
	}

}

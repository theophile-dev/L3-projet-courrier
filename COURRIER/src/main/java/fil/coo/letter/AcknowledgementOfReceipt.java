package fil.coo.letter;

import fil.coo.Inhabitant;
import fil.coo.content.Content;
import fil.coo.content.Text;

public class AcknowledgementOfReceipt extends SimpleLetter {

	public AcknowledgementOfReceipt(Inhabitant sender, Inhabitant receiver) {
		super(sender, receiver, "Acknowledgement Of Receipt",
				new Text(receiver.getName() + " accuse la reception de la lettre de " + sender.getName()));

	}

	@Override
	public Content copyContent() {
		return new AcknowledgementOfReceipt(this.getSender(), this.getReceiver());
	}

}

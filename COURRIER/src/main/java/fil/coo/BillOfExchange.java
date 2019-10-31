package fil.coo;

public class BillOfExchange extends Letter<Money> {

	public BillOfExchange(Inhabitant sender, Inhabitant receiver, Money content) {
		super(sender, receiver, content);
		double cost = (this.getContent().getMoney() * 0.1) + 1;
		this.setCost(cost);
	}

	/**
	 * The BillOfExchange's Action credit the receiver of the money in the letter 
	 * and then make the receiver send a thankYouLetter to the sender
	 */
	@Override
	public void action() {
		this.getReceiver().credit(this.getContent().getMoney());
		ThankYouLetter thankYouLetter = new ThankYouLetter(this.getReceiver(), this.getSender());
		this.getReceiver().sendLetter(thankYouLetter);
	}

}

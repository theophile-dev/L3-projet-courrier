package fil.coo;

public class BillOfExchange extends Letter<Money> {

	public static final double OVERCOST_FACTOR = 0.1;
	public static final double OVERCOST = 0.1;

	public BillOfExchange(Inhabitant sender, Inhabitant receiver, Money content) {
		super(sender, receiver, content);
		double cost = (this.getContent().getMoney() * OVERCOST_FACTOR) + OVERCOST;
		this.setCost(cost);
	}

	/**
	 * The BillOfExchange's Action credit the receiver of the money in the letter
	 * and then make the receiver send a thankYouLetter to the sender
	 */
	@Override
	public void action() {
		this.getReceiver().credit(this.getContent().getMoney());
		this.getSender().debit(this.getContent().getMoney());
		ThankYouLetter thankYouLetter = new ThankYouLetter(this.getReceiver(), this.getSender());
		this.getReceiver().sendLetter(thankYouLetter);
	}

	@Override
	public Content copyContent() {
		return new BillOfExchange(this.getSender(), this.getReceiver(), (Money) this.getContent().copyContent());
	}

}

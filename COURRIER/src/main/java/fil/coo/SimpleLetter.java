package fil.coo;

public class SimpleLetter extends Letter<Text> {

	public static final double COST = 2;

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
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
		return new SimpleLetter(this.getSender(), this.getReceiver(), (Text) this.getContent().copyContent());
	}

}

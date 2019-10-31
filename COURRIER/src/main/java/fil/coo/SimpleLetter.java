package fil.coo;


public class SimpleLetter extends Letter<Text> {

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
		this.setCost(0.5);

	}

	/**
	 * SimpleLetter doesn't trigger any action
	 */
	@Override
	public void action() {
		// does nothing
	}

}

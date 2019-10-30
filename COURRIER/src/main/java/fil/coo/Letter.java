package fil.coo;

public abstract class Letter<T extends Content>{
	private Inhabitant sender;
	private Inhabitant receiver;
	private T content;
	private float cost;
	
	
	/**
	 * @param sender
	 * @param receiver
	 * @param content
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, T content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}
	
	/**
	 * The action is triggered when an inhabitant open the letter
	 */
	public abstract void action();

	public Inhabitant getSender() {
		return sender;
	}

	public Inhabitant getReceiver() {
		return receiver;
	}

	public T getContent() {
		return content;
	}

	public float getCost() {
		return cost;
	}
	
}

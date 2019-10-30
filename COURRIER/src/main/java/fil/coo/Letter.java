package fil.coo;

public abstract class Letter<T extends Content>{
	private Inhabitant sender;
	private Inhabitant receiver;
	private T content;
	private double cost;
	private int letterNumber;
	private static int numberOfLetter = 0;
	
	
	/**
	 * @param sender
	 * @param receiver
	 * @param content
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, T content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.cost = 0;
		this.letterNumber = Letter.numberOfLetter;
		Letter.numberOfLetter++;
	}
	
	/**
	 * The action is triggered when an inhabitant open the letter
	 */
	public abstract void action();
	
	public String getName() {
		return "Courrier" + this.getLetterNumber();
	}
	
	public String getDescription() {
		return this.getName() + "(cout:" + this.getCost() + ")";
	}
	
	public int getLetterNumber() {
		return this.letterNumber;
	}

	public Inhabitant getSender() {
		return this.sender;
	}
	
	public Inhabitant getReceiver() {
		return this.receiver;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}

	public T getContent() {
		return this.content;
	}

	public double getCost() {
		return this.cost;
	}
	
}

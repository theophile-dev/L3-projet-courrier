package fil.coo.letter;

import fil.coo.Inhabitant;
import fil.coo.content.Content;

public abstract class Letter<T extends Content> implements Content {
	private Inhabitant sender;
	private Inhabitant receiver;
	private T content;
	private double cost;
	private int letterNumber;
	private static int numberOfLetter = 0;
	private String letterName;

	public Letter(Inhabitant sender, Inhabitant receiver, String letterName, T content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.cost = 0;
		this.letterNumber = Letter.numberOfLetter;
		this.letterName = letterName;
		Letter.numberOfLetter++;
	}

	public void setSender(Inhabitant sender) {
		this.sender = sender;
	}

	public void setReceiver(Inhabitant receiver) {
		this.receiver = receiver;
	}

	/**
	 * The action is triggered when an inhabitant open the letter
	 */
	public abstract void action();

	public String getName() {
		return this.getLetterName() + "( courrier num : " + this.getLetterNumber() + ")";
	}

	@Override
	public String getDescription() {
		return this.getName() + "(cout:" + this.getCost() + ") : contenue : " + this.getContent().getDescription();
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

	public String getLetterName() {
		return letterName;
	}

}

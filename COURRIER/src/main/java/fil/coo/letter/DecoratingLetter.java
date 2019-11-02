package fil.coo.letter;

public abstract class DecoratingLetter extends Letter<Letter<?>> {

	public DecoratingLetter(Letter<?> insideLetter, String letterName) {
		super(insideLetter.getSender(), insideLetter.getReceiver(), letterName, insideLetter);
	}

	@Override
	public void action() {
		this.getContent().action();
	}

	@Override
	public double getCost() {
		return this.getContent().getCost();
	}

}
package fil.coo;

public abstract class DecoratingLetter extends Letter<Letter<?>> {

	public DecoratingLetter(Letter<?> insideLetter) {
		super(insideLetter.getSender(), insideLetter.getSender(), insideLetter);
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
package fil.coo;

public class UrgentLetter extends DecoratingLetter {

	public static final double OVERCOST_FACTOR = 2;

	public UrgentLetter(Letter<?> insideLetter) {
		super(insideLetter);
	}

	@Override
	public double getCost() {
		return super.getCost() * OVERCOST_FACTOR;
	}

	@Override
	public Content copyContent() {
		return new UrgentLetter((Letter<?>) (this.getContent().copyContent()));
	}
}

package fil.coo;

public class Money implements Content {

	private double money;

	/**
	 * @param money
	 */
	public Money(double money) {
		this.money = money;
	}

	@Override
	public Content copyContent() {
		return new Money(this.getMoney());
	}

	@Override
	public String getDescription() {
		return "valeur = " + this.getMoney() + " euros";
	}

	public double getMoney() {
		return money;
	}

}

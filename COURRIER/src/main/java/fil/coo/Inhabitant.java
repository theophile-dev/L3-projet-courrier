package fil.coo;

public class Inhabitant {
	private String name;
	private City city;
	private float account;
	
	/**
	 * @param name
	 * @param city
	 * @param account
	 */
	public Inhabitant(String name, City city, float account) {
		this.name = name;
		this.city = city;
		this.account = account;
	}

	
	/**
	 * Send a letter to the city, then the city proceed to distribute the letters
	 * @param letter the letter to send
	 */
	public void sendLetter(Letter<?> letter) {
		this.city.addLetter(letter);
	}
	
	/**
	 * Receive a letter and trigger his action
	 * @param letter the letter to receive
	 */
	public void receiveLetter(Letter<?> letter) {
		letter.action();
	}
	
	public void credit(float amount) {
		this.account += amount;
	}
	
	public void debit(float amount) {
		this.account -= amount;
	}
	
	
	
}

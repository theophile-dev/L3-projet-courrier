package fil.coo;

import fil.coo.letter.Letter;

public class Inhabitant {
	private String name;
	private City city;
	private double account;

	public Inhabitant(String name, City city, double account) {
		this.name = name;
		this.city = city;
		this.account = account;
		this.city.addInhabitant(this);
	}

	public String getName() {
		return name;
	}

	public double getAccount() {
		return account;
	}

	public City getCity() {
		return this.city;
	}

	
	/**
	 * Send a letter to the city, then the city proceed to distribute the letters
	 * 
	 * @param letter the letter to send
	 */
	public void sendLetter(Letter<?> letter) {
		System.out.println(">>>" +this.name + " envoie a " + letter.getReceiver().getName() + " la lettre :" + letter.getDescription());
		this.city.addLetter(letter);
		this.debit(letter.getCost());
	}

	/**
	 * Receive a letter and trigger his action
	 * 
	 * @param letter the letter to receive
	 */
	public void receiveLetter(Letter<?> letter) {
		System.out.println("<<<" + this.name + " recoit de la pars de " + letter.getSender().getName() + " la lettre :" + letter.getDescription());
		letter.action();
	}

	public void credit(double amount) {
		this.account += amount;
	}

	public void debit(double amount) {
		this.account -= amount;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
	

}

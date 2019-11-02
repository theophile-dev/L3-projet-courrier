package fil.coo;

import java.util.ArrayList;

import fil.coo.letter.Letter;

public class City {
	private String name;
	private ArrayList<Letter<?>> mailBox;
	private ArrayList<Inhabitant> inhabitantList;

	public City(String name) {
		this.name = name;
		this.mailBox = new ArrayList<Letter<?>>();
		this.inhabitantList = new ArrayList<Inhabitant>();

	}
	
	public String getName() {
		return this.name;
	}

	public void addLetter(Letter<?> letter) {
		this.mailBox.add(letter);
	}

	public void addInhabitant(Inhabitant inhabitant) {
		this.inhabitantList.add(inhabitant);
	}

	public ArrayList<Inhabitant> getInhabitantList() {
		return inhabitantList;
	}

	public ArrayList<Letter<?>> getMailBox() {
		return this.mailBox;
	}
	
	public boolean isMailBoxEmpty() {
		return this.mailBox.isEmpty();
	}

	/**
	 * This method deliver each letter to his recipient
	 */
	public void distributeLetter() {
		ArrayList<Letter<?>> mailBag = new ArrayList<Letter<?>>(this.mailBox);
		for (Letter<?> letter : mailBag) {
			letter.getReceiver().receiveLetter(letter);
			this.mailBox.remove(letter);
		}
	}

}

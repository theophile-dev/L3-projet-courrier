package fil.coo;

import java.util.ArrayList;

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

	/**
	 * This method deliver each letter to his recipient
	 */
	public void distributeLetter() {
		ArrayList<Letter<?>> mailBag = new ArrayList<Letter<?>>(this.mailBox);
		// ArrayList<Letter<?>> mailBag = (ArrayList<Letter<?>>) this.mailbox.clone();
		for (Letter<?> letter : mailBag) {
			letter.getReceiver().receiveLetter(letter);
			this.mailBox.remove(letter);
		}
	}

}

package fil.coo.letter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import fil.coo.Inhabitant;
import fil.coo.content.Content;
import fil.coo.content.InhabitantList;
import fil.coo.content.Money;
import fil.coo.content.Text;

public class FoolLetter extends Letter<InhabitantList> {

	private static final double ANSWERING_PROBABILITY = 0.15;
	private static final int NUMBER_OF_FOOL_LETTER_TO_BE_SEND = 10;
	private static final int INITIAL_NUMBER_OF_INHABITANT_ON_THE_LIST = 4;
	private static final int MONEY_SEND = 5;


	public FoolLetter(Inhabitant Sender, Inhabitant Receiver) {
		super(Receiver, Receiver, "Fool letter", new InhabitantList(new LinkedList<Inhabitant>()));
		List<Inhabitant> inhabitantSublist = generateRandomInhabitantList(INITIAL_NUMBER_OF_INHABITANT_ON_THE_LIST);
		this.getContent().setInhabitantList(new LinkedList<Inhabitant> (inhabitantSublist));
	}
	

	public FoolLetter(Inhabitant Sender, Inhabitant Receiver, InhabitantList inhabitantList) {
		super(Receiver, Receiver, "Fool letter", inhabitantList);
	}

	private void sendMoneyToEveryInhabitantsOfTheList() {
		for (Inhabitant inhabitant : this.getContent().getInhabitantList()) {
			BillOfExchange billOfExchange = new BillOfExchange(this.getReceiver(), inhabitant, new Money(MONEY_SEND));
			this.getReceiver().sendLetter(billOfExchange);
		}
	}
	/**
	 * This function generate a random sublist of inhabitant from the city of the receiver
	 * @param size size of the generated sublist
	 * @return the inhabitant sublist from the receiver's city, this sublist can't include the receiver
	 */
	private List<Inhabitant> generateRandomInhabitantList(int size) {
		ArrayList<Inhabitant> inhabitantOfTheCity = this.getReceiver().getCity().getInhabitantList();
		if (inhabitantOfTheCity.size() < size) {
			return null;
		}
		ArrayList<Inhabitant> inhabitantOfTheCityCopy = new ArrayList<Inhabitant>(inhabitantOfTheCity);
		inhabitantOfTheCityCopy.remove(this.getReceiver());
		Collections.shuffle(inhabitantOfTheCityCopy);
		List<Inhabitant> inhabitantSublist = inhabitantOfTheCityCopy.subList(0, size);
		return inhabitantSublist;
	}
	
	private void sendLetterFoolToInhabitants(List<Inhabitant> inhabitantSublist) {
		for (Inhabitant inhabitant : inhabitantSublist) {
			FoolLetter foolLetterCopy = (FoolLetter) this.copyContent();
			foolLetterCopy.setReceiver(inhabitant);
			foolLetterCopy.setSender(this.getReceiver());
			this.getReceiver().sendLetter(foolLetterCopy);
		}
	}

	/**
	 * If the inhabitant choose to answer the fool letter, he send a certain amount of money to the inhabitants
	 * of the list, then remove the first name of the list and put his own in last pace then proceed to send 
	 * the letter to other inhabitants
	 */
	@Override
	public void action() {
		if (Math.random() <= ANSWERING_PROBABILITY) {
			sendMoneyToEveryInhabitantsOfTheList();
			this.getContent().getInhabitantList().removeFirst();
			this.getContent().getInhabitantList().addLast(this.getReceiver());
			List<Inhabitant> inhabitantSublist = generateRandomInhabitantList(NUMBER_OF_FOOL_LETTER_TO_BE_SEND);
			sendLetterFoolToInhabitants(inhabitantSublist);
		}
	}

	@Override
	public Content copyContent() {
		return new FoolLetter(this.getSender(), this.getReceiver(), (InhabitantList) this.getContent().copyContent());
	}
}

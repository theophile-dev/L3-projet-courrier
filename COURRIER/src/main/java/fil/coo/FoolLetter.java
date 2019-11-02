package fil.coo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FoolLetter extends DecoratingLetter {

	private static double ANSWERING_PROBABILITY = 0.1;
	private static int NUMBER_OF_FOOL_LETTER_TO_BE_SEND = 10;

	LinkedList<Inhabitant> inhabitantList;

	public FoolLetter(Letter<?> insideLetter) {
		super(insideLetter);
		this.inhabitantList = new LinkedList<Inhabitant>();
	}

	public FoolLetter(Letter<?> insideLetter, LinkedList<Inhabitant> inhabitantList) {
		super(insideLetter);
		this.inhabitantList = new LinkedList<Inhabitant>(inhabitantList);
	}

	@Override
	public void action() {
		super.action();
		if (Math.random() <= ANSWERING_PROBABILITY) {
			for (Inhabitant inhabitant : inhabitantList) {
				BillOfExchange billOfExchange = new BillOfExchange(this.getReceiver(), inhabitant, new Money(5));
				this.getReceiver().sendLetter(billOfExchange);
			}
			inhabitantList.removeFirst();
			inhabitantList.addLast(this.getReceiver());
			ArrayList<Inhabitant> inhabitantOfTheCity = this.getReceiver().getCity().getInhabitantList();
			ArrayList<Inhabitant> inhabitantOfTheCityCopy = new ArrayList<Inhabitant>(inhabitantOfTheCity);
			inhabitantOfTheCityCopy.remove(this.getReceiver());
			Collections.shuffle(inhabitantOfTheCityCopy);
			List<Inhabitant> inhabitantSublist = inhabitantOfTheCityCopy.subList(0, NUMBER_OF_FOOL_LETTER_TO_BE_SEND);
			for (Inhabitant inhabitant : inhabitantSublist) {
				FoolLetter foolLetterCopy = new FoolLetter((Letter<?>) this.copyContent());
				foolLetterCopy.setReceiver(inhabitant);
				foolLetterCopy.setSender(this.getReceiver());
			}

		}

	}

	@Override
	public Content copyContent() {
		return new FoolLetter((Letter<?>) (this.getContent().copyContent()));
	}

}

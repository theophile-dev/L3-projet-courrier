package fil.coo;

import java.util.ArrayList;

import fil.coo.content.Money;
import fil.coo.content.Text;
import fil.coo.letter.BillOfExchange;
import fil.coo.letter.FoolLetter;
import fil.coo.letter.Letter;
import fil.coo.letter.RegisteredLetter;
import fil.coo.letter.SimpleLetter;
import fil.coo.letter.UrgentLetter;

public class Courrier {
	
	private static ArrayList<Inhabitant> inhabitantList;
	private static final int NUMBER_OF_INHABITANT = 100;
	private static int n;
	private static int k;
	private static City city;

	private static void setup() {
		inhabitantList = new ArrayList<Inhabitant>();
		n = 5;
		k = 2;
		city = new City("V");
		for (int i=0;i<NUMBER_OF_INHABITANT;i++) {
			inhabitantList.add(new Inhabitant("hab" + i, city, 10));
		}
	}
	
	/**
	 * This function an inhabitant other than the sender
	 * @param sender the inhabitant that will send the letter
	 * @return An other inhabitant
	 */
	private static Inhabitant pickRandomRecipient(Inhabitant sender) {
		ArrayList<Inhabitant> inhabitantListClone = new ArrayList<Inhabitant>(inhabitantList);
		inhabitantListClone.remove(sender);
		return inhabitantListClone.get((int) (Math.random() * (NUMBER_OF_INHABITANT - 1)));
	}
	
	private static Inhabitant pickRandomInhabitant() {
		return inhabitantList.get((int) (Math.random() * NUMBER_OF_INHABITANT));
	}
	
	private static Letter<?> instantiateRandomLetter(Inhabitant sender, Inhabitant receiver){
		int rng = (int) (Math.random() * 2);
		Letter<?> letter = null;
		switch(rng) {
		case 0:
			letter = new SimpleLetter(sender, receiver, "simpleletterTest",new Text("blabla"));
			break;
		case 1:
			letter = new BillOfExchange(sender, receiver,new Money(Math.random()*5));
			break;
		default:
			System.out.println("Bad implementation of the randomLetterGenerator");
			break;
		}
		
		rng = (int) (Math.random() * 3);
		switch(rng) {
		case 0:
			letter = new UrgentLetter(letter);
			break;
		case 1:
			letter = new RegisteredLetter(letter);
			break;
		case 2:
			// This is letter without decorator
			break;
		default:
			System.out.println("Bad implementation of the randomLetterGenerator");
			break;
		}
	
		return letter;
	}
	
	private static void emulateExo9() {
		int dayCounter = 0;
		do {
			System.out.println("---------------------");
			System.out.println("----JOUR--" + dayCounter + "----------");
			if(k > 0) {
				System.out.println("Envoie des " + n + " courriers");
				for (int i=0;i<n;i++) {
					Inhabitant sender = pickRandomInhabitant();
					Inhabitant receiver = pickRandomRecipient(sender);
					sender.sendLetter(instantiateRandomLetter(sender,receiver));
				}
				k--;
			}
			System.out.println("---------------------");
			System.out.println("---------------------");
			System.out.println("----DISTRIBUTION-----");
			System.out.println("Distribution de " + city.getMailBox().size() + " courriers");
			System.out.println("---------------------");
			city.distributeLetter();
			System.out.println();
			dayCounter++;
			
		}while(!city.isMailBoxEmpty() || k>0);
	}
	
	private static void emulateExo10() {
		int dayCounter = 0;
		Inhabitant sender = pickRandomInhabitant();
		Inhabitant receiver = pickRandomRecipient(sender);
		sender.sendLetter(new FoolLetter(sender,receiver));		
		do {
			System.out.println("---------------------");
			System.out.println("----JOUR--" + dayCounter + "----------");
			System.out.println("---------------------");
			System.out.println("----DISTRIBUTION-----");
			System.out.println("Distribution de " + city.getMailBox().size() + " courriers");
			System.out.println("---------------------");
			city.distributeLetter();
			System.out.println();
			dayCounter++;
			
		}while(!city.isMailBoxEmpty());
	}
	
	public static void main(String[] args) {
		setup();
		//emulateExo9();
		emulateExo10();
	}
}

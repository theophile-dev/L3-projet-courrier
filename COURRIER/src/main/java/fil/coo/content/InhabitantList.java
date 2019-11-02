package fil.coo.content;


import java.util.LinkedList;

import fil.coo.Inhabitant;

public class InhabitantList implements Content {

	private LinkedList<Inhabitant> inhabitantList;
	
	
	public InhabitantList(LinkedList<Inhabitant> inhabitantList) {
		this.inhabitantList = inhabitantList;
	}
	
	public LinkedList<Inhabitant> getInhabitantList() {
		return inhabitantList;
	}
	

	public void setInhabitantList(LinkedList<Inhabitant> inhabitantList) {
		this.inhabitantList = inhabitantList;
	}

	@Override
	public String getDescription() {
		return this.inhabitantList.toString();
	}

	@Override
	public Content copyContent() {
		return new InhabitantList(new LinkedList<Inhabitant>(this.inhabitantList)) ;
	}

}

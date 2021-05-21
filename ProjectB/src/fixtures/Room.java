package fixtures;

import java.util.Random;

public class Room extends Fixture{
	final String[] itemArr= {"box","ball","statue","training dummy","table","chair","plant","mirror","soda machine","piano"};
	final String[] attributeArr= {"short","tall","tiny","small","big","huge","long","wide"};
	Exit[] exits;//array order: North, East, South, West, up, down
	int[] cords;
	String item;
	String attribute;
	public Room(String name, String Description, String longDescription) {
		super(name, shortDescription, longDescription);
		generateItem();
		generateAttribute();
		exits=new Exit[6];
	}
	private void generateItem() {
		Random rand=new Random();
		this.item=itemArr[rand.nextInt(itemArr.length)];
	}
	private void generateAttribute() {
		Random rand=new Random();
		this.attribute=attributeArr[rand.nextInt(attributeArr.length)];
	}

	public int[] getCords() {
		return cords;
	}

	public void setCords(int[] cords) {
		this.cords = cords;
	}

	public Exit[] getExits() {
		return exits;
	}
	
	public Exit getExit(String direction) {
		if(direction.equalsIgnoreCase("North"))
			return exits[0];
		if(direction.equalsIgnoreCase("East"))
			return exits[1];
		if(direction.equalsIgnoreCase("South"))
			return exits[2];
		if(direction.equalsIgnoreCase("West"))
			return exits[3];
		return null;
	}
	public Exit getExit(int direction) {
		return exits[direction];
	}
	
	public void setExit(Exit[] e) {
		this.exits=e;
	}

	@Override
	public String toString() {
		String s="Room "+cords[0]+","+cords[1]+","+cords[2]+ " Description ";
		s+="a "+attribute+" "+item+" is in the center of the room\n";
		s+="North: "+exits[0].toString()+"\n";
		s+="East: "+exits[1].toString()+"\n";
		s+="South: "+exits[2].toString()+"\n";
		s+="West: "+exits[3].toString()+"\n";
		return s;
	}

}

package fixtures;

import java.util.Arrays;

public class Room extends Fixture{
	Exit[] exits;//array order: North, East, South, West, up, down
	int[] cords;
	public Room(String name, String Description, String longDescription) {
		super(name, shortDescription, longDescription);
		exits=new Exit[6];
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
		String s="Room "+cords[0]+cords[1]+cords[2]+ " Description\n";
		s+="North: "+exits[0].toString()+"\n";
		s+="East: "+exits[1].toString()+"\n";
		s+="South: "+exits[2].toString()+"\n";
		s+="West: "+exits[3].toString()+"\n";
		return s;
	}

}

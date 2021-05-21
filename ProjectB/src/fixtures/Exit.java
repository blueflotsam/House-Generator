package fixtures;

import java.util.Random;

public class Exit {
	String type="empty";//types are door, wall, stairU, starD, window
	public boolean isEdge() {
		return edge;
	}

	public void setEdge(boolean edge) {
		this.edge = edge;
	}

	boolean edge;//denotes if the exit leads outside(true) or inside(false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		if(type.equalsIgnoreCase("empty")||type.equalsIgnoreCase("stairU")||type.equalsIgnoreCase("stairD"))
			this.type = type;
	}
	public void setType() {//randomly generates a type depending on edge
		Random rand=new Random();
		int i=rand.nextInt(10);
		if(type.equalsIgnoreCase("empty")) {
			if(edge) {
				if(i==9)
					this.type="door";
				else if(i>5)
					this.type="window";
				else
					this.type="wall";
			}
			else {
				if(i==9) {
					int j=rand.nextInt(2);
					if(j==1) {
						this.type="stairU";
					}
					else
						this.type="stairD";
				}
				else if(i>3)
					this.type="door";
				else
					this.type="wall";
			}
		}
	}

	@Override
	public String toString() {
		String s="A "+type;
		if(edge&&!type.equalsIgnoreCase("wall"))
			s+=" leading outside";
		if(type.equalsIgnoreCase("stairU")) {	
			s=s.substring(0, s.length()-1);
			s+="s leading upwards";
		}
		if(type.equalsIgnoreCase("stairD")) {	
			s=s.substring(0, s.length()-1);
			s+="s leading Downwards";
		}
		return s;
	}
}

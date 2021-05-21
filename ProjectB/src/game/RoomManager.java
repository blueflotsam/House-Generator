package game;

import fixtures.Exit;
import fixtures.Room;

public class RoomManager {
	Room startingRoom;
	Room[][][] rooms;
	public RoomManager(int x, int y, int z) {
		rooms=new Room[x][y][z];
		init();
	}
	private void init() {
		for(int x=0;x<rooms.length;x++) {
			for(int y=0;y<rooms[0].length;y++) {
				for(int z=0;z<rooms[0][0].length;z++) {
					Room foyer=new Room("test", "a test room", "a test room with a test dummy");
					int[] a= {x,y,z};
					foyer.setCords(a);
					Exit[] e=foyer.getExits();
					for(int i=0;i<e.length;i++) {
						if(e[i]==null) {
							e[i]=new Exit();
						}
					}
					rooms[x][y][z]=foyer;
				}
			}
		}
		this.setStartingRoom(rooms[0][0][0]);
		initExit();
	}
	private void initExit() {
		for(int x=0;x<rooms.length;x++) {
			for(int y=0;y<rooms[0].length;y++) {
				for(int z=0;z<rooms[0][0].length;z++) {
					Room r=rooms[x][y][z];
					Exit[] e=r.getExits();
					//setting all the edges to true that lead outside
					if(x==0)
						e[3].setEdge(true);
					if(x==rooms.length-1)
						e[1].setEdge(true);
					if(y==0)
						e[0].setEdge(true);
					if(y==rooms[0].length-1)
						e[2].setEdge(true);
					if(z==rooms[0][0].length-1)
						e[4].setEdge(true);
					if(z==0)
						e[5].setEdge(true);
					for(int i=0;i<e.length;i++) {
						if(e[i].getType().equalsIgnoreCase("empty")) {
							e[i].setType();
							if(!e[i].isEdge()) {
								if(e[i].getType().equalsIgnoreCase("stairU")){
									if(e[4].isEdge()==false) {
										rooms[x][y][z+1].getExit(i).setType("stairD");
									}
								}
								else if(e[i].getType().equalsIgnoreCase("stairD")){
									if(e[5].isEdge()==false) {
										rooms[x][y][z-1].getExit(i).setType("stairU");
									}
								}
								else {
									if(i==2) {
										rooms[x][y+1][z].getExit("north").setType(e[i].getType());
									}
									if(i==1) {
										rooms[x+1][y][z].getExit("West").setType(e[i].getType());
									}
									if(i==3) {
										rooms[x-1][y][z].getExit("east").setType(e[i].getType());
									}
									if(i==0) {
										rooms[x][y-1][z].getExit("south").setType(e[i].getType());
									}
								}
								
							}
						}
					}
					
				}
			}
		}
	}

	public Room getStartingRoom() {
		return startingRoom;
	}
	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}
	public Room[][][] getRooms() {
		return rooms;
	}
	public void setRooms(Room[][][] rooms) {
		this.rooms = rooms;
	}
}

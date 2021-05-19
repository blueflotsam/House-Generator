package game;

import fixtures.Room;

public class RoomManager {
	Room startingRoom;
	Room[] rooms;
	public void init() {
		Room foyer=new Room("test", "a test room", "a test room with a test dummy");
	}
}

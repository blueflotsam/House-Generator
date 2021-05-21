package game;

import java.util.Scanner;

import fixtures.Room;

public class Main {
	static Scanner scrn=new Scanner(System.in);
	public static void main(String []args) {
		final int houseX=10;
		final int houseY=10;
		final int houseZ=10;
		RoomManager map=new RoomManager(houseX,houseY,houseZ);
		Player p=new Player();
		p.setCurrentRoom(map.getStartingRoom());
		while(true) {
			printRoom(p);
			parse(collectInput(),p,map);
		}
	}
	private static void printRoom(Player p) {
		System.out.println(p.getCurrentRoom().toString());
	}

	private static String collectInput() {
		System.out.println("where would you like to go?");
		String input ="bad";
		while(!(input.equalsIgnoreCase("north")||input.equalsIgnoreCase("east")||input.equalsIgnoreCase("south")||input.equalsIgnoreCase("west"))) {
			input=scrn.nextLine();
		}
		return input;
	}
		
	private static void parse(String command, Player player,RoomManager map) {
		String type=player.getCurrentRoom().getExit(command).getType();
		
		if(type.equalsIgnoreCase("door")) {
			Room[][][] arr=map.getRooms();
			int[] cords=player.getCurrentRoom().getCords();
			if(player.getCurrentRoom().getExit(command).isEdge()) {
				System.out.println("you exit the house through the door");
				System.exit(0);
			}
			if(command.equalsIgnoreCase("North"))
				player.setCurrentRoom(arr[cords[0]][cords[1]-1][cords[2]]);
			else if(command.equalsIgnoreCase("East"))
				player.setCurrentRoom(arr[cords[0]+1][cords[1]][cords[2]]);
			else if(command.equalsIgnoreCase("South"))
				player.setCurrentRoom(arr[cords[0]][cords[1]+1][cords[2]]);
			else if(command.equalsIgnoreCase("West"))
				player.setCurrentRoom(arr[cords[0]-1][cords[1]][cords[2]]);
		}
		else if(type.equalsIgnoreCase("window")){
			System.out.println("you exit the house through the window");
			System.exit(0);
		}
		else if(type.equalsIgnoreCase("wall")) {
			System.out.println("You ran into a wall...Ouch");
		}
		else if(type.equalsIgnoreCase("stairU")) {
			Room[][][] arr=map.getRooms();
			int[] cords=player.getCurrentRoom().getCords();
			player.setCurrentRoom(arr[cords[0]][cords[1]][cords[2]+1]);
		}
		else if(type.equalsIgnoreCase("stairD")) {
			Room[][][] arr=map.getRooms();
			int[] cords=player.getCurrentRoom().getCords();
			player.setCurrentRoom(arr[cords[0]][cords[1]][cords[2]-1]);
		}
		else {
			System.out.println("not a recognized command");
		}
	}

}

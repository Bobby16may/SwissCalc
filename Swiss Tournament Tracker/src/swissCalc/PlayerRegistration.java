package swissCalc;

import java.util.Scanner;
public class PlayerRegistration {
	
	public static void newPlayer(PlayerManagement rosterIn) {
		PlayerManagement roster = rosterIn;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		String firstName="";
		String lastName="";
		String playerID="";
		
		System.out.println("Enter Player's first name");
		firstName = input.next();
		
		System.out.println("Enter Player's last name");
		lastName = input.next();
		
		System.out.println("Enter Player's KONAMI ID");
		playerID = input.next();
		
		roster.playerList.add(new Player(firstName, lastName, playerID));
		System.out.println("Player "+roster.playerList.get(roster.playerList.size()-1) +" Added!");
	}
	
	public static void newPlayerGUI(PlayerManagement rosterIn, String fNameIn, String lNameIn, String playerIDIn) {
		PlayerManagement roster = rosterIn;
		roster.playerList.add(new Player(fNameIn, lNameIn, playerIDIn));
	}
}

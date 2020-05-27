package swissCalc;

import java.util.Scanner;
public class TournamentSupervisor {
	PlayerManagement roster;
	int rosterSize = 0;
	Scanner select = new Scanner(System.in);
	
	public TournamentSupervisor(PlayerManagement rosterIn) {
		this.roster = rosterIn;
		rosterSize = roster.playerList.size();
	}

	
	public void menu() {
		String selection;
		boolean exitLoop = false;
		 do{
			System.out.println("Welcome to MTMS! Please select an option:");
			System.out.println("1) Add Player");
			System.out.println("2) Remove Player");
			System.out.println("3) List Players");
			System.out.println("4) Begin Tournament");
			selection = select.next();
			switch(selection) {
			case "1":
				PlayerRegistration.newPlayer(roster);
				break;
			case "2": 
				System.out.println("Who do you want to remove? Enter their ID");
				selection = select.next();
				roster.removePlayer(selection);
				break;
			case "3": 
				roster.listPlayers();
				roster.listDrops();
				break;
			case "4": exitLoop=true;
			break;
			default: System.out.println("That is not a valid option");
			break;
			}
		} while(!exitLoop);
	}
	
	public void checkForDrops() {
		String selection;
		String dropID;
		boolean exitLoop = false;
		 do{
			System.out.println("Are there any drops? (Y/N)");
			selection = select.next();
			switch(selection) {
			case "Y":
			case "y": 
				System.out.println("Who do you want to drop? Enter their ID");
				dropID = select.next();
				roster.drop(dropID);
				break;
			case "N": 
			case "n": 
				System.out.println("Alright, no drops!");
				exitLoop = true;
				break;
			default: System.out.println("That is not a valid option");
			break;
			}
		} while(!exitLoop);
	}
	
	public void startNextRound() {
		String selection;
		boolean exitLoop = false;
		 do{
			System.out.println("Ready To Start Next Round? (Y/N)");
			selection = select.next();
			switch(selection) {
			case "Y":
			case "y": 
				System.out.println("Starting pairing for next round!");
				exitLoop = true;
				break;
			case "N": 
			case "n": 
			default: System.out.println("Press Y when you want to start");
			break;
			}
		} while(!exitLoop);
	}

	public static int howManyRounds(int rosterSizeIn) {
		int roundCount = 0;
		if(rosterSizeIn>=2049) {
			roundCount = 12;
		}
		else if(rosterSizeIn>=1025) {
			roundCount = 11;
		}
		else if(rosterSizeIn>=513) {
			roundCount = 10;
		}
		else if(rosterSizeIn>=257) {
			roundCount = 9;
		}
		else if(rosterSizeIn>=129) {
			roundCount = 8;
		}
		else if(rosterSizeIn>=65) {
			roundCount = 7;
		}
		else if(rosterSizeIn>=33) {
			roundCount = 6;
		}
		else if(rosterSizeIn>=17) {
			roundCount = 5;
		}
		else if(rosterSizeIn>=9) {
			roundCount = 4;
		}
		else if(rosterSizeIn>=4) {
			roundCount = 3;
		}
		return roundCount;
	}
	
	//public static 
}

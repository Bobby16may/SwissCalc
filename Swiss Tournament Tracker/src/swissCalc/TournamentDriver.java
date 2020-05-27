package swissCalc;

public class TournamentDriver {

	public static void main(String[] args) {	
		//create tournament roster object
		PlayerManagement roster = new PlayerManagement();
		
		TournamentSupervisor headJudge = new TournamentSupervisor(roster);
		
		headJudge.menu();
		
		//define the bye player
		Player bye = new Player("BYE", "", "BYE");
		//System.out.println("Enter First Name, Last Name, And COSSY ID on seperate lines. Enter DONE to finish");
		int roundCount = 0;

	
		
		//standIn player List
		roster.playerList.add(new Player("Matthew", "Hunter", "1234"));
		roster.playerList.add(new Player("Matt", "Edmunds", "1235"));
		roster.playerList.add(new Player("Jay", "Edmunds", "1236"));
		roster.playerList.add(new Player("Sara", "Nason", "1237"));
		roster.playerList.add(new Player("James", "Noble", "1238"));
		roster.playerList.add(new Player("Yugi", "Muto", "0001"));
		roster.playerList.add(new Player("Joey", "Wheeler", "0002"));
		roster.playerList.add(new Player("Seto", "Kaiba", "0003"));
		roster.playerList.add(new Player("Maximillion", "Pegasus", "0000"));
		roster.playerList.add(new Player("Greg", "Fiddler", "1240"));
		roster.playerList.add(new Player("Zack", "Fortune", "1241"));
		roster.dropList.add(new Player("Weevil", "Underwood", "0004"));
		roster.dropList.add(new Player("Rex", "Raptor", "0005"));
		
		//determine number of rounds
		//int rosterSize = roster.playerList.size();
		roundCount = TournamentSupervisor.howManyRounds(roster.playerList.size());

		
		
		//pre tourney procedure

		//shuffle players to randomize pairings in round 1
		roster.shufflePlayers();
		
		//create rounds
		
		//headJudge.createRounds();
		Round[] rounds = new Round[roundCount];
		System.out.println("Rount Count: " + roundCount);
		
		for(int currentRound = 0; currentRound<roundCount; currentRound++) {
			
			//check for bye, and add if needed
			if(roster.playerList.size()%2 ==1) {
				roster.playerList.add(bye);
			}
			
			//give all players the current round number
			for(int playerNum = 0; playerNum<roster.playerList.size(); playerNum++) {
				roster.playerList.get(playerNum).setCurrentRound(currentRound+1);
			}
			
			//create the current round
			rounds[currentRound] = new Round(roster.playerList, currentRound+1);
			//pair players
			rounds[currentRound].pairUp();
			
			//list matchups
			System.out.println("Round "+ (currentRound+1));
			for(int currentPairing = 0; currentPairing<rounds[currentRound].pairings.size();currentPairing++) {
				System.out.print("Table "+(currentPairing+1)+": "+rounds[currentRound].pairings.get(currentPairing));
			}

			
			
			rounds[currentRound].reportRound(currentRound);
			//post round tasks
			
			//check for drops
			headJudge.checkForDrops();
			
			//remove bye, if in the roster
			roster.removePlayer("BYE");
			//sort players by score
			roster.sortPlayers();
			roster.sortDrops();
			//display rankings
			roster.listPlayers();
			roster.listDrops();
			
			headJudge.startNextRound();
				
		}
		
	}
	
}

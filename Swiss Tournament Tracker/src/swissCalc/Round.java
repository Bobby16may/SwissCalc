package swissCalc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Round {
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<Pairing> pairings = new ArrayList<>();
	int roundNumber;
	Scanner select = new Scanner(System.in);

	//constructor
	@SuppressWarnings("unchecked")
	public Round(ArrayList<Player> playersIn, int roundNumberIn) {
		this.roundNumber = roundNumberIn;
		this.players=(ArrayList<Player>) playersIn.clone();
	
	}

	
	public void pairUp() {
		final int totalPlayers = players.size();
		int index=0;
		int opponentIndex = index+1;
		boolean track = false;
		
			
		for(index=0; index<totalPlayers;) {
			if(players.get(index).hasPlayed(players.get(opponentIndex))) {
				if(opponentIndex<totalPlayers-1) {
					opponentIndex++;
				}
				else if(!track) {
					opponentIndex=index-1;
					track = true;
				}
				else {
					opponentIndex=-2;
					track = false;
				}
			}
			else {
				Collections.swap(players, index+1, opponentIndex);
				index=index+2;
				opponentIndex=index+1;
			}
		}
		
		//System.out.println("Pre-Pair Ranking "+players);

		
		while(!players.isEmpty()) {
			pairings.add(new Pairing(players.get(0), players.get(1), roundNumber));
			players.remove(1);
			players.remove(0);
		}
		
	}
	
	
	public void reportRound(int currentRound) {
		int resultOfMatch=-1;
		String selection;
		for(int pairingNum = 0; pairingNum<pairings.size(); pairingNum++) {
			System.out.println("Report result for Round "+(currentRound+1)+" Table "+(pairingNum+1));
			System.out.println("1: "+pairings.get(pairingNum).getPlayer1()+" wins");
			System.out.println("2: "+pairings.get(pairingNum).getPlayer2()+" wins");
			System.out.println("3: Draw");
			
			
			boolean exitLoop=false;
			do {
				selection = select.next();
				switch(selection) {
					case "1": resultOfMatch = 0;
						exitLoop = true;
						break;
					case "2": resultOfMatch = 2;
						exitLoop = true;
						break;
					case "3": resultOfMatch = 1;
						exitLoop = true;
						break;
					default: System.out.println("That is not a valid option");
						break;
			}
			}while(!exitLoop);
			pairings.get(pairingNum).reportRound(resultOfMatch);
		}
	}
}

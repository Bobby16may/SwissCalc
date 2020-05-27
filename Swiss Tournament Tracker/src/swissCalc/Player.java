package swissCalc;

import java.util.ArrayList;

public class Player implements Comparable<Player>{
	String playerFName;
	String playerLName;
	String playerID;
	int roundCount=1;
	int playerWins;
	int playerDraws;
	boolean hadBye=false;
	ArrayList<Player> opponents = new ArrayList<>();
	
	
	//constructor
	public Player(String playerFNameIn, String playerLNameIn, String playerIDIn/*, int roundCount*/) {
		this.playerFName = playerFNameIn;
		this.playerLName = playerLNameIn;
		this.playerID = playerIDIn;
	}
	
	
	//set round number
	public void setCurrentRound(int roundCountIn) {
		this.roundCount = roundCountIn;
	}
	//getters
	
	//get first name
	public String getFName() {
		return this.playerFName;
	}
	
	//get last name
	public String getLName( ) {
		return this.playerLName;
	}
	
	//get Player ID
	public String getID() {
		return this.playerID;
	}
	
	
	//add opponent
	private void addOpponent(Player opponentIn, int roundNumber) {
		opponents.add(opponentIn);
	}
	
	
	
	//report results
	public void reportRound(int resultIn, Player opponentIn, int roundNumber){
		addOpponent(opponentIn, roundNumber);
		switch(resultIn) {
		case 0: playerWins++;
		break;
		case 1: playerDraws++;
		break;
		default: break;
		}
	}
	
	//get points
	int getPoints() {
		int points = (playerWins*3)+playerDraws;
		return points;
	}

	
	//get player Score
	public String getScore() {
		String score="";
		
		String strOppOppPct =String.valueOf(getOppOppWinPct());
		if(getOppOppWinPct()<100) {
			strOppOppPct="0"+strOppOppPct;
		}
		else if(strOppOppPct == "0") {
			strOppOppPct = "000";
		}
		
		String strOppPct =String.valueOf(getOppWinPct());
		if(getOppWinPct()<100) {
			strOppPct="0"+strOppPct;
		}
		else if(strOppPct == "0") {
			strOppPct = "000";
		}
		
		
		String strPts = String.valueOf(getPoints());
		if(getPoints()<10) {
			strPts="0"+strPts;
		}
		
		
		score = score+strPts+strOppPct+strOppOppPct;
		
		return score;
	}
	
	//check if has played
	public boolean hasPlayed(Player otherPlayer) {
		if(opponents.contains(otherPlayer)) {
			return true;
		}
		else return false;
	}
	
	//has the player had a bye?
	public boolean hasHadBye() {
		if(hadBye) {
			return true;
		}
		else return false;
	}
	
	public int getWinPct() {
		int winPct=0;
		if(roundCount>0) {
			winPct=(100*playerWins+(50*playerDraws))/roundCount;

		}
		return winPct;
	}
	
	
	//TODO return opponents win pcts
	public int getOppWinPct() {
		int pct=0;
		for(int opps = 0; opps<opponents.size(); opps++) {
			pct =pct+opponents.get(opps).getWinPct();
		}
		pct = pct/roundCount;

		return pct;
	}
	

	public int getOppOppWinPct() {
		int pct=0;
		for(int opps = 0; opps<opponents.size(); opps++) {
			pct = pct+opponents.get(opps).getOppWinPct();
		}
		pct = pct/roundCount;
		
		return pct;
	}
	
	//compare by score
	@Override
	public int compareTo(Player otherPlayer) {
		return(this.getScore().compareTo(otherPlayer.getScore()));
	}
	
	
	//toString
	@Override
	public String toString() {
		return(getID()+ " " +getLName()+", "+getFName()+" ("+getScore()+")" );
	}
	

}

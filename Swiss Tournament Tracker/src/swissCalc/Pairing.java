package swissCalc;

	public class Pairing {
		Player player1;
		Player player2;
		int roundNumber;
		
		//constructor
		public Pairing(Player player1In, Player player2In, int roundNumberIn) {
			this.player1 = player1In;
			this.player2 = player2In;
			this.roundNumber = roundNumberIn;
		}
		
		public Player getPlayer1() {
			return player1;
		}
		
		public Player getPlayer2() {
			return player2;
		}
		
		public String toString() {
			return(player1+ " Vs. " + player2+'\n');
		}
		
		public void reportRound(int resultOfMatch) {
			//initialized to error value
			int player1Result=-3;
			int player2Result=-3;
			
			//switch loop to interpret match data
			switch(resultOfMatch) {
			case 0: 
				//player1 wins round
				player1Result = 0;
				player2Result = 2;
				break;
			case 1:
				//draw
				player1Result = 1;
				player2Result = 1;
				break;
			case 2:
				//player2 wins
				player1Result = 2;
				player2Result = 0;
				break;
			}
			
			//report round to player classes
			player1.reportRound(player1Result, player2, roundNumber);
			player2.reportRound(player2Result, player1, roundNumber);
		}
		
		


}

package swissCalc;
import java.util.ArrayList;
import java.util.Collections;

public class PlayerManagement {
	
	ArrayList<Player> playerList = new ArrayList<>();
	ArrayList<Player> dropList = new ArrayList<>();
	
	public void drop(String IDIn) {
		for(int i=0; i<playerList.size(); i++) {
			if(IDIn.equals(playerList.get(i).getID())) {
				dropList.add(playerList.get(i));
				playerList.remove(i);
				//System.out.println(""+i);
			}
			//else {System.out.println("That player is not currently enrolled");}
		}
		sortDrops();
		listDrops();
	}
	
	//remove player from roster without dropping, to be used for Bye player
	public void removePlayer(String IDIn) {
		for(int i=0; i<playerList.size(); i++) {
			if(playerList.get(i).getID().equals(IDIn)) {
				playerList.remove(i);
			}
		}
	}
	
	public void listPlayers() {
		if(playerList.size()==0) {
			System.out.println("There are no players registered!");
		}
		for(int count = 0;count<playerList.size(); count++ ) {
			System.out.println((count+1)+": " +playerList.get(count));
		}
	}
	
	public void listDrops() {
		for(int count = 0;count<dropList.size(); count++ ) {
			System.out.println((count+playerList.size()+1)+"(DROP): " +dropList.get(count));
		}
	}
	
	public ArrayList<Player> shufflePlayers(){
		Collections.shuffle(playerList);
		return playerList;
	}
	
	
	public ArrayList<Player> sortPlayers(){
		Collections.sort(playerList, Collections.reverseOrder());
		return playerList;
	}
	
	public ArrayList<Player> sortDrops(){
		Collections.sort(dropList, Collections.reverseOrder());
		return dropList;
	}
	
}

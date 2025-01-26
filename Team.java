import java.util.ArrayList;
import java.util.Iterator;


class Team {
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(String n, int s) {
        players.add(new Player(n,s));
    }

    public void removePlayer(String name) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getName().equalsIgnoreCase(name)) { // ignore upper case or lower case.
                iterator.remove();
                break; // Stop after removing the first match.
            }
        }
    } // if match is not found nothing happens.
    
    

    public void displayPlayers() {
        for (Player player : players) {
            System.out.println(player.getName() + " - " + player.getScore() + " points");
        }
    }
}
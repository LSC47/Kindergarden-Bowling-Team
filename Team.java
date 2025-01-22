import java.util.ArrayList;

class Team {
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void removePlayer(String name) {
        players.removeIf(player -> player.getName().equalsIgnoreCase(name));
    }

    public void displayPlayers() {
        for (Player player : players) {
            System.out.println(player.getName() + " - " + player.getScore() + " points");
        }
    }
}
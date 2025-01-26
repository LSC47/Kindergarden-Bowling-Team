import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

class Team {
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(String n, int s) {
        players.add(new Player(n, s));
    }

    public void removePlayer(String name) {
        players.removeIf(player -> player.getName().equalsIgnoreCase(name));
    }

    public void displayPlayers() {
        for (Player player : players) {
            System.out.println(player.getName() + " - " + player.getScore() + " points");
        }
    }

    // Update a player's score
    public void updatePlayerScore(String name, int newScore) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                player.setPlayerScore(newScore);
                return; // Stop searching once we update the score
            }
        }
        System.out.println("Player not found!");
    }

    // Save team data to a JSON file
    public void saveToJSON(String filename) throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(players, writer);
        }
    }

    // Load team data from a JSON file
    public void loadFromJSON(String filename) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            Type playerListType = new TypeToken<ArrayList<Player>>() {}.getType();
            players = gson.fromJson(reader, playerListType);
        }
    }
}

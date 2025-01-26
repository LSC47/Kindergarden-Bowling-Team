import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.Scanner;


// IMPORTANT
// DONT RUN IN VS CODE
// Compile with: javac -cp libs/gson-2.10.1.jar:. BowlingTeamApp.java
// Run with: java -cp .:libs/gson-2.10.1.jar BowlingTeamApp
// Windows (On Windows, use ; instead of : in the classpath): java -cp .;libs/gson-2.10.1.jar BowlingTeamApp

public class BowlingTeamApp {

    public static void main(String[] args) {
        Team team = new Team();
        Scanner scanner = new Scanner(System.in);

        // Load players from the JSON file
        try {
            team.loadFromJSON("team.json");
            System.out.println("Team loaded from JSON:");
            team.displayPlayers();
        } catch (IOException e) {
            System.err.println("Error loading from JSON: " + e.getMessage());
        }

        boolean exit = false;

        while (!exit) {
            // Display menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add a new player");
            System.out.println("2. Remove a player");
            System.out.println("3. View all players and scores");
            System.out.println("4. Update a player's score");
            System.out.println("5. Exit the application");
            System.out.print("Choose an option: ");
            
            // Get user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the integer input
            
            switch (choice) {
                case 1: // Add a new player
                    System.out.print("Enter player name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter player score: ");
                    int score = scanner.nextInt();
                    team.addPlayer(name, score);
                    System.out.println("Player added successfully!");
                    break;
                
                case 2: // Remove a player
                    System.out.print("Enter player name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    team.removePlayer(nameToRemove);
                    System.out.println("Player removed successfully!");
                    break;
                
                case 3: // View all players and scores
                    System.out.println("\nPlayers and Scores:");
                    team.displayPlayers();
                    break;
                
                case 4: // Update a player's score
                    System.out.print("Enter player name to update score: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    int newScore = scanner.nextInt();
                    team.updatePlayerScore(nameToUpdate, newScore);
                    System.out.println("Player's score updated successfully!");
                    break;
                
                case 5: // Exit the application
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;
                
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            
            // Save the updated team to the JSON file after each action
            try {
                team.saveToJSON("team.json");
                System.out.println("Team saved to JSON.");
            } catch (IOException e) {
                System.err.println("Error saving to JSON: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
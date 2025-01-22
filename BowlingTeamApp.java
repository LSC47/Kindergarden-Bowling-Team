public class BowlingTeamApp {

    public static void main(String[] args) {
        Team team = new Team();

        team.addPlayer("Alice");
        team.addPlayer("Bob");
        team.addPlayer("Charlie");

        System.out.println("Players:");
        team.displayPlayers();

        team.removePlayer("Bob");
        System.out.println("\nAfter removing Bob:");
        team.displayPlayers();
    }
}
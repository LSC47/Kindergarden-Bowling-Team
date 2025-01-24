public class BowlingTeamApp {

    public static void main(String[] args) {
        Team team = new Team();

        team.addPlayer("Alice", 0);
        team.addPlayer("Bob", 0);
        team.addPlayer("Charlie", 0);

        System.out.println("Players:");
        team.displayPlayers();

        team.removePlayer("Bob");
        System.out.println("\nAfter removing Bob:");
        team.displayPlayers();
    }
}
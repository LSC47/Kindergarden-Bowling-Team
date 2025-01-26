public class BowlingTeamApp {

    public static void main(String[] args) {
        Team team = new Team();

        team.addPlayer("Alice", 4);
        team.addPlayer("Bob", 7);
        team.addPlayer("Charlie", 10);

        System.out.println("Players:");
        team.displayPlayers();

        team.removePlayer("Bob");
        System.out.println("\nAfter removing Bob:");
        team.displayPlayers();
    }
}
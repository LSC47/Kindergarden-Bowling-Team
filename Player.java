public class Player {
    
    private String name = "";
    private int score;

    public Player(){
        
    }

    public Player (String n, int s) {
        name = n;
        score = s;
    }

    public void setPlayerScore(int s) {
        score = s;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

}

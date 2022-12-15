import java.util.ArrayList;

public class Team {
    private Faculty faculty;
    private ArrayList<Player> playersList;
    private int rank;


    public Team(Faculty faculty, ArrayList<Player> playersList, int rank) {
        this.faculty = faculty;
        this.playersList = playersList;
        this.rank = rank;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public int getRank() {
        return rank;
    }


    public void setPlayersList(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

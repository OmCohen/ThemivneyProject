import java.util.ArrayList;

public class Team {
    private Faculty faculty;
    private ArrayList<PlayerInTeamNode> playersList;
    private int rank;


    public Team(Faculty faculty, ArrayList<PlayerInTeamNode> playersList, int rank) {
        this.faculty = faculty;
        this.playersList = playersList;
        this.rank = rank;
    }

    public Team(Faculty faculty) {
        this.faculty = faculty;
        this.playersList = new ArrayList<PlayerInTeamNode>();
        this.rank = 0;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public ArrayList<PlayerInTeamNode> getPlayersList() {
        return this.playersList;
    }

    public int getRank() {
        return rank;
    }


    public void setPlayersList(ArrayList<PlayerInTeamNode> playersList) {
        this.playersList = playersList;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

import java.util.ArrayList;

/*
this is update tryout
 */

public class TechnionTournament implements Tournament{

    int MIN_VALUE = -2147483648;
    int MAX_VALUE = 2147483647;
    private TeamNode root = null;

    TechnionTournament(){};

    @Override
    public void init() {
        TeamNode root = new TeamNode(new Team(new Faculty(MAX_VALUE,"root"),new ArrayList<Player>(),MAX_VALUE));
        TeamNode left = new TeamNode(new Team(new Faculty(MIN_VALUE,"left_sentiel"),new ArrayList<Player>(),MIN_VALUE));
        TeamNode middle = new TeamNode(new Team(new Faculty(MAX_VALUE,"middle_sentiel"),new ArrayList<Player>(),MAX_VALUE));
        left.setP(root);
        middle.setP(root);
        root.setLeft(left);
        root.setMiddle(middle);
        this.root = root;
    }


    @Override
    public void addFacultyToTournament(Faculty faculty) {

    }

    @Override
    public void removeFacultyFromTournament(int faculty_id) {

    }

    @Override
    public void addPlayerToFaculty(int faculty_id,Player player) {

    }

    @Override
    public void removePlayerFromFaculty(int faculty_id, int player_id) {

    }

    @Override
    public void playGame(int faculty_id1, int faculty_id2, int winner,
                         ArrayList<Integer> faculty1_goals, ArrayList<Integer> faculty2_goals) {

    }

    @Override
    public void getTopScorer(Player player) {

    }

    @Override
    public void getTopScorerInFaculty(int faculty_id, Player player) {

    }

    @Override
    public void getTopKFaculties(ArrayList<Faculty> faculties, int k, boolean ascending) {

    }

    @Override
    public void getTopKScorers(ArrayList<Player> players, int k, boolean ascending) {

    }

    @Override
    public void getTheWinner(Faculty faculty) {

    }

    ///TODO - add below your own variables and methods
}

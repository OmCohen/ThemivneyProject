import java.util.ArrayList;

public class TechnionTournament implements Tournament{

    static int MIN_VALUE = -2147483648;
    static int MAX_VALUE = 2147483647;
    static int MINUS_ONE = -1;
    private Tree facultyTree;
    private Tree tournamentFacultyTree;
    private Tree playersTree;
    private Node maxRankTeam;
    private Node maxScorePlayer;

    //constructor
    TechnionTournament(){
        this.facultyTree = null;
        this.tournamentFacultyTree = null;
        this.playersTree = null;
    }

    @Override
    public void init() {
        treeInit(this.facultyTree, MINUS_ONE);
        treeInit(this.tournamentFacultyTree);
        treeInit(this.playersTree);
    }


    @Override
    public void addFacultyToTournament(Faculty faculty) {
        //Create a team
        Team team = new Team(faculty);

        //Create a node for the faculty with same object
        TeamNode teamNodeForIDTree = new TeamNode(team,team.getRank(),faculty.getId());
        TeamNode teamNodeForRankTree = new TeamNode(team,team.getRank(), faculty.getId());

        //connect the id tree object to rank(id) tree object
        teamNodeForIDTree.setTwin(teamNodeForRankTree);

        //inserting the nodes to each tree
        Insert(teamRootByID,teamNodeForIDTree);
        Insert(teamRootByRank,teamNodeForRankTree);

        //connecting the new faculty to successor and predecessor
        Node predecessor = teamNodeForRankTree.predecessorTeam(teamNodeForRankTree);
        Node successor = teamNodeForRankTree.succssorTeam(teamNodeForRankTree);

        teamNodeForRankTree.setLeftSibling(predecessor);
        teamNodeForRankTree.setRightSibling(successor);

        //update successor left sibling and predecessor right sibling
        predecessor.setRightSibling(teamNodeForRankTree);
        successor.setLeftSibling(teamNodeForRankTree);

        //updating max as if the tree was empty or without scoring and faculty has the lowest id
        setMaxRankTeam(teamRootByRank);
    }

    @Override
    public void removeFacultyFromTournament(int faculty_id) {
        //searching
        //remove from both trees and update all pointers, update players
        TeamNode requestedTeamByID = (TeamNode) search(teamRootByID, faculty_id );
        //make all players as free agents
        int length = requestedTeamByID.getTeam().getPlayersList().size();
        for(int i = 0 ; i < length ; i++){
            requestedTeamByID.getTeam().setPlayersList();
        }

        //search for the faculty in the rank tree




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
    
    public void treeInit(Tree T){
        Node root = new Node(new Key(MIN_VALUE, MAX_VALUE));
        Node left = new Node(new Key(MAX_VALUE, MIN_VALUE));
        Node middle = new Node(new Key(MIN_VALUE, MAX_VALUE));
        left.setP(root);
        middle.setP(root);
        root.setLeft(left);
        root.setMiddle(middle);
        T.setRoot(root);
    }

    public void treeInit(Tree T, int minus){
        Node root = new Node(new Key(MIN_VALUE, minus));
        Node left = new Node(new Key(MAX_VALUE, minus));
        Node middle = new Node(new Key(MIN_VALUE, minus));
        left.setP(root);
        middle.setP(root);
        root.setLeft(left);
        root.setMiddle(middle);
        T.setRoot(root);
    }


//update key by ID
public void UpdateKey(Node x){
    x.setKey(x.getLeft().getKey());
    if (x.getMiddle() != null){
        x.setKey(x.getMiddle().getKey());
    }
    if (x.getRight() != null){
        x.setKey(x.getRight().getKey());
    }
}

public void setChildren(Node x, Node left, Node middle, Node right){
    x.setLeft(left);
    x.setMiddle(middle);
    x.setRight(right);
    left.setP(x);
    if (middle != null) {
        middle.setP(x);
    }
    if (right != null) {
    right.setP(x);
    }
    UpdateKey(x);
}

public Node Insert_And_Split(Node x, Node z) {
    Node left = x.getLeft();
    Node right = x.getRight();
    Node middle = x.getMiddle();

    if (right == null) {
        if ((z.getKey().compareTo(left.getKey()))) {
            setChildren(x, z, left, middle);
        } else if ((z.getKey().compareTo(middle.getKey()))) {
            setChildren(x, left, z, middle);
        } else {
            setChildren(x, left, middle, z);
        }
        return null;
    }

    Node y = new Node();
    if (z.getKey().compareTo(left.getKey())){
        setChildren(x, z, left, null);
        setChildren(y, middle, right, null);
    } else if (z.getKey().compareTo(middle.getKey())) {
        setChildren(x, left, z, null);
        setChildren(y, middle, right, null);
    } else if (z.getKey().compareTo(right.getKey())) {
        setChildren(x, left, middle, null);
        setChildren(y, z, right, null);
    } else {
        setChildren(x, left, middle, null);
        setChildren(y, right, z, null);
    }
    return y;
}

public void Insert(Tree T , Node z) {
    Node y = T.getRoot();
    while (y.getLeft() != null) {
        if (z.getKey().compareTo(y.getLeft().getKey())){
            y = y.getLeft();
        } else if (z.getKey().compareTo(y.getMiddle().getKey())) {
            y = y.getMiddle();
        } else {
            y = y.getRight();
        }
    }
    Node x = y.getP();
    Node extra_Node = new Node();
    extra_Node = Insert_And_Split(x, z);
    while (x != T.getRoot()) {
        x = x.getP();
        if (extra_Node != null) {
            extra_Node = Insert_And_Split(x, extra_Node);
        } else {
            UpdateKey(x);
        }
        if (extra_Node != null) {
            Node w = new Node();
            setChildren(w, x, extra_Node, null);
            T.setRoot(w);
        }
    }
}

public Node Borrow_Or_Merge(Node y){
    Node z = y.getP();
    if (y == z.getLeft()) {
        Node x = z.getMiddle();
        if (x.getRight() != null) {
            setChildren(y, y.getLeft(), x.getLeft(), null);
            setChildren(x, x.getMiddle(), x.getRight(), null);
        } else {
            setChildren(x, y.getLeft(), x.getLeft(), x.getMiddle());
            setChildren(z, x, z.getRight(), null);
        }
        return z;
    }
    if (y == z.getMiddle()) {
        Node x = z.getLeft();
        if (x.getRight() != null) {
            setChildren(y, x.getRight(), y.getLeft(), null);
            setChildren(x, x.getLeft(), x.getMiddle(), null);
        } else {
            setChildren(x, x.getLeft(), x.getMiddle(), y.getLeft());
            setChildren(z, x, z.getRight(), null);
        }
        return z;
    }
    Node x = z.getMiddle();
    if (x.getRight() != null) {
        setChildren(y, x.getRight(), y.getLeft(), null);
        setChildren(x, x.getLeft(), x.getMiddle(), null);
    } else {
        setChildren(x, x.getLeft(), x.getMiddle(), y.getLeft());
        setChildren(z, z.getLeft(), x, null);
    }
    return z;
}

public void Delete(Tree T, Node x) {
    Node y = x.getP();
    if (x == y.getLeft()) {
        setChildren(y, y.getMiddle(), y.getRight(), null);
    } else if (x == y.getMiddle()) {
        setChildren(y, y.getLeft(), y.getRight(), null);
    } else {
        setChildren(y, y.getLeft(), y.getMiddle(), null);
    }
    while (y != null){
        if (y.getMiddle() == null ){
            if (y  != T.getRoot()){
                y = Borrow_Or_Merge(y);
            }
            else {
                T.setRoot(y.getLeft());
                y.getLeft().setP(null);
                return;
            }
        }else{
            UpdateKey(y);
            y=y.getP();
        }
    }
}

public Node search(Node x, Key requestKey){
    if (x.getLeft() != null){
        if (x.getKey().isEqual(requestKey)){
            return x;
        }else {
            return null;}
    }
    if (requestKey.compareTo(x.getLeft().getKey()) || requestKey.isEqual(x.getLeft().getKey())){
        return search(x.getLeft(),requestKey);
    }else if (requestKey.compareTo(x.getMiddle().getKey()) || requestKey.isEqual(x.getMiddle().getKey()) ){
        return search(x.getMiddle(),requestKey);
    } else {
        return search(x.getRight(),requestKey);
    }



}

public Node maximum(Node root){
    Key maxKey = new Key(MIN_VALUE, MAX_VALUE);
    Node max = search(root, maxKey);
    return max.predecessor();
}

}
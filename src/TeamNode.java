public class TeamNode {
    private TeamNode left;
    private TeamNode right;
    private TeamNode middle;
    private TeamNode p;
    private Team team;


    public TeamNode(TeamNode left, TeamNode right, TeamNode middle, TeamNode p, Team team) {
        this.left = left;
        this.right = right;
        this.middle = middle;
        this.p = p;
        this.team = team;
    }

    public TeamNode(Team team){
        this.left = null;
        this.right = null;
        this.middle = null;
        this.p = null;
        this.team = team;

    }

    public TeamNode(){
        this.left = null;
        this.right = null;
        this.middle = null;
        this.p = null;
        this.team = null;

    }


    public TeamNode getLeft() {
        return left;
    }

    public TeamNode getRight() {
        return right;
    }

    public TeamNode getMiddle() {
        return middle;
    }

    public TeamNode getP() {
        return p;
    }

    public Team getTeam() {
        return team;
    }


    public void setLeft(TeamNode left) {
        this.left = left;
    }

    public void setRight(TeamNode right) {
        this.right = right;
    }

    public void setMiddle(TeamNode middle) {
        this.middle = middle;
    }

    public void setP(TeamNode p) {
        this.p = p;
    }
}

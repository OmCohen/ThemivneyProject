public class TeamNode extends Node {
    private Team team;


    public TeamNode(TeamNode left,TeamNode middle, TeamNode right, TeamNode p, TeamNode leftSibling, TeamNode rightSibling, Key key, Team team) {
        super(left,middle, right, p, leftSibling, rightSibling, key);
        this.team = team;
    }
    public TeamNode(Team team , Key key){
        super(key);
        this.team = team;
    }

    public TeamNode(Team team){
        super();
        this.team = team;
    }

    public TeamNode(){
        this(null);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

public class PlayerInTeam extends Player{
    Team inTeam;

    public PlayerInTeam(int id, String name, Team inTeam) {
        super(id, name);
        this.inTeam = inTeam;
    }

    public PlayerInTeam(int id, String name) {
        super(id, name);
        this.inTeam = null;
    }
}

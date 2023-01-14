public class PlayerInTeam extends Player{
    private Team inTeam;
    private int goals_number;

    public PlayerInTeam(int id, String name, Team inTeam, int goals_number) {
        super(id, name);
        this.inTeam = inTeam;
        this.goals_number=goals_number;
    }

    public PlayerInTeam(Player player,int goals_number){
        super(player.getId(),player.getName());
        this.inTeam = null;
        this.goals_number=goals_number;

    }
    public PlayerInTeam(Player player){
        super(player.getId(),player.getName());
        this.inTeam = null;
        this.goals_number=0;

    }

    public PlayerInTeam(int id, String name) {
        super(id, name);
        this.inTeam = null;
        this.goals_number=0;
    }


    public Team getInTeam() {
        return this.inTeam;
    }

    public void setInTeam(Team inTeam) {
        this.inTeam = inTeam;
    }

    public int getGoals_number() {
        return this.goals_number;
    }

    public void setGoals_number(int goals_number) {
        this.goals_number = goals_number;
    }



}

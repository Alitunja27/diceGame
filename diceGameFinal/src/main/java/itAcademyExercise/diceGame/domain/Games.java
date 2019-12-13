package itAcademyExercise.diceGame.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Games {

    @Id
    private Integer id;
    //private List<Integer> diceList = new ArrayList<>();
    private Integer dice1,dice2;
    private String gameResult;

    @ManyToOne
    private Player player;

    public Games() {
    }

    public Games(Integer id, Integer dice1, Integer dice2, String gameResult, Integer playerId){
        super();
        this.id = id;
        this.dice1=dice1;
        this.dice2=dice2;
        this.gameResult=gameResult;
        this.player=new Player(playerId,"",null,"");

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDice1() {
        return dice1;
    }

    public void setDice1(Integer dice1) {
        this.dice1 = dice1;
    }

    public Integer getDice2() {
        return dice2;
    }

    public void setDice2(Integer dice2) {
        this.dice2 = dice2;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}

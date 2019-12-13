package itAcademyExercise.diceGame.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Player {

    @Id
    private Integer id;
    private String playerName;
    private String playerRegisterDate;
    private Double successfulRate;



    public Player() {
    }

    public Player(Integer id, String playerName,Double successfulRate, String playerRegisterDate) {
        super();
        this.id = id;
        this.playerName = playerName;
        this.successfulRate = successfulRate;
        this.playerRegisterDate = playerRegisterDate;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerRegisterDate() {
        return playerRegisterDate;
    }

    public void setPlayerRegisterDate(String playerRegisterDate) {
        this.playerRegisterDate = playerRegisterDate;
    }

    public Double getSuccessfulRate() {
        return successfulRate;
    }

    public void setSuccessfulRate(Double successfulRate) {
        this.successfulRate = successfulRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getPlayerName().equals(player.getPlayerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayerName());
    }
}

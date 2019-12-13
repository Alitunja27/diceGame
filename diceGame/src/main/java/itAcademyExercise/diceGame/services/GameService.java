package itAcademyExercise.diceGame.services;

import itAcademyExercise.diceGame.domain.Games;
import itAcademyExercise.diceGame.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameService {
    private Integer id;
    private String gameResult;
    private Random randomGenerator = new Random();
    private Integer counter= 1;


    @Autowired
    GameRepository gameRepository;

    public void playGame(Integer playerId){
        int dice1 = randomGenerator.nextInt(6) + 1;
        int dice2 = randomGenerator.nextInt(6) + 1;

        if (dice1+dice2==7){
            gameResult = "Win";
        }else {
            gameResult = "Lose";
        }
        id=counter;
        counter++;
        Games playerGame = new Games(id,dice1,dice2,gameResult,playerId);
        gameRepository.save(playerGame);
    }

    public List<Games> getAllPlays(Integer id) {
        List<Games> allPlays = new ArrayList<Games>();
        gameRepository.findByPlayerId(id).forEach(allPlays::add);
        return allPlays;
    }

    @Transactional
    public void deletePlays(Integer playerId){
        gameRepository.deleteByPlayerId(playerId);
    }

    public Double successRateAllPlayer (){
        List<Games> allPlays = new ArrayList<Games>();
        gameRepository.findAll().forEach(allPlays::add);
        Double playerSuccessfulRate = Double.valueOf(0);
        for (int i=0;i<allPlays.size();i++){
            if (allPlays.get(i).getGameResult().equalsIgnoreCase("Win")){
                playerSuccessfulRate++;
            }
        }
        Double percentageSuccessfulRate = (playerSuccessfulRate*100)/allPlays.size();
        return percentageSuccessfulRate;
    }

}

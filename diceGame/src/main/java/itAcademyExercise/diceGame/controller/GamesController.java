package itAcademyExercise.diceGame.controller;


import itAcademyExercise.diceGame.domain.Games;
import itAcademyExercise.diceGame.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GamesController {

    @Autowired
    GameService gameService;

    @PostMapping("/players/{id}/play")
    public void playGame (@PathVariable Integer id){
        gameService.playGame(id);
    }

    @RequestMapping("/players/{id}/play")
    public List<Games> getAllPlays(@PathVariable Integer id){
        return gameService.getAllPlays(id);
    }

    @DeleteMapping("/players/{id}/play")
    public void deletePlays(@PathVariable Integer id){
        gameService.deletePlays(id);
    }

    @RequestMapping("/players/ranking")
    public Double getRanking(){
        return gameService.successRateAllPlayer();
    }
}
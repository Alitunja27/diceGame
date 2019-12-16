package itAcademyExercise.diceGame.controller;


import itAcademyExercise.diceGame.domain.Player;
import itAcademyExercise.diceGame.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController{

    @Autowired
    PlayerService playerService;

    @RequestMapping("/players")
    public List<Player> getAllPlayer(){
        return playerService.getAllPlayers();
    }

    @RequestMapping("/players/{id}")
    public Optional<Player> getPlayer(@PathVariable Integer id){
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public void addPlayer (@RequestBody Player newPlayer){
        playerService.addNewPlayer(newPlayer);
    }

    @PutMapping("/players/{id}")
    public void setPlayer (@PathVariable Integer id, @RequestBody Player newName){
        playerService.updatePlayerNewName(id,newName);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer (@PathVariable Integer id){
        playerService.deletePlayer(id);
    }

    @RequestMapping("/players/ranking/worst")
    public List<String> getAllPlayersOrderByWorstSuccessfulRate(){
        return playerService.getWorstPlayer();
    }

    @RequestMapping("/players/ranking/best")
    public List<String> getAllPlayersOrderByBestSuccessfulRate (){
        return playerService.getBestPlayer();
    }
}

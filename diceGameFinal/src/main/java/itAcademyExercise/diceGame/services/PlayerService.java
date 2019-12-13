package itAcademyExercise.diceGame.services;import itAcademyExercise.diceGame.domain.Games;import itAcademyExercise.diceGame.domain.Player;import itAcademyExercise.diceGame.repositories.GameRepository;import itAcademyExercise.diceGame.repositories.PlayerRepository;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import java.time.LocalDate;import java.util.*;@Servicepublic class PlayerService {    private String playerName;    private Integer id;    private Integer counter=1;    @Autowired    PlayerRepository playerRepository;    @Autowired    GameService gameService;    @Autowired    GameRepository gameRepository;    public List<Player> getAllPlayers (){        List<Player> allPlayers = new ArrayList<Player>();        playerRepository.findAll().forEach(allPlayers::add);        for (int i=0;i<allPlayers.size();i++){            Integer playerId = allPlayers.get(i).getId();            allPlayers.get(i).setSuccessfulRate(successfulRateByPlayerId(playerId));        }        return allPlayers;    }    public Optional<Player> getPlayer(Integer id) {        return playerRepository.findById(id);    }    public void addNewPlayer(Player newPlayer) {        if("".equals(newPlayer.getPlayerName())) {            newPlayer.setPlayerName("Anonymous");        }        LocalDate playerRegisterDate = LocalDate.now();        String strPlayerRegisterDate = playerRegisterDate.toString();        id=counter;        counter++;        Double successfulRate = Double.valueOf(0);        newPlayer.setId(id);        newPlayer.setSuccessfulRate(successfulRate);        newPlayer.setPlayerRegisterDate(strPlayerRegisterDate);        playerRepository.save(newPlayer);    }    @Transactional    public void updatePlayerNewName(Integer id, Player newName) {        String newPlayerName = newName.getPlayerName();        playerRepository.findById(id).get().setPlayerName(newPlayerName);    }    @Transactional    public void deletePlayer(Integer id) {        gameRepository.deleteByPlayerId(id);        playerRepository.deleteById(id);    }    public Double successfulRateByPlayerId (Integer playerId){        List <Games> allPlays = gameService.getAllPlays(playerId);        Double playerSuccessfulRate = Double.valueOf(0);        for (int i=0;i<allPlays.size();i++){            if (allPlays.get(i).getGameResult()=="Win"){                playerSuccessfulRate++;            }        }        Double percentageSuccessfulRateByPlayer = (playerSuccessfulRate*100)/allPlays.size();        return percentageSuccessfulRateByPlayer;    }    public String getWorstPlayer (){        List<Player> allPlayers = new ArrayList<Player>();        playerRepository.findAll().forEach(allPlayers::add);        for (int i=0;i<allPlayers.size();i++){            Integer playerId = allPlayers.get(i).getId();            allPlayers.get(i).setSuccessfulRate(successfulRateByPlayerId(playerId));        }        Comparator<Player> compareBySuccessfulRate = (Player p1, Player p2) -> p1.getSuccessfulRate().compareTo(p2.getSuccessfulRate());        Collections.sort(allPlayers, compareBySuccessfulRate);        String worstPlayer = allPlayers.get(0).getPlayerName();        return worstPlayer;    }    public String getBestPlayer (){        List<Player> allPlayers = new ArrayList<Player>();        playerRepository.findAll().forEach(allPlayers::add);        for (int i=0;i<allPlayers.size();i++){            Integer playerId = allPlayers.get(i).getId();            allPlayers.get(i).setSuccessfulRate(successfulRateByPlayerId(playerId));        }        Comparator<Player> compareBySuccessfulRate = (Player p1, Player p2) -> p1.getSuccessfulRate().compareTo(p2.getSuccessfulRate());        Collections.sort(allPlayers, compareBySuccessfulRate.reversed());        String bestPlayer = allPlayers.get(0).getPlayerName();        return bestPlayer;    }    @Override    public boolean equals(Object o) {        if (this == o) return true;        if (!(o instanceof PlayerService)) return false;        PlayerService that = (PlayerService) o;        return playerName.equals(that.playerName);    }    @Override    public int hashCode() {        return Objects.hash(playerName);    }}
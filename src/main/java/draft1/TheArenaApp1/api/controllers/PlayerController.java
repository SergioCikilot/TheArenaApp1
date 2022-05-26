package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.core.exceptions.ApiRequestException;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.dto.PlayerDtos.PlayerWithUserIdDto;
import draft1.TheArenaApp1.entities.model.Player;
import draft1.TheArenaApp1.repository.search.PlayerSearchDao;
import draft1.TheArenaApp1.service.services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerSearchDao playerSearchDao;

    @Autowired
    public PlayerController(PlayerService playerService, PlayerSearchDao playerSearchDao) {

        this.playerService = playerService;

        this.playerSearchDao = playerSearchDao;
    }

    @GetMapping("/search")
    public List<Player> getPlayersBySearch(@RequestParam String name){

        return this.playerSearchDao.findByPlayerNameUsingCustomQuery(name);

    }

    @GetMapping("/getAllPlayers")
    public List<Player> getAllPlayers(){

        return this.playerService
                .getAll();
    }

    @GetMapping("/getPlayersByTeam")
    public List<Player> getPlayersByTeam(@RequestParam int teamId){

        return this.playerService
                .getPlayersByTeam(teamId);
    }

    @GetMapping("/getPlayerAge")
    public String getPlayerAge(@RequestParam int playerId){

        Player player = this.playerService
                .getByPlayerPlayerId(playerId);
        return this.playerService
                .getPlayerAge(player);
    }

    @GetMapping("/getPlayerByUserId")
    public PlayerWithUserIdDto getPlayerByUserId(@RequestParam int userId){
        ModelMapper modelMapper = new ModelMapper();
        Player player = this.playerService
                .getPlayerByUserId(userId);
        if (player == null){

            throw new ApiRequestException("Player does not exist");
        }
        PlayerWithUserIdDto playerWithUserIdDto = modelMapper
                .map(player,PlayerWithUserIdDto.class);
        return playerWithUserIdDto;
    }

    @PostMapping("/addPlayer")
    public void addPlayer(@Valid @RequestBody PlayerWithUserIdDto playerWithUserIdDto){

        ModelMapper modelMapper = new ModelMapper();
        Player player = modelMapper
                .map(playerWithUserIdDto,Player.class);
        this.playerService
                .add(player);
    }

    @DeleteMapping("delete")
    public void deletePlayer(@RequestParam int id){

        this.playerService
                .delete(id);
    }

    @PutMapping("/updatePlayer")
    public void updatePlayer(@RequestBody PlayerWithUserIdDto playerWithIdUser) {

        ModelMapper modelMapper = new ModelMapper();
        Player player = modelMapper
                .map(playerWithIdUser,Player.class);
        this.playerService
                .updatePlayer(player);
    }

    @PutMapping("/updateTeamOfPlayer")
    public void updateTeamOfPlayer(@RequestParam int teamId,@RequestParam int playerId){

        this.playerService
                .addTeam(teamId, playerId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for (FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {

            validationErrors
                    .put(
                    fieldError.getField(),
                    fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors =
                new ErrorDataResult<Object>(validationErrors,"Validation Errors");
        return  errors;
    }

}

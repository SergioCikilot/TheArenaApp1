package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.core.exceptions.ApiRequestException;
import draft1.TheArenaApp1.core.exceptions.ExistingEntryException;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;

import draft1.TheArenaApp1.entities.dto.PlayerDtos.PlayerWithUserIdDto;
import draft1.TheArenaApp1.entities.dto.PlayerDtos.PlayerWithoutTeamDto;
import draft1.TheArenaApp1.entities.model.Player;

import draft1.TheArenaApp1.service.services.PlayerService;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayerController {


    private final PlayerService playerService;
    private final EntityManager entityManager;
    private ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public PlayerController(PlayerService playerService, EntityManager entityManager) {

        this.playerService = playerService;
        this.entityManager = entityManager;
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    //add---------------------------------------------------------------------------------------------------------------
    @PostMapping("/addPlayer")
    public int addPlayer(@Valid @RequestBody PlayerWithoutTeamDto playerWithoutTeamDto){

        Player player = modelMapper
                .map(playerWithoutTeamDto, Player.class);
        this.playerService
                .add(player);
        return player.getPlayerId();
    }
    //update------------------------------------------------------------------------------------------------------------
    @PutMapping("/updatePlayer")
    public void updatePlayer(@RequestBody PlayerWithUserIdDto playerWithIdUser) {

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
    //delete------------------------------------------------------------------------------------------------------------
    @DeleteMapping("delete")//rename
    public void deletePlayer(@RequestParam int id){

        this.playerService
                .delete(id);
    }
    //get---------------------------------------------------------------------------------------------------------------
    @GetMapping("/getAllPlayers")
    public List<Player> getAllPlayers(){

        return this.playerService
                .getAll();
    }
    @GetMapping("/getPlayersByTeam")
    public List<Player> getPlayersByTeamId(@RequestParam int teamId){

        return this.playerService.getPlayersByTeamId(teamId);
    }
    @GetMapping("/getPlayerAge")
    public String getPlayerAge(@RequestParam int playerId){

        Player player = this.playerService
                .getByPlayerPlayerId(playerId);
        return this.playerService
                .getPlayerAge(player);
    }
    @GetMapping("/getPlayerByPlayerName")
    public ResponseEntity<Player> getPlayerByPlayerName(String name)  {

            return ResponseEntity.ok(this.playerService
                    .getPlayerByPlayerName(name));
    }
    @GetMapping("/getPlayersByPlayerName")
    public List<Player> getPlayersByPlayerName(String name)  {

        return this.playerService.getPlayersByPlayerName(name);
    }
    @GetMapping("/getPlayerByUserId")
    public PlayerWithUserIdDto getPlayerByUserId(@RequestParam int userId){

        Player player = this.playerService
                .getPlayerByUserId(userId);
        if (player == null){

            throw new ApiRequestException("Player does not exist");
        }
        PlayerWithUserIdDto playerWithUserIdDto = modelMapper
                .map(player,PlayerWithUserIdDto.class);
        return playerWithUserIdDto;
    }
    //search------------------------------------------------------------------------------------------------------------
    @GetMapping("/search")
    public List<Player> getPlayersBySearch(@RequestParam String name) throws InterruptedException {

        //Get the FullTextEntityManager
        FullTextEntityManager fullTextEntityManager = Search
                .getFullTextEntityManager(entityManager);

        //Create a Hibernate Search DSL query builder for the required entity
        org.hibernate.search.query.dsl.QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Player.class)
                .get();

        //Generate a Lucene query using the builder
        org.apache.lucene.search.Query query = queryBuilder
                .keyword()
                .onField("playerName")
                .matching(name)
                .createQuery();


        org.hibernate.search.jpa.FullTextQuery fullTextQuery = fullTextEntityManager
                .createFullTextQuery(query, Player.class);


        //returns JPA managed entities
        List<Player> results = fullTextQuery
                .getResultList();

        /*FullTextEntityManager fullTextEntityManager = Search
                .getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Player.class)
                .get();

        org.apache.lucene.search.Query query = queryBuilder
                .keyword()
                .onField("playerName")
                .matching(name)
                .createQuery();

        org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager
                .createFullTextQuery(query, Player.class);

       List<Player> results = jpaQuery.getResultList();*/

        return results;
    }
    //handler-----------------------------------------------------------------------------------------------------------
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
    @ExceptionHandler(ExistingEntryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationExistException(ExistingEntryException exceptions){

        Map<String,String> validationErrors = new HashMap<String,String>();

        for (int i = 0; i < exceptions.getFieldList().size() ; i++) {

            validationErrors
                    .put(
                            exceptions.getFieldList()
                                    .get(i),
                            exceptions
                                    .getMessage());

        }

        ErrorDataResult<Object> errors =
                new ErrorDataResult<Object>(validationErrors,"Custom Validation Error");
        return  errors;
    }

}

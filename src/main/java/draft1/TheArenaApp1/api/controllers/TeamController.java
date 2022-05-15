package draft1.TheArenaApp1.api.controllers;


import draft1.TheArenaApp1.entities.dto.TeamDtos.TeamWithoutIdDto;
import draft1.TheArenaApp1.service.services.TeamService;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.model.Team;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {

    private TeamService teamService;

    @Autowired

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/getAllTeams")
    public List<Team> getAllTeams(){

        return this.teamService.getAllTeams();

    }

    @PostMapping("/addTeam")
    public void addTeam(@RequestBody TeamWithoutIdDto teamWithoutIdDto){

        ModelMapper modelMapper = new ModelMapper();
        Team team = modelMapper.map(teamWithoutIdDto,Team.class);
        this.teamService.addTeam(team);

    }

    @PutMapping("updateTeam")
    public void updateTeam(@RequestBody Team team){

        this.teamService.updateTeam(team);

    }

    @DeleteMapping("/deleteTeam")
    public void deleteTeam(@RequestParam int id){

        this.teamService.deleteTeam(id);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for (FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {

            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());

        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation Errors");
        return  errors;
    }

}

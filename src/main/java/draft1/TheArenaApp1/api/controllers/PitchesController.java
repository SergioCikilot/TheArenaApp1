package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.business.services.PitchService;
import draft1.TheArenaApp1.core.utilities.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.Pitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.sql.DriverManager;
import java.util.*;


@RestController
@RequestMapping("/api/pitches")
public class PitchesController {

    private PitchService pitchService;

    @Autowired
    public PitchesController(PitchService pitchService) {
        this.pitchService = pitchService;
    }


    @GetMapping("/getAll")
    public List<Pitch> getAll(){


        return this.pitchService.getAll();
    }


    @PostMapping("/add")
    public void add(@RequestBody Pitch pitch){

        this.pitchService.add(pitch);

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

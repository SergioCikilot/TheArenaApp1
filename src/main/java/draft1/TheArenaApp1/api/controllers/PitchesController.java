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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@RestController
@RequestMapping("/pitch")
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

    @PutMapping("/updateOpeningTimeToPitch")
    public void addTOpeningTimeToPitch(@RequestParam LocalTime openingTime, @RequestParam int pitchId){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String value = openingTime.format(dateTimeFormatter);
        this.pitchService.addPitchOpeningTime(value,pitchId);

    }

    @PutMapping("/updateClosingTimeToPitch")
    public void addClosingTimeToPitch(@RequestParam LocalTime closingTime, @RequestParam int pitchId){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String value = closingTime.format(dateTimeFormatter);
        this.pitchService.addPitchOpeningTime(value,pitchId);

    }

    @PutMapping("/updatePitchMatchDuration")
    public void addPitchMatchDuration(@RequestParam LocalTime duration, @RequestParam int pitchId){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String value = duration.format(dateTimeFormatter);
        this.pitchService.addPitchOpeningTime(value,pitchId);

    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Pitch pitch){

        this.pitchService.delete(pitch);

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

package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.business.services.DateService;
import draft1.TheArenaApp1.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/date")
public class DateController {

    private DateService dateService;

    @Autowired
    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/getTime12Hour")
    public String getFormattedTime12Hour(){

        return this.dateService.getFormattedCurrentTime12Hour();

    }

    @GetMapping("/getTime24Hour")
    public String getFormattedTime24Hour(){

        return this.dateService.getFormattedCurrentTime24Hour();

    }

    @GetMapping("/getTimeIstanbul24Hour")
    public String getFormattedTimeIstanbul24Hour(){

        return this.dateService.getFormattedCurrentTimeIstanbul24Hour();

    }

    @GetMapping("/getDateIstanbul")
    public String getFormattedDateIstanbul(){

        return this.dateService.getFormattedCurrentDateIstanbul();

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

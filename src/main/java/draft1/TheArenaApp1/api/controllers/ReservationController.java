package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.business.managers.ReservationManager;
import draft1.TheArenaApp1.business.services.ReservationService;
import draft1.TheArenaApp1.core.utilities.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.Reservation;
import draft1.TheArenaApp1.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationManager;

    @Autowired
    public ReservationController(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    @GetMapping("/getAll")
    public List<Reservation> getAll(){

        return this.reservationManager.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Reservation reservation){

        this.reservationManager.add(reservation);

    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Reservation reservation){

        this.reservationManager.delete(reservation);

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

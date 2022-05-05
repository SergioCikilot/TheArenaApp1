package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.business.managers.ReservationManager;
import draft1.TheArenaApp1.business.services.ReservationService;
import draft1.TheArenaApp1.core.utilities.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationManager reservationManager) {
        this.reservationService = reservationManager;
    }

    @GetMapping("/getAll")
    public List<Reservation> getAllReservations(){

        return this.reservationService.getAllReservations();
    }

    @PostMapping("/add")
    public void addReservation(@RequestBody Reservation reservation){

        this.reservationService.addReservation(reservation);

    }

    @PutMapping("/updateReservationTime")
    public void updateReservationTime(@RequestParam LocalTime reservationTime, @RequestParam int reservationId){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String value = reservationTime.format(dateTimeFormatter);
        this.reservationService.updateReservationTime(value,reservationId);

    }

    @PutMapping("/updateReservationDate")
    public void updateReservationDate(@RequestParam LocalDate reservationDate, @RequestParam int reservationId){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String value = reservationDate.format(dateTimeFormatter);
        this.reservationService.updateReservationDate(value,reservationId);

    }

    @DeleteMapping("/delete")
    public void deleteReservation(@RequestBody Reservation reservation){

        this.reservationService.deleteReservation(reservation);

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

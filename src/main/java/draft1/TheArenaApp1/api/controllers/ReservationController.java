package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithIdPlayerPitch;
import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithoutLocalDateTime;
import draft1.TheArenaApp1.entities.model.Player;
import draft1.TheArenaApp1.service.managers.ReservationManager;
import draft1.TheArenaApp1.service.services.ReservationService;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.model.Reservation;
import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithPlayerAndPitchIdDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationManager reservationManager) {
        this.reservationService = reservationManager;
    }

    @GetMapping("/getAllReservations")
    public List<ReservationWithoutLocalDateTime> getAllReservations(){

        ModelMapper modelMapper = new ModelMapper();
        return this.reservationService
                .getAllReservations()
                .stream()
                .map(reservation -> modelMapper
                        .map(reservation, ReservationWithoutLocalDateTime.class))
                .collect(Collectors
                        .toList());

    }
    @GetMapping("/getReservationsByPlayerId")
    public List<ReservationWithoutLocalDateTime> getReservationsByPlayerId(@RequestParam int id){

        ModelMapper modelMapper = new ModelMapper();
        List <Reservation> list =this.reservationService
                .getReservationsByPlayerId(id);
        Type listType =
                new TypeToken<List<ReservationWithoutLocalDateTime>>(){}
                        .getType();
        List<ReservationWithoutLocalDateTime> ReservationWithoutLocalDateTime = modelMapper
                .map(list,listType);
        return ReservationWithoutLocalDateTime;

    }

    @PostMapping("/addReservation")
    public void addReservation(@Valid @RequestBody ReservationWithPlayerAndPitchIdDto reservationWithPlayerAndPitchIdDto){

        ModelMapper modelMapper = new ModelMapper();
        Reservation reservation = modelMapper
                .map(reservationWithPlayerAndPitchIdDto,Reservation.class);
        this.reservationService
                .addReservation(reservation);

    }

    @PutMapping("/updateReservation")
    public void updateReservation(@Valid @RequestBody ReservationWithIdPlayerPitch reservationWithIdPlayerPitch){

        ModelMapper modelMapper = new ModelMapper();
        Reservation reservation = modelMapper
                .map(reservationWithIdPlayerPitch,Reservation.class);
        this.reservationService
                .updateReservation(reservation);

    }

    @PutMapping("/updateReservationTime")
    public void updateReservationTime(@Valid @RequestParam LocalTime reservationTime, @RequestParam int reservationId){

        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter
                        .ofPattern("HH:mm:ss");
        String value = reservationTime
                .format(dateTimeFormatter);
        this.reservationService
                .updateReservationTime(value,reservationId);

    }

    @PutMapping("/updateReservationDate")
    public void updateReservationDate(@Valid @RequestParam LocalDate reservationDate, @RequestParam int reservationId){

        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter
                        .ofPattern("dd-MM-yyyy");
        String value = reservationDate
                .format(dateTimeFormatter);
        this.reservationService
                .updateReservationDate(value,reservationId);

    }

    @DeleteMapping("/deleteReservation")
    public void deleteReservation(@RequestParam int id){

        this.reservationService
                .deleteReservation(id);

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

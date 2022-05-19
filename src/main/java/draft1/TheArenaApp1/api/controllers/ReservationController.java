package draft1.TheArenaApp1.api.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import draft1.TheArenaApp1.core.exceptions.ExistingEntryException;
import draft1.TheArenaApp1.core.utils.status.Status;
import draft1.TheArenaApp1.core.validators.ReservationValidator;
import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithIdPlayerPitch;
import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithoutLocalDateTime;
import draft1.TheArenaApp1.service.managers.ReservationManager;
import draft1.TheArenaApp1.service.services.ReservationService;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.model.Reservation;
import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithPlayerAndPitchIdDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;
    private ReservationValidator reservationValidator;

    @Autowired
    public ReservationController(ReservationManager reservationManager, ReservationValidator reservationValidator) {
        this.reservationService = reservationManager;
        this.reservationValidator = reservationValidator;
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
    @GetMapping("/getAllReservationsByPitchId")
    public List<ReservationWithoutLocalDateTime> getAllReservationsByPitchId(@RequestParam int id){

        ModelMapper modelMapper = new ModelMapper();

        List <Reservation> list =this.reservationService
                .findReservationsByPitchPitchId(id);
        Type listType =
                new TypeToken<List<ReservationWithoutLocalDateTime>>(){}
                        .getType();
        List<ReservationWithoutLocalDateTime> ReservationWithoutLocalDateTime = modelMapper
                .map(list,listType);
        return ReservationWithoutLocalDateTime;

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
    public void addReservation(@Valid @RequestBody ReservationWithPlayerAndPitchIdDto reservationWithPlayerAndPitchIdDto) throws ExistingEntryException {

        //map
        ModelMapper modelMapper = new ModelMapper();
        Reservation reservation = modelMapper
                .map(reservationWithPlayerAndPitchIdDto,Reservation.class);

        ArrayList<String> arrayList = new ArrayList<>();
        if (!reservationValidator.IsValid(reservation)){

            arrayList.add("Reservation");

            throw new ExistingEntryException("Reservation is already exists",arrayList);

        }

        else

            this.reservationService.addReservation(reservation);

    }

    @PutMapping("/updateReservation")
    public void updateReservation(@Valid @RequestBody ReservationWithIdPlayerPitch reservationWithIdPlayerPitch) throws ExistingEntryException {

        ModelMapper modelMapper = new ModelMapper();
        Reservation reservation = modelMapper
                .map(reservationWithIdPlayerPitch,Reservation.class);

        if (!reservationValidator.IsValid(reservation)){

            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("Reservation");

            throw new ExistingEntryException("Reservation is already exists",arrayList);

        }
        this.reservationService
                .updateReservation(reservation);

    }

    @PutMapping("/updateReservationTime")
    public void updateReservationTime(@Valid @RequestParam LocalTime reservationTime, @RequestParam int reservationId) throws ExistingEntryException {

        Reservation reservation = this.reservationService.getByReservationId(reservationId);

        if (!reservationValidator.IsValid(reservation)){

            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("Reservation");

            throw new ExistingEntryException("Reservation is already exists",arrayList);

        }

        this.reservationService
                .updateReservationTime(reservationTime,reservationId);

    }

    @PutMapping("/updateReservationDate")
    public void updateReservationDate(@Valid @RequestParam  LocalDate reservationDate, @RequestParam int reservationId) throws ExistingEntryException {


        Reservation reservation = this.reservationService.getByReservationId(reservationId);
        reservation.setReservationDate(reservationDate);
        if (!reservationValidator.IsValid(reservation)){

            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("Reservation");

            throw new ExistingEntryException("Reservation is already exists",arrayList);

        }
        this.reservationService
                .updateReservationDate(reservationDate,reservationId);

    }
@GetMapping("/getReservationStatus")
    public Status getReservationStatus(@RequestParam int id){

        return this.reservationService.getReservationStatus(id);

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

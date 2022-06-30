package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.core.exceptions.ExistingEntryException;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.core.utils.status.Status;
import draft1.TheArenaApp1.core.validators.ReservationValidator;
import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithIdPlayerPitch;
import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithPlayerAndPitchIdDto;
import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithoutLocalDateTime;
import draft1.TheArenaApp1.entities.dto.ReservationDtos.ReservationWithoutPlayerDto;
import draft1.TheArenaApp1.entities.model.Reservation;
import draft1.TheArenaApp1.service.managers.ReservationManager;
import draft1.TheArenaApp1.service.services.ReservationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationValidator reservationValidator;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ReservationController(ReservationManager reservationManager, ReservationValidator reservationValidator) {
        this.reservationService = reservationManager;
        this.reservationValidator = reservationValidator;
    }

    //add---------------------------------------------------------------------------------------------------------------
    @PostMapping("/addReservation")
    public void addReservation(@Valid @RequestBody ReservationWithPlayerAndPitchIdDto reservationWithPlayerAndPitchIdDto) throws ExistingEntryException {

        ModelMapper modelMapper1 = new ModelMapper();
        //map
        reservationWithPlayerAndPitchIdDto.setReservationIsRated(false);
        Reservation reservation = modelMapper
                .map(reservationWithPlayerAndPitchIdDto, Reservation.class);
        ArrayList<String> arrayList = new ArrayList<>();
        if (!reservationValidator.IsValid(reservation)){

            arrayList.add("Reservation");
            throw new ExistingEntryException("Reservation is already exists",arrayList);
        }
        this.reservationService.addReservation(reservation);
    }
    @PostMapping("/addReservationWithoutPlayer")
    public void addReservationWithoutPlayer(@RequestBody ReservationWithoutPlayerDto reservationWithoutPlayerDto) throws ExistingEntryException {

        //map

        reservationWithoutPlayerDto.setReservationIsRated(false);

        Reservation reservation = modelMapper
                .map(reservationWithoutPlayerDto, Reservation.class);
        ArrayList<String> arrayList = new ArrayList<>();
        if (!reservationValidator.IsValid(reservation)){

            arrayList.add("Reservation");
            throw new ExistingEntryException("Reservation is already exists",arrayList);
        }
        this.reservationService.addReservation(reservation);
    }
    //update------------------------------------------------------------------------------------------------------------
    @PutMapping("/updateReservation")
    public void updateReservation( @RequestBody ReservationWithIdPlayerPitch reservationWithIdPlayerPitch) throws ExistingEntryException {

        Reservation reservation = modelMapper
                .map(reservationWithIdPlayerPitch,Reservation.class);
        this.reservationService
                .updateReservation(reservation);
    }
    @PutMapping("/updateReservationTime")
    public void updateReservationTime(@Valid @RequestParam LocalTime reservationTime, @RequestParam int reservationId) throws ExistingEntryException {

        Reservation reservation = this.reservationService
                .getByReservationId(reservationId);
        if (!reservationValidator.IsValid(reservation)){

            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("Reservation");
            throw new ExistingEntryException("Reservation is already exists",arrayList);
        }
        this.reservationService
                .updateReservationTime(reservationTime,reservationId);
    }

    @PutMapping("/updateReservationIsRated")
    public void updateReservationIsRated(@RequestParam int reservationId,@RequestParam boolean reservationIsRated) throws ExistingEntryException {

        this.reservationService
                .updateReservationIsRated(reservationIsRated,reservationId);

    }

    @PutMapping("/updateReservationDate")
    public void updateReservationDate(@Valid @RequestParam  LocalDate reservationDate, @RequestParam int reservationId) throws ExistingEntryException {


        Reservation reservation = this.reservationService
                .getByReservationId(reservationId);
        reservation.setReservationDate(reservationDate);
        if (!reservationValidator.IsValid(reservation)){

            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("Reservation");

            throw new ExistingEntryException("Reservation is already exists",arrayList);
        }
        this.reservationService
                .updateReservationDate(reservationDate,reservationId);
    }
    //delete------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/deleteReservation")
    public void deleteReservation(@RequestParam int id){

        this.reservationService
                .deleteReservation(id);
    }
    //get---------------------------------------------------------------------------------------------------------------
    @GetMapping("/getReservationStatus")
    public Status getReservationStatus(@RequestParam int id){

        return this.reservationService
                .getReservationStatus(id);
    }
    @GetMapping("/getAllReservations")
    public List<ReservationWithoutLocalDateTime> getAllReservations(){

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

        List <Reservation> list =this.reservationService
                .getReservationsByPlayerId(id);
        Type listType =
                new TypeToken<List<ReservationWithoutLocalDateTime>>(){}
                        .getType();
        List<ReservationWithoutLocalDateTime> ReservationWithoutLocalDateTime = modelMapper
                .map(list,listType);
        return ReservationWithoutLocalDateTime;
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

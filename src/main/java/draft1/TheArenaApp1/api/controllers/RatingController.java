package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.core.entities.ratings.PitchRating;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.dto.PitchRatingDtos.PitchRatingDto;
import draft1.TheArenaApp1.service.services.PitchRatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final PitchRatingService pitchRatingService;

    @Autowired
    public RatingController(PitchRatingService pitchRatingService) {
        this.pitchRatingService = pitchRatingService;
    }

    @PostMapping("addPitchRating")
    public void addPitchRating(@Valid @RequestBody PitchRatingDto pitchRatingDto){

        ModelMapper modelMapper = new ModelMapper();
        PitchRating pitchRating = modelMapper
                .map(pitchRatingDto,PitchRating.class);
        this.pitchRatingService
                .addPitchRating(pitchRating);

    }

    @DeleteMapping("deletePitchRating")
    public void deletePitchRating(@RequestParam int id){

        this.pitchRatingService
                .deletePitchRating(id);

    }
    @PutMapping("updatePitchRating")
    public void updatePitchRating(@RequestBody PitchRatingDto pitchRatingDto){

        ModelMapper modelMapper = new ModelMapper();
        PitchRating pitchRating = modelMapper
                .map(pitchRatingDto,PitchRating.class);
        this.pitchRatingService
                .addPitchRating(pitchRating);

    }
    @GetMapping("getPitchRatingsByPitchId")
    public void getPitchRatingsByPitchId(@RequestParam int id){

        this.pitchRatingService
                .getPitchRatingsByPitchId(id);

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

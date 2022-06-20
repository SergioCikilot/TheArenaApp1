package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.entities.model.PitchRating;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.dto.PitchRatingDtos.PitchRatingDto;
import draft1.TheArenaApp1.service.services.PitchRatingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final PitchRatingService pitchRatingService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public RatingController(PitchRatingService pitchRatingService) {

        this.pitchRatingService = pitchRatingService;
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    //add---------------------------------------------------------------------------------------------------------------
    @PostMapping("addPitchRating")
    public void addPitchRating(@Valid @RequestBody PitchRatingDto pitchRatingDto){

        PitchRating pitchRating = modelMapper
                .map(pitchRatingDto,PitchRating.class);
        this.pitchRatingService
                .addPitchRating(pitchRating);
    }
    //update------------------------------------------------------------------------------------------------------------
    @PutMapping("updatePitchRating")
    public void updatePitchRating(@RequestBody PitchRatingDto pitchRatingDto){

        PitchRating pitchRating = modelMapper
                .map(pitchRatingDto,PitchRating.class);
        this.pitchRatingService
                .addPitchRating(pitchRating);
    }
    //delete------------------------------------------------------------------------------------------------------------
    @DeleteMapping("deletePitchRating")
    public void deletePitchRating(@RequestParam int id){

        this.pitchRatingService
                .deletePitchRating(id);
    }
    //get---------------------------------------------------------------------------------------------------------------
    @GetMapping("getPitchRatingsByPitchId")
    public List<PitchRatingDto> getPitchRatingsByPitchId(@RequestParam int id){

        return this.pitchRatingService
                .getPitchRatingsByPitchId(id)
                .stream()
                .map(PitchRating -> modelMapper
                        .map(PitchRating, PitchRatingDto.class))
                .collect(Collectors
                        .toList());
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
}

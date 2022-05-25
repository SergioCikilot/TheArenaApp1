package draft1.TheArenaApp1.api.controllers;


import draft1.TheArenaApp1.core.entities.comments.Comment;
import draft1.TheArenaApp1.core.entities.ratings.PitchRating;
import draft1.TheArenaApp1.entities.dto.CommentDtos.CommentDto;
import draft1.TheArenaApp1.entities.dto.PitchDtos.PitchDto;
import draft1.TheArenaApp1.entities.dto.PitchDtos.PitchWithoutIdDto;

import draft1.TheArenaApp1.entities.dto.PitchRatingDtos.PitchRatingDto;
import draft1.TheArenaApp1.service.services.CommentService;
import draft1.TheArenaApp1.service.services.PitchRatingService;
import draft1.TheArenaApp1.service.services.PitchService;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.model.Pitch;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@RestController
@RequestMapping("/pitch")
public class PitchesController {

    private final PitchService pitchService;
    private final CommentService commentService;
    private final PitchRatingService pitchRatingService;
    @Autowired
    public PitchesController(PitchService pitchService, CommentService commentService, PitchRatingService pitchRatingService) {

        this.pitchService = pitchService;
        this.commentService = commentService;
        this.pitchRatingService = pitchRatingService;
    }

    /*@PostMapping("/addCommentAndRating")
    public void addCommentAndRating(@RequestBody CommentDto commentDto, @RequestBody PitchRatingDto pitchRatingDto){

        ModelMapper modelMapper = new ModelMapper();
        Comment comment = modelMapper
                .map(commentDto,Comment.class);
        this.commentService
                .addComment(comment);

        PitchRating pitchRating = modelMapper
                .map(pitchRatingDto,PitchRating.class);
        this.pitchRatingService
                .addPitchRating(pitchRating);

    }/*


    /*@GetMapping("/searchPitchByName")
    List<Pitch> searchPitchByName(@RequestParam String name){

        return this.pitchService.findByPitchName(name);
    }*/

    @GetMapping("/getAllPitches")
    public List<Pitch> getAllPitches(){

        return this.pitchService
                .getAllPitches();

         /*ModelMapper modelMapper = new ModelMapper();
        return this.pitchService
                .getAllPitches()
                .stream()
                .map(pitch -> modelMapper
                        .map(pitch, PitchDto.class))
                .collect(Collectors
                        .toList());*/
    }

    @GetMapping("/getAllPitchesByPage")
    public List<Pitch> getAllPitchesByPage(@RequestParam int pageNo,@RequestParam int pageSize){

        return this.pitchService
                .getAllPitchesWithPage(pageNo,pageSize);
    }

    @PostMapping("/addPitch")
    public void addPitch(@RequestBody PitchWithoutIdDto pitchWithoutIdDto){

        ModelMapper modelMapper = new ModelMapper();
        Pitch pitch = modelMapper
                .map(pitchWithoutIdDto,Pitch.class);
        this.pitchService
                .addPitch(pitch);
    }

    @DeleteMapping("/deletePitch")
    public void deletePitch(@RequestParam int id){

        this.pitchService
                .deletePitch(id);
    }

    @PutMapping("/updatePitch")
    public void updatePitch(@RequestBody PitchDto pitchDto){

        ModelMapper modelMapper = new ModelMapper();
        Pitch pitch = modelMapper
                .map(pitchDto,Pitch.class);
        this.pitchService
                .updatePitch(pitch);
    }

    @PutMapping("/updatePitchOpeningTime")
    public void updateTOpeningTimeToPitch(@RequestParam LocalTime openingTime, @RequestParam int pitchId){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("HH:mm:ss");
        String value = openingTime
                .format(dateTimeFormatter);
        this.pitchService
                .updatePitchOpeningTime(value,pitchId);
    }

    @PutMapping("/updatePitchClosingTime")
    public void updateClosingTimeToPitch(@RequestParam LocalTime closingTime, @RequestParam int pitchId){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("HH:mm:ss");
        String value = closingTime
                .format(dateTimeFormatter);
        this.pitchService
                .updatePitchClosingTime(value,pitchId);
    }

    @PutMapping("/updatePitchMatchDuration")
    public void updatePitchMatchDuration(@RequestParam LocalTime duration, @RequestParam int pitchId){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("HH:mm:ss");
        String value = duration
                .format(dateTimeFormatter);
        this.pitchService
                .updatePitchMatchDuration(value,pitchId);
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

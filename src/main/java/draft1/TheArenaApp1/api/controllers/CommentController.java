package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.entities.model.Comment;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.dto.CommentDtos.CommentDto;
import draft1.TheArenaApp1.service.services.CommentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private ModelMapper modelMapper = new ModelMapper();

    //cons--------------------------------------------------------------------------------------------------------------
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
        //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    }
    //add---------------------------------------------------------------------------------------------------------------
    @PostMapping("addComment")
    public void addComment(@RequestBody CommentDto commentDto){

        Comment comment = modelMapper
                .map(commentDto,Comment.class);
        this.commentService
                .addComment(comment);
    }
    //update------------------------------------------------------------------------------------------------------------
    @PutMapping("updateComment")
    public void updateComment(@RequestBody CommentDto commentDto){

        Comment comment = modelMapper
                .map(commentDto,Comment.class);
        this.commentService
                .addComment(comment);
    }
    //delete------------------------------------------------------------------------------------------------------------
    @DeleteMapping ("deleteComment")
    public void deleteComment(@RequestParam int id){

        this.commentService
                .deleteComment(id);
    }
    //get---------------------------------------------------------------------------------------------------------------
    @GetMapping("getCommentsByCommentTarget")
    public List<CommentDto> getCommentsByCommentTarget(@RequestParam int id){

        return this.commentService
                .findCommentsByCommentTarget(id)
                .stream()
                .map(comment -> modelMapper
                        .map(comment,CommentDto.class))
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

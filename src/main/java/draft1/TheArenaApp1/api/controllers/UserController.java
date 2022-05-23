package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.core.exceptions.CustomHandler;
import draft1.TheArenaApp1.core.exceptions.ExistingEntryException;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.core.user.User;
import draft1.TheArenaApp1.core.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;

    }

    @PostMapping("/login")
    public String login() throws Exception {

            return "login screen";

    }

    @PostMapping("/signup")
    public void addUser(@Valid @RequestBody User user) throws Exception {

        this.userService
                .add(user);

    }

    @GetMapping("/getUserDetailsByUsername")
    public UserDetails getUserDetailsByUsername(@RequestParam String username) throws Exception {

        return this.userService
                .loadUserByUsername(username);

    }

    @GetMapping("/getUserIdByUsername")
    public int getUserIdByUsername(@RequestParam String username) throws Exception {

        UserDetails userDetails = this.userService
                .loadUserByUsername(username);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper
                .map(userDetails,User.class);
        int id = user
                .getUserId();
        return id;

    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){

        return this.userService
                .getAll();

    }
    @GetMapping("/getUserByUsername")
    public User getUserByUsername(@RequestParam String username){

        return this.userService
                .findUserByUsername(username);

    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User user){

        this.userService
                .delete(user);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(
            MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for (FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {

            String field = fieldError
                    .getField();
            String message = fieldError
                    .getDefaultMessage();
            validationErrors
                    .put(
                            field,
                            message);

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


    /*@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationAllException(Exception exceptions){

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(exceptions.getMessage(),"Validation Error3");
        return  errors;
    }*/
    /*@ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationTheException(DataIntegrityViolationException exceptions){

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(exceptions.getMessage(),"Validation Error2");
        return  errors;
    }*/
}


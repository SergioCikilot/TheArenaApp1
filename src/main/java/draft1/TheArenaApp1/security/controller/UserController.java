package draft1.TheArenaApp1.security.controller;

import draft1.TheArenaApp1.core.utilities.results.ErrorDataResult;
import draft1.TheArenaApp1.security.auth.User;
import draft1.TheArenaApp1.security.auth.UserService;
import draft1.TheArenaApp1.security.jwt.UsernameAndPasswordAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }
    @PostMapping("/signup")
    public void add(@RequestBody User user){

        this.userService.add(user);

    }

    @GetMapping("/getAll")
    public List<User> getAll(){

        return this.userService.getAll();

    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody User user){

        this.userService.delete(user);

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


package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.core.user.UserDao;
import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import draft1.TheArenaApp1.core.user.User;
import draft1.TheArenaApp1.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
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
    public void addUser(@Valid @RequestBody User user) throws Exception {

            this.userService.add(user);


    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){

        return this.userService.getAll();

    }
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User user){

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
    /*@ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationTheException(DataIntegrityViolationException exceptions){

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(exceptions.getMessage(),"Validation Error2");
        return  errors;
    }*/

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationAllException(Exception exceptions){

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(exceptions.getMessage(),"Validation Error3");
        return  errors;
    }


}


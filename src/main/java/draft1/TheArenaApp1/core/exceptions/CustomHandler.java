package draft1.TheArenaApp1.core.exceptions;

import draft1.TheArenaApp1.core.utils.results.ErrorDataResult;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CustomHandler {

    private  ErrorDataResult<Object> errorDataResult;
    private List<Exception> fieldList;


    public CustomHandler() {}

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

        return errors;

    }

}




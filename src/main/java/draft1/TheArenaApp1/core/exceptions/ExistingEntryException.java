package draft1.TheArenaApp1.core.exceptions;


import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
@Data
public class ExistingEntryException extends Exception {

    private ArrayList<String> fieldList;

    public ExistingEntryException(String message, ArrayList<String> fieldList) {
        super(message);

        this.fieldList = fieldList;
    }


}

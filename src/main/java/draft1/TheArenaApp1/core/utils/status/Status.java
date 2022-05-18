package draft1.TheArenaApp1.core.utils.status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Status {

    private String message = "Status:";

    public boolean statusFieldExists(Object object){

        List<Field> arrayList = new ArrayList<>();
        arrayList = List
                .of(
                        object.getClass()
                                .getClass()
                                .getFields());
        for (Field field: arrayList) {

            if (field.equals(Status.class))
            return true;

        }
        return false;
    }

    public HashMap<String,String> getStatus(){

        return null;

    }

}



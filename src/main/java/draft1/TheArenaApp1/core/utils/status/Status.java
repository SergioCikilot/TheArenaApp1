package draft1.TheArenaApp1.core.utils.status;

import draft1.TheArenaApp1.entities.model.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class Status {

    @Column(name = "status_status")
    private String status;

    public Status(String status) {
        this.status = status;
    }

    /*public boolean statusFieldExists(Object object){

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
    }*/


}



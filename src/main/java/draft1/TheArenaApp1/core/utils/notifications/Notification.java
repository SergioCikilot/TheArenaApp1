package draft1.TheArenaApp1.core.utils.notifications;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Notification {

    private int notificationId;
    private boolean notificationIsSeen;
    private int notificationReceiverId;
}

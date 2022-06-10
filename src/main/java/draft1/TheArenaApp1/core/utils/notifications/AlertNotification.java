package draft1.TheArenaApp1.core.utils.notifications;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertNotification extends MessageNotification{

    //Devam et

    public AlertNotification(int notificationId, boolean notificationIsSeen, int notificationReceiverId, String message) {
        super(notificationId, notificationIsSeen, notificationReceiverId, message);
    }
}

package draft1.TheArenaApp1.core.utils.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageNotification extends Notification{

    private String message;

    public MessageNotification(int notificationId, boolean notificationIsSeen, int notificationReceiverId, String message) {

        super(notificationId, notificationIsSeen, notificationReceiverId);
        this.message = message;

    }
}

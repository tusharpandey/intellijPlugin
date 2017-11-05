import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.util.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class BranchMessage extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        try {
            runScript();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        NotNullLazyValue<NotificationGroup> NOTIFICATION_GROUP = new NotNullLazyValue<NotificationGroup>() {
            @NotNull
            @Override
            protected NotificationGroup compute() {
                return new NotificationGroup(
                        "Motivational message",
                        NotificationDisplayType.STICKY_BALLOON,
                        true);
            }
        };

        ApplicationManager.getApplication()
                .invokeLater(
                        () -> Notifications.Bus.notify(NOTIFICATION_GROUP.getValue()
                                .createNotification(
                                        "Quote of the day",
                                        "best in the business" + " " + "CM. PUNK",
                                        NotificationType.INFORMATION,
                                        null)),
                        ModalityState.NON_MODAL);
    }

    public void runScript() throws IOException, InterruptedException {
        String path = "D:\\intellij_plugin_development\\checkForPull.sh";
        Runtime.getRuntime().exec("cmd /c start " + path);
    }
}

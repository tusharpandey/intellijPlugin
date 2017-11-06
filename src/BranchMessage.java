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

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.Executors;

public class BranchMessage extends AnAction {
    
    //Hello world

    @Override
    public void actionPerformed(AnActionEvent e) {
        String valueReturned = null;
        try {
            runScript();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("return value : " + valueReturned);
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

    public String runScript() throws IOException, InterruptedException {
        System.out.println("return value : hellow rodl");
        String path = "D:\\intellij_plugin_development\\checkForPull\\checkForPull.sh";
        String command = "cmd /c start " + path;
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        java.util.Scanner s = new java.util.Scanner(process.getInputStream());
        String data = s.hasNext() ? s.next() : "";
        System.out.println("return value : " + data);
        return data;
    }
}

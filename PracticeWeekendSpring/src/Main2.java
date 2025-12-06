
// NotificationService using IoC via Constructor Injection
public class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendNotification(String recipient, String message) {
        messageSender.sendMessage(recipient, message);
    }
}


public class Main {
    public static void main(String[] args) {

        MessageSender emailSender = new EmailSender();

        NotificationService emailNotificationService = new NotificationService(emailSender);

        emailNotificationService.sendNotification("john.doe@example.com", "Hello via Email!");

        MessageSender smsSender = new SMSSender();

        NotificationService smsNotificationService = new NotificationService(smsSender);

        smsNotificationService.sendNotification("+1234567890", "Hello via SMS!");
    }
}


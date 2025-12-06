public interface INotificationSender{
	public void sendNotification(String recipient , String message) ;
}

class EmailSender implements INotificationSender {
	public void sendNotification(String recipient , String message)
	{
		System.out.println("Sending email to "+recipient+": "+message);
	}
}

class SmsSender implements INotificationSender{
	public void sendNotification(String recipient, String message) {
		System.out.println("Sending SMS to "+recipient+": "+message);
	}
}

class PushNotificationSender implements INotificationSender{
	public void sendNotification(String recipient, String message) {
		System.out.println("Sending push notification to "+recipient+": "+message);
	}
}

class NotificationService {
	private final INotificationSender sender;
	
	public NotificationService(INotificationSender sender) {
		this.sender = sender;
	}
	
	public void notify(String recipient , String message) {
		sender.sendNotification(recipient, message);
	}
}
public class Main {
	NotificationService email = new NotificationService(new EmailSender());
	NotificationService sms = new NotificationService(new SmsSender());
	NotificationService push = new NotificationService(new PushNotificationSender());
}

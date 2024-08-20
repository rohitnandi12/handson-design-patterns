package design_patterns.behavioral.strategy.spring.notification;

public class EmailNotificationStrategy implements NotificationStrategy {
    @Override
    public void sendNotification(Message message) {
        if (message instanceof EmailMessage eMsg) {
            System.out.printf("Email was sent!%n To: %s,%n Subject: %s. %n %s%n",
                    eMsg.getTo(), eMsg.getSubject(), eMsg.getBody());
        } else {
            throw new IllegalArgumentException("Not an EmailMessage");
        }
    }
}

package design_patterns.behavioral.strategy.spring.notification;

public class SmsNotificationStrategy implements NotificationStrategy {
    @Override
    public void sendNotification(Message message) {
        if (message instanceof SmsMessage sMsg) {
            System.out.printf("Sms was sent!%n To: %s,%n PhoneNumber: %s. %n %s%n",
                    sMsg.getTo(), sMsg.getPhoneNumber(), sMsg.getBody());
        } else {
            throw new IllegalArgumentException("Not an EmailMessage");
        }
    }
}


package design_patterns.behavioral.strategy.notifier;

public class SmsNotifier implements MessageNotifier {

    private String to;
    private String body;

    @Override
    public void sendNotification(Message message) {
        if (message instanceof SmsMessage msg) {
            this.to = msg.getTo();
            this.body = msg.getBody();
            send();
        } else {
            throw new IllegalArgumentException("SmsNotifier was sent unknown message object");
        }

    }

    private void send() {
        System.out.printf("SMS was sent!%n To: %s, %n %s%n",
                to, body);
    }
}

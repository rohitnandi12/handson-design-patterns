package design_patterns.behavioral.strategy.notifier;

public class EmailNotifier implements MessageNotifier {

    private String to;
    private String subject;
    private String body;

    @Override
    public void sendNotification(Message message) {
        if (message instanceof EmailMessage eMsg) {
            this.to = eMsg.getTo();
            this.subject = eMsg.getSubject();
            this.body = eMsg.getBody();
            send();
        } else {
            throw new IllegalArgumentException("EmailNotifier was sent unknown message object");
        }
    }

    private void send() {
        System.out.printf("Email was sent!%n To: %s,%n Subject: %s. %n %s%n",
                to, subject, body);
    }
}

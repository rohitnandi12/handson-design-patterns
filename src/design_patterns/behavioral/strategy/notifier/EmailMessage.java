package design_patterns.behavioral.strategy.notifier;

public class EmailMessage extends Message {
    private final String subject;

    public EmailMessage(String to, String subject, String body) {
        super(to, body);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}

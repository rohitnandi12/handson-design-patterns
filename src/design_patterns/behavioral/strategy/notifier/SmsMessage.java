package design_patterns.behavioral.strategy.notifier;

public class SmsMessage extends Message {
    public SmsMessage(String to, String body) {
        super(to, body);
    }
}

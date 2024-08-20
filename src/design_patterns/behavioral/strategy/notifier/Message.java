package design_patterns.behavioral.strategy.notifier;

public class Message {
    private final String to;
    private final String body;

    public Message(String to, String body) {
        this.to = to;
        this.body = body;
    }

    public String getTo() {
        return this.to;
    }

    public String getBody() {
        return body;
    }
}

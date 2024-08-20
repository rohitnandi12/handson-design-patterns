package design_patterns.behavioral.strategy.spring.notification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailMessage extends Message {
    private String subject;

    @Override
    public String toString() {
        return "EmailMessage{" +
                super.toString() +
                "subject='" + subject + '\'' +
                '}';
    }
}

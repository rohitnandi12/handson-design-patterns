package design_patterns.behavioral.strategy.spring.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsMessage extends Message {
    private String phoneNumber;

    @Override
    public String toString() {
        return "SmsMessage{" +
                super.toString() +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

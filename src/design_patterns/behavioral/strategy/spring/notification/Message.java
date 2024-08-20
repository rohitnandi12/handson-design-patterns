package design_patterns.behavioral.strategy.spring.notification;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmailMessage.class, name = "EMAIL"),
        @JsonSubTypes.Type(value = SmsMessage.class, name = "SMS")
})
public abstract class Message {
    //    private String type; // used by JsonTypeInfo; Necessary to pass in json body.
    private MessageType messageType;
    private String to;
    private String body;

    @Override
    public String toString() {
        return  "messageType=" + messageType +
                ", to='" + to + '\'' +
                ", body='" + body + '\'';
    }
}

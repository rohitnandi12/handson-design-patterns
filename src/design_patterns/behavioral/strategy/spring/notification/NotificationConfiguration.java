package design_patterns.behavioral.strategy.spring.notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

@Configuration
public class NotificationConfiguration {

    @Bean
    public NotificationStrategyFactory notificationStrategyFactory() {
        Map<MessageType, NotificationStrategy> strategies = new EnumMap<>(MessageType.class);
        strategies.put(MessageType.EMAIL, new EmailNotificationStrategy());
        strategies.put(MessageType.SMS, new SmsNotificationStrategy());

        return new NotificationStrategyFactory(strategies);
    }
}

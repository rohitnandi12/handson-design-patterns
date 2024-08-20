package design_patterns.behavioral.strategy.spring.notification;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationStrategyFactory strategyFactory;

    public NotificationService(NotificationStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public void sendNotification(Message message) {
        NotificationStrategy strategy = strategyFactory.getStrategy(message.getMessageType());
        if (strategy != null) {
            strategy.sendNotification(message);
        } else {
            throw new IllegalArgumentException("No notification strategy found for type");
        }
    }
}

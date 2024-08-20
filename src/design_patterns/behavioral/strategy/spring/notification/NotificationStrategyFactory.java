package design_patterns.behavioral.strategy.spring.notification;

import java.util.Map;

public class NotificationStrategyFactory {

    private final Map<MessageType, NotificationStrategy> strategies;

    public NotificationStrategyFactory(Map<MessageType, NotificationStrategy> strategies) {
        this.strategies = strategies;
    }

    public NotificationStrategy getStrategy(MessageType messageType) {
        return strategies.get(messageType);
    }

}

package design_patterns.behavioral.strategy.notifier;

public class OrderServiceContext {

    private MessageNotifier notificationStrategy;

    public void setMessageNotifier(MessageNotifier messageNotifier) {
        this.notificationStrategy = messageNotifier;
    }

    public void sendNotification(Message message) {
        // frame a message
        notificationStrategy.sendNotification(message);
    }
}

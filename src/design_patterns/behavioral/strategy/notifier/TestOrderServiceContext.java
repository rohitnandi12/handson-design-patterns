package design_patterns.behavioral.strategy.notifier;

public class TestOrderServiceContext {

    /**
     * below method shows incorrect way of usage of strategy pattern, because it is not
     * thread safe.
     * @param args
     */
    public static void main2(String[] args) {
        OrderServiceContext orderServiceContext = new OrderServiceContext();
        orderServiceContext.setMessageNotifier(new EmailNotifier());

        // Thread 1
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            orderServiceContext.sendNotification(
                    new EmailMessage("Rohit", "Some Subject", "Some body")
            );
        }).start();

        // Thread 2
        new Thread(() -> {
            orderServiceContext.setMessageNotifier(new SmsNotifier());
            orderServiceContext.sendNotification(
                    new SmsMessage("To Someone", "Some body")
            );
        }).start();
    }

    /**
     * Use immutability to ensure concurrency issue
     * @param args
     */
    public static void main(String[] args) {
        OrderServiceContext orderServiceWithEmailNotifierContext = new OrderServiceContext();
        orderServiceWithEmailNotifierContext.setMessageNotifier(new EmailNotifier());

        OrderServiceContext orderServiceWithSmsNotifierContext = new OrderServiceContext();
        orderServiceWithSmsNotifierContext.setMessageNotifier(new SmsNotifier());

        // Thread 1
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            orderServiceWithEmailNotifierContext.sendNotification(
                    new EmailMessage("Rohit", "Some Subject", "Some body")
            );
        }).start();

        // Thread 2
        new Thread(() -> {
            orderServiceWithSmsNotifierContext.sendNotification(
                    new SmsMessage("To Someone", "Some body")
            );
        }).start();
    }
}

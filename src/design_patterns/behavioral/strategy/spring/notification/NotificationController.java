package design_patterns.behavioral.strategy.spring.notification;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/email/send")
    public ResponseEntity<String> sendEmailNotification(
            @RequestBody EmailMessage message
    ) {
        notificationService.sendNotification(message);
        return ResponseEntity.ok("Email Message sent successfully");
    }

    @PostMapping("/sms/send")
    public ResponseEntity<String> sendSmsNotification(
            @RequestBody SmsMessage message
    ) {
        notificationService.sendNotification(message);
        return ResponseEntity.ok("SMS Message sent successfully");
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendSmsNotification(
            @RequestBody Message message
    ) {
        System.out.println(message);
        notificationService.sendNotification(message);
        return ResponseEntity.ok(Message.class.getName() + " sent successfully");
    }
}

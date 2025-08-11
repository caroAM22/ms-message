package com.pragma.plazoleta.infrastructure.adapters.output;

import com.pragma.plazoleta.domain.model.MessageModel;
import com.pragma.plazoleta.domain.spi.INotificationServicePort;
import com.pragma.plazoleta.infrastructure.exception.InfrastructureException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService implements INotificationServicePort {
    
    @Value("${twilio.account.sid}")
    private String accountSid;
    
    @Value("${twilio.auth.token}")
    private String authToken;
    
    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Override
    public String sendNotification(MessageModel messageModel) {
        try {
            Twilio.init(accountSid, authToken);
            
            Message message = Message.creator(
                    new PhoneNumber(messageModel.getPhoneNumber()),
                    new PhoneNumber(twilioPhoneNumber),
                    messageModel.getMessage())
                    .create();

            return "Message sent successfully with SID: " + message.getSid();
            
        } catch (Exception e) {
            throw new InfrastructureException("Failed to send message: " + e.getMessage());
        }
    }
} 
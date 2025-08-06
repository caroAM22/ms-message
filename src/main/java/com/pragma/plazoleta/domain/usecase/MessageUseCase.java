package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IMessageServicePort;
import com.pragma.plazoleta.domain.model.MessageModel;
import com.pragma.plazoleta.domain.spi.ITwilioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageUseCase implements IMessageServicePort {
    
    private final ITwilioServicePort twilioServicePort;

    @Override
    public String sendMessage(MessageModel messageModel) {
        return twilioServicePort.sendNotification(messageModel);
    }
} 
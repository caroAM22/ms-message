package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IMessageServicePort;
import com.pragma.plazoleta.domain.model.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageUseCase implements IMessageServicePort {
    
    private final IMessageServicePort messageServicePort;

    @Override
    public String sendNotification(MessageModel messageModel) {
        return messageServicePort.sendNotification(messageModel);
    }
} 
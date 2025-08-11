package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IMessageServicePort;
import com.pragma.plazoleta.domain.model.MessageModel;
import com.pragma.plazoleta.domain.spi.INotificationServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageUseCase implements IMessageServicePort {
    
    private final INotificationServicePort notificationServicePort;

    @Override
    public String sendMessage(MessageModel messageModel) {
        return notificationServicePort.sendNotification(messageModel);
    }
} 
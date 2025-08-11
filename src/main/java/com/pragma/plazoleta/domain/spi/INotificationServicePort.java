package com.pragma.plazoleta.domain.spi;

import com.pragma.plazoleta.domain.model.MessageModel;

public interface INotificationServicePort {
    String sendNotification(MessageModel messageModel);
} 
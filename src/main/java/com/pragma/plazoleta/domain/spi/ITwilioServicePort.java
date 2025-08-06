package com.pragma.plazoleta.domain.spi;

import com.pragma.plazoleta.domain.model.MessageModel;

public interface ITwilioServicePort {
    String sendNotification(MessageModel messageModel);
} 
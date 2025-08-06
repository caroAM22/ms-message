package com.pragma.plazoleta.domain.api;

import com.pragma.plazoleta.domain.model.MessageModel;

public interface IMessageServicePort {
    String sendMessage(MessageModel messageModel);
} 
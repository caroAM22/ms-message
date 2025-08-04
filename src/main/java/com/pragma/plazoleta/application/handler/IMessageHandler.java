package com.pragma.plazoleta.application.handler;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;
import com.pragma.plazoleta.application.dto.response.MessageResponseDto;

public interface IMessageHandler {
    MessageResponseDto sendNotification(MessageRequestDto messageRequestDto);
} 
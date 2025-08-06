package com.pragma.plazoleta.application.handler.impl;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;
import com.pragma.plazoleta.application.dto.response.MessageResponseDto;
import com.pragma.plazoleta.application.handler.IMessageHandler;
import com.pragma.plazoleta.application.mapper.IMessageRequestMapper;
import com.pragma.plazoleta.domain.api.IMessageServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class MessageHandler implements IMessageHandler {
    private final IMessageServicePort messageServicePort;
    private final IMessageRequestMapper messageRequestMapper;

    @Override
    public MessageResponseDto sendNotification(MessageRequestDto messageRequestDto) {
        String result = messageServicePort.sendMessage(messageRequestMapper.toModel(messageRequestDto));
        
        MessageResponseDto response = new MessageResponseDto();
        response.setMessage(result);
        response.setStatus("SUCCESS");
        response.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        return response;
    }
} 
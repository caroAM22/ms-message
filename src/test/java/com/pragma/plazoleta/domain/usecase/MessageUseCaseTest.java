package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IMessageServicePort;
import com.pragma.plazoleta.domain.model.MessageModel;
import com.pragma.plazoleta.domain.spi.ITwilioServicePort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MessageUseCaseTest {

    @Mock
    private IMessageServicePort messageServicePort;

    @Mock
    private ITwilioServicePort twilioServicePort;

    private MessageUseCase messageUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        messageUseCase = new MessageUseCase(twilioServicePort);
    }

    @Test
    void shouldSendNotificationSuccessfully() {
        MessageModel messageModel = new MessageModel("Test message", "+573001234567");
        String expectedResponse = "Message sent successfully";
        
        when(twilioServicePort.sendNotification(messageModel)).thenReturn(expectedResponse);
        String result = messageUseCase.sendMessage(messageModel);

        assertNotNull(result);
        assertEquals(expectedResponse, result);
        verify(twilioServicePort, times(1)).sendNotification(messageModel);
    }
} 
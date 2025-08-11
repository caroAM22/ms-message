package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IMessageServicePort;
import com.pragma.plazoleta.domain.model.MessageModel;
import com.pragma.plazoleta.domain.spi.INotificationServicePort;

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
    private INotificationServicePort notificationServicePort;

    private MessageUseCase messageUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        messageUseCase = new MessageUseCase(notificationServicePort);
    }

    @Test
    void shouldSendNotificationSuccessfully() {
        MessageModel messageModel = new MessageModel("Test message", "+573001234567");
        String expectedResponse = "Message sent successfully";
        
        when(notificationServicePort.sendNotification(messageModel)).thenReturn(expectedResponse);
        String result = messageUseCase.sendMessage(messageModel);

        assertNotNull(result);
        assertEquals(expectedResponse, result);
        verify(notificationServicePort, times(1)).sendNotification(messageModel);
    }
} 
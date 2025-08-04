package com.pragma.plazoleta.infrastructure.input.rest;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;
import com.pragma.plazoleta.application.dto.response.MessageResponseDto;
import com.pragma.plazoleta.application.handler.IMessageHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
@Tag(name = "Notification", description = "Notification management endpoints")
public class MessageRestController {
    
    private final IMessageHandler messageHandler;

    @PostMapping("/send")
    @PreAuthorize("hasAnyRole('EMPLOYEE')")
    @Operation(summary = "Send notification", description = "Send a notification message via SMS")
    @ApiResponse(responseCode = "200", description = "Notification sent successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MessageResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Invalid request data")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<MessageResponseDto> sendNotification(@Valid @RequestBody MessageRequestDto messageRequestDto) {
        MessageResponseDto response = messageHandler.sendNotification(messageRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
} 
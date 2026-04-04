package com.relness.fintrack.dto;

import java.time.LocalDateTime;
import lombok.Data;


@Data
public class ErrorMessage {

    private String message;
    private LocalDateTime timestamp;
}
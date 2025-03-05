package com.example.e_commerce_EmailSender.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EmailDTO(@Valid @NotNull UUID userId,
                                           @Valid @NotNull String emailTo,
                                           @Valid @NotNull String subject,
                                           @Valid @NotNull String text) {
}

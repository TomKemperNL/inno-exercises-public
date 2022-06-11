package nl.hu.sd.tennis.application.dto;

import jakarta.validation.constraints.NotBlank;

public record NewGameDTO(
        @NotBlank(message = "server must not be blank") String server,
        @NotBlank(message = "receiver must not be blank") String receiver) {
}

package com.acortador.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UrlDataDto(
    @NotBlank(message = "la url no puede ser vacía")
    @Pattern(regexp = "^(http|https)://.*$", message = "la url debe comenzar con http:// o https://")
    String longUrl) {}

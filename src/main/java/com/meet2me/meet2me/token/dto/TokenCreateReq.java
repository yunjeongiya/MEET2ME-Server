package com.meet2me.meet2me.token.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenCreateReq {
    @NotBlank(message = "User name cannot be blank")
    @Size(min = 3, max = 20, message = "User name must be between 3 and 20 characters")
    private String username;
}

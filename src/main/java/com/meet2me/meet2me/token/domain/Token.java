package com.meet2me.meet2me.token.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Token {
    String username;
    String tokenValue;
    String roomId;
}
package com.meet2me.meet2me.token.repository;

import com.meet2me.meet2me.token.domain.Token;

import java.util.List;

public interface TokenRepository {
    boolean save(Token token);
    Token findByToken(String token);
    boolean deleteByToken(String token);
    List<Token> findAllByRoomId(String roomId);
}
package com.meet2me.meet2me.token.repository;

import com.meet2me.meet2me.token.domain.Token;

public interface TokenRepository {
    boolean save(Token token);
    Token findByToken(String token);
    boolean deleteByToken(String token);
    boolean existsByUsername(String username);
}
package com.meet2me.meet2me.token.repository;

import com.meet2me.meet2me.token.domain.Token;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryTokenRepository implements TokenRepository {
    private final Map<String, Token> tokens = new HashMap<>();
    @Override
    public boolean save(Token token) {
        if(tokens.containsKey(token.getValue())) {
            return false;
        }
        tokens.put(token.getValue(), token);
        return true;
    }

    @Override
    public Token findByToken(String token) {
        return tokens.get(token);
    }

    @Override
    public boolean deleteByToken(String token) {
        return tokens.remove(token) != null;
    }

    @Override
    public boolean existsByToken(String token) {
        return tokens.containsKey(token);
    }
}

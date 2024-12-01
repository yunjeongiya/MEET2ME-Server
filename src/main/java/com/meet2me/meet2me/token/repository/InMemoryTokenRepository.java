package com.meet2me.meet2me.token.repository;

import com.meet2me.meet2me.token.domain.Token;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryTokenRepository implements TokenRepository {
    private final Map<String, Token> tokens = new HashMap<>();
    @Override
    public boolean save(Token token) {
        if(tokens.containsKey(token.getTokenValue())) {
            return false;
        }
        tokens.put(token.getTokenValue(), token);
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
    public List<Token> findAllByRoomId(String roomId) {
        return tokens.values().stream()
                .filter(token -> token.getRoomId().equals(roomId)).toList();
    }
}

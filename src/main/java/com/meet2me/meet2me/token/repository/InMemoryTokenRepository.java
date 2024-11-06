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
    public boolean existsByUsername(String username) {
        return tokens.entrySet().stream()
                .anyMatch(entry -> entry.getValue().getUsername().equals(username));
        // 전체 순회
        // 대안 1. username-token 인 hashmap 하나 더 두고 동시에 관리 -> 동시성 문제 야기 가능
        // 대안 2. username-token 인 hashmap 만 관리하고 token 으로 삭제할 땐 token 에서 username parsing 해 와서 사용
        // 대안 3. database 사용하기
    }
}

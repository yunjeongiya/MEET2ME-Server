package com.meet2me.meet2me.token;

import com.meet2me.meet2me.room.repository.RoomRepository;
import com.meet2me.meet2me.token.domain.Token;
import com.meet2me.meet2me.token.dto.TokenCreateSuccessRes;
import com.meet2me.meet2me.token.repository.TokenRepository;
import io.livekit.server.AccessToken;
import io.livekit.server.RoomJoin;
import io.livekit.server.RoomName;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;
    private final RoomRepository roomRepository;
    @Value("${livekit.api.key}")
    private String apiKey;
    @Value("${livekit.api.secretKey}")
    private String secret;
    @Value("${livekit.api.ttl}")
    private Long ttl;

    public TokenCreateSuccessRes createToken(String roomId, String username) {
        if(!roomRepository.existsById(roomId)) {
            throw new IllegalArgumentException("Room does not exist");
        }

        if(tokenRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("this username already exists in the room");
        }

        AccessToken token = new AccessToken(apiKey, secret);
        token.setIdentity(username);
        token.setTtl(ttl); //long millis
        token.addGrants(new RoomJoin(true), new RoomName(roomId));
        String jwtToken = token.toJwt();

        if(!tokenRepository.save(new Token(username, jwtToken))) {
            throw new IllegalArgumentException("token could not be saved");
        }
        return new TokenCreateSuccessRes(jwtToken);
    }

    public void deleteToken(String roomId, String token) {
        if(!roomRepository.existsById(roomId)) {
            throw new IllegalArgumentException("Room does not exist");
        }


        if(!tokenRepository.deleteByToken(token)) {
            throw new IllegalArgumentException("Token does not exist");
        }

        //TODO if this was the last token of the room, delete the room
    }
}

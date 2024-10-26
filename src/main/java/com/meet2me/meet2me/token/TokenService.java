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

        AccessToken token = new AccessToken(apiKey, secret);

        // Fill in token information.
        token.setName(username);
        token.setIdentity("identity");
        // token.setMetadata("metadata");
        token.setTtl(ttl); //long millis
        token.addGrants(new RoomJoin(true), new RoomName(roomId));
        String jwtToken = token.toJwt();
        if(tokenRepository.existsByToken(jwtToken)) {
            throw new IllegalArgumentException("token already exists for this username in the room");
        }
        tokenRepository.save(new Token(jwtToken));
        return new TokenCreateSuccessRes(jwtToken);
    }
}

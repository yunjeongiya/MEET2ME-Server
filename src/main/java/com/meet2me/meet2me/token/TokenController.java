package com.meet2me.meet2me.token;

import com.meet2me.meet2me.token.dto.TokenCreateSuccessRes;
import com.meet2me.meet2me.token.dto.TokenCreateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TokenController {
    private final TokenService tokenService;

    @PostMapping("/rooms/{roomId}/tokens")
    public ResponseEntity<TokenCreateSuccessRes> createToken(@PathVariable String roomId, @RequestBody TokenCreateReq tokenCreateReq) {
        return ResponseEntity.ok(tokenService.createToken(roomId, tokenCreateReq.getUsername()));
    }

    @DeleteMapping("/rooms/{roomId}/tokens/{token}")
    public ResponseEntity<Void> deleteToken(@PathVariable String roomId, @PathVariable String token) {
        tokenService.deleteToken(roomId, token);
        return ResponseEntity.noContent().build();
    }
}

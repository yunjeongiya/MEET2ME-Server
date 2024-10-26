package com.meet2me.meet2me.token;

import com.meet2me.meet2me.token.dto.TokenCreateSuccessRes;
import com.meet2me.meet2me.token.dto.TokenCreateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenController {
    private final TokenService tokenService;

    @PostMapping("/rooms/{roomId}/tokens")
    public ResponseEntity<TokenCreateSuccessRes> createToken(@PathVariable String roomId, @RequestBody TokenCreateReq tokenCreateReq) {
        return ResponseEntity.ok(tokenService.createToken(roomId, tokenCreateReq.getUsername()));
    }
}

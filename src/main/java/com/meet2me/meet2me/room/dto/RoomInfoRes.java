package com.meet2me.meet2me.room.dto;
import com.meet2me.meet2me.token.domain.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomInfoRes {
    String roomId;
    List<Token> tokenList;
}
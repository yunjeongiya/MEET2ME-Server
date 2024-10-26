package com.meet2me.meet2me.room;

import com.meet2me.meet2me.room.dto.RoomCreateSuccessRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @PostMapping()
    public ResponseEntity<RoomCreateSuccessRes> createRoom() {
        return ResponseEntity.ok(roomService.createRoom());
    }
}

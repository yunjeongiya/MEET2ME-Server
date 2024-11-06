package com.meet2me.meet2me.room;

import com.meet2me.meet2me.room.dto.RoomCreateSuccessRes;
import com.meet2me.meet2me.room.dto.RoomInfoRes;
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

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomInfoRes> getRoom(@PathVariable String roomId) {
        return ResponseEntity.ok(roomService.getRoom(roomId));
    }
}

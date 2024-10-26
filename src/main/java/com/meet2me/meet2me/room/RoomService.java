package com.meet2me.meet2me.room;

import com.meet2me.meet2me.room.domain.Room;
import com.meet2me.meet2me.room.dto.RoomCreateSuccessRes;
import com.meet2me.meet2me.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomCreateSuccessRes createRoom() {
        String roomId = UUID.randomUUID().toString();
        Room room = new Room(roomId);
        if(!roomRepository.save(room)) {
            throw new IllegalStateException("Failed to save room");
        }
        return new RoomCreateSuccessRes(roomId);
    }
}
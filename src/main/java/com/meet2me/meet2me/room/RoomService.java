package com.meet2me.meet2me.room;

import com.meet2me.meet2me.room.domain.Room;
import com.meet2me.meet2me.room.dto.RoomCreateSuccessRes;
import com.meet2me.meet2me.room.dto.RoomInfoRes;
import com.meet2me.meet2me.room.repository.RoomRepository;
import com.meet2me.meet2me.token.domain.Token;
import com.meet2me.meet2me.token.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final TokenRepository tokenRepository;

    public RoomCreateSuccessRes createRoom() {
        String roomId = UUID.randomUUID().toString();
        Room room = new Room(roomId);
        if(!roomRepository.save(room)) {
            throw new IllegalStateException("Failed to save room");
        }
        return new RoomCreateSuccessRes(roomId);
    }

    public RoomInfoRes getRoom(String roomId) {
        if(!roomRepository.existsById(roomId)) {
            throw new IllegalStateException("Room not found");
        }
        List<Token> tokens = tokenRepository.findAllByRoomId(roomId);
        return new RoomInfoRes(roomId, tokens);
    }

    public List<RoomInfoRes> getRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().map(room -> getRoom(room.getRoomId())).toList();
    }

    public void deleteRoom(String roomId) {
        if(!roomRepository.existsById(roomId)) {
            throw new IllegalStateException("Room not found");
        }
        tokenRepository.findAllByRoomId(roomId).forEach(token -> tokenRepository.deleteByToken(token.getTokenValue()));
        roomRepository.deleteById(roomId);
    }

    public void deleteAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        rooms.forEach(room -> deleteRoom(room.getRoomId()));
    }
}
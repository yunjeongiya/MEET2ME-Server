package com.meet2me.meet2me.room.repository;

import com.meet2me.meet2me.room.domain.Room;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryRoomRepository implements RoomRepository {
    private final Map<String, Room> rooms = new HashMap<>();
    @Override
    public boolean save(Room room) {
        if(rooms.containsKey(room.getRoomId())) {
            return false;
        }
        rooms.put(room.getRoomId(), room);
        return true;
    }

    @Override
    public boolean existsById(String roomId) {
        return rooms.containsKey(roomId);
    }

    @Override
    public Room findById(String roomId) {
        return rooms.get(roomId);
    }

    @Override
    public boolean deleteById(String roomId) {
        return rooms.remove(roomId) != null;
    }

    @Override
    public List<Room> findAll() {
        return rooms.values().stream().toList();
    }
}

package com.meet2me.meet2me.room.repository;

import com.meet2me.meet2me.room.domain.Room;

public interface RoomRepository {
    boolean save(Room room);
    boolean existsById(String roomId);
    Room findById(String roomId);
    boolean deleteById(String roomId);
}

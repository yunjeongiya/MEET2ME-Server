package com.meet2me.meet2me.room.repository;

import com.meet2me.meet2me.room.domain.Room;

import java.util.List;

public interface RoomRepository {
    boolean save(Room room);
    boolean existsById(String roomId);
    Room findById(String roomId);
    boolean deleteById(String roomId);
    List<Room> findAll();
}

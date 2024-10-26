package com.meet2me.meet2me.room;

import com.meet2me.meet2me.room.dto.RoomCreateSuccessRes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RoomControllerTest {

    @InjectMocks
    private RoomController roomController;

    @Mock
    private RoomService roomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRoom() {
        // Arrange
        String roomId = "sampleRoomId";
        RoomCreateSuccessRes response = new RoomCreateSuccessRes(roomId);
        when(roomService.createRoom()).thenReturn(response);

        // Act
        ResponseEntity<RoomCreateSuccessRes> result = roomController.createRoom();

        // Assert
        assertEquals(ResponseEntity.ok(response), result);
    }
}

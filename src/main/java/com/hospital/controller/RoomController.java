package com.hospital.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.Room;
import com.hospital.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 2017/3/17.
 */
@Controller
@RequestMapping("/")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "admin/room/{page}", method = RequestMethod.GET)
    @ResponseBody
    public String getRoom(@PathVariable String page) {
        int pages = Integer.parseInt(page);
        List rooms = roomService.getAllRoom();
        List<Room> subrooms = null;
        int fromIndex = (pages - 1) * 10;
        int total = (rooms.size()-1)/10+1;
        if (rooms.size() >= fromIndex) {
            int toIndex = pages * 10;
            if (rooms.size() >= toIndex) {
                subrooms = rooms.subList(fromIndex, toIndex);
            } else {
                subrooms = rooms.subList(fromIndex, rooms.size());
            }
        }
        class templateInfo {
            Integer id;
            String roomName;
        }
        List<templateInfo> result = new ArrayList<templateInfo>();
        for (Room room : subrooms) {
            templateInfo tempInfo = new templateInfo();//必须放在循环内
            tempInfo.id = room.getId();
            tempInfo.roomName = room.getRoomName();
            result.add(tempInfo);
        }
        String json = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            json = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{\"data\":" + json + ",\"pages\":" + total + "}";
    }

    @RequestMapping(value = "admin/room",method = RequestMethod.PUT)
    @ResponseBody
    public String updateRoom(@RequestBody Room room){
        roomService.updateRoom(room);
        return "{\"result\":true}";
    }


    @RequestMapping(value = "admin/room", method = RequestMethod.POST)
    @ResponseBody
    public String saveRoom(@RequestBody Room room) {
        roomService.saveRoom(room);
        return "{\"result\":true}";
    }

    @RequestMapping(value = "admin/room",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRoom(@RequestBody Room room) {
        Integer id = room.getId();
        roomService.deleteRoom(id);
        return "{\"result\":true}";
    }
}

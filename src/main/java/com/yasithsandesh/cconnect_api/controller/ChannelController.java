package com.yasithsandesh.cconnect_api.controller;

import com.yasithsandesh.cconnect_api.dto.request.ChannelSaveDTO;
import com.yasithsandesh.cconnect_api.dto.request.CheckChannelDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.entitiy.Channel;
import com.yasithsandesh.cconnect_api.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @PostMapping(path = "/check")
    public ResponseEntity<ResponseDTO<Boolean>> checkChannel(@RequestBody CheckChannelDTO checkChannelDTO){
        return new ResponseEntity<>(this.channelService.checkChannel(checkChannelDTO), HttpStatus.OK);
    }

    @PostMapping(path = "/pay")
    public  ResponseEntity<ResponseDTO> pay(@RequestBody ChannelSaveDTO channelSaveDTO){
        return  new ResponseEntity<>(this.channelService.saveChannel(channelSaveDTO),HttpStatus.OK );
    }

    @GetMapping(path = "/get-user-channels/{id}")
    public ResponseEntity<List<Channel>> getUserChannels(@PathVariable("id") String id){
        return new ResponseEntity<>(this.channelService.getUserChannels(id),HttpStatus.OK);
    }

    @GetMapping(path = "/get-counsellor-channels/{id}")
    public ResponseEntity<List<Channel>> getCounsellorChannels(@PathVariable("id") String id){
        return new ResponseEntity<>(this.channelService.getCounsellorChannels(id),HttpStatus.OK);
    }

    @GetMapping(path = "/get-counsellor-channels/{id}/{y}/{m}/{d}")
    public  ResponseEntity<List<Channel>> getCounsellorChannels(@PathVariable("id") String id , @PathVariable("y") int y, @PathVariable("m") int m, @PathVariable("d") int d){
        return new ResponseEntity<>(this.channelService.getCounsellorChannels(id,y,m,d), HttpStatus.OK);
    }
}
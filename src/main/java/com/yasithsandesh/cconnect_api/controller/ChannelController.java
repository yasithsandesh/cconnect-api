package com.yasithsandesh.cconnect_api.controller;

import com.yasithsandesh.cconnect_api.dto.request.ChannelSaveDTO;
import com.yasithsandesh.cconnect_api.dto.request.CheckChannelDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
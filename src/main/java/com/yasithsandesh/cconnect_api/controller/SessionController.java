package com.yasithsandesh.cconnect_api.controller;

import com.yasithsandesh.cconnect_api.dto.request.SendSessionDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.entitiy.Session;
import com.yasithsandesh.cconnect_api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/session")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<Boolean>> sendSession(@RequestBody SendSessionDTO sendSessionDTO) {
        return new ResponseEntity<>(this.sessionService.sendSession(sendSessionDTO), HttpStatus.OK);
    }

    @GetMapping("/get-all-counsellor-session/{id}")
    public ResponseEntity<List<Session>> getAllCounsellorSession(@PathVariable String id){
        return new ResponseEntity<>(this.sessionService.getAllCounsellorSession(id),HttpStatus.OK );
    }


    @GetMapping("/get-all-counsellor-session/{id}/{month}/{year}/{day}")
    public ResponseEntity<List<Session>> getAllCounsellorSession(@PathVariable String id, @PathVariable String month, @PathVariable String year, @PathVariable String day){
        return new ResponseEntity<>(this.sessionService.getAllCounsellorSession(id,Integer.valueOf(month),Integer.valueOf(year),Integer.valueOf(day)),HttpStatus.OK );
    }

    @GetMapping("/get-all-user-session/{id}")
    public ResponseEntity<List<Session>> getAllUserSession(@PathVariable String id){
        return new ResponseEntity<>(this.sessionService.getAllUserSession(id),HttpStatus.OK );
    }
}

package com.yasithsandesh.cconnect_api.controller;

import com.yasithsandesh.cconnect_api.dto.request.ServiceProfileReqDTO;
import com.yasithsandesh.cconnect_api.dto.request.ServiceProfileUpdateDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.entitiy.ServiceProfile;
import com.yasithsandesh.cconnect_api.service.ServiceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/service-profile")
public class ServiceProfileController {

//    http://localhost:8080/api/v1/service-profile/add
    @Autowired
    private ServiceProfileService serviceProfileService;


    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDTO> addServiceProfile(@RequestBody final ServiceProfileReqDTO serviceProfileReqDTO) {
        ResponseDTO responseDTO = this.serviceProfileService.addServiceProfile(serviceProfileReqDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<ResponseDTO> updateServiceProfile(@RequestBody final ServiceProfileUpdateDTO serviceProfileUpdateDTO) {
        return new ResponseEntity<>(this.serviceProfileService.updateServiceProfile(serviceProfileUpdateDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ServiceProfile>> getAllServiceProfiles() {
        return new ResponseEntity<>(this.serviceProfileService.getAllServiceProfiles(),HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<ResponseDTO<ServiceProfile>> getServiceProfileById(@PathVariable("id") final long id) {
        return new ResponseEntity<>(this.serviceProfileService.getServiceProfileById(id),HttpStatus.OK);
    }
}

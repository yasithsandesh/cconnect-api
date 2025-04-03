package com.yasithsandesh.cconnect_api.service;

import com.yasithsandesh.cconnect_api.dto.request.ServiceProfileReqDTO;
import com.yasithsandesh.cconnect_api.dto.request.ServiceProfileUpdateDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.entitiy.ServiceProfile;

import java.util.List;

public interface ServiceProfileService {
    //add
    public ResponseDTO addServiceProfile(ServiceProfileReqDTO serviceProfileReqDTO);
    //update
    public ResponseDTO updateServiceProfile(ServiceProfileUpdateDTO serviceProfileUpdateDTO);
    //all
    public List<ServiceProfile> getAllServiceProfiles();
    //one
    public ResponseDTO<ServiceProfile> getServiceProfileById(Long id);
}

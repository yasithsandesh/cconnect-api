package com.yasithsandesh.cconnect_api.service.impl;

import com.yasithsandesh.cconnect_api.dto.request.ServiceProfileReqDTO;
import com.yasithsandesh.cconnect_api.dto.request.ServiceProfileUpdateDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.repo.ServiceProfileRepo;
import com.yasithsandesh.cconnect_api.service.ServiceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yasithsandesh.cconnect_api.entitiy.ServiceProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProfileIMPL implements ServiceProfileService {

    @Autowired
    ServiceProfileRepo serviceProfileRepo;


    @Override
    public ResponseDTO addServiceProfile(ServiceProfileReqDTO serviceProfileReqDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        if (!serviceProfileRepo.existsByCounsellerId(serviceProfileReqDTO.getCounsellerId())) {



            ServiceProfile serviceProfile = new ServiceProfile();
            serviceProfile.setCounsellerId(serviceProfileReqDTO.getCounsellerId());
            serviceProfile.setFirstName(serviceProfileReqDTO.getFirstName());
            serviceProfile.setLastName(serviceProfileReqDTO.getLastName());
            serviceProfile.setLatitude(serviceProfileReqDTO.getLatitude());
            serviceProfile.setLongitude(serviceProfileReqDTO.getLongitude());
            serviceProfile.setRate(serviceProfileReqDTO.getRate());
            serviceProfile.setLimit(serviceProfileReqDTO.getLimit());
            serviceProfile.setStatus(serviceProfileReqDTO.isStatus());
            serviceProfileRepo.save(serviceProfile);

            responseDTO.setMessage("Successfully added service profile");

        }else{

            responseDTO.setMessage("Service profile already exists");

        }

        return responseDTO;
    }

    @Override
    public ResponseDTO updateServiceProfile(ServiceProfileUpdateDTO serviceProfileUpdateDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
       ServiceProfile serviceProfile = this.serviceProfileRepo.getReferenceById(serviceProfileUpdateDTO.getId());
       if (serviceProfile != null) {
           serviceProfile.setRate(serviceProfileUpdateDTO.getRate());
           serviceProfile.setLimit(serviceProfileUpdateDTO.getLimit());
           this.serviceProfileRepo.save(serviceProfile);
       }else {
           responseDTO.setMessage("Service profile not found");
       }
        return responseDTO;
    }

    @Override
    public List<ServiceProfile> getAllServiceProfiles() {
        List<ServiceProfile> serviceProfileList = this.serviceProfileRepo.findAll();
        return serviceProfileList;
    }

    @Override
    public ResponseDTO<ServiceProfile> getServiceProfileById(Long id) {
        ResponseDTO<ServiceProfile> responseDTO = new ResponseDTO<>();
        ServiceProfile serviceProfile = this.serviceProfileRepo.getReferenceById(id);
        responseDTO.setData(serviceProfile);
        responseDTO.setMessage("Successfully retrieved service profile");
        return responseDTO;
    }
}

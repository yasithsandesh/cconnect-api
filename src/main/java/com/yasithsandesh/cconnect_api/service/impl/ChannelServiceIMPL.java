package com.yasithsandesh.cconnect_api.service.impl;

import com.yasithsandesh.cconnect_api.dto.request.ChannelSaveDTO;
import com.yasithsandesh.cconnect_api.dto.request.CheckChannelDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.entitiy.Channel;
import com.yasithsandesh.cconnect_api.entitiy.ServiceProfile;
import com.yasithsandesh.cconnect_api.repo.ChannelRepo;
import com.yasithsandesh.cconnect_api.repo.ServiceProfileRepo;
import com.yasithsandesh.cconnect_api.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ChannelServiceIMPL implements ChannelService {

    @Autowired
    ChannelRepo channelRepo;

    @Autowired
    ServiceProfileRepo serviceProfileRepo;


    @Override
    public ResponseDTO saveChannel(ChannelSaveDTO channelSaveDTO) {
        ResponseDTO responseDTO  = new ResponseDTO();
        ServiceProfile serviceProfile = this.serviceProfileRepo.getReferenceById(channelSaveDTO.getServiceProfileId());
        Channel channel =  new Channel(channelSaveDTO.getUserId(),serviceProfile,channelSaveDTO.getPrice(),channelSaveDTO.getMonth(),channelSaveDTO.getYear(),channelSaveDTO.getDay());
        this.channelRepo.save(channel);
        responseDTO.setMessage("Your counseling session is now confirmed. You will receive the session details shortly. If you have any questions, feel free to contact us.");
        responseDTO.setData(channel.getPrice());
        return responseDTO;
    }

    @Override
    public List<Channel> getUserChannels(String userId) {
        List<Channel> channelList =  this.channelRepo.findByUserId(userId);
        return channelList;
    }


    @Override
    public Channel getChannel(Long channelId) {
        Channel channel =  this.channelRepo.getReferenceById(channelId);
        return channel;
    }

    @Override
    public ResponseDTO<Boolean> checkChannel(CheckChannelDTO checkChannelDTO) {
        ResponseDTO<Boolean> responseDTO = new ResponseDTO<>();


        // Validate input
        if (checkChannelDTO.getYear() == 0 || checkChannelDTO.getMonth() == 0 || checkChannelDTO.getDay() == 0) {
            responseDTO.setMessage("Invalid date parameters");
            responseDTO.setData(false);
            return responseDTO;
        }

        ServiceProfile serviceProfile = this.serviceProfileRepo.getReferenceById(checkChannelDTO.getServiceProfileId());
        int limit = serviceProfile.getLimit();
        List<Channel> channelList = this.channelRepo.findByServiceProfileAndYearAndMonthAndDay(serviceProfile,checkChannelDTO.getYear(),checkChannelDTO.getMonth(),checkChannelDTO.getDay());
        if (channelList.isEmpty()) {
            responseDTO.setMessage("No channel found");
            responseDTO.setData(true);
        }else{
            if(channelList.size() < limit){
                responseDTO.setMessage("No channel found");
                responseDTO.setData(true);
            }else{
                responseDTO.setMessage("Too many channels");

            }
        }
        return responseDTO;
    }

    @Override
    public List<Channel> getCounsellorChannels(String counselorId) {

        ServiceProfile serviceProfile = this.serviceProfileRepo.findByCounsellerId(counselorId);
        List<Channel> channelList =  this.channelRepo.findByServiceProfile(serviceProfile);

        return channelList;
    }

    @Override
    public List<Channel> getCounsellorChannels(String counselorId, int year, int month, int day) {
        ServiceProfile serviceProfile = this.serviceProfileRepo.findByCounsellerId(counselorId);
        List<Channel> channelList = this.channelRepo.findByServiceProfileAndYearAndMonthAndDay(serviceProfile,year,month,day);
        return channelList;
    }


}

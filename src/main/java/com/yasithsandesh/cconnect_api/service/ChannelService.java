package com.yasithsandesh.cconnect_api.service;

import com.yasithsandesh.cconnect_api.dto.request.ChannelSaveDTO;
import com.yasithsandesh.cconnect_api.dto.request.CheckChannelDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.entitiy.Channel;

import java.util.List;

public interface ChannelService {
    //save
    public ResponseDTO saveChannel(ChannelSaveDTO channelSaveDTO);

    //getUserAllChannel
    public List<Channel> getUserChannels(String userId);

    //getChannel
    public Channel getChannel(Long channelId);

    //checkChannel
    public ResponseDTO<Boolean> checkChannel(CheckChannelDTO checkChannelDTO);

    //getCounsellerAllChannel
    public List<Channel> getCounsellorChannels(String counselorId);

    public List<Channel> getCounsellorChannels(String counselorId,int year,int month,int day);
}
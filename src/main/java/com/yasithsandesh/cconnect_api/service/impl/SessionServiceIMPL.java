package com.yasithsandesh.cconnect_api.service.impl;

import com.yasithsandesh.cconnect_api.dto.request.SendSessionDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.entitiy.Channel;
import com.yasithsandesh.cconnect_api.entitiy.ServiceProfile;
import com.yasithsandesh.cconnect_api.entitiy.Session;
import com.yasithsandesh.cconnect_api.repo.ChannelRepo;
import com.yasithsandesh.cconnect_api.repo.ServiceProfileRepo;
import com.yasithsandesh.cconnect_api.repo.SessionRepo;
import com.yasithsandesh.cconnect_api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceIMPL implements SessionService {

    @Autowired
    ChannelRepo channelRepo;

    @Autowired
    SessionRepo sessionRepo;

    @Autowired
    ServiceProfileRepo serviceProfileRepo;


    @Override
    public ResponseDTO<Boolean> sendSession(SendSessionDTO sendSessionDTO) {
        ResponseDTO<Boolean> responseDTO = new ResponseDTO<>();
        Channel channel = channelRepo.getReferenceById(sendSessionDTO.getChannelId());
        Session session = new Session();
        session.setChannel(channel);
        session.setLink(sendSessionDTO.getLink());
        this.sessionRepo.save(session);
        responseDTO.setData(true);
        responseDTO.setMessage("Successfully sent session");
        return null;
    }

    @Override
    public List<Session> getAllCounsellorSession(String counselorId) throws NullPointerException {
        ServiceProfile serviceProfile = this.serviceProfileRepo.findByCounsellerId(counselorId);
        if(serviceProfile != null){
            List<Channel> channelList = this.channelRepo.findByServiceProfile(serviceProfile);
            List<Session> sessionList = new ArrayList<>();
            for(Channel channel : channelList){
                Session session = this.sessionRepo.findByChannel(channel);
                sessionList.add(session);
            }
            return sessionList;
        }else{

            throw new NullPointerException("No service profile found");

        }

    }

    @Override
    public List<Session> getAllCounsellorSession(String counselorId, int month, int year, int day) {
        ServiceProfile serviceProfile = this.serviceProfileRepo.findByCounsellerId(counselorId);
        if(serviceProfile != null){
            List<Channel> channelList = this.channelRepo.findByServiceProfileAndYearAndMonthAndDay(serviceProfile, year, month, day);
            List<Session> sessionList = new ArrayList<>();
            for(Channel channel : channelList){
                Session session = this.sessionRepo.findByChannel(channel);
                sessionList.add(session);
            }
            return sessionList;
        }else{

            throw new NullPointerException("No service profile found");

        }
    }

    @Override
    public List<Session> getAllUserSession(String userId) {
        List<Session> sessionList = new ArrayList<>();
        List<Channel> channelList = this.channelRepo.findByUserIdOrderByDateDesc(userId);
        for(Channel channel : channelList){
            Session session = this.sessionRepo.findByChannel(channel);
            sessionList.add(session);
        }
        return sessionList;
    }
}

package com.yasithsandesh.cconnect_api.service;

import com.yasithsandesh.cconnect_api.dto.request.SendSessionDTO;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;
import com.yasithsandesh.cconnect_api.entitiy.Session;

import java.util.List;

public interface SessionService {
    public ResponseDTO<Boolean> sendSession(SendSessionDTO sendSessionDTO);
    public List<Session> getAllCounsellorSession(String counselorId);
    public List<Session> getAllCounsellorSession(String counselorId,int month, int year, int day);
    public List<Session> getAllUserSession(String userId);
}
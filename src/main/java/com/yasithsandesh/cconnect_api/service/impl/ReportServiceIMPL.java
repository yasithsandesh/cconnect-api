package com.yasithsandesh.cconnect_api.service.impl;

import com.yasithsandesh.cconnect_api.dto.response.EarningsReportData;
import com.yasithsandesh.cconnect_api.entitiy.Channel;
import com.yasithsandesh.cconnect_api.entitiy.ServiceProfile;
import com.yasithsandesh.cconnect_api.repo.ChannelRepo;
import com.yasithsandesh.cconnect_api.repo.ServiceProfileRepo;
import com.yasithsandesh.cconnect_api.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Service
public class ReportServiceIMPL implements ReportService {

    @Autowired
    ChannelRepo channelRepo;

    @Autowired
    ServiceProfileRepo serviceProfileRepo;

    @Override
    public EarningsReportData getEarningsReportData(String counsellorId) {
        EarningsReportData earningsReportData = new EarningsReportData();
        HashMap<Integer,Double> earningsMap = new HashMap<>();
        // Get the current year
        int currentYear = LocalDate.now().getYear();
        //total
        double totalEarnings = 0.0;

        ServiceProfile serviceProfile = this.serviceProfileRepo.findByCounsellerId(counsellorId);
        for (int i = 1; i < 13; i++) {
            List<Channel> channelList =  this.channelRepo.findByServiceProfileAndYearAndMonth(serviceProfile, currentYear, i);
            double monthTotalEarnings = 0.0;
            for (Channel channel : channelList) {
               monthTotalEarnings = monthTotalEarnings +channel.getPrice();
            }
            totalEarnings = totalEarnings + monthTotalEarnings;
            earningsMap.put(i, monthTotalEarnings);
        }
        earningsReportData.setYear(currentYear);
        earningsReportData.setEarnings(earningsMap);
        earningsReportData.setTotal(totalEarnings);
        return earningsReportData;
    }


}

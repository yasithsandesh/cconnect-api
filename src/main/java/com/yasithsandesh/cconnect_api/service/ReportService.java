package com.yasithsandesh.cconnect_api.service;

import com.yasithsandesh.cconnect_api.dto.response.EarningsReportData;
import com.yasithsandesh.cconnect_api.dto.response.ResponseDTO;

public interface ReportService {
    //counsellor
    public EarningsReportData getEarningsReportData(String counsellorId);
    //admin
}

package com.pigo.shop.service;


import com.pigo.shop.entity.ErrorLog;

import java.util.List;

public interface ErrorLogService {
    List<ErrorLog> getErrorLogList();
    void createErrorLog(ErrorLog errorLog);
    void deleteErrorLog(String id);
    void updateErrorLog(ErrorLog errorLog);
}

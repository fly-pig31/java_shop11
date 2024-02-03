package com.pigo.shop.service;


import com.pigo.shop.entity.OpLog;

import java.util.List;

public interface OpLogService {
    List<OpLog> getOpLogList();
    void createOpLog(OpLog opLog);
    void deleteOpLog(String id);
    void updateOpLog(OpLog opLog);

    List<OpLog> getLoginLogList();
}

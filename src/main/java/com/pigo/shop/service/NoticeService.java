package com.pigo.shop.service;


import com.pigo.shop.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNoticeList();
    void createNotice(Notice notice);
    void deleteNotice(String id);

    void updateNotice(Notice notice);
}

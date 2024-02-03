package com.pigo.shop.service;


import com.pigo.shop.entity.Ad;

import java.util.List;

public interface AdService {
    List<Ad> getAdList();
    void createAd(Ad ad);
    void deleteAd(String id);

    void updateAd(Ad ad);
}

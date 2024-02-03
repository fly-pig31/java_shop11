package com.pigo.shop.service;


import com.pigo.shop.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressList(String userId);
    void createAddress(Address address);
    void deleteAddress(String id);

    void updateAddress(Address address);
}

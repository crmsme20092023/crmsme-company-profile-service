package com.crmsme.services;

import com.crmsme.dto.BusinessAddress;
import com.crmsme.dto.BusinessRequestDto;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessService {

    public Long createBusinessDetails(BusinessRequestDto businessRequestDto);

    void insertBusinessAddress(BusinessAddress businessAddress,Long businessId);
}

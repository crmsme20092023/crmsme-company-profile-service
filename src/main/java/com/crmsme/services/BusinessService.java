package com.crmsme.services;

import com.crmsme.dbo.BusinessEntity;
import com.crmsme.dto.BusinessRequestDto;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessService {

    public boolean createBusinessDetails(BusinessRequestDto businessRequestDto);

}

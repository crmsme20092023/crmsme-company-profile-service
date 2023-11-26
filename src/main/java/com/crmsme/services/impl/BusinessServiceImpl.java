package com.crmsme.services.impl;

import com.crmsme.dbo.BusinessAddressEntity;
import com.crmsme.dbo.BusinessEntity;
import com.crmsme.dto.BusinessAddress;
import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.mapper.BusinessMapper;
import com.crmsme.mapper.ConfigDataMapper;
import com.crmsme.services.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessMapper businessMapper;

    @Autowired
    ConfigDataMapper configDataMapper;

    @Override
    public Long createBusinessDetails(BusinessRequestDto businessRequestDto) {


        BusinessEntity businessEntity = businessRequestDto.createBusinessEntity();

        businessEntity.setBusinessCategoryId((
                configDataMapper.getConfigDataByLabel(businessRequestDto.getBusinessCategory())
                ).getId());
        businessEntity.setBusinessRegistrationTypeId((
                configDataMapper.getConfigDataByLabel(businessRequestDto.getBusinessRegistrationType())
        ).getId());
        businessEntity.setBusinessTypeId((
                configDataMapper.getConfigDataByLabel(businessRequestDto.getBusinessType())
        ).getId());
        businessEntity.setCurrentBillingProcessId((
                configDataMapper.getConfigDataByLabel(businessRequestDto.getCurrentBillingProcess())
        ).getId());

        businessEntity.setBusinessId("2342");

         businessMapper.insertBusinessDetails(businessEntity);
         long id = businessEntity.getId();
         log.info("Business Created :: ID  : '{}' ",id);

        return id;
    }

    @Override
    public void insertBusinessAddress(BusinessAddress businessAddress, Long businessId) {

        BusinessAddressEntity businessAddressEntity = businessAddress.createBusinessAddressEntity();


        businessAddressEntity.setCountryId(1L);
        businessAddressEntity.setStateId(1L);
        businessAddressEntity.setCityId(1L);

        /***Mapper Insert Address ***/


    }
}

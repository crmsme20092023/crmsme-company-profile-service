package com.crmsme.services.impl;

import com.crmsme.dbo.BusinessEntity;
import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.mapper.BusinessMapper;
import com.crmsme.mapper.ConfigDataMapper;
import com.crmsme.services.BusinessService;
import com.sun.mail.imap.protocol.UID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessMapper businessMapper;

    @Autowired
    ConfigDataMapper configDataMapper;

    @Override
    public boolean createBusinessDetails(BusinessRequestDto businessRequestDto) {


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

        return true;
    }
}

package com.crmsme.services.impl;

import com.crmsme.dbo.BusinessEntity;
import com.crmsme.dbo.ConfigDataEntity;
import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.dto.BusinessResponseDto;
import com.crmsme.dto.ConfigDataResponseDto;
import com.crmsme.mapper.BusinessMapper;
import com.crmsme.mapper.ConfigDataMapper;
import com.crmsme.services.BusinessService;
import com.crmsme.services.ConfigDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConfigDataServiceImpl implements ConfigDataService {

    @Autowired
    ConfigDataMapper configDataMapper;

    @Override
    public List<ConfigDataResponseDto> getConfigDataAsListOfValues() {


       List<ConfigDataEntity> configDataEntityList  = configDataMapper.getLovDataFromConfigData();


        return configDataEntityList.stream()
                .map(ConfigDataEntity::createBusinessResponse)
                .sorted(Comparator.comparingLong(ConfigDataResponseDto::getId).reversed())
                .collect(Collectors.toList());

    }
}

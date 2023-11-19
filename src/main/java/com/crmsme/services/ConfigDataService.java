package com.crmsme.services;

import com.crmsme.dto.BusinessRequestDto;
import com.crmsme.dto.ConfigDataResponseDto;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConfigDataService {

    public List<ConfigDataResponseDto> getConfigDataAsListOfValues();

}

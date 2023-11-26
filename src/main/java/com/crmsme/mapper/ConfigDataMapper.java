package com.crmsme.mapper;

import com.crmsme.dbo.ConfigDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConfigDataMapper {



    @Select("select * from config_data cd "   +
            " where  cd.label  = #{label}")
   public ConfigDataEntity getConfigDataByLabel(String label);


    @Select("select * from config_data cd "   +
            " where  cd.id  = #{id}")
    public ConfigDataEntity getConfigDataById(Long id);


    @Select("select * from config_data cd "   +
            " where  cd.delete_flag='N' ")
    public List<ConfigDataEntity> getLovDataFromConfigData();



    /*** New ***/
    @Select("select * from config_data cd "   +
            " where  cd.label  = #{label}")
    public ConfigDataEntity getCountryIdByName(Long id);


    @Select("select * from config_data cd "   +
            " where  cd.label  = #{label}")
    public ConfigDataEntity getCountryNameById(Long id);


    @Select("select * from config_data cd "   +
            " where  cd.label  = #{label}")
    public ConfigDataEntity getStateIdByName(Long id);

    @Select("select * from config_data cd "   +
            " where  cd.label  = #{label}")
    public ConfigDataEntity getStateNameById(Long id);


    @Select("select * from config_data cd "   +
            " where  cd.label  = #{label}")
    public ConfigDataEntity getCityIdByName(Long id);

    @Select("select * from config_data cd "   +
            " where  cd.label  = #{label}")
    public ConfigDataEntity getCityNameById(Long id);


}

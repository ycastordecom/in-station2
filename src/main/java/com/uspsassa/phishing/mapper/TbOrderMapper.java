package com.uspsassa.phishing.mapper;

import com.uspsassa.phishing.entity.TbOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbOrderMapper {
    /**
     * delete by primary key
     * @param sid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer sid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TbOrder record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TbOrder record);

    /**
     * select by primary key
     * @param sid primary key
     * @return object by primary key
     */
    TbOrder selectByPrimaryKey(Integer sid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TbOrder record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TbOrder record);
}
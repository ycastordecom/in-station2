package com.uspsassa.phishing.mapper;

import com.uspsassa.phishing.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
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
    int insert(Order record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Order record);

    /**
     * select by primary key
     * @param sid primary key
     * @return object by primary key
     */
    Order selectByPrimaryKey(String sid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Order record);
}
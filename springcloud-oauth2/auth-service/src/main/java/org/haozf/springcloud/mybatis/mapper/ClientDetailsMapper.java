package org.haozf.springcloud.mybatis.mapper;

import java.util.List;
import org.haozf.springcloud.mybatis.model.ClientDetails;
import org.haozf.springcloud.mybatis.model.ClientDetailsExample;

public interface ClientDetailsMapper {
    int countByExample(ClientDetailsExample example);

    int deleteByPrimaryKey(String appid);

    int insert(ClientDetails record);

    int insertSelective(ClientDetails record);

    List<ClientDetails> selectByExample(ClientDetailsExample example);

    ClientDetails selectByPrimaryKey(String appid);

    int updateByPrimaryKeySelective(ClientDetails record);

    int updateByPrimaryKey(ClientDetails record);
}
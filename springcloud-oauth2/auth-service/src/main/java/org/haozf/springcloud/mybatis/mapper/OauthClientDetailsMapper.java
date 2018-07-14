package org.haozf.springcloud.mybatis.mapper;

import java.util.List;
import org.haozf.springcloud.mybatis.model.OauthClientDetails;
import org.haozf.springcloud.mybatis.model.OauthClientDetailsExample;

public interface OauthClientDetailsMapper {
    int countByExample(OauthClientDetailsExample example);

    int deleteByPrimaryKey(String clientId);

    int insert(OauthClientDetails record);

    int insertSelective(OauthClientDetails record);

    List<OauthClientDetails> selectByExample(OauthClientDetailsExample example);

    OauthClientDetails selectByPrimaryKey(String clientId);

    int updateByPrimaryKeySelective(OauthClientDetails record);

    int updateByPrimaryKey(OauthClientDetails record);
}
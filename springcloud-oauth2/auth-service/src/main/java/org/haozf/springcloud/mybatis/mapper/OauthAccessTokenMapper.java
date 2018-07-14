package org.haozf.springcloud.mybatis.mapper;

import java.util.List;
import org.haozf.springcloud.mybatis.model.OauthAccessToken;
import org.haozf.springcloud.mybatis.model.OauthAccessTokenExample;
import org.haozf.springcloud.mybatis.model.OauthAccessTokenWithBLOBs;

public interface OauthAccessTokenMapper {
    int countByExample(OauthAccessTokenExample example);

    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthAccessTokenWithBLOBs record);

    int insertSelective(OauthAccessTokenWithBLOBs record);

    List<OauthAccessTokenWithBLOBs> selectByExampleWithBLOBs(OauthAccessTokenExample example);

    List<OauthAccessToken> selectByExample(OauthAccessTokenExample example);

    OauthAccessTokenWithBLOBs selectByPrimaryKey(String authenticationId);

    int updateByPrimaryKeySelective(OauthAccessTokenWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OauthAccessTokenWithBLOBs record);

    int updateByPrimaryKey(OauthAccessToken record);
}
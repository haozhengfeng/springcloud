package org.haozf.springcloud.mybatis.mapper;

import java.util.List;
import org.haozf.springcloud.mybatis.model.OauthRefreshToken;
import org.haozf.springcloud.mybatis.model.OauthRefreshTokenExample;

public interface OauthRefreshTokenMapper {
    int countByExample(OauthRefreshTokenExample example);

    int insert(OauthRefreshToken record);

    int insertSelective(OauthRefreshToken record);

    List<OauthRefreshToken> selectByExampleWithBLOBs(OauthRefreshTokenExample example);

    List<OauthRefreshToken> selectByExample(OauthRefreshTokenExample example);
}
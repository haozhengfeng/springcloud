package org.haozf.springcloud.mybatis.mapper;

import java.util.List;
import org.haozf.springcloud.mybatis.model.OauthCode;
import org.haozf.springcloud.mybatis.model.OauthCodeExample;

public interface OauthCodeMapper {
    int countByExample(OauthCodeExample example);

    int insert(OauthCode record);

    int insertSelective(OauthCode record);

    List<OauthCode> selectByExampleWithBLOBs(OauthCodeExample example);

    List<OauthCode> selectByExample(OauthCodeExample example);
}
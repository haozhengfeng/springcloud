package org.haozf.springcloud.mybatis.mapper;

import java.util.List;
import org.haozf.springcloud.mybatis.model.OauthApprovals;
import org.haozf.springcloud.mybatis.model.OauthApprovalsExample;

public interface OauthApprovalsMapper {
    int countByExample(OauthApprovalsExample example);

    int insert(OauthApprovals record);

    int insertSelective(OauthApprovals record);

    List<OauthApprovals> selectByExample(OauthApprovalsExample example);
}
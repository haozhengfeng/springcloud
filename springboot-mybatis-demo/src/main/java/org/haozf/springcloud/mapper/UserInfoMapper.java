package org.haozf.springcloud.mapper;

import java.util.List;
import org.haozf.springcloud.mybatis.model.User;

public interface UserInfoMapper {
    List<User> selectAllUser();
}
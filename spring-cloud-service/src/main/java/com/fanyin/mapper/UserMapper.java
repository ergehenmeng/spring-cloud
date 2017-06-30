package com.fanyin.mapper;

import com.fanyin.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fanyin
 * @create 2017-06-29 13:41
 */

public interface UserMapper {

    public User getUserById(Long id);
}

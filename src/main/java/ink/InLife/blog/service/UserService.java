package ink.InLife.blog.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import ink.InLife.blog.mapper.UserMapper;
import ink.InLife.blog.model.entity.UserEntity;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> getUserList() {
        QueryWrapper<UserEntity> userQuery = new QueryWrapper<>();
        userQuery.lambda().eq(UserEntity::getId, 7);
        List<UserEntity> userList = userMapper.selectList(userQuery);
        return userList;
    }

    public List<UserEntity> getUserListById(int id) {
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.lambda().eq(UserEntity::getId, id);
        List<UserEntity> userEntities = userMapper.selectList(userEntityQueryWrapper);
        return userEntities;
    }
}

package ink.InLife.blog.service;

import ink.InLife.blog.mapper.UserMapper;
import ink.InLife.blog.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> GetUserList() {
        List<UserEntity> userList = userMapper.selectList(null);
        return userList;
    }
}

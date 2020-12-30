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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        QueryWrapper<UserEntity> userQuery = new QueryWrapper<>();
        userQuery.lambda().eq(UserEntity::getNickName, userName);
        // 1.查询用户
        UserEntity userEntity = userMapper.selectOne(userQuery);
        if (userEntity == null) {
            // 这里找不到必须抛异常
            throw new UsernameNotFoundException("User" + userName + " was not found in db");
        }
        // 2. 设置角色
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userEntity.getRole());
        grantedAuthorities.add(grantedAuthority);

        return new org.springframework.security.core.userdetails.User(userName,
                userEntity.getPassword(), grantedAuthorities);
    }

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

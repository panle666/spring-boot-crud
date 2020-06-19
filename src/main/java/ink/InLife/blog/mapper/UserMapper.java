package ink.InLife.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ink.InLife.blog.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

public interface UserMapper extends BaseMapper<UserEntity> {

}

package ink.InLife.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("xiaole_users")
public class UserEntity {
    @TableField("id")
    private long id;

    @TableField("nickname")
    private String NickName;
}

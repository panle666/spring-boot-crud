package ink.InLife.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("xiaole_users")
public class UserEntity {
    @TableField("id")
    private long id;

    @TableField("nickname")
    private String NickName;

    @TableField("Password")
    private String Password;

    @TableField("Role")
    private String Role;
}

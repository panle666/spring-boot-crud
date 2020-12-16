package ink.InLife.blog.controller;

import cn.hutool.http.HttpUtil;
import ink.InLife.blog.model.entity.UserEntity;
import ink.InLife.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/index")
    public ResponseEntity<Object> Index(Integer id) {
        if (id == null) {
            return new ResponseEntity<>("请输入id", HttpStatus.OK);
        }
        List<UserEntity> userList = userService.getUserListById(id);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @RequestMapping("/user/indexV2")
    public ResponseEntity<Object> Indexv2() {
        String result = HttpUtil.get("https://www.360kad.com/");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

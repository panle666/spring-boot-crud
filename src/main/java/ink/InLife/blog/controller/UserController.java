package ink.InLife.blog.controller;

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
    public ResponseEntity<Object> Index() {
        List<UserEntity> userList = userService.GetUserList();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}

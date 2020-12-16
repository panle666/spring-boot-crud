package ink.InLife.blog.controller;

import ink.InLife.blog.model.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public ResponseEntity<Object> Login() {
        return new ResponseEntity<>("111222", HttpStatus.OK);
    }
}

package app.controllers;

import app.model.User;
import app.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(path = "getUser/{userId}", method = GET)
    public List<User> push(@PathVariable String userId) {
        return userService.getUsers();
    }

    @RequestMapping(path = "getUsers", method = GET)
    public List<User> push() {
        return userService.getUsers();
    }
}

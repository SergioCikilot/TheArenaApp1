package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.business.services.UserService;
import draft1.TheArenaApp1.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public void add(@RequestBody User user){

        userService.add(user);

    }

    @GetMapping("/getAll")
    public List<User> getAll(){

        return userService.getAll();

    }



}

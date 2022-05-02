package draft1.TheArenaApp1.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

        return "test home page arena app";

    }

    @GetMapping("/hellospringsecurity")
    public String hellospringsecurity() {
        return "hellospringsecurity";
    }


}

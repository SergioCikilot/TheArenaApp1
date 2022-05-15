package draft1.TheArenaApp1.api.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VersionController {

    @GetMapping("/showCurrentVersion")
    public String showCurrentVersion(){

        return "Running Version: _v.0.6";

    }

}

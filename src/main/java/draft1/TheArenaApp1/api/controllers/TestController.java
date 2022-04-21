package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.business.services.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



    @RestController
    @RequestMapping("")
    public class TestController{

        private PitchService pitchService;

        @Autowired
        public TestController(PitchService pitchService) {
            this.pitchService = pitchService;
        }

        @GetMapping("")
        public String hello() {

            return " ARENAYA HOŞGELDİN KARDEŞ";
        }

    }

package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.business.services.PitchService;
import draft1.TheArenaApp1.entities.Pitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pitches")
public class PitchesController {

    private PitchService pitchService;

    @Autowired
    public PitchesController(PitchService pitchService) {
        this.pitchService = pitchService;
    }

    @GetMapping("/getAll")
    public List<Pitch> getAll(){

        return this.pitchService.getAll();
    }

    @GetMapping("/getByPitchName")
    public Pitch getByPitchName(@RequestParam String pitchName){

        return pitchService.getByPitchName(pitchName);

    }

    @PostMapping("/add")
    public void add(@RequestBody Pitch pitch){

        this.pitchService.add(pitch);


    }


}

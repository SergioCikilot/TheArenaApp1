package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.business.services.PlayerService;
import draft1.TheArenaApp1.business.services.PositionService;
import draft1.TheArenaApp1.core.entities.positions.Position;
import draft1.TheArenaApp1.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {

        this.positionService = positionService;

    }



}

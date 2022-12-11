package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class FootballClubController {
    private final FootballClubService fcService;

    public FootballClubController(FootballClubService fcService) {
        this.fcService = fcService;
    }

    @ResponseBody
    @GetMapping("/clubs")
    public Iterable<FootballClub> getCurrentAircraft() throws IOException {
        return fcService.getFootballClubs();
    }
}


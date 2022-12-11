package main;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FootballClubService {
    private final ClubRepository repo;

    public FootballClubService(ClubRepository repo) {
        this.repo = repo;
    }

    public Iterable<FootballClub> getFootballClubs() throws IOException {
        List<FootballClub> clubs = new ArrayList<>();

        if (clubs.size() > 0) {
            clubs.forEach(System.out::println);

            repo.deleteAll();
            return repo.saveAll(clubs);
        } else {
            return saveMyClubs();
        }
    }

    private Iterable<FootballClub> saveMyClubs() {
        repo.deleteAll();
        
        var fc1 = new FootballClub(null, "Real", 1000, 200, 97);
        var fc2 = new FootballClub(null, "Barca", 900, 100, 90);
        var fc3 = new FootballClub(null, "Liverpool", 930, 180, 94);
        var fc4 = new FootballClub(null, "Bayern", 880, 165, 93);

        return repo.saveAll(List.of(fc1, fc2, fc3, fc4));
    }
}


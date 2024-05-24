package ru.nsu.sportinformationsystem.sportClub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class SportClubService {
    private final SportClubRepository sportClubRepository;

    @Autowired
    public SportClubService(SportClubRepository sportClubRepository) {
        this.sportClubRepository = sportClubRepository;
    }

    public SportClub getById(int id) {
        return sportClubRepository.findById(id).orElse(null);
    }

    public List<SportClub> findAll() {
        return (List<SportClub>) sportClubRepository.findAll();
    }

    public List<SportClub> makeDefaultDropList() {
        SportClub noneClub = new SportClub();
        noneClub.setName("none");
        List<SportClub> sportClubs = (List<SportClub>) sportClubRepository.findAll();
        sportClubs.add(0, noneClub);
        return sportClubs;
    }

    public List<SportClub> makeDropListForAthlete(Integer athleteClubId) {
        List<SportClub> sportClubs = makeDefaultDropList();
        if (athleteClubId != null) {
            SportClub clubOfAthlete = sportClubs.stream()
                    .filter(sportClub -> Objects.equals(sportClub.getId(), athleteClubId))
                    .findFirst().orElse(null);
            sportClubs.remove(clubOfAthlete);
            sportClubs.add(0, clubOfAthlete);
        }
        return sportClubs;
    }

    public List<SportClubCountOutput> findByDate(String from, String to) {
        LocalDate dateFrom = from.isEmpty() ? LocalDate.now().minusYears(100) : LocalDate.parse(from);
        LocalDate dateTo = to.isEmpty() ? LocalDate.now() : LocalDate.parse(to);
        return sportClubRepository.findAllByDate(dateFrom, dateTo);
    }
}

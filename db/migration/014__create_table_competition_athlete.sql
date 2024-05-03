CREATE TABLE IF NOT EXISTS Competition_athlete (
    competition_id int REFERENCES Competition(id) ON DELETE RESTRICT,
    athlete_id int REFERENCES Athlete(id) ON DELETE CASCADE,
    place int Not NULL CHECK(place > 0),
    PRIMARY KEY (competition_id, athlete_id)
);
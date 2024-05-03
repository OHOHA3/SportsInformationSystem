CREATE TABLE IF NOT EXISTS Athlete_sport (
    athlete_id int REFERENCES Athlete(id) ON DELETE CASCADE,
    sport_id int REFERENCES Sport(id) ON DELETE RESTRICT,
    sports_rank_id int REFERENCES Sports_rank(id) ON DELETE RESTRICT,
    PRIMARY KEY (athlete_id, sport_id)
);
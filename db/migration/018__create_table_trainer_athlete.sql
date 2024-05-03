CREATE TABLE IF NOT EXISTS Trainer_athlete (
    trainer_id int REFERENCES Trainer(id) ON DELETE CASCADE,
    athlete_id int REFERENCES Athlete(id) ON DELETE CASCADE,
    sport_id int REFERENCES Sport(id) ON DELETE RESTRICT,
    PRIMARY KEY (athlete_id, trainer_id, sport_id)
);
CREATE TABLE IF NOT EXISTS Trainer_sport (
    trainer_id int REFERENCES Trainer(id) ON DELETE CASCADE,
    sport_id int REFERENCES Sport(id) ON DELETE RESTRICT,
    qualification_id int REFERENCES Trainer_qualification(id) ON DELETE RESTRICT,
    PRIMARY KEY (trainer_id, sport_id)
);
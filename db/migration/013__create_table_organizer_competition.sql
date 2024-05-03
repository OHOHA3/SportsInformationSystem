CREATE TABLE IF NOT EXISTS Organizer_competition (
    organizer_id int REFERENCES Organizer(id) ON DELETE RESTRICT,
    competition_id int REFERENCES Competition(id) ON DELETE CASCADE,
    PRIMARY KEY (competition_id, organizer_id)
);
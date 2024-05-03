CREATE TABLE IF NOT EXISTS Gym (
    place_id int PRIMARY KEY REFERENCES Sport_place(id) ON DELETE CASCADE,
    simulators_count int NOT NULL CHECK(simulators_count>0)
);
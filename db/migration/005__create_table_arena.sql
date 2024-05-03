CREATE TABLE IF NOT EXISTS Arena (
    place_id int PRIMARY KEY REFERENCES Sport_place(id) ON DELETE CASCADE,
    area int NOT NULL CHECK(area>0)
);
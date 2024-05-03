CREATE TABLE IF NOT EXISTS Stadium (
    place_id int PRIMARY KEY REFERENCES Sport_place(id) ON DELETE CASCADE,
    capacity int NOT NULL CHECK(capacity>0)
);
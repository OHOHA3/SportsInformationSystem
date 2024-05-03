CREATE TABLE IF NOT EXISTS Competition (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name varchar(150) NOT NULL,
    sport_id int NOT NULL REFERENCES Sport(id) ON DELETE RESTRICT,
    place_id int NOT NULL REFERENCES Sport_place(id) ON DELETE RESTRICT,
    competition_date date NOT NULL CHECK(extract(year from competition_date) > 1900),
    UNIQUE(name, place_id, competition_date)
);
CREATE TABLE IF NOT EXISTS Court (
    place_id int PRIMARY KEY REFERENCES Sport_place(id) ON DELETE CASCADE,
    coating_type_id int NOT NULL REFERENCES Coating_type(id) ON DELETE RESTRICT
);
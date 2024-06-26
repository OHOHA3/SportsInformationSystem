CREATE TABLE IF NOT EXISTS Sport_place (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name varchar(150) NOT NULL,
    type_id int NOT NULL REFERENCES Sport_place_type(id) ON DELETE RESTRICT,
    address varchar(100) NOT NULL,
    UNIQUE(name, address)
);
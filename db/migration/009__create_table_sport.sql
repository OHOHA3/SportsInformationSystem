CREATE TABLE IF NOT EXISTS Sport (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name varchar(100) NOT NULL UNIQUE,
    description varchar
);
CREATE TABLE IF NOT EXISTS Trainer (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    father_name varchar(100)
);
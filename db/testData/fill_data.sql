-- Заполнение таблицы Sport_place
INSERT INTO Sport_place (name, type_id, address) VALUES
    ('Tennis Club', 4, '10 Park Avenue'),
    ('Jumping arena', 2, '15 Lake Street'),
    ('Soccer Field', 3, '20 Stadium Road'),
    ('Fitness Studio', 2, '25 Gym Street'),
    ('Running Track', 3, '30 Jogging Lane'),
    ('Boxing Gym', 1, '35 Fight Street'),
    ('Basketball Court', 4, '40 Court Avenue'),
    ('Volleyball Court', 4, '45 Beach Road');

-- Заполнение таблицы Coating_type
INSERT INTO Coating_type (name) VALUES
    ('Parquet'),
    ('Grass'),
    ('Rubber Flooring'),
    ('Sand');

-- Заполнение таблицы Gym
INSERT INTO Gym (place_id, simulators_count) VALUES
    (6, 12);

-- Заполнение таблицы Arena
INSERT INTO Arena (place_id, area) VALUES
    (2, 800),
    (4, 1000);

-- Заполнение таблицы Stadium
INSERT INTO Stadium (place_id, capacity) VALUES
    (3, 10000),
    (5, 12000);

-- Заполнение таблицы Court
INSERT INTO Court (place_id, coating_type_id) VALUES
    (1, 3),
    (7, 1),
    (8, 1);

-- Заполнение таблицы Organizer
INSERT INTO Organizer (first_name, last_name, father_name) VALUES
    ('William', 'Robinson', 'Sr.'),
    ('Harper', 'Perez', 'Jr.'),
    ('Evelyn', 'Reed', 'Sr.'),
    ('Jacob', 'Turner', 'Jr.'),
    ('Olivia', 'Harris', 'Sr.'),
    ('Lucas', 'Lee', 'Jr.');
INSERT INTO Organizer (first_name, last_name) VALUES
    ('Benjamin', 'Cook'),
    ('Liam', 'Cooper');


-- Заполнение таблицы Sport
INSERT INTO Sport (name, description) VALUES
    ('Tennis', 'Racket sport played individually against a single opponent (singles) or between two teams of two players each (doubles)'),
    ('Swimming', 'Sport in water'),
    ('Soccer', 'Team sport played with a spherical ball between two teams of 11 players each'),
    ('Running', 'Activity of moving rapidly on foot, especially as a sport'),
    ('Boxing', 'Combat sport in which two people, usually wearing protective gloves and other protective equipment such as hand wraps and mouthguards, throw punches at each other for a predetermined amount of time in a boxing ring'),
    ('Basketball', 'Indoor or outdoor sport with a ball and a hoop'),
    ('Volleyball', 'Team sport in which two teams of six players are separated by a net'),
    ('Gymnastics', 'Sport involving exercises and performance feats requiring physical strength, flexibility, and kinesthetic awareness');

-- Заполнение таблицы Competition
INSERT INTO Competition (name, sport_id, place_id, competition_date) VALUES
    ('Tennis Tournament', 1, 1, '2023-08-20'),
    ('Soccer League', 3, 3, '2023-09-30'),
    ('Running Race', 4, 5, '2023-10-15'),
    ('Boxing Championship', 5, 6, '2023-11-05'),
    ('Basketball Tournament', 6, 7, '2023-12-01'),
    ('Volleyball Cup', 7, 8, '2022-01-15'),
    ('Gymnastics Competition', 8, 4, '2022-02-20');

-- Заполнение таблицы Sport_club
INSERT INTO Sport_club (name, creation_date) VALUES
    ('Tennis Club A', '2010-01-01'),
    ('Soccer Club C', '2008-11-20'),
    ('Running Club D', '2013-02-15'),
    ('Boxing Club E', '2007-09-30'),
    ('Basketball Club F', '2015-07-20'),
    ('Volleyball Club G', '2011-04-05'),
    ('Gymnastics Club H', '2018-10-12');

-- Заполнение таблицы Athlete
INSERT INTO Athlete (first_name, last_name, father_name, club_id) VALUES
    ('Michael', 'Johnson', 'Sr.', 1),
    ('Emily', 'Wilson', 'Jr.', 2),
    ('Sophia', 'Martinez', 'Sr.', 1),
    ('Ava', 'Lewis', 'Jr.', 2);
INSERT INTO Athlete (first_name, last_name, club_id) VALUES
    ('David', 'Brown', 3),
    ('Olivia', 'Davis', 3);
INSERT INTO Athlete (first_name, last_name, father_name) VALUES
    ('Noah', 'Garcia', 'Jr.'),
    ('Ethan', 'Clark', 'Sr.');

-- Заполнение таблицы Organizer_competition
INSERT INTO Organizer_competition (organizer_id, competition_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7);

-- Заполнение таблицы Competition_athlete
INSERT INTO Competition_athlete (competition_id, athlete_id, place) VALUES
    (1, 1, 1),
    (1, 2, 2),
    (2, 3, 3),
    (2, 4, 1),
    (3, 5, 2),
    (3, 6, 3),
    (4, 7, 1),
    (4, 8, 2);

-- Заполнение таблицы Sports_rank
INSERT INTO Sports_rank (name) VALUES
    ('third youth category'),
    ('second youth category'),
    ('first youth category'),
    ('third category'),
    ('second category'),
    ('first category'),
    ('candidate for master of sports'),
    ('international master of sports');

-- Заполнение таблицы Athlete_sport
INSERT INTO Athlete_sport (athlete_id, sport_id, sports_rank_id) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 1),
    (5, 5, 2),
    (6, 6, 3),
    (7, 7, 4),
    (8, 8, 5);

-- Заполнение таблицы Trainer
INSERT INTO Trainer (first_name, last_name, father_name) VALUES
    ('Matthew', 'Thomas', 'Sr.'),
    ('Ava', 'Gonzalez', 'Jr.'),
    ('Isabella', 'Hernandez', 'Sr.'),
    ('James', 'Clark', 'Jr.'),
    ('Jacob', 'Rodriguez', 'Sr.'),
    ('Sophia', 'Young', 'Jr.');
INSERT INTO Trainer (first_name, last_name) VALUES
    ('Ethan', 'Lopez'),
    ('Mia', 'Lewis');

-- Заполнение таблицы Trainer_athlete
INSERT INTO Trainer_athlete (trainer_id, athlete_id, sport_id) VALUES
    (1, 1, 1),
    (2, 2, 1),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5),
    (6, 6, 6),
    (7, 7, 7),
    (8, 8, 8);

-- Заполнение таблицы Trainer_qualification
INSERT INTO Trainer_qualification (name) VALUES
    ('the third category'),
    ('the second category'),
    ('the first category'),
    ('highest category');

-- Заполнение таблицы Trainer_sport
INSERT INTO Trainer_sport (trainer_id, sport_id, qualification_id) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 1),
    (6, 6, 2),
    (7, 7, 3),
    (8, 8, 4);
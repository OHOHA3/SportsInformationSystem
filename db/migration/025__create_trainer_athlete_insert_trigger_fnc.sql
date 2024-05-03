CREATE OR REPLACE FUNCTION trainer_athlete_insert_trigger_fnc()
    RETURNS trigger AS
$$
BEGIN
    IF NOT EXISTS
        (SELECT 1 FROM Athlete_sport AS a_s
        WHERE a_s.athlete_id = NEW.athlete_id
        AND a_s.sport_id = NEW.sport_id)
    THEN
        INSERT INTO Athlete_sport (athlete_id, sport_id)
        VALUES(NEW.athlete_id, NEW.sport_id);
    END IF;

    IF NOT EXISTS
        (SELECT 1 FROM Trainer_sport AS ts
         WHERE ts.trainer_id = NEW.trainer_id
           AND ts.sport_id = NEW.sport_id)
    THEN
        INSERT INTO Trainer_sport (trainer_id, sport_id)
        VALUES(NEW.trainer_id, NEW.sport_id);
    END IF;

    RETURN NEW;
END
$$
LANGUAGE 'plpgsql';
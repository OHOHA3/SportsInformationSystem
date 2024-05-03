CREATE OR REPLACE TRIGGER trainer_athlete_insert_trigger
    AFTER INSERT ON Trainer_athlete
    FOR EACH ROW
EXECUTE PROCEDURE trainer_athlete_insert_trigger_fnc();
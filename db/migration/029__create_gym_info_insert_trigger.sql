CREATE OR REPLACE TRIGGER gym_insert_trigger
    INSTEAD OF INSERT ON Gym_info
    FOR EACH ROW
EXECUTE PROCEDURE gym_insert_trigger_fnc();
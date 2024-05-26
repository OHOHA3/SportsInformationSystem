CREATE OR REPLACE TRIGGER gym_update_trigger
    INSTEAD OF UPDATE ON Gym_info
    FOR EACH ROW
EXECUTE PROCEDURE gym_update_trigger_fnc();
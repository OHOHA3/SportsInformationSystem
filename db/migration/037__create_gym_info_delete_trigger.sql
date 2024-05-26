CREATE OR REPLACE TRIGGER gym_delete_trigger
    INSTEAD OF DELETE ON Gym_info
    FOR EACH ROW
EXECUTE PROCEDURE sport_place_delete_trigger_fnc();
CREATE OR REPLACE TRIGGER stadium_update_trigger
    INSTEAD OF UPDATE ON Stadium_info
    FOR EACH ROW
EXECUTE PROCEDURE stadium_update_trigger_fnc();

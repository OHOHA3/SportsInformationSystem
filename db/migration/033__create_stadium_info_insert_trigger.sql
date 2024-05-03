CREATE OR REPLACE TRIGGER stadium_insert_trigger
    INSTEAD OF INSERT ON Stadium_info
    FOR EACH ROW
EXECUTE PROCEDURE stadium_insert_trigger_fnc();

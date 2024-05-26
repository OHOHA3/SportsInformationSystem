CREATE OR REPLACE TRIGGER stadium_delete_trigger
    INSTEAD OF DELETE ON Stadium_info
    FOR EACH ROW
EXECUTE PROCEDURE sport_place_delete_trigger_fnc();

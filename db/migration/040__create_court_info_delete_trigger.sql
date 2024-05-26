CREATE OR REPLACE TRIGGER court_delete_trigger
    INSTEAD OF DELETE ON Court_info
    FOR EACH ROW
EXECUTE PROCEDURE sport_place_delete_trigger_fnc();
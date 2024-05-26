CREATE OR REPLACE TRIGGER court_update_trigger
    INSTEAD OF UPDATE ON Court_info
    FOR EACH ROW
EXECUTE PROCEDURE court_update_trigger_fnc();
CREATE OR REPLACE TRIGGER court_insert_trigger
    INSTEAD OF INSERT ON Court_info
    FOR EACH ROW
EXECUTE PROCEDURE court_insert_trigger_fnc();
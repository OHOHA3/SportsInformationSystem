CREATE OR REPLACE TRIGGER arena_insert_trigger
    INSTEAD OF INSERT ON Arena_info
    FOR EACH ROW
EXECUTE PROCEDURE arena_insert_trigger_fnc();

CREATE OR REPLACE TRIGGER arena_update_trigger
    INSTEAD OF UPDATE ON Arena_info
    FOR EACH ROW
EXECUTE PROCEDURE arena_update_trigger_fnc();

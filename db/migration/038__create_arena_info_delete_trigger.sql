CREATE OR REPLACE TRIGGER arena_delete_trigger
    INSTEAD OF DELETE ON Arena_info
    FOR EACH ROW
EXECUTE PROCEDURE sport_place_delete_trigger_fnc();

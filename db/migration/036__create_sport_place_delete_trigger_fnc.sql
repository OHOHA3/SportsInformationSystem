CREATE OR REPLACE FUNCTION sport_place_delete_trigger_fnc()
    RETURNS trigger AS
$$
BEGIN
    DELETE FROM Sport_place WHERE id = OLD.id;
    RETURN OLD;
END
$$
    LANGUAGE 'plpgsql';
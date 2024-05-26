CREATE OR REPLACE FUNCTION arena_insert_trigger_fnc()
    RETURNS trigger AS
$$
BEGIN
    UPDATE Sport_place SET name = NEW.name, address = NEW.address
    WHERE id = OLD.id;
    UPDATE Arena SET area = NEW.area
    WHERE place_id = OLD.id;
    RETURN NEW;
END
$$
    LANGUAGE 'plpgsql';
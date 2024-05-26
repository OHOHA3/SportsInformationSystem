CREATE OR REPLACE FUNCTION stadium_insert_trigger_fnc()
    RETURNS trigger AS
$$
BEGIN
    UPDATE Sport_place SET name = NEW.name, address = NEW.address
    WHERE id = OLD.id;
    UPDATE stadium SET capacity = NEW.capacity
    WHERE place_id = OLD.id;
    RETURN NEW;
END
$$
    LANGUAGE 'plpgsql';
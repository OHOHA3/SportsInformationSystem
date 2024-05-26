CREATE OR REPLACE FUNCTION court_insert_trigger_fnc()
    RETURNS trigger AS
$$
BEGIN
    UPDATE Sport_place SET name = NEW.name, address = NEW.address
    WHERE id = OLD.id;
    UPDATE Court SET coating_type_id = NEW.coating_type_id
    WHERE place_id = OLD.id;
    RETURN NEW;
END
$$
    LANGUAGE 'plpgsql';
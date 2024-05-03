CREATE OR REPLACE FUNCTION court_insert_trigger_fnc()
    RETURNS trigger AS
$$
DECLARE
    sport_place_id integer;
BEGIN
    INSERT INTO Sport_place(name, type_id, address)
    VALUES(NEW.name, 4, NEW.address);
    SELECT sp.id INTO sport_place_id FROM Sport_place AS sp
    WHERE sp.name = NEW.name AND sp.address = NEW.address;
    INSERT INTO Court(place_id, coating_type_id)
    VALUES(sport_place_id, NEW.coating_type_id);
    RETURN NEW;
END
$$
    LANGUAGE 'plpgsql';
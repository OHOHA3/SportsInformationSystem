CREATE OR REPLACE FUNCTION arena_insert_trigger_fnc()
    RETURNS trigger AS
$$
DECLARE
    sport_place_id integer;
BEGIN
    INSERT INTO Sport_place(name, type_id, address)
    VALUES(NEW.name, 2, NEW.address);
    SELECT sp.id INTO sport_place_id FROM Sport_place AS sp
    WHERE sp.name = NEW.name AND sp.address = NEW.address;
    INSERT INTO Arena(place_id, area)
    VALUES(sport_place_id, NEW.area);
    RETURN NEW;
END
$$
    LANGUAGE 'plpgsql';
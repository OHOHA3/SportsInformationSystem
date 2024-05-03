CREATE OR REPLACE FUNCTION stadium_insert_trigger_fnc()
    RETURNS trigger AS
$$
DECLARE
    sport_place_id integer;
BEGIN
    INSERT INTO Sport_place(name, type_id, address)
    VALUES(NEW.name, 3, NEW.address);
    SELECT sp.id INTO sport_place_id FROM Sport_place AS sp
    WHERE sp.name = NEW.name AND sp.address = NEW.address;
    INSERT INTO Stadium(place_id, capacity)
    VALUES(sport_place_id, NEW.capacity);
    RETURN NEW;
END
$$
    LANGUAGE 'plpgsql';
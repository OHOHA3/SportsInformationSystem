CREATE OR REPLACE FUNCTION gym_update_trigger_fnc()
    RETURNS trigger AS
$$
BEGIN
    UPDATE Sport_place SET name = NEW.name, address = NEW.address
    WHERE id = OLD.id;
    UPDATE Gym SET simulators_count = NEW.simulators_count
    WHERE place_id = OLD.id;
    RETURN NEW;
END
$$
    LANGUAGE 'plpgsql';
CREATE VIEW Gym_info AS
SELECT sp.id AS id,
       sp.name AS name,
       sp.type_id AS type_id,
       sp.address AS address,
       g.simulators_count AS simulators_count
FROM Sport_place AS sp JOIN Gym AS g
ON sp.id = g.place_id

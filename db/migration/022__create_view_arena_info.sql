CREATE VIEW Arena_info AS
SELECT sp.id AS id,
       sp.name AS name,
       sp.type_id AS type_id,
       sp.address AS address,
       a.area AS area
FROM Sport_place AS sp JOIN Arena AS a
ON sp.id = a.place_id

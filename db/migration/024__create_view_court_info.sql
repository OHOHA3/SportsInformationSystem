CREATE VIEW Court_info AS
SELECT sp.id AS id,
       sp.name AS name,
       sp.type_id AS type_id,
       sp.address AS address,
       c.coating_type AS coating_type
FROM Sport_place AS sp JOIN Court AS c
ON sp.id = c.place_id

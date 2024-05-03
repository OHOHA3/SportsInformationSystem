CREATE VIEW Stadium_info AS
SELECT sp.id AS id,
       sp.name AS name,
       sp.type_id AS type_id,
       sp.address AS address,
       s.capacity AS capacity
FROM Sport_place AS sp JOIN Stadium AS s
ON sp.id = s.place_id

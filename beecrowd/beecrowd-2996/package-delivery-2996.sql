--IN PROGRESS

SELECT p.year, 
	   s.name AS sender, 
	   r.name AS receiver
FROM packages p
INNER JOIN users s ON p.id_user_sender = s.id
INNER JOIN users r ON p.id_user_receiver = r.id
WHERE (p.color = 'blue' OR p.year = 2015) AND (s.address != 'Taiwan' AND r.address != 'Taiwan')
ORDER BY p.year DESC, p.id_user_sender DESC;
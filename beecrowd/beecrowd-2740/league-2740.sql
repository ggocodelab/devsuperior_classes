SELECT
	 CASE
    	WHEN l.position <= 3 THEN 'Podium: ' || l.team
   		ELSE 'Demoted: ' || l.team
  	 END AS name
FROM(
	(SELECT * FROM league WHERE position <= 3)
	UNION ALL
	(SELECT  * FROM league ORDER BY position DESC LIMIT 2)	
    ) AS l
ORDER BY l.position ASC;
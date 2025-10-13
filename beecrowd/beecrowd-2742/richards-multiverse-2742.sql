SELECT lr.name, ROUND(lr.omega * 1.618, 3) AS "Fator N"
FROM life_registry lr
LEFT JOIN dimensions d ON lr.dimensions_id = d.id
WHERE d.name IN ('C875', 'C774') AND lr.name LIKE 'Richard%'
ORDER BY lr.omega ASC;
SELECT p.name
FROM products p
JOIN providers prov ON p.id_providers = prov.id
WHERE p.amount BETWEEN 10 AND 20
	AND prov.name LIKE 'P%';
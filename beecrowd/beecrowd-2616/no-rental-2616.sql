SELECT 
	c.id, c.name
FROM customers c
LEFT JOIN locations l ON l.id_customers = c.id
WHERE l.id_customers IS NULL;
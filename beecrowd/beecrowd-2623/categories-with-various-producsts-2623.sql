SELECT p.name, c.name
FROM products p
JOIN categories c ON p.id_categories = c.id
WHERE p.id_categories IN(1, 2, 3, 6, 9); 
SELECT
    p.name AS name,
    v.name AS name
FROM products p
JOIN providers v ON p.id_providers = v.id
WHERE p.id_categories = 6;
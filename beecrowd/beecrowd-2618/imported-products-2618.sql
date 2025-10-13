SELECT prod.name, prov.name, c.name
FROM products prod
INNER JOIN providers prov ON prod.id_providers = prov.id
INNER JOIN categories c ON prod.id_categories = c.id
WHERE prov.name = 'Sansul SA' AND c.name = 'Imported';
SELECT prod.name, prov.name, prod.price
FROM products prod
INNER JOIN providers prov ON prod.id_providers = prov.id
INNER JOIN categories c ON prod.id_categories = c.id
WHERE prod.price > 1000.0 AND c.name = 'Super Luxury';
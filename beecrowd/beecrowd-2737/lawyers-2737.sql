-- in progress
-- Union All operator: https://www.w3schools.com/sql/sql_union_all.asp
-- literal with column name: SELECT List - https://www.postgresql.org/docs/current/sql-select.html
SELECT 
	name,	
	customers_number
FROM lawyers
WHERE customers_number = (SELECT MAX(customers_number) FROM lawyers)
   OR customers_number = (SELECT MIN(customers_number) FROM lawyers)
UNION ALL
SELECT
	'Average' AS name,
	ROUND(AVG(customers_number)) AS customers_number
FROM lawyers
ORDER BY name, customers_number DESC;
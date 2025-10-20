-- in progress
SELECT 
	name,
	CASE
		WHEN customers_number = (SELECT MAX(customers_number) FROM lawyers) THEN customers_number
		WHEN customers_number = (SELECT MIN(customers_number) FROM lawyers) THEN customers_number
	END AS values
FROM lawyers
GROUP BY name, customers_number;
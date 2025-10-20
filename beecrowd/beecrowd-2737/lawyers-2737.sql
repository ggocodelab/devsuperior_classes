-- in progress
-- Union All operator: https://www.w3schools.com/sql/sql_union_all.asp
-- literal with column name: SELECT List - https://www.postgresql.org/docs/current/sql-select.html
-- Order rows by positional identifiers: https://blog.mattclemente.com/2021/05/11/sql-group-order-by-column-position/
-- sorting rows: https://www.postgresql.org/docs/current/queries-order.html
-- FROM Clause: https://www.postgresql.org/docs/current/queries-table-expressions.html#QUERIES-FROM 
-- The result of the FROM list is an intermediate virtual table that can then be subject to transformations by the WHERE, GROUP BY, and HAVING clauses and is finally the result of the overall table expression.
-- Select with FROM Clause 21:55: https://www.youtube.com/watch?v=4dW4LdQGBzA


SELECT * 
FROM (
	SELECT name, customers_number
	FROM lawyers
	WHERE customers_number = (SELECT MAX(customers_number) FROM lawyers)
	   OR customers_number = (SELECT MIN(customers_number) FROM lawyers)
	UNION ALL
	SELECT 'Average' AS name,
	ROUND(AVG(customers_number)) AS customers_number
	FROM lawyers
) AS result
ORDER BY
	CASE 
		WHEN name = 'Average' THEN 1
		ELSE 0
	END,
	customers_number DESC;


--SELECT 
--	name,	
--	customers_number
--FROM lawyers
--WHERE customers_number = (SELECT MAX(customers_number) FROM lawyers)
-- OR customers_number = (SELECT MIN(customers_number) FROM lawyers)
--UNION ALL
--SELECT
--	'Average' AS name,
--	ROUND(AVG(customers_number)) AS customers_number
--FROM lawyers
--ORDER BY 
--	CASE
--		WHEN name = 'Average' THEN 1
--		ELSE 0
--	END
--	customers_number DESC;


-- Min max Values
--SELECT 
--	name,
--	customers_number
--FROM lawyers
--WHERE customers_number = (SELECT MAX(customers_number) FROM lawyers)
--   OR customers_number = (SELECT MIN(customers_number) FROM lawyers);


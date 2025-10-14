SELECT count(amount) AS most_frequent_value
FROM value_table
GROUP BY amount
ORDER BY amount DESC
LIMIT 1;
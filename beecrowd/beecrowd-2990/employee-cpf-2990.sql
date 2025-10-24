SELECT
	e.cpF,
    e.enome,
	d.dnome
FROM empregados e
LEFT JOIN trabalha t ON e.cpf = t.cpf_emp
LEFT JOIN departamentos d ON e.dnumero = d.dnumero
WHERE t.cpf_emp IS NULL
ORDER BY e.cpF ASC;
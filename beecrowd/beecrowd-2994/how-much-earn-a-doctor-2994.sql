SELECT 
    d.name,
    ROUND(SUM((a.hours * 150) * (1 + w.bonus / 100.0)), 1) AS salary
FROM doctors d
JOIN attendances a ON a.id_doctor = d.id
JOIN work_shifts w ON a.id_work_shift = w.id
GROUP BY d.name
ORDER BY salary DESC;
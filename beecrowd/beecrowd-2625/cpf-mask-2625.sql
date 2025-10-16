-- https://regexr.com/
-- https://www.youtube.com/watch?v=d2uqo6PhdM4
-- https://www.postgresql.org/docs/current/functions-matching.html
-- Buscas, Validações, Substituições
-- / regex /
-- g  global
-- d encontra qualquer dígito - similar a [0-9]
-- i  case insensitive
-- [0] localiza todos os zeros do arquivo
-- [02] 0 ou 2
-- [0-9] qualquer número entre 0 e 9
-- [0][0] Procura par de zeros no arquivo
-- [0]{2} 2 ocorrências de 0.
-- [0-9]{6} 6 primeiros dígitos de cada linha
-- [0-9]{6}$ cifrão marca o fim da linha
-- ^[0-9]{6}$ circunflexo é o começo da linha. Nesse exemplo apenas os 6 primeiros números serão selecionados porque após há um $ marcando o fim.
-- ^[0-9]+  $  mais significa um número qualquer de ocorrências.
-- ^[0-9]+ [a-z]$ a traço z significa qualquer letra do alfabeto.
-- ^[0-9]+ [-][a-z]$ Para que o traço faça parte do padrão é preciso adicioná-lo entre colchetes.
-- cpf: [0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}
-- regexp_replace() função só aceita texto
-- () grupo 
-- \1, \2, \3, \4 referência aos grupos
-- \\ representa uma barra invertida

SELECT regexp_replace(trim(cpf), '(\d{3})(\d{3})(\d{3})(\d{2})', '\1.\2.\3-\4') AS CPF
FROM natural_person as np
JOIN customers c ON np.id_customers = c.id;

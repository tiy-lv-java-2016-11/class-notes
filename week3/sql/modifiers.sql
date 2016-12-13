SELECT *
FROM books b
WHERE lower(title) like '%lord of the rings%'
ORDER BY year ASC ;

SELECT *
FROM ratings
WHERE isbn = '0345296087';


SELECT b.id, b.title, sum(r.rating), avg(r.rating), min(r.rating), max(r.rating), count(r.rating)
FROM books b
JOIN ratings r ON b.isbn = r.isbn
WHERE b.isbn = '0345296087' AND r.rating > 0
GROUP BY b.id, b.title;

SELECT b.year, avg(r.rating), min(r.rating), max(r.rating), count(r.rating)
FROM books b
JOIN ratings r ON b.isbn = r.isbn
WHERE r.rating > 0
GROUP BY b.year
HAVING count(r.rating) > 100
ORDER BY avg(r.rating) DESC;

SELECT b.id, b.title, avg(r.rating), count(r.rating)
FROM books b
  JOIN ratings r ON b.isbn = r.isbn
WHERE r.rating > 0
GROUP BY b.id, b.title
HAVING count(r.rating) > 10
ORDER BY avg(r.rating) DESC;

SELECT b.title, avg(r.rating), count(r.rating)
FROM books b
  JOIN ratings r ON b.isbn = r.isbn
WHERE r.rating > 0 AND lower(b.title) like '%harry potter%'
GROUP BY b.title
HAVING count(r.rating) > 50
ORDER BY avg(r.rating) DESC;


SELECT *
FROM books_users;

INSERT INTO books_users (book_id, user_id) VALUES(1, 2);
INSERT INTO books_users (book_id, user_id) VALUES(2, 3), (3, 4), (5, 6);

UPDATE books_users
SET user_id = 50, book_id = 100
WHERE id = 1;

/*UPDATE books_users
SET user_id = 50, book_id = 100;*/

-- DELETE FROM books_users
-- WHERE id = 2;
--
-- DELETE FROM books_users;
-- TRUNCATE books_users;

SELECT year, year::int as intYear
FROM books
limit 10;

-- UPDATE books
-- SET int_year = year::INTEGER;

SELECT *
FROM books
WHERE int_year > 2017;
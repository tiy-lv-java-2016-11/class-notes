SELECT *
FROM books;

SELECT id, isbn, title, author, year, publisher
FROM books;

SELECT id, isbn, title, author, year, publisher
FROM books
LIMIT 10;

SELECT id, isbn, title, author, year, publisher
FROM books
WHERE year = '2002';

SELECT id, isbn, title, author, year, publisher
FROM books
WHERE year = '2002' OR year = '2001';

SELECT id, isbn, title, author, year, publisher
FROM books
WHERE year = '2002' AND author = 'Jennifer Egan';

SELECT id, isbn, title, author, year, publisher
FROM books
WHERE (year = '2002' AND author = 'Jennifer Egan') OR year = '2002';

SELECT id, isbn, title, author, year, publisher
FROM books
WHERE (year = '2002' AND lower(author) = 'jennifer egan') OR year = '2002';

SELECT id, isbn, title, author, year, publisher
FROM books
WHERE lower(title) like '%lord of the rings%';

SELECT id, isbn, title, author, year, publisher
FROM books
WHERE lower(title) like '%lord of the rings%' AND year != '0'
ORDER BY year ASC, title ASC
LIMIT 10;

SELECT id, isbn, title, author, year, publisher
FROM books
WHERE year is NULL;

SELECT id, isbn, rating
FROM ratings
WHERE isbn = '0345296052';

SELECT *
FROM books
  JOIN ratings ON books.isbn = ratings.isbn
WHERE books.isbn = '0345296052';

SELECT *
FROM books b
  JOIN ratings r ON b.isbn = r.isbn
WHERE b.isbn = '0345296052';


SELECT *
FROM books b
  JOIN ratings r ON b.isbn = r.isbn
WHERE b.isbn = '192076920X';


SELECT *
FROM books b
  LEFT JOIN ratings r ON b.isbn = r.isbn
WHERE r.id is null;

SELECT *
FROM books b
  RIGHT JOIN ratings r on b.isbn = r.isbn
WHERE b.id is null;

/* jfidofjidosfj */
SELECT id, isbn, title as MYTITLE
FROM books b
WHERE b.year = '2020';
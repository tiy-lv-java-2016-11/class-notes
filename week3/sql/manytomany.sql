SELECT * FROM genre;

SELECT *
FROM movies m
  JOIN movie_genre mg ON mg.movieid = m.movieid
  JOIN genre g ON g.id = mg.genre_id
WHERE m.movieid = 1;
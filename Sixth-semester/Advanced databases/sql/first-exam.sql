/* Sakila DB */

/* Obtain the title, rating, and the total number of actors of the movies with a given release year and within a length range */
SELECT title, rating, COUNT(f.film_id) AS actor_count
FROM film AS f
INNER JOIN film_actor AS fa
ON f.film_id = fa.film_id
WHERE f.release_year = 2006
AND f.length >= 47
AND f.length <= 87
GROUP BY(f.film_id);

/* Build a stored procedure to encapsulate the functionality of the previously generated query */
DELIMITER $$
CREATE PROCEDURE number_of_actors_in_year_between_length 
    (IN movie_year YEAR, minimum_minutes INT, maximum_minutes INT, OUT msg VARCHAR(100))
BEGIN
    SELECT title, rating, COUNT(f.film_id) AS actor_count
    FROM film AS f
    INNER JOIN film_actor AS fa
    ON f.film_id = fa.film_id
    WHERE f.release_year = movie_year
    AND f.length BETWEEN minimum_minutes AND maximum_minutes
    GROUP BY(f.film_id);
END$$
DELIMITER ;

CALL number_of_actors_in_year_between_length(2006, 40, 50, @result);

/* Build either an event or trigger to call the previously generated stored procedure on a daily basis */
CREATE EVENT actors_event
    ON SCHEDULE EVERY 1 DAY
    DO CALL number_of_actors_in_year_between_length(2006, 47, 87, @result);

/* Create indices to improve the performance of the query and analyze your query to validate that the indices are properly working */
CREATE INDEX idx_film_filmid ON film(film_id);
CREATE INDEX idx_filmactor_filmid ON film_actor(film_id);
CREATE INDEX idx_film_releaseyear ON film(release_year);
CREATE INDEX idx_film_length ON film(length);
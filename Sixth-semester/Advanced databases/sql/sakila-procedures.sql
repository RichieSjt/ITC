
/* Obtain a list with all the movies of a given actor */
DELIMITER $$
CREATE PROCEDURE movies_from_actor 
    (IN actor_name VARCHAR(100), actor_last_name VARCHAR(100), OUT msg VARCHAR(100))
BEGIN
    SELECT first_name,last_name, title 
    FROM actor 
    INNER JOIN film_actor 
    ON actor.actor_id = film_actor.actor_id 
    INNER JOIN film 
    ON film.film_id = film_actor.film_id  
    WHERE first_name = actor_name 
    AND last_name = actor_last_name;
END$$
DELIMITER ;

CALL movies_from_actor("PENELOPE", "GUINESS", @result);

/* Obtain a list with the names of all the actors in a given movie */
DELIMITER $$
CREATE PROCEDURE actors_from_movie 
    (IN movie_title VARCHAR(100), OUT msg VARCHAR(100))
BEGIN
    SELECT title, first_name,last_name 
    FROM actor 
    INNER JOIN film_actor 
    ON actor.actor_id = film_actor.actor_id 
    INNER JOIN film 
    ON film.film_id = film_actor.film_id 
    WHERE title = movie_title;
END$$
DELIMITER ;

CALL actors_from_movie("ANGELS LIFE", @result);

/* Determine the total income obtained by a given movie */
DELIMITER $$
CREATE PROCEDURE movie_total_income 
    (IN movie_title VARCHAR(100), OUT msg VARCHAR(100))
BEGIN
    SELECT title, SUM(amount) FROM 
    film 
    INNER JOIN inventory 
    ON film.film_id = inventory.film_id 
    INNER JOIN rental 
    INNER JOIN payment
    ON rental.rental_id = payment.rental_id 
    ON inventory.inventory_id = rental.inventory_id
    WHERE title = movie_title ;
END$$
DELIMITER ;

CALL movie_total_income("ANGELS LIFE", @result);

/* Determine the total income obtained by the movies rented of a given actor */
DELIMITER $$
CREATE PROCEDURE movie_total_income_by_actor 
    (IN actor_name VARCHAR(100), actor_last_name VARCHAR(100), OUT msg VARCHAR(100))
BEGIN
    SELECT first_name, SUM(amount) 
    FROM (actor INNER JOIN film_actor ON actor.actor_id = film_actor.actor_id) 
    INNER JOIN((film INNER JOIN inventory ON film.film_id = inventory.film_id) 
    INNER JOIN(rental INNER JOIN payment ON rental.rental_id = payment.rental_id) 
    ON inventory.inventory_id = rental.inventory_id) 
    ON film_actor.film_id = film.film_id
    WHERE first_name = actor_name
    AND last_name = actor_last_name;
END$$
DELIMITER ;

CALL movie_total_income_by_actor("PENELOPE", "GUINESS", @result);

/* Determine the number of times a given movie has been rented */
DELIMITER $$
CREATE PROCEDURE movie_rents 
    (IN movie_title VARCHAR(100), OUT msg VARCHAR(100))
BEGIN
    SELECT title, count(rental_id) AS rentals
    FROM film INNER JOIN inventory ON film.film_id = inventory.film_id 
    INNER JOIN rental 
    ON inventory.inventory_id = rental.inventory_id  
    WHERE title = movie_title;
END$$
DELIMITER ;

CALL movie_rents("ANGELS LIFE", @result);
DELIMITER $$
CREATE FUNCTION hello_world(person_name VARCHAR(100))
RETURNS VARCHAR(100) DETERMINISTIC
BEGIN
	RETURN CONCAT("Hello ", person_name);
END$$
DELIMITER ;

SELECT hello_world("Richie");

DELIMITER $$
CREATE PROCEDURE p_hello_world(IN person_name VARCHAR(100), OUT msg VARCHAR(100))
BEGIN
	SELECT CONCAT("Hello ", person_name) INTO msg;
END$$
DELIMITER ;

CALL p_hello_world("Richie", @result);
SELECT @result;
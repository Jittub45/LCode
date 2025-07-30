CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE result INT;
  DECLARE offset_val INT;

  SET offset_val = N - 1;

  SELECT DISTINCT salary
  INTO result
  FROM Employee
  ORDER BY salary DESC
  LIMIT offset_val, 1;

  RETURN result;
END;

#DROP TABLE user;

CREATE TABLE user(
  id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(32),
  description VARCHAR(255)
);

#DROP TABLE log;

CREATE TABLE log(
  taskid CHAR(17) PRIMARY KEY,
  time DATETIME,
  tableName VARCHAR(128),
  detail VARCHAR(1024)
);
CREATE TABLE users (
   id BIGINT AUTO_INCREMENT NOT NULL,
   `first` VARCHAR(255) NOT NULL,
   `last` VARCHAR(255) NOT NULL,
   `handle` VARCHAR(255) NOT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);
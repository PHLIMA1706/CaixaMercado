DROP DATABASE mercadopedreira;
CREATE DATABASE mercadopedreira;


USE mercadopedreira;


CREATE TABLE CLIENTE(
cli_nome varchar(50) NOT NULL,
cli_cpf BIGINT(25) NOT NULL,
cli_cel BIGINT(20) NOT NULL,
cli_tel BIGINT(20) ,
cli_obs varchar(100),
PRIMARY KEY(cli_cpf));
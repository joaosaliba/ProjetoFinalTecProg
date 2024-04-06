CREATE SCHEMA IF NOT EXISTS estoque;

CREATE TABLE IF NOT EXISTS estoque.produto (
                                               id SERIAL PRIMARY KEY,
                                               descricao VARCHAR(255),
    quantidade INT,
    preco NUMERIC(10,2),
    categoria VARCHAR(255)
    );
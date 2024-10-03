CREATE TABLE clientes (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL,
                          cpf VARCHAR(11) NOT NULL UNIQUE,
                          telefone VARCHAR(20)
);
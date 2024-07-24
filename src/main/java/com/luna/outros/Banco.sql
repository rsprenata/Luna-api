CREATE TABLE artista (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    email VARCHAR(100) NOT NULL,
    nome VARCHAR(128) NOT null,
    senha VARCHAR(50) NOT NULL,
    endereco VARCHAR(100) NOT null,
    bairro_endereco VARCHAR(50) NOT NULL,
    numero_endereco VARCHAR(50) NOT null,
    cidade_endereco VARCHAR(50) NOT NULL,
    telefone VARCHAR(20) NOT null,
    peso VARCHAR(10) NOT NULL,
    altura VARCHAR(10) NOT null,
    experiencia TEXT NOT NULL
);
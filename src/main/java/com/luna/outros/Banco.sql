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

ALTER TABLE public.artista ADD idade int NULL;

ALTER TABLE public.candidatura DROP CONSTRAINT candidatura_pk;
ALTER TABLE public.candidatura ADD id int NOT NULL;
ALTER TABLE public.candidatura ADD CONSTRAINT candidatura_pk PRIMARY KEY (id);

ALTER TABLE public.candidatura DROP CONSTRAINT candidatura_pk;
ALTER TABLE public.candidatura DROP COLUMN id;
ALTER TABLE public.candidatura ADD id int NOT NULL GENERATED ALWAYS AS IDENTITY;
ALTER TABLE public.candidatura ADD CONSTRAINT candidatura_pk PRIMARY KEY (id);

ALTER TABLE public.vaga ADD nivel int NULL;
ALTER TABLE public.candidatura ADD status int NULL;

CREATE TABLE public.status (
                               id int NOT NULL GENERATED ALWAYS AS IDENTITY,
                               descricao varchar NULL,
                               CONSTRAINT status_pk PRIMARY KEY (id)
);

CREATE TABLE public.nivel (
                              id int NOT NULL GENERATED ALWAYS AS IDENTITY,
                              descricao varchar NULL,
                              CONSTRAINT nivel_pk PRIMARY KEY (id)
);


DROP TABLE vaga;
CREATE TABLE vaga (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(128),
    descricao TEXT,
    valor VARCHAR(10),
    data VARCHAR(12),
    qtd_vagas INTEGER
);
INSERT INTO vaga (nome, descricao, valor, data, qtd_vagas) VALUES
('Teste filme', 'blabalbalbabalblalb', 'R$1300,00', '15/08/1990', 3),
('Ilustrador', 'Responsável por criar ilustrações para livros infantis.', 'R$ 2500', '2024-07-30', 3),
('Designer Gráfico', 'Criação de artes para mídias sociais e materiais impressos.', 'R$ 3000', '2024-08-01', 2),
('Fotógrafo', 'Fotografia de eventos e sessões de fotos.', 'R$ 4000', '2024-07-25', 1),
('Artista Plástico', 'Criação de obras de arte para galerias e exposições.', 'R$ 3500', '2024-08-15', 2),
('Cenógrafo', 'Desenvolvimento de cenários para peças de teatro.', 'R$ 4500', '2024-09-01', 1),
('Escultor', 'Criação de esculturas para exposições e vendas.', 'R$ 3800', '2024-07-28', 1),
('Diretor de Arte', 'Coordenação de projetos de design e publicidade.', 'R$ 5000', '2024-08-10', 1),
('Animador 2D', 'Criação de animações 2D para vídeos e jogos.', 'R$ 3200', '2024-07-31', 2),
('Curador de Arte', 'Organização e curadoria de exposições de arte.', 'R$ 4500', '2024-09-05', 1),
('Produtor Musical', 'Produção e mixagem de trilhas sonoras.', 'R$ 5500', '2024-08-20', 1);

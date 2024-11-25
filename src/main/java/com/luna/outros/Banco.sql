CREATE TABLE artista (
                         id_usuario INTEGER PRIMARY KEY,
                         peso VARCHAR(10) NOT NULL,
                         altura VARCHAR(10) NOT null,
                         experiencia TEXT NOT null,
                         idade INTEGER,
                         FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE empresa (
                         id_usuario INTEGER PRIMARY KEY,
                         cnpj VARCHAR(15) NOT NULL,
                         descricao VARCHAR(200),
                         FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
ALTER TABLE public.artista RENAME COLUMN id_usuario TO id;
ALTER TABLE public.usuario ADD nivel int NOT NULL;
ALTER TABLE public.empresa RENAME COLUMN id_usuario TO id;


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

CREATE TABLE public.empresa (
                                id int NOT NULL GENERATED ALWAYS AS IDENTITY,
                                cnpj varchar NOT NULL,
                                descricao varchar NULL
);

ALTER TABLE public.vaga ADD id_empresa varchar NULL;

ALTER TABLE public.artista DROP COLUMN endereco;
ALTER TABLE public.artista DROP COLUMN bairro_endereco;
ALTER TABLE public.artista DROP COLUMN numero_endereco;
ALTER TABLE public.artista DROP COLUMN nome;
ALTER TABLE public.artista DROP COLUMN email;
ALTER TABLE public.artista DROP COLUMN senha;
ALTER TABLE public.artista DROP COLUMN cidade_endereco;
ALTER TABLE public.artista DROP COLUMN telefone;

CREATE TABLE public.usuario (
                                id int NOT NULL GENERATED ALWAYS AS IDENTITY,
                                senha varchar(50) NULL,
                                email varchar(100) NULL,
                                nome varchar(128) NULL,
                                endereco varchar(200) NULL,
                                bairro_endereco varchar(100) NULL,
                                numero_endereco varchar(20) NULL,
                                telefone varchar NULL,
                                cidade_endereco varchar(50) NULL
);

ALTER TABLE public.usuario ADD CONSTRAINT usuario_pk PRIMARY KEY (id);
ALTER TABLE public.artista RENAME COLUMN id TO id_usuario;

ALTER TABLE public.artista DROP CONSTRAINT artista_pkey;


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


CREATE TABLE public.candidatura (
                                    artista_id int4 NOT NULL,
                                    vaga_id int4 NOT NULL,
                                    id int4 NOT NULL GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE),
                                    status int4 NULL,
                                    CONSTRAINT candidatura_pk PRIMARY KEY (id)
);

CREATE TABLE public.especialidade (
                                      id int NOT NULL GENERATED ALWAYS AS IDENTITY,
                                      descricao varchar NULL
);
CREATE TABLE public.nivel_perfil (
                                     id int NOT NULL GENERATED ALWAYS AS IDENTITY,
                                     descricao varchar NULL
);

ALTER TABLE public.vaga RENAME COLUMN nivel TO especialidade;


-- Auto-generated SQL script #202410301650
INSERT INTO public.nivel_perfil (descricao)
VALUES ('Artista');
INSERT INTO public.nivel_perfil (descricao)
VALUES ('Empresa');

-- Auto-generated SQL script #202410301651
INSERT INTO public.especialidade (descricao)
VALUES ('Ator/Atriz');
INSERT INTO public.especialidade (descricao)
VALUES ('Modelo');
INSERT INTO public.especialidade (descricao)
VALUES ('Artista Plástico');

ALTER TABLE public.artista ADD especialidade int NULL;


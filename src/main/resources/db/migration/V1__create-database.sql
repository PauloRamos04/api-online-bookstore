-- public.administradores definition
CREATE TABLE public.administradores (
                                        id serial4 NOT NULL,
                                        nome varchar(255) NOT NULL,
                                        email varchar(255) NOT NULL,
                                        senha varchar(255) NOT NULL,
                                        CONSTRAINT administradores_email_key UNIQUE (email),
                                        CONSTRAINT administradores_pkey PRIMARY KEY (id)
);

-- public.autores definition
CREATE TABLE public.autores (
                                id serial4 NOT NULL,
                                nome varchar(255) NOT NULL,
                                biografia text NULL,
                                CONSTRAINT autores_pkey PRIMARY KEY (id)
);

-- public.editoras definition
CREATE TABLE public.editoras (
                                 id serial4 NOT NULL,
                                 nome varchar(255) NOT NULL,
                                 descricao text NULL,
                                 CONSTRAINT editoras_pkey PRIMARY KEY (id)
);


-- public.usuarios definition
CREATE TABLE public.usuarios (
                                 id serial4 NOT NULL,
                                 nome varchar(255) NOT NULL,
                                 email varchar(255) NOT NULL,
                                 senha varchar(255) NOT NULL,
                                 CONSTRAINT usuarios_email_key UNIQUE (email),
                                 CONSTRAINT usuarios_pkey PRIMARY KEY (id)
);

-- public.livros definition
CREATE TABLE public.livros (
                               id serial4 NOT NULL,
                               titulo varchar(255) NOT NULL,
                               descricao text NULL,
                               ano_publicacao int4 NULL,
                               autor_id int4 NULL,
                               editora_id int4 NULL,
                               status varchar(255) NULL DEFAULT 'Aguardando Aprovação'::character varying,
                               CONSTRAINT livros_pkey PRIMARY KEY (id),
                               CONSTRAINT livros_autor_id_fkey FOREIGN KEY (autor_id) REFERENCES public.autores(id),
                               CONSTRAINT livros_editora_id_fkey FOREIGN KEY (editora_id) REFERENCES public.editoras(id)
);

-- public.moderacao definition
CREATE TABLE public.moderacao (
                                  id serial4 NOT NULL,
                                  livro_id int4 NULL,
                                  usuario_id int4 NULL,
                                  "data" timestamp NULL,
                                  status_anterior varchar(255) NULL,
                                  status_novo varchar(255) NULL,
                                  comentario text NULL,
                                  CONSTRAINT moderacao_pkey PRIMARY KEY (id),
                                  CONSTRAINT moderacao_livro_id_fkey FOREIGN KEY (livro_id) REFERENCES public.livros(id),
                                  CONSTRAINT moderacao_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id)
);

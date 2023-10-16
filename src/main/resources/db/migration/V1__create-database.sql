-- V1__create_autores.sql
CREATE TABLE Autores (
                         id SERIAL PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         biografia TEXT
    -- Outros campos relevantes para o autor
);

-- V2__create_editoras.sql
CREATE TABLE Editoras (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          descricao TEXT
    -- Outros campos relevantes para a editora
);

-- V3__create_livros.sql
CREATE TABLE Livros (
                        id SERIAL PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        descricao TEXT,
                        ano_publicacao INT,
                        autor_id INT,
                        editora_id INT,
                        status VARCHAR(20) DEFAULT 'Aguardando Aprovação',
                        CHECK (status IN ('Aguardando Aprovação', 'Aprovado', 'Rejeitado')),
                        FOREIGN KEY (autor_id) REFERENCES Autores(id),
                        FOREIGN KEY (editora_id) REFERENCES Editoras(id)
);

-- V4__create_usuarios.sql
CREATE TABLE Usuarios (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL
    -- Outros campos relevantes para o usuário
);

-- V5__create_moderacao.sql
CREATE TABLE Moderacao (
                           id SERIAL PRIMARY KEY,
                           livro_id INT,
                           usuario_id INT,
                           data TIMESTAMP,
                           status VARCHAR(20),
                           FOREIGN KEY (livro_id) REFERENCES Livros(id),
                           FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);
-- V6__create_administradores.sql
CREATE TABLE Administradores (
                                 id SERIAL PRIMARY KEY,
                                 nome VARCHAR(255) NOT NULL,
                                 email VARCHAR(255) NOT NULL UNIQUE,
                                 senha VARCHAR(255) NOT NULL
);

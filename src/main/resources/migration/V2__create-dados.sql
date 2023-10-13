-- Inserir dados fictícios na tabela Autores
INSERT INTO Autores (nome, biografia)
VALUES ('Autor1', 'Biografia do Autor 1'),
       ('Autor2', 'Biografia do Autor 2'),
       ('Autor3', 'Biografia do Autor 3');

-- Inserir dados fictícios na tabela Editoras
INSERT INTO Editoras (nome, descricao)
VALUES ('Editora1', 'Descrição da Editora 1'),
       ('Editora2', 'Descrição da Editora 2'),
       ('Editora3', 'Descrição da Editora 3');

-- Inserir dados fictícios na tabela Usuarios
INSERT INTO Usuarios (nome, email, senha)
VALUES ('Usuario1', 'usuario1@exemplo.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.'),
       ('Usuario2', 'usuario2@exemplo.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.'),
       ('Usuario3', 'usuario3@exemplo.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');

-- Inserir dados fictícios na tabela Administradores
INSERT INTO Administradores (nome, email, senha)
VALUES ('Admin1', 'admin1@exemplo.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.'),
       ('Admin2', 'admin2@exemplo.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.'),
       ('Admin3', 'admin3@exemplo.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');

-- Inserir dados fictícios na tabela Livros
INSERT INTO Livros (titulo, descricao, ano_publicacao, autor_id, editora_id, status)
VALUES ('Livro1', 'Descrição do Livro 1', 2023, 1, 1, 'Aguardando Aprovação'),
       ('Livro2', 'Descrição do Livro 2', 2023, 2, 2, 'Aprovado'),
       ('Livro3', 'Descrição do Livro 3', 2023, 3, 3, 'Rejeitado');

-- Inserir dados fictícios na tabela Moderacao
INSERT INTO Moderacao (livro_id, usuario_id, data, status)
VALUES (1, 1, '2023-10-10 12:00:00', 'Aguardando Aprovação'),
       (2, 2, '2023-10-11 12:00:00', 'Aguardando Aprovação'),
       (3, 3, '2023-10-12 12:00:00', 'Aguardando Aprovação');

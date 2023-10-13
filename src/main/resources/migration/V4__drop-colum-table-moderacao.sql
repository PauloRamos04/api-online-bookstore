-- V7__remove_status_anterior_from_moderacao.sql
-- Remove o campo 'status_anterior' da tabela 'Moderacao'
ALTER TABLE Moderacao
    DROP COLUMN status_novo;

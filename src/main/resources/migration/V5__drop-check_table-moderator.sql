-- V8__remove_moderacao_status_check.sql
-- Remove a restrição de verificação 'moderacao_status_check' da tabela 'Moderacao'
ALTER TABLE Moderacao
    DROP CONSTRAINT moderacao_status_check;

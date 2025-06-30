-- V2: Migration para adicionar as colunas de idioma na tabela de cadastro

ALTER TABLE tb_registration
ADD COLUMN book_language VARCHAR(255);

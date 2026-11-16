CREATE TABLE tb_registration (
    id UUID PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    realease_year DATE,
    publisher VARCHAR(255),
    status VARCHAR(255),
    description VARCHAR(1000),
    rating_id UUID,
    book_image BYTEA
);

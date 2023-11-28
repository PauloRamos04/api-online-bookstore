-- db/migration/V1__Create_Cart.sql

CREATE TABLE cart (
                      id SERIAL PRIMARY KEY,
                      user_id BIGINT
);

CREATE TABLE cart_item (
                           id SERIAL PRIMARY KEY,
                           cart_id BIGINT REFERENCES cart(id),
                           book_id BIGINT REFERENCES livros(id),
                           quantity INT
);

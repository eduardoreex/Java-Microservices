create schema if not exists shopping;

-- Tabela principal da Compra
create table shopping.shop (
    id bigserial primary key,
    user_identifier varchar(100) not null,
    date timestamp not null,
    total float not null
);

-- Tabela de Itens da Compra (Cada linha é um produto comprado)
create table shopping.item (
    shop_id bigint references shopping.shop(id),
    product_identifier varchar(100) not null,
    price float not null
);
create table t_inventory
(
    id  bigint auto_increment primary key,
    sku_code varchar(255)     not null,
    quantity int default NULL null
);


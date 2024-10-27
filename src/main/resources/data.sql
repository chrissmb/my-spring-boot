insert into product (id, description) values
(1, 'pen'),
(2, 'erasor');

insert into sale (id) values
(1);

insert into sale_item (sale_id, sequence, product_id, quantity, amount, active) values
(1, 1, 1, 2, 2.5, true),
(1, 2, 2, 1, 1.4, true),
(1, 3, 2, 5, 1.1, false);
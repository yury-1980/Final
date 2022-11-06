INSERT INTO public.gift_certificate (id, create_data, description, duration, last_update_date, name, price)
VALUES (1, '2022-10-17 12:49:32.166000', 'yes', 2, '2022-10-17 12:49:32.166000', 'milk04', 1.50),
       (2, '2022-10-17 14:09:18.958000', 'yes', 2, '2022-10-17 14:09:18.958000', 'milk01', 1.50),
       (3, '2022-10-17 22:10:55.600000', 'yes', 2, '2022-10-17 22:10:55.600000', 'Milk', 1.50),
       (4, '2022-10-17 22:11:41.517000', 'yes', 2, '2022-10-17 22:11:41.517000', 'B', 1.50);

INSERT INTO public.tag (id, name)
VALUES (1, 'milk04'),
       (2, 'milk01'),
       (3, 'Milk'),
       (4, 'T');

INSERT INTO public.tag_gift_certificate (id, tag_id, gift_certificate_id)
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 3, 3),
       (4, 4, 4);
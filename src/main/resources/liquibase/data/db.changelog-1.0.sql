-- update databasechangelog set md5sum = 'null' where id = 'raw';

CREATE TABLE gift_certificate
(
    id               bigserial not null
        constraint gift_certificate_pkey
            primary key,
    create_data      timestamp,
    description      varchar(255),
    duration         integer,
    last_update_date timestamp,
    name             varchar(255)
        constraint uk_en7vlwcn343hrd7cfcibpw284
            unique,
    price            numeric(19, 2)
);

alter table gift_certificate
    owner to postgres;

CREATE TABLE tag
(
    id   bigserial not null
        constraint tag_pkey
            primary key,
    name varchar(255)
        constraint uk_1wdpsed5kna2y38hnbgrnhi5b
            unique
);

alter table tag
    owner to postgres;

CREATE TABLE tag_gift_certificate
(
    id                  bigserial not null
        constraint tag_gift_certificate_pkey
            primary key,
    tag_id              bigint    not null
        constraint fkp1ogeu7w3xixqyh12yg6u71hh
            references tag,
    gift_certificate_id bigint    not null
        constraint fkpd3w8hohgt5d852jwcp0ss9cm
            references gift_certificate
);

alter table tag_gift_certificate
    owner to postgres;

create table message
(
    id        uuid    not null,
    msisdn    integer not null,
    action    varchar not null,
    timestamp integer not null
);

alter table message
    owner to postgres;

create unique index message_id_uindex
    on message (id);

create unique index message_msisdn_uindex
    on message (msisdn);

create table subscription
(
    id         uuid not null
        constraint subscription_pk
            primary key,
    message_id uuid not null
        constraint fk_subscription_message
            references message (id)
);

alter table subscription
    owner to postgres;

create unique index subscription_id_uindex
    on subscription (id);

create unique index subscription_message_id_uindex
    on subscription (message_id);

create table purchase
(
    id         uuid not null
        constraint purchase_pk
            primary key,
    message_id uuid not null
        constraint fk_purchase_message
            references message (id)
);

alter table purchase
    owner to postgres;

create unique index purchase_id_uindex
    on purchase (id);

create unique index purchase_message_id_uindex
    on purchase (message_id);
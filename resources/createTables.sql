create table public.flight
(
    id                     bigint generated always as identity
    primary key,
    flight_no              varchar,
    departure_date         date,
    departure_airport_code varchar,
    aircraft_id            bigint,
    status                 varchar,
    column_name            integer
);

alter table public.flight
    owner to admin;

create table public.ticket
(
    id             bigint generated always as identity
        constraint ticket_pk
            primary key,
    passenger_no   varchar,
    passenger_name varchar,
    flight_id      bigint
        constraint flight_id
            references public.flight,
    seat_no        varchar,
    cost           integer
);

alter table public.ticket
    owner to admin;

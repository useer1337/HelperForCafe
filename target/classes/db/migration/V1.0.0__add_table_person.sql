create sequence seq_person;

create table person(
    id numeric primary key default nextval('seq_person'),
    name varchar not null ,
    phone_number numeric not null,
    login varchar not null,
    password varchar not null
);

insert into person(name, phone_number, login, password)
values('Коваль Алекссандр Викторович', '+70000000000', 'koval', '123');
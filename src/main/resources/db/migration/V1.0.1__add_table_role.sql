create sequence seq_role;

create table role(
    id numeric primary key default nextval('seq_role'),
    name varchar
);

alter table person add column id_role numeric constraint fk_role references role(id);

insert into role(name)
values('ROLE_CLIENT'), ('ROLE_ADMINISTRATOR');

update person
set id_role='1'
where login='koval';


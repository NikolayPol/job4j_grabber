CREATE TABLE company (
    id   integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person (
    id         integer NOT NULL,
    name       character varying,
    company_id integer references company (id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name)
values (1, 'Company1');
insert into company(id, name)
values (2, 'Company2');
insert into company(id, name)
values (3, 'Company3');
insert into company(id, name)
values (4, 'Company4');
insert into company(id, name)
values (5, 'Company5');

insert into person(id, name, company_id)
values (1, 'Person1', 4);
insert into person(id, name, company_id)
values (2, 'Person2', 3);
insert into person(id, name, company_id)
values (3, 'Person3', 2);
insert into person(id, name, company_id)
values (4, 'Person4', 1);
insert into person(id, name, company_id)
values (5, 'Person5', 5);
insert into person(id, name, company_id)
values (6, 'Person6', 5);
insert into person(id, name, company_id)
values (7, 'Person7', 5);

--1. В одном запросе получить
-- имена всех person, которые не состоят в компании с id = 5;
select p.name
from person p
         inner join company c on p.company_id = c.id
where company_id != 5;

--- название компании для каждого человека.
select p.name, c.name
from company c inner join person p on c.id = p.company_id
where p.company_id = c.id AND company_id != 5;

--2. Необходимо выбрать название компании
-- с максимальным количеством человек + количество человек в этой компании.
select company.name, count(p.company_id)
from company
         inner join person p on company.id = p.company_id
group by company.name
having count(p.company_id) =
       (
           select count(company_id) as stat
           from company c
           inner join person p on c.id = p.company_id
           group by p.company_id
           order by stat desc
           fetch first row only
       )

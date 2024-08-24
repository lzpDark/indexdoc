create database if not exists indexdoc;
use indexdoc;
create table if not exists resource_task (
    id bigint not null,
    task_state integer not null,
    url varchar(200) not null,
    language varchar(10),
    unique index (url)
);
create table if not exists task_state (
    id integer not null,
    name varchar(20) not null,
    primary key (id),
    unique index (name)
);
insert into task_state(id, name) values (1, 'NOT_STARTED') on duplicate key update name = 'NOT_STARTED';
insert into task_state(id, name) values (2, 'IN_PROGRESS') on duplicate key update name = 'IN_PROGRESS';
insert into task_state(id, name) values (3, 'FINISHED') on duplicate key update name = 'FINISHED';
insert into task_state(id, name) values (4, 'ERROR') on duplicate key update name = 'ERROR';
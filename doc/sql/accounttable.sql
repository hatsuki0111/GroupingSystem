create table account
(
  name varchar(32),
  password varchar(32) not null,
  constraint account_pk
    primary key (name)
);
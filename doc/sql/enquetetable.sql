create table enquete
(
  id bigint auto_increment,
  title varchar(128) not null,
  author_account_name varchar(32) not null,
  start timestamp not null,
  "end" timestamp not null,
  constraint enquete_pk
    primary key (id),
  constraint enquete_ACCOUNT_NAME_fk
    foreign key (author_account_name) references ACCOUNT
      on update cascade
);
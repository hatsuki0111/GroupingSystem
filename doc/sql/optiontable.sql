create table option
(
  enquete_id bigint not null,
  label varchar(64) not null,
  authorized bool not null,
  constraint option_ENQUETE_ID_fk
    foreign key (enquete_id) references ENQUETE
      on update cascade on delete cascade
);

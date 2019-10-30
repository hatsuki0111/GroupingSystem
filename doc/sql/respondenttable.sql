create table respondent
(
  enquete_id bigint not null,
  account_name varchar(32) not null,
  constraint respondent_ENQUETE_ID_fk
    foreign key (enquete_id) references ENQUETE
      on update cascade on delete cascade,
  constraint respondent_ACCOUNT_NAME_fk
    foreign key (account_name) references ACCOUNT
      on update cascade on delete cascade
);

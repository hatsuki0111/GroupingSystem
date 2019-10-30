create table selected_option
(
  account_name varchar(32) not null,
  enquete_id bigint not null,
  option_label varchar(64) not null,
  constraint selected_option_ACCOUNT_NAME_fk
    foreign key (account_name) references ACCOUNT
      on update cascade on delete cascade,
  constraint selected_option_ENQUETE_ID_fk
    foreign key (enquete_id) references ENQUETE
      on update cascade on delete cascade
);
create table SELECTED_OPTION
(
    ACCOUNT_NAME VARCHAR(32) not null,
    ENQUETE_ID   BIGINT      not null,
    OPTION_LABEL VARCHAR(64) not null,
    constraint SELECTED_OPTION_ACCOUNT_NAME_FK
        foreign key (ACCOUNT_NAME) references ACCOUNT (NAME)
            on update cascade on delete cascade,
    constraint SELECTED_OPTION_ENQUETE_ID_FK
        foreign key (ENQUETE_ID) references ENQUETE (ID)
            on update cascade on delete cascade
);


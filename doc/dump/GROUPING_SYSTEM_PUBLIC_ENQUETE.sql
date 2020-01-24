create table ENQUETE
(
    ID                  BIGINT auto_increment,
    TITLE               VARCHAR(128) not null,
    AUTHOR_ACCOUNT_NAME VARCHAR(32)  not null,
    START_DATE_TIME     TIMESTAMP    not null,
    END_DATE_TIME       TIMESTAMP    not null,
    POSTED_DATE_TIME    TIMESTAMP    not null,
    constraint ENQUETE_PK
        primary key (ID),
    constraint ENQUETE_ACCOUNT_NAME_FK
        foreign key (AUTHOR_ACCOUNT_NAME) references ACCOUNT (NAME)
            on update cascade
);

INSERT INTO PUBLIC.ENQUETE (ID, TITLE, AUTHOR_ACCOUNT_NAME, START_DATE_TIME, END_DATE_TIME, POSTED_DATE_TIME) VALUES (33, 'ENQUETE1', 'admin', '2020-01-24 20:04:00.000000000', '2021-01-24 20:04:00.000000000', '2020-01-24 20:04:40.860833500');
create table RESPONDENT
(
    ENQUETE_ID   BIGINT      not null,
    ACCOUNT_NAME VARCHAR(32) not null,
    constraint RESPONDENT_ACCOUNT_NAME_FK
        foreign key (ACCOUNT_NAME) references ACCOUNT (NAME)
            on update cascade on delete cascade,
    constraint RESPONDENT_ENQUETE_ID_FK
        foreign key (ENQUETE_ID) references ENQUETE (ID)
            on update cascade on delete cascade
);

INSERT INTO PUBLIC.RESPONDENT (ENQUETE_ID, ACCOUNT_NAME) VALUES (33, 'admin');
INSERT INTO PUBLIC.RESPONDENT (ENQUETE_ID, ACCOUNT_NAME) VALUES (33, 'b2170001');
INSERT INTO PUBLIC.RESPONDENT (ENQUETE_ID, ACCOUNT_NAME) VALUES (33, 'b2170002');
INSERT INTO PUBLIC.RESPONDENT (ENQUETE_ID, ACCOUNT_NAME) VALUES (33, 'b2170003');
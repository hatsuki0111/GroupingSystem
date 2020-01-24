create table OPTION
(
    ENQUETE_ID BIGINT      not null,
    LABEL      VARCHAR(64) not null,
    AUTHORIZED BOOLEAN     not null,
    constraint OPTION_ENQUETE_ID_FK
        foreign key (ENQUETE_ID) references ENQUETE (ID)
            on update cascade on delete cascade
);

INSERT INTO PUBLIC.OPTION (ENQUETE_ID, LABEL, AUTHORIZED) VALUES (33, 'E1G1', true);
INSERT INTO PUBLIC.OPTION (ENQUETE_ID, LABEL, AUTHORIZED) VALUES (33, 'E1G2', true);
INSERT INTO PUBLIC.OPTION (ENQUETE_ID, LABEL, AUTHORIZED) VALUES (33, 'E1G3', true);
INSERT INTO PUBLIC.OPTION (ENQUETE_ID, LABEL, AUTHORIZED) VALUES (33, 'E1G4', true);
INSERT INTO PUBLIC.OPTION (ENQUETE_ID, LABEL, AUTHORIZED) VALUES (33, 'E1G5', true);
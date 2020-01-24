create table EVALUATION
(
    ID             BIGINT auto_increment,
    ENQUETE_ID     BIGINT      not null,
    EVALUATOR_NAME VARCHAR(32) not null,
    EVALUATEE_NAME VARCHAR(32) not null,
    constraint EVALUATION_ENQUETE_ID_FK
        foreign key (ENQUETE_ID) references ENQUETE (ID)
            on update cascade,
    constraint EVALUATION_EVALUATEE_ACCOUNT_NAME_FK
        foreign key (EVALUATEE_NAME) references ACCOUNT (NAME)
            on update cascade,
    constraint EVALUATION_EVALUATOR_ACCOUNT_NAME_FK
        foreign key (EVALUATOR_NAME) references ACCOUNT (NAME)
            on update cascade
);

create unique index EVALUATION_ID_UINDEX
    on EVALUATION (ID);

alter table EVALUATION
    add constraint EVALUATION_PK
        primary key (ID);

INSERT INTO PUBLIC.EVALUATION (ID, ENQUETE_ID, EVALUATOR_NAME, EVALUATEE_NAME) VALUES (8, 33, 'admin', 'b2170001');
INSERT INTO PUBLIC.EVALUATION (ID, ENQUETE_ID, EVALUATOR_NAME, EVALUATEE_NAME) VALUES (9, 33, 'b2170002', 'b2170001');
create table ENQUETE_EVALUATION_ITEM
(
    ENQUETE_ID         BIGINT not null,
    EVALUATION_ITEM_ID BIGINT not null,
    constraint ENQUETE_EVALUATION_ITEM_ENQUETE_ID_FK
        foreign key (ENQUETE_ID) references ENQUETE (ID)
            on update cascade,
    constraint ENQUETE_EVALUATION_ITEM_EVALUATION_ITEM_ID_FK
        foreign key (EVALUATION_ITEM_ID) references EVALUATION_ITEM (ID)
            on update cascade
);


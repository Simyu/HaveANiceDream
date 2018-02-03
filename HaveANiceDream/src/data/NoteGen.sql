CREATE TABLE Note
(
    note_no          NUMBER               NOT NULL, 
    note_sender      VARCHAR2(20)      NULL, 
    note_receiver    VARCHAR2(20)      NULL, 
    note_date        DATE              NULL, 
    note_content     VARCHAR2(1000)    NULL, 
    note_state       CHAR(1)           NULL, 
    CONSTRAINT NOTE_PK PRIMARY KEY (note_no)
)


CREATE SEQUENCE Note_SEQ
START WITH 1
INCREMENT BY 1;


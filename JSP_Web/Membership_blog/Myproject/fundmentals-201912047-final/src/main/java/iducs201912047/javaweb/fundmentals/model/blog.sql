create sequence seq_bl201912047 increment by 1 start with 1;


create  table bl201912047
(
    id number(11) not null primary key,
    title varchar2(100) not null,
    content varchar2(100),
    regdate varchar2(30),
    author   varchar2(30) not null,
    email varchar2(30) not null

);


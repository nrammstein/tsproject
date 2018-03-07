-- нулевой этап - создаем пользователя
-- USER SQL
CREATE USER BASE1 IDENTIFIED BY "123456"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS

-- ROLES

-- SYSTEM PRIVILEGES
GRANT CREATE ROLE TO BASE1 ;
GRANT CREATE TRIGGER TO BASE1 ;
GRANT ALTER SESSION TO BASE1 ;
GRANT CREATE MATERIALIZED VIEW TO BASE1 ;
GRANT CREATE VIEW TO BASE1 ;
GRANT CREATE SESSION TO BASE1 ;
GRANT CREATE TABLE TO BASE1 ;
GRANT CREATE TYPE TO BASE1 ;
GRANT CREATE PUBLIC SYNONYM TO BASE1 ;
GRANT CREATE SYNONYM TO BASE1 ;
GRANT CREATE SEQUENCE TO BASE1 ;
GRANT CREATE DATABASE LINK TO BASE1 ;
GRANT UNLIMITED TABLESPACE TO BASE1 ;
GRANT CREATE PROCEDURE TO BASE1 ;

-- первый этап - создание таблиц, последовательностей и триггеров (для автогенерации ID)
CREATE TABLE CERTIFICATES (
    ID              NUMBER NOT NULL,
    EMPLOYEE_ID     NUMBER NOT NULL,
    "DATE"          DATE,
    COMPANY         VARCHAR2(100),
    NAME            VARCHAR2(100),
    "NUMBER"        NUMBER NOT NULL,
    SCAN            BLOB
);

CREATE TABLE DEPARTMENTS (
    ID            NUMBER NOT NULL,
    PARENT_ID     NUMBER,
    NAME          VARCHAR2(30) NOT NULL,
    HEAD          NUMBER NOT NULL
);

CREATE TABLE EMPLOYEES (
    ID              NUMBER NOT NULL,
    "UID"             NUMBER NOT NULL,
    FIRST_NAME      VARCHAR2(100) NOT NULL,
    SECOND_NAME     VARCHAR2(100) NOT NULL,
    THIRD_NAME      VARCHAR2(100),
    SEX             VARCHAR2(1) NOT NULL,
    BIRTH_DATE      DATE NOT NULL,
    DEPARTMENT_ID   NUMBER NOT NULL,
    POSITION_ID     NUMBER NOT NULL,
    GRADE_ID        NUMBER NOT NULL,
    SALARY          NUMBER,
    FROM_DATE       DATE NOT NULL,
    TO_DATE         DATE
);

CREATE TABLE GRADES (
    ID     NUMBER NOT NULL,
    NAME   VARCHAR2(10) NOT NULL
);

CREATE TABLE POSITIONS (
    ID     NUMBER NOT NULL,
    NAME   VARCHAR2(50) NOT NULL
);

CREATE SEQUENCE certificates_id_seq START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER certificates_seq_trg BEFORE
    INSERT ON certificates
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := certificates_id_seq.nextval;
END;
/

CREATE SEQUENCE departments_id_seq START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER departments_seq_trg BEFORE
    INSERT ON departments
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := departments_id_seq.nextval;
END;
/

CREATE SEQUENCE employees_id_seq START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER employees_seq_trg BEFORE
    INSERT ON employees
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := employees_id_seq.nextval;
END;
/

CREATE SEQUENCE grades_id_seq START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER grades_seq_trg BEFORE
    INSERT ON grades
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := grades_id_seq.nextval;
END;
/

CREATE SEQUENCE positions_id_seq START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER positions_seq_trg BEFORE
    INSERT ON positions
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := positions_id_seq.nextval;
END;
/

-- второй этап - выполнить INSERT-ы из db_fill.sql


-- третий этап - применить CONSTRAINT-ы
ALTER TABLE certificates ADD CONSTRAINT certificates_pk PRIMARY KEY ( id );
ALTER TABLE departments ADD CONSTRAINT deaprtments_pk PRIMARY KEY ( id );
ALTER TABLE departments ADD CONSTRAINT deaprtments_name_un UNIQUE ( name );
ALTER TABLE employees ADD CONSTRAINT employees_pk PRIMARY KEY ( id );
ALTER TABLE grades ADD CONSTRAINT grades_pk PRIMARY KEY ( id );
ALTER TABLE grades ADD CONSTRAINT grades_name_un UNIQUE ( name );
ALTER TABLE positions ADD CONSTRAINT positions_pk PRIMARY KEY ( id );
ALTER TABLE positions ADD CONSTRAINT positions_name_un UNIQUE ( name );

ALTER TABLE certificates
    ADD CONSTRAINT certificates_employees_fk FOREIGN KEY ( EMPLOYEE_ID )
        REFERENCES employees ( id );

ALTER TABLE departments
    ADD CONSTRAINT deaprtments_deaprtments_fk FOREIGN KEY ( PARENT_ID )
        REFERENCES departments ( id );

ALTER TABLE departments
    ADD CONSTRAINT deaprtments_employees_fk FOREIGN KEY ( HEAD )
        REFERENCES employees ( id );

ALTER TABLE employees
    ADD CONSTRAINT employees_deaprtments_fk FOREIGN KEY ( DEPARTMENT_ID )
        REFERENCES departments ( id );

ALTER TABLE employees
    ADD CONSTRAINT employees_grades_fk FOREIGN KEY ( GRADE_ID )
        REFERENCES grades ( id );

ALTER TABLE employees
    ADD CONSTRAINT employees_positions_fk FOREIGN KEY ( POSITION_ID )
        REFERENCES positions ( id );

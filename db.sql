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
CREATE TABLE certificates (
    id              NUMBER NOT NULL,
    "Employee Id"   NUMBER NOT NULL,
    "Date"          DATE,
    company         VARCHAR2(100),
    name            VARCHAR2(100),
    "Number"        NUMBER NOT NULL,
    scan            BLOB
);

CREATE TABLE departments (
    id            NUMBER NOT NULL,
    "Parent Id"   NUMBER,
    name          VARCHAR2(30) NOT NULL,
    head          NUMBER
);

CREATE TABLE employees (
    id              NUMBER NOT NULL,
    "UID"           NUMBER NOT NULL,
    "First Name"    VARCHAR2(100) NOT NULL,
    "Second Name"   VARCHAR2(100) NOT NULL,
    "Third Name"    VARCHAR2(100),
    sex             VARCHAR2(3),
    "Birth Date"    DATE NOT NULL,
    "Dpt Id"        NUMBER,
    "Position Id"   NUMBER,
    "Grade Id"      NUMBER,
    salary          NUMBER,
    "From Date"     DATE NOT NULL,
    "To Date"       DATE
);

CREATE TABLE grades (
    id     NUMBER NOT NULL,
    name   VARCHAR2(10) NOT NULL
);

CREATE TABLE positions (
    id     NUMBER NOT NULL,
    name   VARCHAR2(50) NOT NULL
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
    ADD CONSTRAINT certificates_employees_fk FOREIGN KEY ( "Employee Id" )
        REFERENCES employees ( id );

ALTER TABLE departments
    ADD CONSTRAINT deaprtments_deaprtments_fk FOREIGN KEY ( "Parent Id" )
        REFERENCES departments ( id );

ALTER TABLE departments
    ADD CONSTRAINT deaprtments_employees_fk FOREIGN KEY ( head )
        REFERENCES employees ( id );

ALTER TABLE employees
    ADD CONSTRAINT employees_deaprtments_fk FOREIGN KEY ( "Dpt Id" )
        REFERENCES departments ( id );

ALTER TABLE employees
    ADD CONSTRAINT employees_grades_fk FOREIGN KEY ( "Grade Id" )
        REFERENCES grades ( id );

ALTER TABLE employees
    ADD CONSTRAINT employees_positions_fk FOREIGN KEY ( "Position Id" )
        REFERENCES positions ( id );

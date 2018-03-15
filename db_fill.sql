-- второй этап - выполнить INSERT-ы
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'CEO');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'CTO');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'Java Developer');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'Quality Engineer');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'Business Analyst');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'System Analyst');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'System Administrator');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'Database Administrator');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'Janitor');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'HR staff');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'Head of Department');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'Lawyer');
INSERT INTO POSITIONS (ID,NAME) VALUES (positions_id_seq.nextval,'System Architect');

INSERT INTO GRADES (ID,NAME) VALUES (grades_id_seq.nextval,'Trainee');
INSERT INTO GRADES (ID,NAME) VALUES (grades_id_seq.nextval,'Junior');
INSERT INTO GRADES (ID,NAME) VALUES (grades_id_seq.nextval,'Middle');
INSERT INTO GRADES (ID,NAME) VALUES (grades_id_seq.nextval,'Senior');
INSERT INTO GRADES (ID,NAME) VALUES (grades_id_seq.nextval,'Chief');

INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, NULL, 'HR', 1);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, 1, 'Employee Relations', 2);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, 1, 'Personnel Management', 3);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, NULL, 'Sales', 4);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, 4, 'Market Research', 5);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, 4, 'Marketing', 6);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, NULL, 'Accounting', 7);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, 7, 'Accounts and Wages', 8);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, 7, 'Creditors and Debtors', 9);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, NULL, 'IT', 10);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, 10, 'Development', 11);
INSERT INTO DEPARTMENTS (ID, PARENT_ID, NAME, HEAD) VALUES (departments_id_seq.nextval, 10, 'QA', 12);

INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 1, 'Bill', 'Johns', 'M', TO_DATE('09/12/1980', 'MM/DD/YYYY'), 1, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 2, 'John', 'Doe', 'M', TO_DATE('03/11/1970', 'MM/DD/YYYY'), 2, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 3, 'Marta', 'Grey', 'F', TO_DATE('05/27/1981', 'MM/DD/YYYY'), 3, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 4, 'Will', 'Smith', 'M', TO_DATE('01/08/1977', 'MM/DD/YYYY'), 4, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 5, 'Frank', 'Freeman', 'M', TO_DATE('02/14/1983', 'MM/DD/YYYY'), 5, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 6, 'Maggie', 'Phillipson', 'F', TO_DATE('07/25/1979', 'MM/DD/YYYY'), 6, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 7, 'Bart', 'Simpson', 'M', TO_DATE('02/15/1970', 'MM/DD/YYYY'), 7, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 8, 'Chandler', 'Trump', 'M', TO_DATE('03/17/1990', 'MM/DD/YYYY'), 8, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 9, 'George', 'Bush', 'M', TO_DATE('10/01/1978', 'MM/DD/YYYY'), 9, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 10, 'Stew', 'Capito', 'M', TO_DATE('04/20/1988', 'MM/DD/YYYY'), 10, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 11, 'Helen', 'Thompson', 'F', TO_DATE('06/22/1976', 'MM/DD/YYYY'), 11, 11, 3, 12345, SYSDATE);
INSERT INTO EMPLOYEES (ID, "UID", FIRST_NAME, SECOND_NAME, SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE)
VALUES (employees_id_seq.nextval, 12, 'Alexandra', 'McGregor', 'F', TO_DATE('07/29/1971', 'MM/DD/YYYY'), 12, 11, 3, 12345, SYSDATE);

INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/2000', 'MM/DD/YYYY'), 'Certificate Company 1', 'Certificate 1', 1);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/1990', 'MM/DD/YYYY'), 'Certificate Company 2', 'Certificate 2', 2);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/2001', 'MM/DD/YYYY'), 'Certificate Company 3', 'Certificate 3', 3);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/1997', 'MM/DD/YYYY'), 'Certificate Company 4', 'Certificate 4', 4);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/2003', 'MM/DD/YYYY'), 'Certificate Company 5', 'Certificate 5', 5);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/1999', 'MM/DD/YYYY'), 'Certificate Company 6', 'Certificate 6', 6);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/1990', 'MM/DD/YYYY'), 'Certificate Company 7', 'Certificate 7', 7);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/2010', 'MM/DD/YYYY'), 'Certificate Company 8', 'Certificate 8', 8);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/1998', 'MM/DD/YYYY'), 'Certificate Company 9', 'Certificate 9', 9);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/2008', 'MM/DD/YYYY'), 'Certificate Company 10', 'Certificate 10', 10);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/1996', 'MM/DD/YYYY'), 'Certificate Company 11', 'Certificate 11', 11);
INSERT INTO CERTIFICATES (ID, EMPLOYEE_ID, RECEIVING_DATE, COMPANY, NAME, NUMBER_CER) VALUES (certificates_id_seq.nextval, 1, TO_DATE('01/01/1991', 'MM/DD/YYYY'), 'Certificate Company 12', 'Certificate 12', 12);

IF NOT EXISTS (SELECT *
               FROM INFORMATION_SCHEMA.TABLES
               WHERE TABLE_NAME = N'ST_STUDENT')
    BEGIN
        CREATE TABLE ST_STUDENT
        (
            STST_ID              BIGINT IDENTITY (1,1) PRIMARY KEY,
            STST_NAME            VARCHAR(255) NOT NULL,
            STST_EMAIL           VARCHAR(255) NOT NULL UNIQUE,
            STST_PASSWORD        VARCHAR(255) NOT NULL,
            STST_DOB             Date         NOT NULL,
            STST_ENROLLMENT_DATE DateTime,
            CREATED_AT           Date         NOT NULL DEFAULT GETDATE(),
            CREATED_BY           VARCHAR(255),
            MODIFIED_AT          Date,
            MODIFIED_BY          VARCHAR(255)
        );
    END

IF NOT EXISTS (SELECT *
               FROM INFORMATION_SCHEMA.TABLES
               WHERE TABLE_NAME = N'ST_UNIVERSITY')
    BEGIN
        CREATE TABLE ST_UNIVERSITY
        (
            STUN_ID     BIGINT IDENTITY (1,1) PRIMARY KEY,
            STUN_NAME   VARCHAR(255) NOT NULL UNIQUE,
            STUN_CITY   VARCHAR(255) NOT NULL,
            CREATED_AT  Date         NOT NULL DEFAULT GETDATE(),
            CREATED_BY  VARCHAR(255),
            MODIFIED_AT Date,
            MODIFIED_BY VARCHAR(255)
        );
    END

IF NOT EXISTS (SELECT *
               FROM INFORMATION_SCHEMA.TABLES
               WHERE TABLE_NAME = N'ST_COURSE')
    BEGIN
        CREATE TABLE ST_COURSE
        (
            STCO_ID     BIGINT IDENTITY (1,1) PRIMARY KEY,
            STCO_NAME   VARCHAR(255) NOT NULL,
            STUN_ID     BIGINT       NOT NULL,
            FOREIGN KEY (STUN_ID) REFERENCES ST_UNIVERSITY (STUN_ID),
            CREATED_AT  Date         NOT NULL DEFAULT GETDATE(),
            CREATED_BY  VARCHAR(255),
            MODIFIED_AT Date,
            MODIFIED_BY VARCHAR(255)
        );
    END

IF NOT EXISTS (SELECT *
               FROM INFORMATION_SCHEMA.TABLES
               WHERE TABLE_NAME = N'ST_APPLICATION')
    BEGIN
        CREATE TABLE ST_APPLICATION
        (
            STAP_ID               BIGINT IDENTITY (1,1) PRIMARY KEY,
            STAP_NAME             VARCHAR(255) NOT NULL,
            STST_ID               BIGINT       NOT NULL,
            STCO_ID               BIGINT       NOT NULL,
            STAP_APPLICATION_DATE DATE         NOT NULL DEFAULT GETDATE(),
            FOREIGN KEY (STST_ID) REFERENCES ST_STUDENT (STST_ID),
            FOREIGN KEY (STCO_ID) REFERENCES ST_COURSE (STCO_ID),
            CREATED_AT            Date         NOT NULL DEFAULT GETDATE(),
            CREATED_BY            VARCHAR(255),
            MODIFIED_AT           Date,
            MODIFIED_BY           VARCHAR(255)
        );
    END

IF NOT EXISTS (SELECT *
               FROM ST_UNIVERSITY
               WHERE STUN_NAME = 'KU')
    BEGIN
        INSERT INTO ST_UNIVERSITY (STUN_NAME, STUN_CITY)
        VALUES ('KU', 'KHI');
    END
IF NOT EXISTS (SELECT *
               FROM ST_UNIVERSITY
               WHERE STUN_NAME = 'IU')
    BEGIN
        INSERT INTO ST_UNIVERSITY (STUN_NAME, STUN_CITY)
        VALUES ('IU', 'KHI');
    END
IF NOT EXISTS (SELECT *
               FROM ST_UNIVERSITY
               WHERE STUN_NAME = 'FAST')
    BEGIN
        INSERT INTO ST_UNIVERSITY (STUN_NAME, STUN_CITY)
        VALUES ('FAST', 'ISL');
    END

IF NOT EXISTS (SELECT *
               FROM ST_COURSE
               WHERE STCO_NAME = 'Math'
                 AND STCO_ID = '1')
    BEGIN
        INSERT INTO ST_COURSE (STCO_NAME, STUN_ID)
        VALUES ('Math', '1');
    END
IF NOT EXISTS (SELECT *
               FROM ST_COURSE
               WHERE STCO_NAME = 'Math'
                 AND STCO_ID = '2')
    BEGIN
        INSERT INTO ST_COURSE (STCO_NAME, STUN_ID)
        VALUES ('Math', '2');
    END
IF NOT EXISTS (SELECT *
               FROM ST_COURSE
               WHERE STCO_NAME = 'Computer Science'
                 AND STCO_ID = '2')
    BEGIN
        INSERT INTO ST_COURSE (STCO_NAME, STUN_ID)
        VALUES ('Computer Science', '2');
    END
IF NOT EXISTS (SELECT *
               FROM ST_COURSE
               WHERE STCO_NAME = 'Software Eng'
                 AND STCO_ID = '3')
    BEGIN
        INSERT INTO ST_COURSE (STCO_NAME, STUN_ID)
        VALUES ('Software Eng', '3');
    END
IF NOT EXISTS (SELECT *
               FROM ST_COURSE
               WHERE STCO_NAME = 'Software Eng'
                 AND STCO_ID = '1')
    BEGIN
        INSERT INTO ST_COURSE (STCO_NAME, STUN_ID)
        VALUES ('Software Eng', '1');
    END
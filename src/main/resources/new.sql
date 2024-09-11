CREATE TABLE ST_STUDENT (
                         STST_ID BIGINT IDENTITY(1,1) PRIMARY KEY,
                         STST_NAME VARCHAR(255) NOT NULL,
                         STST_EMAIL VARCHAR(255) NOT NULL UNIQUE,
                         STST_PASSWORD VARCHAR(255) NOT NULL,
                         STST_DOB Date NOT NULL,
                         STST_ENROLLMENT_DATE Date,
                         CREATED_AT Date NOT NULL DEFAULT GETDATE(),
                         CREATED_BY VARCHAR(255),
                         MODIFIED_AT Date,
                         MODIFIED_BY VARCHAR(255)
);

CREATE TABLE ST_UNIVERSITY (
                               STUN_ID BIGINT IDENTITY(1,1) PRIMARY KEY,
                               STUN_NAME VARCHAR(255) NOT NULL UNIQUE,
                               STUN_CITY VARCHAR(255) NOT NULL,
                               CREATED_AT Date NOT NULL DEFAULT GETDATE(),
                               CREATED_BY VARCHAR(255),
                               MODIFIED_AT Date,
                               MODIFIED_BY VARCHAR(255)
);

CREATE TABLE ST_COURSE (
                           STCO_ID BIGINT IDENTITY(1,1) PRIMARY KEY,
                           STCO_NAME VARCHAR(255) NOT NULL,
                           STUN_ID BIGINT NOT NULL,
                           FOREIGN KEY (STUN_ID) REFERENCES ST_UNIVERSITY(STUN_ID),
                           CREATED_AT Date NOT NULL DEFAULT GETDATE(),
                           CREATED_BY VARCHAR(255),
                           MODIFIED_AT Date,
                           MODIFIED_BY VARCHAR(255)
);

CREATE TABLE ST_APPLICATION (
                                STAP_ID BIGINT IDENTITY(1,1) PRIMARY KEY,
                                STAP_NAME VARCHAR(255) NOT NULL,
                                STST_ID BIGINT NOT NULL,
                                STUN_ID BIGINT NOT NULL,
                                STCO_ID BIGINT NOT NULL,
                                STAP_APPLICATION_DATE DATE NOT NULL DEFAULT GETDATE(),
                                FOREIGN KEY (STST_ID) REFERENCES ST_STUDENT(STST_ID),
                                FOREIGN KEY (STUN_ID) REFERENCES ST_UNIVERSITY(STUN_ID),
                                FOREIGN KEY (STCO_ID) REFERENCES ST_COURSE(STCO_ID),
                                CREATED_AT Date NOT NULL DEFAULT GETDATE(),
                                CREATED_BY VARCHAR(255),
                                MODIFIED_AT Date,
                                MODIFIED_BY VARCHAR(255)
);
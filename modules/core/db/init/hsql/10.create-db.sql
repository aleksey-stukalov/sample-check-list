-- begin SAMPLECHECKLIST_OPTIONS_GROUP
create table SAMPLECHECKLIST_OPTIONS_GROUP (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION longvarchar,
    --
    primary key (ID)
)^
-- end SAMPLECHECKLIST_OPTIONS_GROUP
-- begin SAMPLECHECKLIST_OPTION
create table SAMPLECHECKLIST_OPTION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GROUP_ID varchar(36) not null,
    VALUE_ varchar(255) not null,
    DESCRIPTION longvarchar,
    --
    primary key (ID)
)^
-- end SAMPLECHECKLIST_OPTION
-- begin SAMPLECHECKLIST_CHECKS_GROUP
create table SAMPLECHECKLIST_CHECKS_GROUP (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION longvarchar,
    --
    primary key (ID)
)^
-- end SAMPLECHECKLIST_CHECKS_GROUP
-- begin SAMPLECHECKLIST_CHECK
create table SAMPLECHECKLIST_CHECK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION longvarchar,
    GROUP_ID varchar(36) not null,
    OPTIONS_GROUP_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end SAMPLECHECKLIST_CHECK
-- begin SAMPLECHECKLIST_LOAN_APPLICATION
create table SAMPLECHECKLIST_LOAN_APPLICATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    APPLICANT_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end SAMPLECHECKLIST_LOAN_APPLICATION
-- begin SAMPLECHECKLIST_CHECK_ITEM
create table SAMPLECHECKLIST_CHECK_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CHECK_ID varchar(36) not null,
    OPTION_ID varchar(36) not null,
    LOAN_APPLICATION_ID varchar(36),
    --
    primary key (ID)
)^
-- end SAMPLECHECKLIST_CHECK_ITEM

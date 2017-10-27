alter table SAMPLECHECKLIST_CHECK add column MANDATORY boolean ^
update SAMPLECHECKLIST_CHECK set MANDATORY = false where MANDATORY is null ;
alter table SAMPLECHECKLIST_CHECK alter column MANDATORY set not null ;

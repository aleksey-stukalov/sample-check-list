update SAMPLECHECKLIST_LOAN_APPLICATION set NUMBER_ = '' where NUMBER_ is null ;
alter table SAMPLECHECKLIST_LOAN_APPLICATION alter column NUMBER_ set not null ;

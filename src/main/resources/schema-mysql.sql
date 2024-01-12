create table db_test1.assignment (id bigint not null auto_increment, end_time date, start_time date, technician_id integer, primary key (id));

create table db_test1.technician (id bigint not null auto_increment, email varchar(255), first_name varchar(255), last_name varchar(255), technician_id bigint, primary key (id));
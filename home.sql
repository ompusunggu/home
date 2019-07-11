create database home
	with owner postgres;

create table if not exists personalities
(
	id varchar(100) not null
		constraint personalities_pk
			primary key,
	name varchar(100)
);

alter table personalities owner to postgres;

create table if not exists users
(
	id varchar(100) not null
		constraint users_pk
			primary key,
	email varchar(100),
	personality_id varchar(100)
		constraint users_personalities_id_fk
			references personalities
				on update cascade on delete cascade,
	name varchar(100)
);

alter table users owner to postgres;

create table if not exists modules
(
	id varchar(100) not null
		constraint modules_pk
			primary key,
	name varchar(100)
);

alter table modules owner to postgres;

create table if not exists personality_groups
(
	id varchar(100) not null
		constraint personality_groups_pk
			primary key,
	personality_id varchar(100)
		constraint personality_groups_personalities_id_fk
			references personalities
				on update cascade on delete cascade,
	module_id varchar(100)
		constraint personality_groups_modules_id_fk
			references modules
				on update cascade on delete cascade
);

alter table personality_groups owner to postgres;

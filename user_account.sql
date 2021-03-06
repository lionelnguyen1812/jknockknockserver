use master
go

drop database chicklingslove
go

create database chicklingslove
go

use chicklingslove
go

create table user_account (
	[user_id] int identity not null,
	[user_name] varchar(40) not null,
	[password] varchar(40) not null,
	name_first varchar(40) not null,
	name_last varchar(40) not null,
	gender char not null,
	email varchar(100) not null,
	avatar varchar(250) not null default 'avatars/default.jpg',
	active bit not null default 1,
	[online] int not null default 1,
	time_stamp datetime not null default CURRENT_TIMESTAMP,
	primary key ([user_id])
	)
go

alter table user_account add constraint unique_user_account_username unique ([user_name])
go

insert into user_account (
	[user_name],
	password,
	name_first,
	name_last,
	gender,
	email
	)
values (
	'anhntv',
	'70FB874A43097A25234382390C0BAEB3',
	'ntv',
	'anh',
	'F',
	'abc@xyz.now'
	)
go

insert into user_account (
	[user_name],
	password,
	name_first,
	name_last,
	gender,
	email
	)
values (
	'hunglm',
	'70FB874A43097A25234382390C0BAEB3',
	'hung',
	'lm',
	'M',
	'abc@xyz.no'
	)
go

--test
select *
from user_account
go

--@final
create procedure [login] @uname varchar(40),
	@pwd varchar(40),
	@user_id int out
as
begin
	declare @id int;

	set @id = - 1;

	select @id = ua.[user_id]
	from user_account ua
	where [user_name] = 'anhnt'
		and [password] = '70FB874A43097A25234382390C0BAEB3';

	set @user_id = @id;
end
go

--@final
create procedure insert_user_account @user_name varchar(40),
	@encripted_password varchar(40),
	@name_first varchar(40),
	@name_last varchar(40),
	@gender char,
	@email varchar(100),
	@id int out
as
begin
	set nocount on;

	insert into user_account (
		[user_name],
		password,
		name_first,
		name_last,
		gender,
		email
		)
	values (
		@user_name,
		@encripted_password,
		@name_first,
		@name_last,
		@gender,
		@email
		);

	set @id = SCOPE_IDENTITY();
end
go

--@final
create procedure update_user_account @id int,
	@user_name varchar(40),
	@encripted_password varchar(40),
	@name_first varchar(40),
	@name_last varchar(40),
	@gender char,
	@email varchar(100)
as
begin
	update user_account
	set [user_name] = @user_name,
		[password] = @encripted_password,
		name_first = @name_first,
		name_last = @name_last,
		gender = @gender,
		email = @email
	where @id = [user_id];
end
go

create procedure deactive_account @user_id int
as
begin
	update user_account
	set active = 0
	where [user_id] = @user_id;
end
go

create procedure active_account @user_id int
as
begin
	update user_account
	set active = 1
	where [user_id] = @user_id;
end
go



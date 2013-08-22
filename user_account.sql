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
create procedure login @uname varchar(40),
	@pwd varchar(40),
	@commit bit out
as
begin
	if exists (
			select *
			from user_account
			where @uname = [user_name]
				and @pwd = password
			)
		set @commit = 1;
	else
		set @commit = 0;
end
go

--@final
create procedure INSERT_USER_ACCOUNT @user_name varchar(40),
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
create procedure UPDATE_USER_ACCOUNT @id int,
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

-------------------------------------------------------------
create table friendships (
	friendship_id int identity primary key,
	[user_id] int,
	friend_id int,
	accepted bit default 0,
	constraint fk_friendships_user foreign key ([user_id]) references user_account([user_id]),
	constraint unique_friendship_pair unique (
		[user_id],
		friend_id
		)
	)
go

create procedure get_all_friends @id int
as
begin
	select fs.friend_id,
		fs.accepted
	from friendships fs
	where fs.[user_id] = @id
end
go

create procedure add_friend @id int,
	@friend_id int,
	@friendship_id int out
as
begin
	insert into friendships (
		[user_id],
		friend_id
		)
	values (
		@id,
		@friend_id
		);

	set @friendship_id = SCOPE_IDENTITY();
end
go

create procedure unfriend @user_id int,
	@friend_id int,
	@success bit out
as
begin
	begin try
		delete friendships
		where [user_id] = @user_id
			and friend_id = @friend_id;

		set @success = 1;
	end try

	begin catch
		set @success = 0;
	end catch
end
go


----------------------------------------------------------------


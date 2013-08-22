use chicklingslove
go

create table Posts (
	post_id int primary key identity not null,
	user_id int foreign key references user_account(user_id),
	[text] nvarchar(1000),
	link nvarchar(100),
	[type] nvarchar(20),
	time_stamp datetime not null default CURRENT_TIMESTAMP
	)
go

insert into Posts ([user_id], [text])
values (1, 'day la post thu nhat')
go

create table Comment (
	cmt_id int IDENTITY primary key not null,
	user_id int foreign key references user_account(user_id),
	post_id int foreign key references Posts(post_id),
	content nvarchar(200),
	time_stamp datetime not null default CURRENT_TIMESTAMP
	)
go

create proc add_post @post_id int output,
	@user_id int,
	@text nvarchar(1000),
	@link nvarchar(100),
	@type nvarchar(20)
as
begin
	insert into Posts (
		user_id,
		[text],
		link,
		[type]
		)
	values (
		@user_id,
		@text,
		@link,
		@type
		)

	set @post_id = @@IDENTITY
end
go

create proc remove_post @post_id int
as
begin
	delete
	from Posts
	where post_id = @post_id
end
go

create proc add_comment @cmt_id int out,
	@user_id int,
	@post_id int,
	@content nvarchar(200)
as
begin
	insert into Comment (
		user_id,
		post_id,
		content
		)
	values (
		@user_id,
		@post_id,
		@content
		)

	set @cmt_id = @@IDENTITY
end
go

create proc remove_comment @cmt_id int
as
begin
	delete
	from Comment
	where cmt_id = @cmt_id
end

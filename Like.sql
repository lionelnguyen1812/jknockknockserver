
use chicklingslove
go

create table like_post (
	like_id int identity primary key,
	[user_id] int,
	post_id int,
	time_stamp datetime not null default CURRENT_TIMESTAMP,
	constraint fk_like_post_user foreign key ([user_id]) references user_account([user_id]),
	constraint fk_like_post_post foreign key ([post_id]) references Posts(post_id),
	constraint unique_like_post unique (
		[user_id],
		post_id
		)
	)
go

create table like_comment (
	like_id int identity primary key,
	[user_id] int,
	[cmt_id] int,
	time_stamp datetime not null default CURRENT_TIMESTAMP,
	constraint fk_like_cmt_user foreign key ([user_id]) references user_account([user_id]),
	constraint fk_like_cmt_post foreign key ([cmt_id]) references Comment(cmt_id),
	constraint unique_like_comment unique (
		[user_id],
		cmt_id
		)
	)
go

create proc do_like_post @user_id int,
	@post_id int
as
begin
	insert into like_post (
		[user_id],
		post_id
		)
	values (
		@user_id,
		@post_id
		);
end
go

create proc do_like_comment @user_id int,
	@cmt_id int
as
begin
	insert into like_comment (
		[user_id],
		cmt_id
		)
	values (
		@user_id,
		@cmt_id
		);
end
go

create proc do_unlike_post @user_id int,
	@post_id int
as
begin
	delete like_post
	where [user_id] = @user_id
		and post_id = @post_id
end
go

create proc do_unlike_comment @user_id int,
	@cmt_id int
as
begin
	delete like_comment
	where [user_id] = @user_id
		and cmt_id = @cmt_id
end
go



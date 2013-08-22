use chicklingslove
go

create table like_post (
	like_id int identity primary key,
	[user_id] int,
	post_id int,
	time_stamp datetime not null default CURRENT_TIMESTAMP,
	constraint fk_like_post_user foreign key ([user_id]) references user_account([user_id]),
	constraint fk_like_post_post foreign key ([post_id]) references Posts(post_id)
	)
go

create table like_comment (
	like_id int identity primary key,
	[user_id] int,
	[cmt_id] int,
	time_stamp datetime not null default CURRENT_TIMESTAMP,
	constraint fk_like_cmt_user foreign key ([user_id]) references user_account([user_id]),
	constraint fk_like_cmt_post foreign key ([cmt_id]) references Comment(cmt_id)
	)
go

create proc



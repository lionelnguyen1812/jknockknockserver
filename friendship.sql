use chicklingslove
go

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

drop procedure get_all_friends
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

drop procedure add_friend
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

drop proc unfriend
go

create proc unfriend @user_id int,
	@friend_id int
as
begin
	delete friendships
	where [user_id] = @user_id
		and friend_id = @friend_id;
end
go

drop proc accept_friendship_request
go

create proc accept_friendship_request @user_id int,
	@request_from_id int
as
begin
	update friendships
	set accepted = 1
	where friend_id = @user_id
		and [user_id] = @request_from_id
end
go



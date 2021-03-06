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

create procedure get_all_friends @user_id int
as
begin
	select fs.friend_id,
		ua.[user_name],
		ua.name_first,
		ua.name_last,
		ua.gender,
		ua.email,
		ua.avatar,
		ua.[online],
		fs.accepted
	from friendships fs
	inner join user_account ua
		on fs.friend_id = ua.[user_id]
	where fs.[user_id] = @user_id
end
go

drop procedure add_friend
go

create procedure add_friend @id int,
	@friend_id int
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

drop proc remove_friendship_request
go

create proc remove_friendship_request @user_id int,
	@request_from_id int
as
begin
	delete friendships
	where friend_id = @user_id
		and [user_id] = @request_from_id
end
go



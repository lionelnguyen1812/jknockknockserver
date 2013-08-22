USE master
GO

DROP DATABASE chicklingslove
GO

CREATE DATABASE chicklingslove
GO

USE chicklingslove
GO

CREATE TABLE user_account (
	[user_id] INT identity NOT NULL,
	[user_name] VARCHAR(40) NOT NULL,
	[password] VARCHAR(40) NOT NULL,
	name_first VARCHAR(40) NOT NULL,
	name_last VARCHAR(40) NOT NULL,
	gender CHAR NOT NULL,
	email VARCHAR(100) NOT NULL,
	avatar VARCHAR(250) NOT NULL DEFAULT 'avatars/default.jpg',
	active BIT NOT NULL DEFAULT 1,
	[online] INT NOT NULL DEFAULT 1,
	time_stamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	primary key ([user_id])
	)
GO

INSERT INTO user_account (
	user_name,
	password,
	name_first,
	name_last,
	gender,
	email
	)
VALUES (
	'anhntv',
	'70FB874A43097A25234382390C0BAEB3',
	'ntv',
	'anh',
	'F',
	'abc@xyz.now'
	)
GO

--test
SELECT *
FROM user_account
GO

--@final
CREATE PROC LOGIN @uname VARCHAR(40),
	@pwd VARCHAR(40),
	@commit BIT out
AS
BEGIN
	IF EXISTS (
			SELECT *
			FROM user_account
			WHERE @uname = user_name
				AND @pwd = password
			)
		SET @commit = 1;
	ELSE
		SET @commit = 0;
END
GO

--@final
CREATE PROC INSERT_USER_ACCOUNT @user_name VARCHAR(40),
	@encripted_password VARCHAR(40),
	@name_first VARCHAR(40),
	@name_last VARCHAR(40),
	@gender CHAR,
	@email VARCHAR(100),
	@id INT out
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO user_account (
		user_name,
		password,
		name_first,
		name_last,
		gender,
		email
		)
	VALUES (
		@user_name,
		@encripted_password,
		@name_first,
		@name_last,
		@gender,
		@email
		);

	SELECT @id = SCOPE_IDENTITY();
END
GO

--@final
CREATE PROC UPDATE_USER_ACCOUNT @id INT,
	@user_name VARCHAR(40),
	@encripted_password VARCHAR(40),
	@name_first VARCHAR(40),
	@name_last VARCHAR(40),
	@gender CHAR,
	@email VARCHAR(100),
	@success BIT out
AS
BEGIN
	BEGIN TRY
		UPDATE user_account
		SET user_name = @user_name,
			[password] = @encripted_password,
			name_first = @name_first,
			name_last = @name_last,
			gender = @gender,
			email = @email
		WHERE @id = user_id;

		SET @success = 1;
	END TRY

	BEGIN CATCH
		SET @success = 0;
	END CATCH
END
GO

-------------------------------------------------------------
CREATE TABLE friendslist (
	friends_list_id INT PRIMARY KEY,
	[user_id] INT,
	friendship_id INT,
	constraint fk_friendslist_user FOREIGN KEY ([user_id]) REFERENCES user_account(user_id)
	)
GO

CREATE TABLE friendships (
	friendship_id INT identity PRIMARY KEY,
	friends_list_id INT,
	user_id INT,
	friend_id INT,
	accepted BIT DEFAULT 0,
	constraint fk_friendships_friendslist FOREIGN KEY (friends_list_id) REFERENCES friendslist(friends_list_id),
	constraint fk_friendships_user FOREIGN KEY ([user_id]) REFERENCES user_account([user_id])
	)
GO

ALTER TABLE friendslist ADD CONSTRAINT fk_friendslist_friendship FOREIGN KEY (friendship_id) REFERENCES friendships (friendship_id)
GO

CREATE PROC get_friends_list @id INT
AS
BEGIN
	SELECT fs.friend_id,
		fs.accepted
	FROM friendships fs
	WHERE fs.user_id = @id
END
GO

CREATE PROC add_friend @id INT,
	@friend_id INT,
	@friendship_id INT out
AS
BEGIN
	SELECT @friendship_id = fs.friendship_id
	FROM friendships fs
	WHERE fs.user_id = @id
		AND fs.friend_id = @friend_id
END
GO



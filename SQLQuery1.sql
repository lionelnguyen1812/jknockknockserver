USE master
GO

CREATE DATABASE chicklingslove
GO

USE chicklingslove
GO

CREATE TABLE user_account (
	user_id INT identity NOT NULL,
	user_name VARCHAR(40) NOT NULL,
	password VARCHAR(40) NOT NULL,
	name_first VARCHAR(40) NOT NULL,
	name_last VARCHAR(40) NOT NULL,
	gender CHAR NOT NULL,
	email VARCHAR(100) NOT NULL,
	avatar VARCHAR(250) NOT NULL DEFAULT 'avatars/default.jpg',
	active BIT NOT NULL DEFAULT 1,
	online INT NOT NULL DEFAULT 1,
	time_stamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (user_id)
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

-------------------------------------------------------------
CREATE TABLE friendships (
	friendship_id INT identity PRIMARY KEY,
	user_id INT FOREIGN KEY REFERENCES user_account(user_id),
	friend_id INT FOREIGN KEY REFERENCES user_account(user_id),
	accepted BIT DEFAULT 0
	)

CREATE TABLE friends_list (
	friend_list_id INT identity NOT NULL,
	NAME VARCHAR(40),
	)

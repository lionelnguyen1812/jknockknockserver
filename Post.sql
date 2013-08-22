
USE chicklingslove
GO
CREATE TABLE Posts(
	post_id INT PRIMARY KEY identity NOT NULL,
	user_id INT FOREIGN KEY REFERENCES user_account(user_id),
	[text] NVARCHAR(1000),
	link NVARCHAR(100),
	[type] NVARCHAR(20),
	time_stamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)

GO
CREATE TABLE Comment(
	cmt_id INT IDENTITY PRIMARY KEY NOT NULL,
	user_id INT FOREIGN KEY REFERENCES user_account(user_id),
	post_id INT FOREIGN KEY REFERENCES Posts(post_id),
	content NVARCHAR(200),
	time_stamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)

GO
CREATE PROC add_post
	@post_id INT output,
	@user_id INT,
	@text NVARCHAR(1000),
	@link NVARCHAR(100),
	@type NVARCHAR(20)
AS
BEGIN
	INSERT INTO Posts(user_id,[text],link,[type]) 
	VALUES (@user_id,@text,@link,@type)
	SET @post_id = @@IDENTITY
END


GO
CREATE PROC remove_post
	@post_id int
AS
BEGIN
	DELETE FROM Posts WHERE post_id = @post_id
END

GO
CREATE PROC add_comment
	@cmt_id  INT out,
	@user_id int,
	@post_id int,
	@content NVARCHAR(200)
AS
BEGIN
	INSERT INTO Comment (user_id,post_id,content)
	VALUES (@user_id,@post_id,@content)
	SET @cmt_id = @@IDENTITY
END

GO
CREATE PROC remove_comment
	@cmt_id int
AS
BEGIN
	DELETE FROM Comment 
	WHERE cmt_id = @cmt_id
END	
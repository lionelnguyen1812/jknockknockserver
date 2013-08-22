
USE chicklingslove
go
CREATE TABLE Posts(
	post_id INT PRIMARY KEY identity NOT NULL,
	user_id INT FOREIGN KEY REFERENCES user_account(user_id),
	[text] NVARCHAR(1000),
	link NVARCHAR(100),
	[type] NVARCHAR(20),
	time_stamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)


CREATE TABLE CommentList(
	cmt_id INT PRIMARY KEY NOT NULL,
	user_id INT FOREIGN KEY REFERENCES user_account(user_id),
	content NVARCHAR(50),
)


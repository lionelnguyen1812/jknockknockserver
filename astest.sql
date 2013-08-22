use chicklingslove
go

select * from user_account
select * from Posts
select * from Comment
select * from like_post
select * from like_comment

delete  from like_post
delete  from like_comment

insert into Posts (user_id, text)
values (1, 'day la post thu nhat')
go

insert into Comment([user_id], post_id, content)
values (1, 1, 'the ah')
go
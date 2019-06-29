create table test.user (
     id serial8 primary key not null,
     create_at timestamp without time zone  not null default now(),
     update_at timestamp without time zone  not null default now(),
     name varchar not null,
     age int not null default 0,
     sex int not null default 0,
     email varchar(20)
);
comment on table test.user is '用户表|记录用户的基本信息|浩浩|2019-04-14';
comment on column test.user.id is '用户ID|浩浩|2019-04-14';
comment on column test.user.create_at is '创建时间|浩浩|2019-04-14';
comment on column test.user.update_at is '更新时间|浩浩|2019-04-14';
comment on column test.user.name is '姓名|浩浩|2019-04-14';
comment on column test.user.age is '年龄|浩浩|2019-04-14|默认为0';
comment on column test.user.sex is '性别|浩浩|2019-04-14|男-0，女-1';
comment on column test.user.email is '邮箱|浩浩|2019-04-14';

create table test.task (
     id serial8 primary key not null,
     create_at timestamp without time zone  not null default now(),
     update_at timestamp without time zone  not null default now(),
     task_name varchar(200) not null,
     description varchar(300) not null,
     type int,
     grade varchar(20) not null default 0
);
comment on table test.task is '任务表|记录用户的基本任务信息|浩浩|2019-04-14';
comment on column test.task.id is '任务ID|浩浩|2019-04-14';
comment on column test.task.create_at is '创建时间|浩浩|2019-04-14';
comment on column test.task.update_at is '更新时间|浩浩|2019-04-14';
comment on column test.task.task_name is '任务名|浩浩|2019-04-14';
comment on column test.task.description is '任务描述|浩浩|2019-04-14|默认为0';
comment on column test.task.type is '任务类型|浩浩|2019-04-14|爬山-0，跑步-1，游泳-2，跳高-3';
comment on column test.task.grade is '任务得分|浩浩|2019-04-14|默认得分为0';

alter table test.task alter column grade type integer USING (grade::integer);

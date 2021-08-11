create table goods
(
    goods_Id     varchar(100) not null comment '物品id'
        primary key,
    pic          varchar(200) not null comment '图片',
    descs        varchar(200) not null,
    times        datetime     not null comment '获得时间',
    place        varchar(200) not null comment '获得地点',
    user_Id      varchar(100) not null comment '发布人id',
    release_Time datetime     not null comment '发布时间',
    label        varchar(10)  null comment '标签',
    type_Table   varchar(10)  null comment '种类'
);

create table user
(
    user_Id   varchar(100) not null comment '用户id'
        primary key,
    user_Name varchar(20)  not null comment '用户名',
    password  varchar(20)  not null comment '密码',
    telephone varchar(20)  not null comment '联系电话',
    address   varchar(50)  null comment '地址',
    user_Xh   varchar(20)  null comment '学号',
    sex       varchar(10)  null comment '性别'
);



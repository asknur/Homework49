create table roles_authorities
(
    id int primary key,
    authority_id bigint,
    role_id bigint,
    foreign key (authority_id) references AUTHORITIES(ID) on DELETE cascade,
    foreign key (role_id) references ROLES(ID) on DELETE cascade
);

create table user_roles
(
    id int primary key,
    role_id bigint,
    user_id bigint,
    foreign key (role_id) references ROLES(ID) on DELETE cascade,
    foreign key (user_id) references USERS(ID) on DELETE cascade
);
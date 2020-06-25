
insert into users (name, surname, password, phone_number, email) values ('Admin', 'Admin', '$2a$10$MTQHmq61pABuQ0tMc8FD8OSQwyIW8DKw4yIrum4B8yJvcTb8rDhYS', '062/111-1111', 'admin@gmail.com');
insert into users (name, surname, password, phone_number, email) values ('User', 'User', '$2a$10$rXESfhzPmCmKBFYu/4IP6OjxIeXgpI0JnbHBgpmMLdS9BHKG7PX/a', '064/111-1111', 'user@gmail.com');

insert into user_roles(id,name) values (1, 'ROLE_ADMIN');
insert into user_roles(id,name) values (2, 'ROLE_USER');

insert into users_roles(user_id, role_id) values (1, 1);
insert into users_roles(user_id, role_id) values (1, 2);

insert into users_roles(user_id, role_id) values (2, 2);

insert into permission (id, name) values (1, 'CREATE_CERTIFICATE');
insert into permission (id, name) values (2, 'READ_CERTIFICATE');
insert into permission (id, name) values (3, 'DELETE_CERTIFICATE');
					

insert into authorities_permissions (permission_id, user_roles_id) values (1, 1);
insert into authorities_permissions (permission_id, user_roles_id) values (2, 1);
insert into authorities_permissions (permission_id, user_roles_id) values (3, 1);


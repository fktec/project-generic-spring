-- USER
INSERT INTO app_user (id, username, email, password) VALUES (1, 'test_user', 'test@test.com', '$2a$10$GPN1YObIzSn9vnlQ3aOqhuFc5DiZD.hkH8dewvJXZdOG.L/fDHi7y');

-- ROLES
INSERT INTO role (id, description) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, description) VALUES (2, 'ROLE_MASTER');

-- USER & ROLES
INSERT INTO user_role (id_app_user, id_app_client) VALUES (1, 1);

-- CLIENT
INSERT INTO app_client (id, client_id, client_secret, scope, authorized_grant_types, access_token_validity)	VALUES (1, 'test_client', '$2a$10$FGadFZ/gslXsy6WV5qhpYOTS2lDHrcd.na7YQtcNhh1vLt6q60Om.', 'read,trust', 'password', 60);
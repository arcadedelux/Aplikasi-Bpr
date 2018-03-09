INSERT INTO security.roles (rolename, created_by, created_date) VALUES
  ('Administrator', 'migration', now()),
  ('Operator', 'migration', now());

INSERT INTO security.users (user_id, username, passwd, is_active, created_by, created_date) VALUES
  ('0001', 'admin', 'admin', TRUE, 'migration', now()),
  ('0002', 'dimas', 'dimas', FALSE, 'migration', now());

INSERT INTO security.user_roles (user_id, role_id) VALUES
  ('0001', (SELECT role_id
            FROM security.roles
            WHERE rolename = 'Administrator')),
  ('0001', (SELECT role_id
            FROM security.roles
            WHERE rolename = 'Operator')),
  ('0002', (SELECT role_id
            FROM security.roles
            WHERE rolename = 'Operator'));
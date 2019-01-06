INSERT INTO `roles`(`name`, `is_deletable`, `company_id`) VALUES('Admin', 0, 'DEF');

INSERT INTO `user_roles`(`user_id`, `role_id`) VALUES((SELECT id from users limit 1), (SELECT id from roles limit 1));

INSERT INTO `resources`(`name`, `code`, `company_id`) VALUES('Create Companies', 'COMPANIES', 'DEF');

INSERT INTO `operations`(`name`, `verb`) VALUES ('Read', 'GET');
INSERT INTO `operations`(`name`, `verb`) VALUES ('Create', 'POST');
INSERT INTO `operations`(`name`, `verb`) VALUES ('Update', 'PUT');
INSERT INTO `operations`(`name`, `verb`) VALUES ('Delete', 'DELETE');

INSERT INTO `permissions`(`name`, `resource_id`, `operation_id`, `is_deletable`, `verb`, `link`, `role_id`, `company_id`) VALUES('CREATE_COMPANY', (select id from resources limit 1), (select id from operations where name = 'Create' and verb = 'POST'), 0, 'POST', '/companies', (select id from roles limit 1), 'DEF');

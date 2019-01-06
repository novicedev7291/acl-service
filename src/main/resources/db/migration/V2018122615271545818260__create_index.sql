CREATE INDEX `fk_roles_id_idx` ON `user_roles` (`role_id` ASC);
CREATE INDEX `fk_users_id_idx` ON `user_roles` (`user_id` ASC);

CREATE INDEX `fk_roles_perm_id_idx` ON `permissions` (`role_id`);
CREATE INDEX `fk_resources_id_idx` ON `permissions` (`resource_id`);
CREATE INDEX `fk_operations_id_idx` ON `permissions` (`operation_id`);
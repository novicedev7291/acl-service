INSERT INTO `oauth_client_details` VALUES ('default_client','','P@ssw111rd','read,write','password,authorization_code,refresh_token',NULL,NULL,1800,3600,NULL,'1');

INSERT INTO `companies`(`name`, `code`) VALUES('Default Company', 'DEF');

INSERT INTO `users`(`name`, `user_name`, `email`, `phone`, `country_code`, `password`, `company_id`) VALUES('Admin', 'admin', 'kuldeepyadav7291@gmail.com', '8800337921', '+91', '$2y$12$wiaADbjx0I2wLG7q1/a1d.MUTC488ypSkbuicSbcWBa9UtMnqvEUS', 'DEF');
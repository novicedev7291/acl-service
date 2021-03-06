--
-- Table structure for table `oauth_client_details`
--

DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table structure for table `oauth_client_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(255) NOT NULL,
  `token` BLOB NOT NULL,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table structure for table `oauth_access_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(255) NOT NULL,
  `token` BLOB NOT NULL,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `authentication` BLOB DEFAULT NULL,
  `refresh_token` BLOB DEFAULT NULL,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table structure for table `oauth_refresh_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(255) NOT NULL,
  `token` BLOB NOT NULL,
  `authentication` BLOB DEFAULT NULL,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table structure for table `oauth_code`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(255) DEFAULT NULL,
  `authentication` BLOB DEFAULT NULL
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table structure for table `oauth_approvals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `expiresAt` DATETIME DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `lastModifiedAt` DATETIME DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table `companies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `companies`;
CREATE TABLE IF NOT EXISTS `companies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `code` VARCHAR(20) NOT NULL,
  `description` VARCHAR(250) NULL,
  `active` TINYINT NULL DEFAULT 0,
  `customize_info` VARCHAR(2000) DEFAULT NULL,
  `security_info` VARCHAR(2000) DEFAULT NULL,
  `created_on` DATETIME NULL DEFAULT NULL,
  `created_by` VARCHAR(100) NULL DEFAULT NULL,
  `updated_on` DATETIME NULL DEFAULT NULL,
  `updated_by` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `CODE_UNIQUE` (`code` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `user_name` VARCHAR(100) NULL,
  `email` VARCHAR(200) NOT NULL,
  `phone` VARCHAR(50) NOT NULL,
  `country_code` VARCHAR(5) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `change_password` TINYINT NULL DEFAULT 0,
  `active` TINYINT NULL DEFAULT 1,
  `company_id` VARCHAR(20) NOT NULL,
  `created_on` DATETIME NULL DEFAULT NULL,
  `created_by` VARCHAR(100) NULL DEFAULT NULL,
  `updated_on` DATETIME NULL DEFAULT NULL,
  `updated_by` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `is_deletable` TINYINT NULL DEFAULT 1,
  `created_on` DATETIME NULL DEFAULT NULL,
  `created_by` VARCHAR(100) NULL DEFAULT NULL,
  `updated_on` DATETIME NULL DEFAULT NULL,
  `updated_by` VARCHAR(100) NULL DEFAULT ' NULL',
  `company_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `created_by` VARCHAR(100) NULL DEFAULT NULL,
  `created_on` DATETIME NULL DEFAULT NULL,
  `updated_by` VARCHAR(100) NULL DEFAULT NULL,
  `updated_on` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_roles_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `resource`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE IF NOT EXISTS `resources` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `company_id` VARCHAR(20) NOT NULL,
  `created_on` DATETIME NULL DEFAULT NULL,
  `created_by` VARCHAR(100) NULL DEFAULT NULL,
  `updated_on` DATETIME NULL DEFAULT NULL,
  `updated_by` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `operations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `operations`;
CREATE TABLE IF NOT EXISTS `operations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `verb` VARCHAR(10) NOT NULL,
  `created_on` DATETIME NULL DEFAULT NULL,
  `created_by` VARCHAR(100) NULL DEFAULT NULL,
  `updated_on` DATETIME NULL DEFAULT NULL,
  `updated_by` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `permissions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE IF NOT EXISTS `permissions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `resource_id` INT NOT NULL,
  `operation_id` INT NOT NULL,
  `is_deletable` TINYINT NULL DEFAULT 1,
  `verb` VARCHAR(10) NOT NULL,
  `link` VARCHAR(200) NOT NULL,
  `role_id` INT NOT NULL,
  `created_on` DATETIME NULL DEFAULT NULL,
  `created_by` VARCHAR(100) NULL DEFAULT NULL,
  `updated_on` DATETIME NULL DEFAULT NULL,
  `updated_by` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_perm_UNIQUE` (`name` ASC),
  CONSTRAINT `fk_roles_perm_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resources_id`
    FOREIGN KEY (`resource_id`)
    REFERENCES `resources` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operations_id`
    FOREIGN KEY (`operation_id`)
    REFERENCES `operations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

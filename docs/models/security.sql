USE crazy_dumplings__security;

CREATE TABLE `groups` (
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200),
    description VARCHAR(4000),
    
    PRIMARY KEY (id)
);


CREATE TABLE group_permission_maps (
	id BIGINT NOT NULL AUTO_INCREMENT,
    group_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    
    PRIMARY KEY (id)
);


CREATE TABLE `permissions` (
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200),
    description VARCHAR(4000),
    
    PRIMARY KEY (id)
);


CREATE TABLE `users` (
	id BIGINT NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(400),
    user_name VARCHAR(200),
    encoded_password VARCHAR(200),
    
    PRIMARY KEY (id)
);


CREATE TABLE user_group_maps (
	id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    group_id BIGINT NOT NULL,
    
    PRIMARY KEY (id)
);




ALTER TABLE group_permission_maps
ADD CONSTRAINT `FK_GPMAP_GROUP_ID` FOREIGN KEY (group_id)
REFERENCES `groups` (id);


ALTER TABLE group_permission_maps
ADD CONSTRAINT `FK_GPMAP_PERMISSION_ID` FOREIGN KEY (group_id)
REFERENCES `permissions` (id);


ALTER TABLE user_group_maps
ADD CONSTRAINT `FK_UGMAP_USER_ID` FOREIGN KEY (user_id)
REFERENCES `users` (id);


ALTER TABLE user_group_maps
ADD CONSTRAINT `FK_UGMAP_GROUP_ID` FOREIGN KEY (group_id)
REFERENCES `groups` (id);





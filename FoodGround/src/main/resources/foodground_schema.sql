SET DATABASE SQL SYNTAX MYS TRUE;

CREATE TABLE IF NOT EXISTS favorite (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(20) DEFAULT NULL,
    section_id INT NOT NULL,
    store_id INT NOT NULL,
    toggle VARCHAR(1) DEFAULT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE INDEX (nickname, section_id)
);

CREATE TABLE IF NOT EXISTS mark (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    store_id INT NOT NULL,
    nickname VARCHAR(20) DEFAULT NULL,
    point INT DEFAULT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP
);
 
CREATE TABLE IF NOT EXISTS recommend (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    store_id INT NOT NULL,
    menu_name VARCHAR(45) DEFAULT NULL,
    comment VARCHAR(1000) DEFAULT NULL,
    nickname VARCHAR(20) DEFAULT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS review (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    store_id INT NOT NULL,
     section_id INT NOT NULL,
    nickname VARCHAR(20) DEFAULT NULL,
    contents VARCHAR(1000) DEFAULT NULL,
    ipv4 VARCHAR(20) DEFAULT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP
);
 
CREATE TABLE IF NOT EXISTS section (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    section_name VARCHAR(40) DEFAULT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    chg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    nickname VARCHAR(20) DEFAULT NULL
);
 
CREATE TABLE IF NOT EXISTS store (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    store_name VARCHAR(50) DEFAULT NULL,
    category VARCHAR(30) DEFAULT NULL,
    section_id INT NOT NULL,
    address1 VARCHAR(100) DEFAULT NULL,
    address2 VARCHAR(100) DEFAULT NULL,
    zipcode VARCHAR(10) DEFAULT NULL,
    coordinates VARCHAR(15) DEFAULT NULL,
    tel_main VARCHAR(15) DEFAULT NULL,
    tel_sub VARCHAR(15) DEFAULT NULL,
    img1 VARCHAR(1000) DEFAULT NULL,
    img2 VARCHAR(1000) DEFAULT NULL,
    store_url VARCHAR(1000) DEFAULT NULL,
    tag_keyword VARCHAR(100) DEFAULT NULL,
    tag_menu VARCHAR(100) DEFAULT NULL,
    tag_service VARCHAR(100) DEFAULT NULL,
    open VARCHAR(1) DEFAULT NULL,
    nickname VARCHAR(20) DEFAULT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    chg_date DATETIME DEFAULT CURRENT_TIMESTAMP
);
 
CREATE TABLE IF NOT EXISTS store_log (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    store_id INT NOT NULL,
    log_type VARCHAR(45) DEFAULT NULL,
    memo VARCHAR(1000) DEFAULT NULL,
    memo_before VARCHAR(1000) DEFAULT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    nickname VARCHAR(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS member (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    section_id INT NOT NULL,
    nickname VARCHAR(20) DEFAULT NULL,
    password VARCHAR(45) DEFAULT NULL,
    email VARCHAR(40) DEFAULT NULL,
    ipv4 VARCHAR(15) DEFAULT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO member (section_id, nickname, password, email, ipv4) VALUES (1, 'admin1234', 'admin1234', 'admin1234@foodground.net', '0:0:0:0:0:0:0:1');
INSERT INTO store (store_name, category, section_id, address1, address2, zipcode, coordinates, tel_main, tel_sub, img1, img2, store_url, tag_keyword, tag_menu, tag_service, open, nickname) VALUES ('매그놀리아','베이커리',1, '경기 성남시 분당구 백현동 582-7','지하1층','463-420','','02-123-1234','','img\1209357258\magnolia.jpg','','http://www.bymagnolia.com','베이커리, 커피','바나나 푸딩, 치즈케익','택배, 편한소파','Y','admin1234');
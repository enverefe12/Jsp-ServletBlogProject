CREATE DATABASE IF NOT EXISTS `BlogSitesi`;
USE `BlogSitesi`;

CREATE TABLE `users` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL DEFAULT 'member',
  PRIMARY KEY (`userId`));

CREATE TABLE `texts` (
  `textId` INT NOT NULL AUTO_INCREMENT,
  `textName` VARCHAR(45) NULL,
  `textPath` VARCHAR(45) NULL,
  `categoryId` VARCHAR(45) NULL,
  PRIMARY KEY (`textId`));

CREATE TABLE `category` (
  `categoryId` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NULL,
  PRIMARY KEY (`categoryId`));

INSERT INTO `category` (`category`) VALUES ('bos');
INSERT INTO `category` (`category`) VALUES ('Tarih');
INSERT INTO `category` (`category`) VALUES ('Biyoloji');

INSERT INTO `texts` (`textName`, `textPath`, `categoryId`) VALUES ('Evrimden Notlar', 'biyo.jsp', '3');
INSERT INTO `texts` (`textName`, `textPath`, `categoryId`) VALUES ('Kanlı Pazardan Ekim Devrimine; Rusya', 'sovyet1.jsp', '2');
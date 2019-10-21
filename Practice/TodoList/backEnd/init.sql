--DROP database IF EXISTS `todoItem`;
--create database `todoItem` default character set utf8 collate utf8_general_ci;
--CREATE DATABASE  IF NOT EXISTS `todoItem`  DEFAULT CHARACTER SET latin1;
USE `todoItem`;

DROP TABLE IF EXISTS `todoList`;
CREATE TABLE `todoList`(
  `id`  id int(11) NOT NULL,
  `description` VARCHAR(4000),
  `status` INT(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

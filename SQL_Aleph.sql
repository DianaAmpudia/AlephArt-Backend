-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema AlephArt
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AlephArt
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AlephArt` ;
-- -----------------------------------------------------
-- Schema alephart
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema alephart
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `alephart` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `AlephArt` ;

-- -----------------------------------------------------
-- Table `AlephArt`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`book` (
  `id_book` INT NOT NULL AUTO_INCREMENT,
  `book_photo` BLOB NULL,
  `book_name` VARCHAR(30) NULL,
  `book_description` VARCHAR(200) NULL,
  PRIMARY KEY (`id_book`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`userprofile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`userprofile` (
  `id_user_profile` INT NOT NULL AUTO_INCREMENT,
  `profile_photo` BLOB NULL,
  `banner` BLOB NULL,
  `about_me` VARCHAR(200) NULL,
  `profession` VARCHAR(30) NULL,
  `book_id_book` INT NOT NULL,
  PRIMARY KEY (`id_user_profile`),
  INDEX `fk_userProfile_book1_idx` (`book_id_book` ASC) VISIBLE,
  CONSTRAINT `fk_userProfile_book1`
    FOREIGN KEY (`book_id_book`)
    REFERENCES `AlephArt`.`book` (`id_book`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(30) NULL,
  `last_name` VARCHAR(30) NULL,
  `phone_number` VARCHAR(13) NULL,
  `password` VARCHAR(30) NULL,
  `email` VARCHAR(30) NULL,
  `userprofile_id_user_profile` INT NOT NULL,
  PRIMARY KEY (`id_user`, `userprofile_id_user_profile`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_user_userProfile_idx` (`userprofile_id_user_profile` ASC) VISIBLE,
  CONSTRAINT `fk_user_userProfile`
    FOREIGN KEY (`userprofile_id_user_profile`)
    REFERENCES `AlephArt`.`userprofile` (`id_user_profile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`posts` (
  `id_posts` INT NOT NULL AUTO_INCREMENT,
  `posts_date` DATE NULL,
  `posts_description` VARCHAR(200) NULL,
  `post_file` BLOB NULL,
  `user_id_user` INT NOT NULL,
  `user_userprofile_id_user_profile` INT NOT NULL,
  PRIMARY KEY (`id_posts`),
  INDEX `fk_posts_user1_idx` (`user_id_user` ASC, `user_userprofile_id_user_profile` ASC) VISIBLE,
  CONSTRAINT `fk_posts_user1`
    FOREIGN KEY (`user_id_user` , `user_userprofile_id_user_profile`)
    REFERENCES `AlephArt`.`user` (`id_user` , `userprofile_id_user_profile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`comments` (
  `id_comment` INT NOT NULL AUTO_INCREMENT,
  `comment_date` DATE NULL,
  `comment_description` VARCHAR(200) NULL,
  `posts_id_posts` INT NOT NULL,
  `user_id_user` INT NOT NULL,
  `user_userprofile_id_user_profile` INT NOT NULL,
  PRIMARY KEY (`id_comment`, `user_id_user`, `user_userprofile_id_user_profile`),
  INDEX `fk_comments_posts1_idx` (`posts_id_posts` ASC) VISIBLE,
  INDEX `fk_comments_user1_idx` (`user_id_user` ASC, `user_userprofile_id_user_profile` ASC) VISIBLE,
  CONSTRAINT `fk_comments_posts1`
    FOREIGN KEY (`posts_id_posts`)
    REFERENCES `AlephArt`.`posts` (`id_posts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_user1`
    FOREIGN KEY (`user_id_user` , `user_userprofile_id_user_profile`)
    REFERENCES `AlephArt`.`user` (`id_user` , `userprofile_id_user_profile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`eventmode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`eventmode` (
  `id_event_mode` INT NOT NULL AUTO_INCREMENT,
  `mode_name` VARCHAR(30) NULL,
  PRIMARY KEY (`id_event_mode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`eventcategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`eventcategory` (
  `id_event_category` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(15) NULL,
  PRIMARY KEY (`id_event_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`locationcity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`locationcity` (
  `id_location_city` INT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(30) NULL,
  PRIMARY KEY (`id_location_city`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`locationstate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`locationstate` (
  `id_location_state` INT NOT NULL AUTO_INCREMENT,
  `state_name` VARCHAR(30) NULL,
  PRIMARY KEY (`id_location_state`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`events` (
  `id_events` INT NOT NULL AUTO_INCREMENT,
  `event_name` VARCHAR(50) NULL,
  `event_description` VARCHAR(200) NULL,
  `event_photo` BLOB NULL,
  `event_date` DATE NULL,
  `event_time` TIME NULL,
  `user_id_user` INT NOT NULL,
  `user_userprofile_id_user_profile` INT NOT NULL,
  `eventmode_id_event_mode` INT NOT NULL,
  `eventcategory_id_event_category` INT NOT NULL,
  `locationcity_id_location_city` INT NOT NULL,
  `locationstate_id_location_state` INT NOT NULL,
  PRIMARY KEY (`id_events`, `eventmode_id_event_mode`, `eventcategory_id_event_category`, `locationcity_id_location_city`, `locationstate_id_location_state`),
  INDEX `fk_events_user1_idx` (`user_id_user` ASC, `user_userprofile_id_user_profile` ASC) VISIBLE,
  INDEX `fk_events_eventmode1_idx` (`eventmode_id_event_mode` ASC) VISIBLE,
  INDEX `fk_events_eventCategory1_idx` (`eventcategory_id_event_category` ASC) VISIBLE,
  INDEX `fk_events_locationCity1_idx` (`locationcity_id_location_city` ASC) VISIBLE,
  INDEX `fk_events_locationState1_idx` (`locationstate_id_location_state` ASC) VISIBLE,
  CONSTRAINT `fk_events_user1`
    FOREIGN KEY (`user_id_user` , `user_userprofile_id_user_profile`)
    REFERENCES `AlephArt`.`user` (`id_user` , `userprofile_id_user_profile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_eventmode1`
    FOREIGN KEY (`eventmode_id_event_mode`)
    REFERENCES `AlephArt`.`eventmode` (`id_event_mode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_eventCategory1`
    FOREIGN KEY (`eventcategory_id_event_category`)
    REFERENCES `AlephArt`.`eventcategory` (`id_event_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_locationCity1`
    FOREIGN KEY (`locationcity_id_location_city`)
    REFERENCES `AlephArt`.`locationcity` (`id_location_city`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_locationState1`
    FOREIGN KEY (`locationstate_id_location_state`)
    REFERENCES `AlephArt`.`locationstate` (`id_location_state`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
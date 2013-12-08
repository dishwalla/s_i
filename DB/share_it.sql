SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `share_it` DEFAULT CHARACTER SET utf8 ;
USE `share_it` ;

-- -----------------------------------------------------
-- Table `share_it`.`categories`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `share_it`.`categories` (
  `categoryId` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL DEFAULT NULL ,
  `subCategoryId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`categoryId`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `share_it`.`users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `share_it`.`users` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL DEFAULT NULL ,
  `surname` VARCHAR(45) NULL DEFAULT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(20) NOT NULL ,
  `passHash` VARCHAR(45) NULL DEFAULT NULL ,
  `avatarRelativePath` VARCHAR(130) NULL DEFAULT NULL ,
  PRIMARY KEY (`userId`) ,
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  UNIQUE INDEX `passHash_UNIQUE` (`passHash` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `share_it`.`items`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `share_it`.`items` (
  `itemId` INT(11) NOT NULL AUTO_INCREMENT ,
  `categoryId` INT(11) NOT NULL ,
  `description` TEXT NULL DEFAULT NULL ,
  `holderId` INT(11) NULL DEFAULT NULL ,
  `itemName` VARCHAR(60) NULL DEFAULT NULL ,
  `conditions` TEXT NULL DEFAULT NULL ,
  `maxParticipants` INT(11) NULL DEFAULT NULL ,
  `daysAvaiable` INT(11) NULL DEFAULT NULL ,
  `dateAdded` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`itemId`) ,
  UNIQUE INDEX `iditems_UNIQUE` (`itemId` ASC) ,
  INDEX `holderId_FK` (`holderId` ASC) ,
  INDEX `categoryId_FK` (`categoryId` ASC) ,
  CONSTRAINT `categoryId_FK`
    FOREIGN KEY (`categoryId` )
    REFERENCES `share_it`.`categories` (`categoryId` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `holderId_FK`
    FOREIGN KEY (`holderId` )
    REFERENCES `share_it`.`users` (`userId` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `share_it`.`photos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `share_it`.`photos` (
  `photoId` INT(11) NOT NULL AUTO_INCREMENT ,
  `relativePath` VARCHAR(130) NULL DEFAULT NULL ,
  `itemId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`photoId`) ,
  INDEX `itemId_FK` (`itemId` ASC) ,
  CONSTRAINT `itemId_FK`
    FOREIGN KEY (`itemId` )
    REFERENCES `share_it`.`items` (`itemId` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

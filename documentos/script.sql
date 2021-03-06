-- MySQL Script generated by MySQL Workbench
-- Wed Feb 10 00:46:25 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_SGSV
-- -----------------------------------------------------
-- DB_Sistema Gerenciador de Sessão de Votação

-- -----------------------------------------------------
-- Schema db_SGSV
--
-- DB_Sistema Gerenciador de Sessão de Votação
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_SGSV` DEFAULT CHARACTER SET utf8 ;
USE `db_SGSV` ;

-- -----------------------------------------------------
-- Table `db_SGSV`.`TB_PAUTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SGSV`.`TB_PAUTA` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(20) NULL,
  `descricao` VARCHAR(255) NULL,
  `dt_abertura_sessao` DATETIME NULL,
  `qt_duracao_sessao` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_SGSV`.`TB_ASSOCIADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SGSV`.`TB_ASSOCIADO` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  `cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_SGSV`.`TB_VOTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SGSV`.`TB_VOTO` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `associado_id` BIGINT NOT NULL,
  `pauta_id` BIGINT NOT NULL,
  `valor` CHAR(3) NOT NULL,
  INDEX `FK_TB_VOTACAO_TB_PAUTA_IDX` (`pauta_id` ASC),
  INDEX `FK_TB_VOTACAO_TB_ASSOCIADO_IDX` (`associado_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ASSOCIADO_ID_PAUTA_ID_UK` (`associado_id` ASC, `pauta_id` ASC),
  CONSTRAINT `FK_TB_VOTACAO_TB_ASSOCIADO`
    FOREIGN KEY (`associado_id`)
    REFERENCES `db_SGSV`.`TB_ASSOCIADO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TB_VOTACAO_TB_SESSAO`
    FOREIGN KEY (`pauta_id`)
    REFERENCES `db_SGSV`.`TB_PAUTA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

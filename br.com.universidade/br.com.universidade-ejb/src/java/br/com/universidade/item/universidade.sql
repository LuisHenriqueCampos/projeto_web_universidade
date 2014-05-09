SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `universidade` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
CREATE SCHEMA IF NOT EXISTS `universidade` DEFAULT CHARACTER SET latin1 ;

-- -----------------------------------------------------
-- Table `universidade`.`materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidade`.`materia` ;

CREATE  TABLE IF NOT EXISTS `universidade`.`materia` (
  `idMateria` INT NOT NULL AUTO_INCREMENT ,
  `materia` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`idMateria`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `universidade`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidade`.`pessoa` ;

CREATE  TABLE IF NOT EXISTS `universidade`.`pessoa` (
  `idPessoa` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `dataNascimento` DATE NOT NULL ,
  `cpf` VARCHAR(14) NOT NULL ,
  PRIMARY KEY (`idPessoa`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `universidade`.`aluno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidade`.`aluno` ;

CREATE  TABLE IF NOT EXISTS `universidade`.`aluno` (
  `idPessoa` INT(11) NOT NULL ,
  `email` VARCHAR(50) NULL DEFAULT NULL ,
  `nomeResponsavel` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`idPessoa`) ,
  INDEX `fk_aluno_pessoa1` (`idPessoa` ASC) ,
  CONSTRAINT `fk_aluno_pessoa1`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `universidade`.`pessoa` (`idPessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `universidade`.`curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidade`.`curso` ;

CREATE  TABLE IF NOT EXISTS `universidade`.`curso` (
  `idCurso` SMALLINT(6) NOT NULL AUTO_INCREMENT ,
  `nomeCurso` VARCHAR(45) NOT NULL ,
  `cargaHoraria` INT(11) NOT NULL ,
  PRIMARY KEY (`idCurso`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `universidade`.`situacaomatricula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidade`.`situacaomatricula` ;

CREATE  TABLE IF NOT EXISTS `universidade`.`situacaomatricula` (
  `idSituacaoMatricula` SMALLINT(6) NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idSituacaoMatricula`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `universidade`.`periodoletivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidade`.`periodoletivo` ;

CREATE  TABLE IF NOT EXISTS `universidade`.`periodoletivo` (
  `idPeriodoLetivo` SMALLINT(6) NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NOT NULL ,
  `dataInicio` DATE NOT NULL ,
  `dataFim` DATE NOT NULL ,
  PRIMARY KEY (`idPeriodoLetivo`) )
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `universidade`.`turma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidade`.`turma` ;

CREATE  TABLE IF NOT EXISTS `universidade`.`turma` (
  `idTurma` INT(11) NOT NULL AUTO_INCREMENT ,
  `idCurso` SMALLINT(6) NOT NULL ,
  `idPeriodoLetivo` SMALLINT(6) NOT NULL ,
  `nomeTurma` VARCHAR(45) NOT NULL ,
  `horarioInicio` TIME NOT NULL ,
  `horarioFim` TIME NOT NULL ,
  `quantidadeVagas` INT(11) NOT NULL ,
  PRIMARY KEY (`idTurma`) ,
  INDEX `fk_Turma_Curso1` (`idCurso` ASC) ,
  INDEX `fk_Turma_PeriodoLetivo1` (`idPeriodoLetivo` ASC) ,
  CONSTRAINT `fk_Turma_Curso1`
    FOREIGN KEY (`idCurso` )
    REFERENCES `universidade`.`curso` (`idCurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turma_PeriodoLetivo1`
    FOREIGN KEY (`idPeriodoLetivo` )
    REFERENCES `universidade`.`periodoletivo` (`idPeriodoLetivo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `universidade`.`matricula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidade`.`matricula` ;

CREATE  TABLE IF NOT EXISTS `universidade`.`matricula` (
  `idMatricula` INT(11) NOT NULL AUTO_INCREMENT ,
  `idAluno` INT(11) NOT NULL ,
  `idTurma` INT(11) NOT NULL ,
  `idSituacaoMatricula` SMALLINT(6) NOT NULL ,
  `dataMatricula` DATETIME NOT NULL ,
  `notaFinal` DOUBLE NULL DEFAULT NULL ,
  PRIMARY KEY (`idMatricula`) ,
  INDEX `fk_Matricula_SituacaoMatricula1` (`idSituacaoMatricula` ASC) ,
  INDEX `fk_Matricula_Turma1` (`idTurma` ASC) ,
  INDEX `fk_matricula_aluno1` (`idAluno` ASC) ,
  CONSTRAINT `fk_matricula_aluno1`
    FOREIGN KEY (`idAluno` )
    REFERENCES `universidade`.`aluno` (`idPessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matricula_SituacaoMatricula1`
    FOREIGN KEY (`idSituacaoMatricula` )
    REFERENCES `universidade`.`situacaomatricula` (`idSituacaoMatricula` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matricula_Turma1`
    FOREIGN KEY (`idTurma` )
    REFERENCES `universidade`.`turma` (`idTurma` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `universidade`.`cursoMateria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidade`.`cursoMateria` ;

CREATE  TABLE IF NOT EXISTS `universidade`.`cursoMateria` (
  `idCurso` SMALLINT(6) NOT NULL ,
  `idMateria` INT NOT NULL ,
  PRIMARY KEY (`idCurso`, `idMateria`) ,
  INDEX `fk_curso_has_materia_curso1` (`idCurso` ASC) ,
  INDEX `fk_curso_has_materia_materia1` (`idMateria` ASC) ,
  CONSTRAINT `fk_curso_has_materia_curso1`
    FOREIGN KEY (`idCurso` )
    REFERENCES `universidade`.`curso` (`idCurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_has_materia_materia1`
    FOREIGN KEY (`idMateria` )
    REFERENCES `universidade`.`materia` (`idMateria` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

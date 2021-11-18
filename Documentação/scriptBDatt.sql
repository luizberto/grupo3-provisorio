CREATE DATABASE `sportybd2` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
use sportybd2;

CREATE TABLE `endereco` (
  `id_endereco` int NOT NULL AUTO_INCREMENT,
  `cep` char(8) DEFAULT NULL,
  `logradouro` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `atleta` (
  `id_atleta` int NOT NULL AUTO_INCREMENT,
  `cpf` char(14) DEFAULT NULL,
  `nome_atleta` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `fk_endereco` int DEFAULT NULL,
  PRIMARY KEY (`id_atleta`),
  KEY `fkEndereco_idx` (`fk_endereco`),
  KEY `fk_Atleta_Endereco1_idx` (`fk_endereco`),
  CONSTRAINT `fkEndereco` FOREIGN KEY (`fk_endereco`) REFERENCES `endereco` (`id_endereco`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `quadra` (
  `id_quadra` int NOT NULL AUTO_INCREMENT,
  `nome_quadra` varchar(45) DEFAULT NULL,
  `desc_quadra` varchar(300) DEFAULT NULL,
  `limite_pessoas` int DEFAULT NULL,
  `classificacao_quadra` int DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `fk_endereco` int DEFAULT NULL,
  `id_endereco` int DEFAULT NULL,
  PRIMARY KEY (`id_quadra`),
  KEY `fk_Quadra_Endereco1_idx` (`fk_endereco`),
  KEY `FK9ns3au6djsq9bxkxbo3n7igrm` (`id_endereco`),
  CONSTRAINT `FK9ns3au6djsq9bxkxbo3n7igrm` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`),
  CONSTRAINT `fk_endereco` FOREIGN KEY (`fk_endereco`) REFERENCES `endereco` (`id_endereco`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `reserva` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `hora_partida` datetime(6) NOT NULL,
  `qtd_atletas` int DEFAULT NULL,
  `valor_reserva` double DEFAULT NULL,
  `quadra_id_quadra` int DEFAULT NULL,
  `responsavel_id_atleta` int DEFAULT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `FKjk3ddvwoex6saht8w97258xsp` (`quadra_id_quadra`),
  KEY `FKsger44p1qeofgdgold01rxccu` (`responsavel_id_atleta`),
  CONSTRAINT `FKjk3ddvwoex6saht8w97258xsp` FOREIGN KEY (`quadra_id_quadra`) REFERENCES `quadra` (`id_quadra`),
  CONSTRAINT `FKsger44p1qeofgdgold01rxccu` FOREIGN KEY (`responsavel_id_atleta`) REFERENCES `atleta` (`id_atleta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `reservas` (
  `hora_partida` datetime NOT NULL,
  `Quadra` int DEFAULT NULL,
  `responsavel` int DEFAULT NULL,
  `qtd_atletas` varchar(45) DEFAULT NULL,
  `valor_reserva` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hora_partida`),
  KEY `fk_Atleta_has_Quadra_Quadra1_idx` (`Quadra`),
  KEY `fk_Reservas_Atleta1_idx` (`responsavel`),
  CONSTRAINT `fk_Atleta_has_Quadra_Quadra1` FOREIGN KEY (`Quadra`) REFERENCES `quadra` (`id_quadra`),
  CONSTRAINT `fk_Reservas_Atleta1` FOREIGN KEY (`responsavel`) REFERENCES `atleta` (`id_atleta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `dono_quadra` (
  `id_dono` int NOT NULL AUTO_INCREMENT,
  `nome_dono` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  `cpf` char(14) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  PRIMARY KEY (`id_dono`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

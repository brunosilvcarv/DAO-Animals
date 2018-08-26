CREATE DATABASE IF NOT EXISTS crudanimal
DEFAULT COLLATE utf8_general_ci
DEFAULT CHARACTER SET utf8;


CREATE TABLE `animal` (
  `idanimal` int(11) NOT NULL AUTO_INCREMENT,
  `propanimal` varchar(150) DEFAULT NULL,
  `racaanimal` int(11) DEFAULT NULL,
  `nomeanimal` varchar(150) DEFAULT NULL,
  `espanimal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idanimal`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;


CREATE TABLE `especie` (
  `idespecie` int(11) NOT NULL AUTO_INCREMENT,
  `nomeespecie` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idespecie`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


CREATE TABLE `raca` (
  `idraca` int(11) NOT NULL AUTO_INCREMENT,
  `espraca` int(11) DEFAULT NULL,
  `nomeraca` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idraca`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

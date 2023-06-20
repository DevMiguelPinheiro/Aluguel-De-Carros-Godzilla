/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  migue
 * Created: 20 de jun de 2023
 */

CREATE TABLE `aluguel` (
  `id_aluguel` int NOT NULL AUTO_INCREMENT,
  `id_do_cliente` int DEFAULT NULL,
  `placa_do_carro` varchar(20) DEFAULT NULL,
  `data_retorno` date DEFAULT NULL,
  `data_aluguel` date DEFAULT NULL,
  `taxa` double DEFAULT NULL,
  PRIMARY KEY (`id_aluguel`),
  KEY `id_do_cliente` (`id_do_cliente`),
  KEY `placa_do_carro` (`placa_do_carro`),
  CONSTRAINT `aluguel_ibfk_1` FOREIGN KEY (`id_do_cliente`) REFERENCES `clientes` (`id`),
  CONSTRAINT `aluguel_ibfk_2` FOREIGN KEY (`placa_do_carro`) REFERENCES `carros` (`placa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3
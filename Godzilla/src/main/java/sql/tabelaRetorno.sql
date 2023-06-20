/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  migue
 * Created: 20 de jun de 2023
 */

CREATE TABLE `retorno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_aluguel` int DEFAULT NULL,
  `placa` varchar(40) DEFAULT NULL,
  `nome` varchar(40) DEFAULT NULL,
  `data_retorno` varchar(40) DEFAULT NULL,
  `atraso` mediumtext,
  `multaConta` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3

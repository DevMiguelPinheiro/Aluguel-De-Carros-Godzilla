/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  migue
 * Created: 20 de jun de 2023
 */

CREATE TABLE `carros` (
  `placa` varchar(40) NOT NULL,
  `marca` varchar(40) DEFAULT NULL,
  `modelo` varchar(40) DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `caminhoimg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`placa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3
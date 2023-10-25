
CREATE DATABASE estilopropio;

USE estilopropio;

CREATE TABLE `cliente` (
 `id` int NOT NULL AUTO_INCREMENT,
 `nombre` varchar (300) DEFAULT NULL,
 `correo` varchar(300) DEFAULT NULL,
 `telefono` varchar(300) DEFAULT NULL,
 `password` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO cliente VALUES (1, 'Thalia Cristiano', 'thaliac@gmail.com','3152468727', 'ADC1234*');
INSERT INTO cliente VALUES (2, 'Edward Loaiza', 'edwardl@gmail.com','3152468728', 'ADC1235*');
INSERT INTO cliente VALUES (3, 'Juan Izquierdo', 'juaniz@gmail.com','3152468729', 'ADC1236*');
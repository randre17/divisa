DROP TABLE IF EXISTS TIPO_CAMBIO;

CREATE TABLE TIPO_CAMBIO (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  divisa VARCHAR(250) NOT NULL,
  descripcion VARCHAR(250) NOT NULL,
  tipocambio DECIMAL NOT NULL
);
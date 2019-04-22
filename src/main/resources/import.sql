INSERT INTO ROL(id_rol, name) VALUES (1, "ADMINISTRADOR");
INSERT INTO ROL(id_rol, name) VALUES (2, "USUARIO");
INSERT INTO ROL(id_rol, name) VALUES (3, "QA");

INSERT INTO USER(username, password, email, id_rol) VALUES("jacob", "jacobpass", "jacob@email.com", 1); 
INSERT INTO USER(username, password, email, id_rol) VALUES("alejandro", "alepass", "ale@email.com", 2); 
INSERT INTO USER(username, password, email, id_rol) VALUES("test", "testpass", "test@email.com", 3); 
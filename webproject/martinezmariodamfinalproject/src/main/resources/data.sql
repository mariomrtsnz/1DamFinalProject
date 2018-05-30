ALTER TABLE PUBLIC.ADMIN ADD CONSTRAINT PUBLIC.CONSTRAINT_3 PRIMARY KEY(ID);
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.ADMIN;   
INSERT INTO PUBLIC.ADMIN(ID, EMAIL, NAME, NIF, PASSWORD, PHONE, PROFILEPIC) VALUES
(1, 'admin@admin.com', 'Admin', '55123456T', 'admin', '664560382', '/images/profilePics/profile-admin.jpg');         

ALTER TABLE PUBLIC.APPOINTMENT ADD CONSTRAINT PUBLIC.CONSTRAINT_2 PRIMARY KEY(ID);     
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.APPOINTMENT;             
INSERT INTO PUBLIC.APPOINTMENT(ID, ENDTIME, ORDERDATE, PAID, STARTTIME, CLIENT_ID, EMPLOYEE_ID, TREATMENT_ID) VALUES
(1, TIMESTAMP '2013-12-27 11:00:00', TIMESTAMP '2013-12-20 16:00:00', FALSE, TIMESTAMP '2013-12-27 10:00:00', 3, 1, 1),
(2, TIMESTAMP '2013-12-18 15:30:00', TIMESTAMP '2013-12-15 18:00:00', TRUE, TIMESTAMP '2013-12-18 14:30:00', 1, 2, 8),
(3, TIMESTAMP '2018-10-24 16:00:00', TIMESTAMP '2018-09-30 11:00:00', FALSE, TIMESTAMP '2018-10-24 15:00:00', 3, 2, 2),
(4, TIMESTAMP '2018-08-03 17:00:00', TIMESTAMP '2018-08-01 19:00:00', FALSE, TIMESTAMP '2018-08-03 16:00:00', 1, 1, 3);     
  
ALTER TABLE PUBLIC.CLIENT ADD CONSTRAINT PUBLIC.CONSTRAINT_7 PRIMARY KEY(ID); 
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.CLIENT;  
INSERT INTO PUBLIC.CLIENT(ID, DNI, DUEPAYMENT, EMAIL, HISTORICAL, NAME, PASSWORD, PHONE, PROFILEPIC, REGISTERDATE, COMPANY_ID) VALUES
(1, '77927639M', TRUE, 'usuario@usuario.com', FALSE, STRINGDECODE('Mario Mart\u00ednez Sanz'), '1234', '678377084', '/images/profilePics/profile-usuario.jpg', TIMESTAMP '2018-05-30 20:17:17.989691', 1),
(2, '00988766D', FALSE, 'frankcastle@rwd.com', TRUE, 'Frank Castle', 'frankcastle', '882764410', '/images/profilePics/profile-client2.jpg', TIMESTAMP '2014-01-01 10:10:30', 1),
(3, '92115067U', TRUE, 'daredevil@rwd.com', FALSE, 'Matt Murdock', 'daredevil', '620331525', '/images/profilePics/profile-client3.jpg', TIMESTAMP '2015-05-22 15:00:48', 1);             

ALTER TABLE PUBLIC.COMPANY ADD CONSTRAINT PUBLIC.CONSTRAINT_6 PRIMARY KEY(ID);
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.COMPANY; 
INSERT INTO PUBLIC.COMPANY(ID, ADDRESS, CLOSETIME, EMAIL, NAME, NIF, OPENTIME, PHONE) VALUES
(1, STRINGDECODE('c/ Alejo Fern\u00e1ndez, 13, 41003'), TIME '19:00:00', 'contact@realworlddental.com', 'RealWorld Dental', '55123456T', TIME '10:00:00', '954 335 932');       

ALTER TABLE PUBLIC.EMPLOYEE ADD CONSTRAINT PUBLIC.CONSTRAINT_75 PRIMARY KEY(ID);           
-- 6 +/- SELECT COUNT(*) FROM PUBLIC.EMPLOYEE;
INSERT INTO PUBLIC.EMPLOYEE(ID, DNI, EMAIL, GROSSANUALSALARY, HIREDATE, HISTORICAL, HISTORICALDATE, NAME, PASSWORD, PHONE, POSITION, PROFILEPIC, COMPANY_ID) VALUES
(1, '54259538P', 'empleado@empleado.com', 20000.0, TIMESTAMP '2018-05-03 07:30:00', FALSE, NULL, 'Bruce Wayne', 'empleado', '632612336', 'Administrativo', '/images/staff/1.png', 1),
(2, '92961930R', 'harveydent@rwd.com', 67690.0, TIMESTAMP '2018-03-01 06:29:00', FALSE, NULL, 'Harvey Dent', 'harveydent', '615483364', 'Dentista', '/images/staff/2.png', 1),
(3, '49084817B', 'poisonivy@rwd.com', 50049.03, TIMESTAMP '2018-03-01 06:29:00', FALSE, NULL, 'Pamela Lillian Isley', 'poisonivy', '666543237', 'Dentista', '/images/staff/3.png', 1),
(4, '11180791P', 'catwoman@rwd.com', 51210.74, TIMESTAMP '2018-03-01 06:29:00', FALSE, NULL, 'Selina Kyle', 'catwoman', '639699259', 'Dentista', '/images/staff/4.png', 1),
(5, '44189356P', 'barbaragordon@rwd.com', 30000.0, TIMESTAMP '2018-03-01 06:29:00', FALSE, NULL, STRINGDECODE('B\u00e1rbara Gordon'), 'barbaragordon', '677 171 894', 'Administrativo', '/images/staff/5.png', 1),
(6, '98498552V', 'enygma@rwd.com', 45000.0, TIMESTAMP '2018-03-01 06:29:00', FALSE, NULL, 'Edward Nygma', 'enygma', '666953939', 'Dentista', '/images/staff/6.png', 1);  

ALTER TABLE PUBLIC.TREATMENT ADD CONSTRAINT PUBLIC.CONSTRAINT_A PRIMARY KEY(ID);            
-- 10 +/- SELECT COUNT(*) FROM PUBLIC.TREATMENT;              
INSERT INTO PUBLIC.TREATMENT(ID, DESCRIPTION, DISCOUNT, HISTORICAL, NAME, NUMSESSIONS, PAIDININSTALLMENTS, PICTURE, TOTALPRICE, COMPANY_ID) VALUES
(1, STRINGDECODE('Los dientes son muy importantes para su apariencia. Te ves m\u00e1s joven con los dientes m\u00e1s blancos. Aqu\u00ed en RealWorldDental blanqueamos tus dientes con la \u00faltima tecnolog\u00eda.'), 10, FALSE, 'Blanqueamiento', 1, FALSE, '/images/services/teethwhitening.jpg', 150.0, 1),
(2, STRINGDECODE('Se utilizan para ocultar dientes agrietados, menos est\u00e9ticos , o dientes descoloridos. Se utiliza preferentemente en los dientes frontales.'), 0, FALSE, 'Carillas', 2, TRUE, '/images/services/carillas.png', 100.0, 1),
(3, STRINGDECODE('Una corona es la mejor opci\u00f3n cuando se trata de una gran parte del diente la que necesita ser reemplazada o si vemos que el diente por est\u00e9tica necesite cambiar el color o la forma.'), 5, FALSE, 'Coronas y Puentes', 2, FALSE, '/images/services/corona.jpg', 200.0, 1),
(4, STRINGDECODE('Para arreglar hasta las peque\u00f1as lesiones de caries. Consiste en anestesia, limpieza de la caries, relleno de la cavidad y pulido del empaste.'), 0, FALSE, 'Empaste', 1, FALSE, '/images/services/empaste.png', 50.0, 1),
(5, STRINGDECODE('Necesaria cuando existe una hipersensibilidad en el diente, dolor al masticar o dolor ante el consumo de bebidas muy fr\u00edas o muy calientes ocasionados por la presencia de caries en el diente.'), 5, FALSE, 'Endodoncia', 1, FALSE, '/images/services/endodoncia.jpg', 80.0, 1),
(6, STRINGDECODE('Los implantes dentales se utilizan cuando haya perdido uno o m\u00e1s dientes. Es una elecci\u00f3n segura y duradera para toda la vida.'), 0, FALSE, 'Implante', 2, TRUE, '/images/services/implante.png', 140.0, 1),
(7, STRINGDECODE('Encargada de explorar y tratar a ni\u00f1os y reci\u00e9n nacidos. Tambi\u00e9n se encarga de detectar posibles anomal\u00edas en la posici\u00f3n de los maxilares o dientes para remitir al ortodoncista.'), 0, FALSE, STRINGDECODE('Odontopediatr\u00eda'), 1, FALSE, '/images/services/odontopediatria.png', 60.0, 1),
(8, STRINGDECODE('A veces los dientes crecen en una posici\u00f3n inadecuada o se han movido debido a varios motivos. Mediante la ortodoncia podemos hacer cualquier correcci\u00f3n.'), 0, FALSE, 'Ortodoncia', 5, TRUE, '/images/services/ortodoncia.jpg', 500.0, 1),
(9, STRINGDECODE('Proviene de una enfermedad inflamatoria que afecta principalmente a los tejidos que sostienen los dientes. Es de avance lento. Si no recibes tratamiento, pueden pasar muchos a\u00f1os antes de perder los dientes.'), 5, FALSE, 'Periodontitis', 1, FALSE, '/images/services/periodontitis.jpg', 60.0, 1),
(10, STRINGDECODE('Revisar tu boca al menos una vez al a\u00f1o es una medida preventiva que te llevar\u00e1 unos minutos de tu tiempo, sin embargo, el beneficio que vas a obtener es mucho mayor.'), 0, FALSE, STRINGDECODE('Revisi\u00f3n'), 1, FALSE, '/images/services/revision.jpg', 30.0, 1);

ALTER TABLE PUBLIC.CLIENT ADD CONSTRAINT PUBLIC.UK_F07YMTQAIF0TBCAWYB71L3ONE UNIQUE(EMAIL);   
ALTER TABLE PUBLIC.TREATMENT ADD CONSTRAINT PUBLIC.UK_SGA29CWGQ9CKCFS991CXD52VN UNIQUE(NAME); 
ALTER TABLE PUBLIC.EMPLOYEE ADD CONSTRAINT PUBLIC.UK_2Y5G3IJ0KGTVRLP3RTMJLABJ4 UNIQUE(EMAIL); 
ALTER TABLE PUBLIC.CLIENT ADD CONSTRAINT PUBLIC.UK_JJFVTU1OMVYVB8CWSDFFDO3K7 UNIQUE(DNI);     
ALTER TABLE PUBLIC.EMPLOYEE ADD CONSTRAINT PUBLIC.UK_RBEJ3POIHVY9B078TAISP2UPR UNIQUE(DNI);   
ALTER TABLE PUBLIC.APPOINTMENT ADD CONSTRAINT PUBLIC.FKP47PMRNE1BL1SUH0OB4ULIC2N FOREIGN KEY(TREATMENT_ID) REFERENCES PUBLIC.TREATMENT(ID) NOCHECK;           
ALTER TABLE PUBLIC.APPOINTMENT ADD CONSTRAINT PUBLIC.FKKPMOTT4GICVH2CMEQJMY04F06 FOREIGN KEY(EMPLOYEE_ID) REFERENCES PUBLIC.EMPLOYEE(ID) NOCHECK;             
ALTER TABLE PUBLIC.ADMIN ADD CONSTRAINT PUBLIC.FK3PYW6U4VQ4MOFCQ0595I416FX FOREIGN KEY(ID) REFERENCES PUBLIC.COMPANY(ID) NOCHECK;             
ALTER TABLE PUBLIC.APPOINTMENT ADD CONSTRAINT PUBLIC.FKDMPURDN7NL6PXJEQS5U5JMB6J FOREIGN KEY(CLIENT_ID) REFERENCES PUBLIC.CLIENT(ID) NOCHECK; 
ALTER TABLE PUBLIC.CLIENT ADD CONSTRAINT PUBLIC.FK780D0M7Y70QBENSIITAB769N3 FOREIGN KEY(COMPANY_ID) REFERENCES PUBLIC.COMPANY(ID) NOCHECK;    
ALTER TABLE PUBLIC.TREATMENT ADD CONSTRAINT PUBLIC.FKCADKA07ARYC4NHKUXNVY1AAWM FOREIGN KEY(COMPANY_ID) REFERENCES PUBLIC.COMPANY(ID) NOCHECK; 
ALTER TABLE PUBLIC.EMPLOYEE ADD CONSTRAINT PUBLIC.FKOGYDJHDLCL557PPJR3G8XWMH0 FOREIGN KEY(COMPANY_ID) REFERENCES PUBLIC.COMPANY(ID) NOCHECK;  
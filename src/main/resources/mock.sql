TRUNCATE public.details;
TRUNCATE public.plant CASCADE ;
TRUNCATE public.arduino CASCADE ;
TRUNCATE public.client CASCADE ;
TRUNCATE public.detailsarchive;

INSERT INTO public.client (email, password) VALUES ('fake@email.com', '12345');
INSERT INTO public.client (email, password) VALUES ('fake2@email.com', '12345');

INSERT INTO public.arduino (physicalidentifier, series, ledsetting, redcode, greencode, bluecode)
VALUES (101, 'xx', false, 0, 0, 0);

INSERT INTO public.arduino (physicalidentifier, series, ledsetting, redcode, greencode, bluecode)
VALUES (102, 'xx', true, 11, 22, 33);
INSERT INTO public.arduino (physicalidentifier, series, ledsetting, redcode, greencode, bluecode)
VALUES (103, 'xx', false, 0, 0, 0);

INSERT INTO public.arduino (physicalidentifier, series, ledsetting, redcode, greencode, bluecode)
VALUES (104, 'xx', true, 11, 22, 33);

INSERT INTO public.plant (plantid,useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES (1,'fake@email.com', 'planty', 'PLAIN', '2022-12-01 20:03:45.000000', 101);

INSERT INTO public.plant (plantid,useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES (2,'fake@email.com', 'plantos', 'PLAIN', '2022-12-01 20:04:00.000000', 102);
INSERT INTO public.plant (plantid,useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES (3,'fake2@email.com', 'planty2', 'PLAIN', '2022-12-01 20:03:45.000000', 103);

INSERT INTO public.plant (plantid,useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES (4,'fake2@email.com', 'plantos2', 'PLAIN', '2022-12-01 20:04:00.000000', 104);


INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,56,32,612,11,27,35,85,11,93,157,1096,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,30,60,60,912,10,25,39,84,10,94,248,1122,8633);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,18,91,58,722,13,25,38,83,17,88,127,1009,8646);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,13,57,89,1092,11,44,33,88,11,85,290,1140,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,80,67,648,9,41,36,88,11,88,253,1072,8646);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,19,75,59,647,12,36,39,83,11,91,296,1059,8639);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,12,58,61,926,10,38,35,80,11,88,127,1026,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,20,62,81,645,12,27,33,89,10,91,260,1111,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,15,72,69,637,12,38,34,84,11,93,185,1106,8643);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,55,35,1155,8,42,30,89,15,86,213,1186,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,92,38,975,10,31,32,88,18,94,267,1183,8643);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,10,66,70,962,10,38,36,84,13,91,246,1078,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,13,72,43,933,11,39,35,89,15,86,221,1120,8635);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,28,72,45,714,8,40,31,80,16,86,290,1198,8648);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,92,35,657,12,35,38,86,14,88,292,1046,8649);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,11,61,39,731,11,38,34,81,13,94,296,1080,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,14,77,53,905,14,32,33,89,12,91,231,1199,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,17,81,79,1194,10,25,39,82,13,91,276,1109,8643);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,72,52,548,13,30,34,82,10,90,141,1029,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,11,82,52,793,9,30,35,84,11,89,203,1126,8648);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,16,62,45,569,11,33,31,89,13,88,141,1087,8630);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,16,69,69,711,11,37,31,86,17,87,113,1170,8638);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,88,88,763,12,29,36,86,17,93,228,1194,8634);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,11,74,60,1078,14,32,32,84,12,89,196,1052,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,29,82,86,682,8,25,31,80,13,91,182,1057,8646);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,93,50,889,11,36,36,85,18,93,236,1090,8635);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,16,89,71,1180,9,41,37,80,13,86,193,1103,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,17,84,66,1044,10,32,35,80,19,85,261,1076,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,15,57,40,643,13,42,37,88,13,93,102,1087,8632);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,25,86,90,930,9,30,33,83,10,93,120,1073,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,28,89,73,613,9,43,31,84,18,89,103,1003,8649);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,29,74,46,969,10,40,31,83,11,93,193,1094,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,69,50,1185,8,29,39,87,16,92,249,1122,8632);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,18,72,73,690,9,27,33,88,12,94,223,1066,8635);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,30,88,34,792,11,36,34,85,15,90,104,1079,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,30,88,45,1073,12,26,38,88,14,92,131,1108,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,75,41,538,10,40,30,84,16,92,281,1155,8630);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,18,64,94,1145,11,43,39,84,15,92,103,1100,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,20,64,60,955,12,31,31,85,14,86,126,1170,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,10,91,72,1031,9,26,37,84,15,86,235,1114,8633);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,87,46,861,11,38,32,89,19,93,210,1129,8646);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,10,86,62,987,9,31,37,83,10,92,202,1007,8633);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,14,86,82,561,14,29,36,86,16,90,155,1059,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,13,51,35,1138,14,40,34,85,13,89,117,1075,8631);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,18,54,59,765,10,41,35,81,10,88,170,1034,8635);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,25,53,34,628,13,39,32,83,12,92,288,1070,8632);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,11,68,30,1161,10,35,36,89,14,89,122,1154,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,25,78,94,803,12,26,31,81,10,90,159,1063,8636);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,29,70,69,1092,11,28,36,87,14,90,287,1162,8632);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,52,62,803,9,27,36,89,12,93,130,1007,8645);

SELECT MAX(plantid) FROM public.plant
-- DELETE FROM arduino WHERE physicalIdentifier=101;
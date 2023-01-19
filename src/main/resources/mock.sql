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
VALUES (1,'fake@email.com', 'planty', 'CREEPERS', '2022-12-01 20:03:45.000000', 101);

INSERT INTO public.plant (plantid,useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES (2,'fake@email.com', 'plantos', 'CREEPERS', '2022-12-01 20:04:00.000000', 102);
INSERT INTO public.plant (plantid,useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES (3,'fake2@email.com', 'planty2', 'CREEPERS', '2022-12-01 20:03:45.000000', 103);

INSERT INTO public.plant (plantid,useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES (4,'fake2@email.com', 'plantos2', 'CREEPERS', '2022-12-01 20:04:00.000000', 104);


INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,56,32,612,21,27,35,85,11,93,157,1096,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,30,60,60,912,20,25,39,84,10,94,248,1122,8633);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,18,91,58,722,23,25,38,83,17,88,127,1009,8646);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,23,57,49,1092,21,44,33,88,11,85,290,1140,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,80,57,648,19,41,36,88,11,88,253,1072,8646);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,29,75,59,647,32,36,39,83,11,91,296,1059,8639);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,22,58,41,926,20,38,35,80,11,88,127,1026,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,20,62,61,645,32,27,33,89,10,91,260,1111,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,25,72,59,637,32,38,34,84,11,93,185,1106,8643);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,55,45,1155,28,42,30,89,15,86,213,1186,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,92,38,975,20,31,32,88,18,94,267,1183,8643);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,20,66,50,962,30,38,36,84,13,91,246,1078,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,23,72,43,933,31,39,35,89,15,86,221,1120,8635);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,28,72,45,714,28,40,31,80,16,86,290,1198,8648);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,92,35,657,32,35,38,86,14,88,292,1046,8649);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,61,39,731,31,38,34,81,13,94,296,1080,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,77,53,905,24,32,33,89,12,91,231,1199,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,27,81,59,1194,30,25,39,82,13,91,276,1109,8643);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,72,52,548,33,30,34,82,10,90,141,1029,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,82,52,793,29,30,35,84,11,89,203,1126,8648);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,62,35,569,31,33,31,89,13,88,141,1087,8630);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,69,59,711,31,37,31,86,17,87,113,1170,8638);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,88,48,763,32,29,36,86,17,93,228,1194,8634);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,74,60,1078,34,32,32,84,12,89,196,1052,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,29,82,46,682,28,25,31,80,13,91,182,1057,8646);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,93,50,889,31,36,36,85,18,93,236,1090,8635);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,89,51,1180,29,41,37,80,13,86,193,1103,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,84,56,1044,30,32,35,80,19,85,261,1076,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,25,57,40,643,33,42,37,88,13,93,102,1087,8632);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,25,86,60,930,29,30,33,83,10,93,120,1073,8644);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,28,89,33,613,29,43,31,84,18,89,103,1003,8649);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,29,74,46,969,30,40,31,83,11,93,193,1094,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,69,50,1185,28,29,39,87,16,92,249,1122,8632);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,20,72,43,690,29,27,33,88,12,94,223,1066,8635);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,88,34,792,31,36,34,85,15,90,104,1079,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,30,88,45,1073,32,26,38,88,14,92,131,1108,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,26,75,41,538,30,40,30,84,16,92,281,1155,8630);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,64,54,1145,31,43,39,84,15,92,103,1100,8647);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,20,64,60,955,32,31,31,85,14,86,126,1170,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,20,91,52,1031,29,26,37,84,15,86,235,1114,8633);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,87,46,861,31,38,32,89,19,93,210,1129,8646);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,20,86,52,987,29,31,37,83,10,92,202,1007,8633);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,86,52,561,34,29,36,86,16,90,155,1059,8641);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,23,51,35,1138,34,40,34,85,13,89,117,1075,8631);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,22,54,59,765,30,41,35,81,10,88,170,1034,8635);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,25,53,34,628,33,39,32,83,12,92,288,1070,8632);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,21,68,30,1161,30,35,36,89,14,89,122,1154,8642);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,25,78,54,803,32,26,31,81,10,90,159,1063,8636);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,29,70,59,1092,31,28,36,87,14,90,287,1162,8632);
INSERT INTO public.detailsarchive (plantid, temperatureavg, humidityavg, moistureavg, lightavg, minimumtemperature, maximumtemperature, minimumhumidity, maximumhumidity, minimummoisture, maximummoisture, minimumlight, maximumlight, totalrowsarchived)
VALUES (1,24,52,62,803,29,27,36,89,12,93,130,1007,8645);

SELECT MAX(plantid) FROM public.plant
-- DELETE FROM arduino WHERE physicalIdentifier=101;
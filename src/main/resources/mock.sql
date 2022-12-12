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

INSERT INTO public.plant (useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES ('fake@email.com', 'planty', 'PLAIN', '2022-12-01 20:03:45.000000', 101);

INSERT INTO public.plant (useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES ('fake@email.com', 'plantos', 'PLAIN', '2022-12-01 20:04:00.000000', 102);
INSERT INTO public.plant (useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES ('fake2@email.com', 'planty2', 'PLAIN', '2022-12-01 20:03:45.000000', 103);

INSERT INTO public.plant (useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES ('fake2@email.com', 'plantos2', 'PLAIN', '2022-12-01 20:04:00.000000', 104);



SELECT MAX(plantid) FROM public.plant
-- DELETE FROM arduino WHERE physicalIdentifier=101;
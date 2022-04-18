INSERT INTO Institution (id, name,description) VALUES (1, 'Dbam o Zdrowie','Pomoc dzieciom z ubogich rodzin.');
INSERT INTO Institution (id, name,description) VALUES (2, 'A kogo','Pomoc wybudzaniu dzieci ze śpiączki.');
INSERT INTO Institution (id, name,description) VALUES (3, 'Bez domu','Pomoc dla osób nie posiadających miejsca zamieszkania.');
INSERT INTO Institution (id, name,description) VALUES (4, 'Dla dzieci','Pomoc osobom znajdującym się w trudnej sytuacji życiowej.');


INSERT INTO Category (id, name) VALUES (1, 'AGD');
INSERT INTO Category (id, name) VALUES (2, 'Książki');
INSERT INTO Category (id, name) VALUES (3, 'Odzież');
INSERT INTO Category (id, name) VALUES (4, 'Meble');
INSERT INTO Category (id, name) VALUES (5, 'Akcesoria');
INSERT INTO Category (id, name) VALUES (6, 'Zabawki');

INSERT INTO Role (role_id, role) VALUES (1, 'ROLE_USER');



INSERT INTO USER (id, login,email,password,enabled) VALUES (1, 'linuxgt','linuxgt@gmail.com','$2a$12$64Qtds/2pEUfR8TIbSHWtunZtYQAxm51UBd6Pp026L3cQTNg/8BRi',1);

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);




INSERT INTO DONATION (id, quantity,street,city,zip_code,phone,pick_up_date,pick_up_time,pick_up_comment,institution_id,user_id,delivered) VALUES (1, 1,'Motycka 23/2','Warszawa','03-566','743444222','2022-01-01','11:11','po prawej stronie od budynku',1,1,false);
INSERT INTO DONATION (id, quantity,street,city,zip_code,phone,pick_up_date,pick_up_time,pick_up_comment,institution_id,user_id,delivered) VALUES (2, 2,'Powstańców','Ząbki','05-764','6566677676','2022-03-04','10:01','zadzwonić w domofon',2,1,false);
INSERT INTO DONATION (id, quantity,street,city,zip_code,phone,pick_up_date,pick_up_time,pick_up_comment,institution_id,user_id,delivered) VALUES (3, 4,'Jana Pawła II','Katowice','00-141','65376756765','2022-03-02','19:00','brak',3,1,true);
INSERT INTO DONATION (id, quantity,street,city,zip_code,phone,pick_up_date,pick_up_time,pick_up_comment,institution_id,user_id,delivered) VALUES (4, 1,'Jasna','Rzeszów','41-231','677331643','2023-07-11','11:00','brak',4,null ,false);
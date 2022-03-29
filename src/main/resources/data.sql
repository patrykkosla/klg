
INSERT INTO USER (USER_NAME ) VALUES
('Jan'),
('Dan'),
('Ban'),
('Stefan'),
('Olga'),
('Aleksandra'),
('Dagmara');

INSERT INTO FACILITIES (facility_name, price_per_day,  property_area, OWNER_USER_ID,  descryption   ) VALUES
('Vila Karpatia' , 222,   22, 5 ,  'Possimus nobis ex molestias. Eveniet consequatur sit quos. Deleniti veritatis quo est minus. Libero est ut suscipit quasi hic amet. Voluptate fugiat maiores soluta velit rerum'),
('Pole' , 221,   2,  5 ,  'Possimus nobis ex molestias. Eveniet consequatur sit quos. Deleniti veritatis quo est minus. Libero est ut suscipit quasi hic amet. Voluptate fugiat maiores soluta velit rerum.'),
('Vila Prezydencka' , 223,   23, 5 ,   'Possimus nobis ex molestias. Eveniet consequatur sit quos. Deleniti veritatis quo est minus. Libero est ut suscipit quasi hic amet. Voluptate fugiat maiores soluta velit rerum.'),
('Magazyn' , 224,   24, 6 ,   'Possimus nobis ex molestias. Eveniet consequatur sit quos. Deleniti veritatis quo est minus. Libero est ut suscipit quasi hic amet. Voluptate fugiat maiores soluta velit rerum.'),
('Vila Stefana' , 225,   2,  6 ,    'Possimus nobis ex molestias. Eveniet consequatur sit quos. Deleniti veritatis quo est minus. Libero est ut suscipit quasi hic amet. Voluptate fugiat maiores soluta velit rerum.'),
('Hata' , 22,   2,  6 ,    'Possimus nobis ex molestias. Eveniet consequatur sit quos. Deleniti veritatis quo est minus. Libero est ut suscipit quasi hic amet. Voluptate fugiat maiores soluta velit rerum');

INSERT INTO RESERVATION (RESERVED_FROM, RESERVED_TO, FACILITY_ID, RESERVED_BY_USER_ID, ID, RESERVATION_COST  ) VALUES
('2021-11-22' ,'2021-11-27', 5, 1, 1, 100),
('2020-12-15' ,'2020-12-28', 5, 1, 2, 22),
('2022-02-15' ,'2022-03-18', 5, 1, 3, 2),
('2022-04-01' ,'2022-04-18', 5, 1, 4, 1123),
('2000-02-15' ,'2000-03-18', 2, 4, 5, 102);


INSERT INTO USER_USER_RESERVATIONS (USER_USER_ID,USER_RESERVATIONS_ID ) VALUES
(1,1),
(1,2),
(1,3),
(1,4);
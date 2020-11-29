-- product_type là loại sản phẩm: Lap,ram,ổ cứng,...
-- category là loại của sản phẩm: -Laptop: Gaming
-- 										   Văn phòng
-- 										   Cao cấp,..
-- 								  -RAM: DDR3,DDR3l, DDR4
-- 								  -Storage(ổ cứng): HDD, SSD
-- 								  -Keyboard: Văn phòng, gaming 
-- 								  -Mouse: Văn phòng, gaming 
-- Image:lưu ảnh: image: là link ảnh
-- manufacturer: hãng sx
-- product:  là sản phẩm. Mỗi sản phẩm có loại sản phẩm và sẽ ứng với 1 sản phẩm cụ thểalter

-- insert product type
			
INSERT INTO `laptopweb`.`product_type`(`id`,`name`)
VALUES
(1,'LAPTOP');
INSERT INTO `laptopweb`.`product_type`(`id`,`name`)
VALUES
(2,'RAM');
INSERT INTO `laptopweb`.`product_type`(`id`,`name`)
VALUES
(3,'STORAGE');
INSERT INTO `laptopweb`.`product_type`(`id`,`name`)
VALUES
(4,'KEYBOARD');
INSERT INTO `laptopweb`.`product_type`(`id`,`name`)
VALUES
(5,'MOUSE');

-- insert category
-- laptop
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(6,'Gaming',1);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(7,'Văn phòng',1);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(8,'Cao cấp',1);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(9,'Máy trạm',1);
-- ram
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(10,'DDR3',2);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(11,'DDR3L',2);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(12,'DDR4',2);
-- storage
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(13,'HDD',3);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(14,'SSD',3);
-- keyboard
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(15,'Gaming',4);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(16,'Văn phòng',4);
-- mouse
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(17,'Gaming',5);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(18,'Văn phòng',5);
-- insert IMAGE
-- LAPTOP
-- DELL
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(19,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ADell_Logo.svg&psig=AOvVaw31dM1l8FQDSzLchj0YJQ35&ust=1606723043458000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIj8lfWjp-0CFQAAAAAdAAAAABA3');
-- ASUS
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(20,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.cleanpng.com%2Fpng-laptop-asus-db-central-computers-design-logo-asus-3320341%2F&psig=AOvVaw2WPHLto-f_GWe5qupdBqCv&ust=1606723128255000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMCU8Zykp-0CFQAAAAAdAAAAABAT');
-- ACER
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(21,'https://www.google.com/url?sa=i&url=https%3A%2F%2Flogos-download.com%2F3654-acer-logo-download.html&psig=AOvVaw0fCPO6M7NWTNpjQupk0E3Z&ust=1606723172287000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMj18rGkp-0CFQAAAAAdAAAAABAP');
-- LENOVO
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(22,'https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.vhv.rs%2Fdpng%2Fd%2F66-667371_lenovo-logo-png-transparent-png.png&imgrefurl=https%3A%2F%2Fwww.vhv.rs%2Fviewpic%2FoRowRm_lenovo-logo-png-transparent-png%2F&tbnid=-qKM0pUwNOvWqM&vet=12ahUKEwiY2o_HpKftAhVlE6YKHVf6ByoQMygLegUIARDaAQ..i&docid=vjRUh1_eV9XjuM&w=860&h=182&q=LENOVO%20logo%20png&ved=2ahUKEwiY2o_HpKftAhVlE6YKHVf6ByoQMygLegUIARDaAQ');
-- HP
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(23,'https://www.google.com/url?sa=i&url=https%3A%2F%2Ffreebiesupply.com%2Flogos%2Fhp-logo%2F&psig=AOvVaw1uM-CUK8k6hiqH8ZKprgNl&ust=1606723285198000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPieu-ekp-0CFQAAAAAdAAAAABAN');
-- APPLE
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(24,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fvi.wikipedia.org%2Fwiki%2FT%25E1%25BA%25ADp_tin%3AApple-logo.png&psig=AOvVaw2KCoXzowGWXvoXhhvYN3Sq&ust=1606723321106000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIDQ2Pikp-0CFQAAAAAdAAAAABAD');

-- RAM
-- SAMSUNG 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(25,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFile%3ASamsung_Logo.svg&psig=AOvVaw0QgS2k2sGQJ7dOVJIl7V27&ust=1606723945511000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOjf6aOnp-0CFQAAAAAdAAAAABAD');

-- Corsair
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(26,'https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fe%2Fe1%2FCorsair.svg%2F1200px-Corsair.svg.png&imgrefurl=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ACorsair.svg&tbnid=8mN4vLvQSXJ5fM&vet=12ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ..i&docid=KqbShNqWa-9IWM&w=1200&h=306&q=Corsair%20logo%20png&ved=2ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ');

-- Crucial
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(27,'https://www.google.com/url?sa=i&url=https%3A%2F%2F1000logos.net%2Fcrucial-logo%2F&psig=AOvVaw0te5B2LKvf8bPai_cNY4Dt&ust=1606723995836000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJivr7qnp-0CFQAAAAAdAAAAABAD');

-- G.Skill
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(28,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F565272190721172556%2F&psig=AOvVaw0ZWAT_wKqmTVBjSZTL8Qf1&ust=1606724015568000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJDE_cOnp-0CFQAAAAAdAAAAABAD');

-- Kingston
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(29,'https://www.google.com/url?sa=i&url=https%3A%2F%2F1000logos.net%2Fkingston-logo%2F&psig=AOvVaw1KFodn5qrZvKne_NR3Sb0F&ust=1606724032058000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJiUgsynp-0CFQAAAAAdAAAAABAb');

-- STORAGE
-- SAMSUNG
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(30,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFile%3ASamsung_Logo.svg&psig=AOvVaw0QgS2k2sGQJ7dOVJIl7V27&ust=1606723945511000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOjf6aOnp-0CFQAAAAAdAAAAABAD');

-- Corsair
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(31,'https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fe%2Fe1%2FCorsair.svg%2F1200px-Corsair.svg.png&imgrefurl=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ACorsair.svg&tbnid=8mN4vLvQSXJ5fM&vet=12ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ..i&docid=KqbShNqWa-9IWM&w=1200&h=306&q=Corsair%20logo%20png&ved=2ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ');

-- Crucial
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(32,'https://www.google.com/url?sa=i&url=https%3A%2F%2F1000logos.net%2Fcrucial-logo%2F&psig=AOvVaw0te5B2LKvf8bPai_cNY4Dt&ust=1606723995836000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJivr7qnp-0CFQAAAAAdAAAAABAD');

-- Gigabyte
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(33,'https://www.google.com/url?sa=i&url=https%3A%2F%2Ffreebiesupply.com%2Flogos%2Fgigabyte-logo-2%2F&psig=AOvVaw3pa3_3XYC_7pwQe5pFKgmu&ust=1606724298875000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICU1cqop-0CFQAAAAAdAAAAABAs');

-- Intel
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(34,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.stickpng.com%2Fimg%2Ficons-logos-emojis%2Ftech-companies%2Fintel-logo&psig=AOvVaw1Kt2pjgJA2DQulPA3e2kau&ust=1606724369429000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICqu-yop-0CFQAAAAAdAAAAABAD');

-- Kingston
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(35,'https://www.google.com/url?sa=i&url=https%3A%2F%2F1000logos.net%2Fkingston-logo%2F&psig=AOvVaw1KFodn5qrZvKne_NR3Sb0F&ust=1606724032058000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJiUgsynp-0CFQAAAAAdAAAAABAb');


-- Western Digital
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(36,'https://www.google.com/url?sa=i&url=https%3A%2F%2Flogos-download.com%2F4592-western-digital-logo-download.html&psig=AOvVaw14zUR3sm3ZZeb3zqMPKVCR&ust=1606724393328000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNihrPiop-0CFQAAAAAdAAAAABAJ');

-- MOUSE
-- LOGITECH
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(37,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F772367404817041681%2F&psig=AOvVaw1dyeQJOZfCeup2WRP7lLb-&ust=1606724811395000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKDSsL-qp-0CFQAAAAAdAAAAABAO');

-- RAZER
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(38,'https://www.google.com/url?sa=i&url=https%3A%2F%2Ffreebiesupply.com%2Flogos%2Frazer-logo%2F&psig=AOvVaw01SRD33VasGLsrCqL6GU5w&ust=1606724835140000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMi7rsqqp-0CFQAAAAAdAAAAABAq');
-- STEELSERIES
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(39,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFile%3ASteelseries-logo.png&psig=AOvVaw271iAbMRSOTytOp0pst1IO&ust=1606724878949000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICHst-qp-0CFQAAAAAdAAAAABAD');
-- CORSAIR
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(40,'https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fe%2Fe1%2FCorsair.svg%2F1200px-Corsair.svg.png&imgrefurl=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ACorsair.svg&tbnid=8mN4vLvQSXJ5fM&vet=12ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ..i&docid=KqbShNqWa-9IWM&w=1200&h=306&q=Corsair%20logo%20png&ved=2ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ');

-- DARE U 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(41,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dareu.co.id%2Fgaming%2Fmouse%2Fdareu-lm115g%2F&psig=AOvVaw37kcd4P1Vl5-ZSv7yzpd4D&ust=1606724895097000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPj9j-eqp-0CFQAAAAAdAAAAABAq');
-- FUHLEN
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(42,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fseeklogo.com%2Fvector-logo%2F349367%2Ffuhlen&psig=AOvVaw12YWvwLo6hemfpD6pmhtNc&ust=1606724929212000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCODCn_eqp-0CFQAAAAAdAAAAABAI');
-- AKKO
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(43,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.akkogear.com%2F&psig=AOvVaw2EYTg5xp0lH7C1-xT_1XfD&ust=1606724944651000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMD96f6qp-0CFQAAAAAdAAAAABAD');

-- INSERT HÃNG LAPTOP
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(44,'DELL','MỸ',19,1);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(45,'ASUS','ĐÀI LOAN',20,1);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(46,'ACER','ĐỨC',21,1);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(47,'LENOVO','TRUNG QUỐC',22,1);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(48,'HP','MỸ',23,1);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(49,'APPLE','MỸ',24,1);

-- INSERT HÃNG RAM
-- SAMSUNG 
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(50,'SAMSUNG','HÀN QUỐC',25,2);
-- Corsair
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(51,'CORSAIR','MỸ',26,2);
-- Crucial
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(52,'CRUCIAL','TRUNG QUỐC',27,2);
-- G.Skill
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(53,'G.SKILL','TRUNG QUỐC',28,2);
-- Kingston
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(54,'KINGSTON','TRUNG QUỐC',29,2);

-- INSERT HANG O CUNG
-- SAMSUNG
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(55,'SAMSUNG','HÀN QUỐC',30,3);
-- CORSAIR
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(56,'CORSAIR','MỸ',31,3);
-- CRUCIAL
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(57,'CRUCIAL','TRUNG QUỐC',32,3);
-- GIGABYTE
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(58,'GIGABYTE','ĐÀI LOAN',33,3);
-- INTEL
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(59,'INTEL','MỸ',34,3);
-- KINGSTON
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(60,'KINGSTON','TRUNG QUỐC',35,3);
-- WESTERN DIGITAL
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(61,'WESTERN DIGITAL','TRUNG QUỐC',36,3);

-- INSERT CHUỘT
-- LOGITECH
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(62,'LOGITECH','THỤY SĨ',37,5);
-- RAZER
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(63,'RAZER','MỸ',38,5);
-- STEELSERIES
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(64,'STEELSERIES','MỸ',39,5);
-- CORSAIR
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(65,'CORSAIR','MỸ',40,5);
-- DARE U 
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(66,'KINGSTON','TRUNG QUỐC',41,5);
-- FUHLEN
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(67,'DARE U ','TRUNG QUỐC',42,5);
-- AKKO
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(68,'AKKO','TRUNG QUỐC',43,5);














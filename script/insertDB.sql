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
(100001,'LAPTOP');
INSERT INTO `laptopweb`.`product_type`(`id`,`name`)
VALUES
(100002,'RAM');
INSERT INTO `laptopweb`.`product_type`(`id`,`name`)
VALUES
(100003,'STORAGE');
INSERT INTO `laptopweb`.`product_type`(`id`,`name`)
VALUES
(100004,'KEYBOARD');
INSERT INTO `laptopweb`.`product_type`(`id`,`name`)
VALUES
(100005,'MOUSE');

-- insert category
-- laptop
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(100001,'Gaming',100001);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(100002,'Văn phòng',100001);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(100003,'Cao cấp',100001);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(100004,'Máy trạm',100001);
-- ram
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(100005,'DDR3',100002);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(100006,'DDR3L',100002);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(100007,'DDR4',100002);
-- storage
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(100008,'HDD',100003);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(100009,'SSD',100003);
-- keyboard
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(1000010,'Gaming',100004);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(1000011,'Văn phòng',100004);
-- mouse
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(1000012,'Gaming',100005);
INSERT INTO `laptopweb`.`category`(`id`,`name`,`id_product_type`)
VALUES
(1000013,'Văn phòng',100005);

-- insert IMAGE
-- LAPTOP
-- DELL
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(100001,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ADell_Logo.svg&psig=AOvVaw31dM1l8FQDSzLchj0YJQ35&ust=1606723043458000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIj8lfWjp-0CFQAAAAAdAAAAABA3');
-- ASUS
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(100002,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.cleanpng.com%2Fpng-laptop-asus-db-central-computers-design-logo-asus-3320341%2F&psig=AOvVaw2WPHLto-f_GWe5qupdBqCv&ust=1606723128255000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMCU8Zykp-0CFQAAAAAdAAAAABAT');
-- ACER
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(100003,'https://www.google.com/url?sa=i&url=https%3A%2F%2Flogos-download.com%2F3654-acer-logo-download.html&psig=AOvVaw0fCPO6M7NWTNpjQupk0E3Z&ust=1606723172287000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMj18rGkp-0CFQAAAAAdAAAAABAP');
-- LENOVO
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(100004,'https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.vhv.rs%2Fdpng%2Fd%2F66-667371_lenovo-logo-png-transparent-png.png&imgrefurl=https%3A%2F%2Fwww.vhv.rs%2Fviewpic%2FoRowRm_lenovo-logo-png-transparent-png%2F&tbnid=-qKM0pUwNOvWqM&vet=12ahUKEwiY2o_HpKftAhVlE6YKHVf6ByoQMygLegUIARDaAQ..i&docid=vjRUh1_eV9XjuM&w=860&h=182&q=LENOVO%20logo%20png&ved=2ahUKEwiY2o_HpKftAhVlE6YKHVf6ByoQMygLegUIARDaAQ');
-- HP
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(100005,'https://www.google.com/url?sa=i&url=https%3A%2F%2Ffreebiesupply.com%2Flogos%2Fhp-logo%2F&psig=AOvVaw1uM-CUK8k6hiqH8ZKprgNl&ust=1606723285198000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPieu-ekp-0CFQAAAAAdAAAAABAN');
-- APPLE
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(100006,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fvi.wikipedia.org%2Fwiki%2FT%25E1%25BA%25ADp_tin%3AApple-logo.png&psig=AOvVaw2KCoXzowGWXvoXhhvYN3Sq&ust=1606723321106000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIDQ2Pikp-0CFQAAAAAdAAAAABAD');

-- RAM
-- SAMSUNG 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(100007,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFile%3ASamsung_Logo.svg&psig=AOvVaw0QgS2k2sGQJ7dOVJIl7V27&ust=1606723945511000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOjf6aOnp-0CFQAAAAAdAAAAABAD');

-- Corsair
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(100008,'https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fe%2Fe1%2FCorsair.svg%2F1200px-Corsair.svg.png&imgrefurl=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ACorsair.svg&tbnid=8mN4vLvQSXJ5fM&vet=12ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ..i&docid=KqbShNqWa-9IWM&w=1200&h=306&q=Corsair%20logo%20png&ved=2ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ');

-- Crucial
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(100009,'https://www.google.com/url?sa=i&url=https%3A%2F%2F1000logos.net%2Fcrucial-logo%2F&psig=AOvVaw0te5B2LKvf8bPai_cNY4Dt&ust=1606723995836000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJivr7qnp-0CFQAAAAAdAAAAABAD');

-- G.Skill
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000010,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F565272190721172556%2F&psig=AOvVaw0ZWAT_wKqmTVBjSZTL8Qf1&ust=1606724015568000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJDE_cOnp-0CFQAAAAAdAAAAABAD');

-- Kingston
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000011,'https://www.google.com/url?sa=i&url=https%3A%2F%2F1000logos.net%2Fkingston-logo%2F&psig=AOvVaw1KFodn5qrZvKne_NR3Sb0F&ust=1606724032058000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJiUgsynp-0CFQAAAAAdAAAAABAb');

-- STORAGE
-- SAMSUNG
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000012,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFile%3ASamsung_Logo.svg&psig=AOvVaw0QgS2k2sGQJ7dOVJIl7V27&ust=1606723945511000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOjf6aOnp-0CFQAAAAAdAAAAABAD');

-- Corsair
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000013,'https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fe%2Fe1%2FCorsair.svg%2F1200px-Corsair.svg.png&imgrefurl=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ACorsair.svg&tbnid=8mN4vLvQSXJ5fM&vet=12ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ..i&docid=KqbShNqWa-9IWM&w=1200&h=306&q=Corsair%20logo%20png&ved=2ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ');

-- Crucial
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000014,'https://www.google.com/url?sa=i&url=https%3A%2F%2F1000logos.net%2Fcrucial-logo%2F&psig=AOvVaw0te5B2LKvf8bPai_cNY4Dt&ust=1606723995836000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJivr7qnp-0CFQAAAAAdAAAAABAD');

-- Gigabyte
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000015,'https://www.google.com/url?sa=i&url=https%3A%2F%2Ffreebiesupply.com%2Flogos%2Fgigabyte-logo-2%2F&psig=AOvVaw3pa3_3XYC_7pwQe5pFKgmu&ust=1606724298875000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICU1cqop-0CFQAAAAAdAAAAABAs');

-- Intel
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000016,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.stickpng.com%2Fimg%2Ficons-logos-emojis%2Ftech-companies%2Fintel-logo&psig=AOvVaw1Kt2pjgJA2DQulPA3e2kau&ust=1606724369429000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICqu-yop-0CFQAAAAAdAAAAABAD');

-- Kingston
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000017,'https://www.google.com/url?sa=i&url=https%3A%2F%2F1000logos.net%2Fkingston-logo%2F&psig=AOvVaw1KFodn5qrZvKne_NR3Sb0F&ust=1606724032058000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJiUgsynp-0CFQAAAAAdAAAAABAb');


-- Western Digital
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000018,'https://www.google.com/url?sa=i&url=https%3A%2F%2Flogos-download.com%2F4592-western-digital-logo-download.html&psig=AOvVaw14zUR3sm3ZZeb3zqMPKVCR&ust=1606724393328000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNihrPiop-0CFQAAAAAdAAAAABAJ');

-- MOUSE
-- LOGITECH
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000019,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F772367404817041681%2F&psig=AOvVaw1dyeQJOZfCeup2WRP7lLb-&ust=1606724811395000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKDSsL-qp-0CFQAAAAAdAAAAABAO');

-- RAZER
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000020,'https://www.google.com/url?sa=i&url=https%3A%2F%2Ffreebiesupply.com%2Flogos%2Frazer-logo%2F&psig=AOvVaw01SRD33VasGLsrCqL6GU5w&ust=1606724835140000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMi7rsqqp-0CFQAAAAAdAAAAABAq');
-- STEELSERIES
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000021,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFile%3ASteelseries-logo.png&psig=AOvVaw271iAbMRSOTytOp0pst1IO&ust=1606724878949000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICHst-qp-0CFQAAAAAdAAAAABAD');
-- CORSAIR
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000022,'https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fe%2Fe1%2FCorsair.svg%2F1200px-Corsair.svg.png&imgrefurl=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ACorsair.svg&tbnid=8mN4vLvQSXJ5fM&vet=12ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ..i&docid=KqbShNqWa-9IWM&w=1200&h=306&q=Corsair%20logo%20png&ved=2ahUKEwiHpuarp6ftAhVD7ZQKHXCNC8wQMygAegUIARCiAQ');

-- DARE U 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000023,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dareu.co.id%2Fgaming%2Fmouse%2Fdareu-lm115g%2F&psig=AOvVaw37kcd4P1Vl5-ZSv7yzpd4D&ust=1606724895097000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPj9j-eqp-0CFQAAAAAdAAAAABAq');
-- FUHLEN
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000024,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fseeklogo.com%2Fvector-logo%2F349367%2Ffuhlen&psig=AOvVaw12YWvwLo6hemfpD6pmhtNc&ust=1606724929212000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCODCn_eqp-0CFQAAAAAdAAAAABAI');
-- AKKO
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1000025,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.akkogear.com%2F&psig=AOvVaw2EYTg5xp0lH7C1-xT_1XfD&ust=1606724944651000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMD96f6qp-0CFQAAAAAdAAAAABAD');







-- INSERT HÃNG LAPTOP
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(100001,'DELL','MỸ',100001,100001);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(100002,'ASUS','ĐÀI LOAN',100002,100001);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(100003,'ACER','ĐỨC',100003,100001);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(100004,'LENOVO','TRUNG QUỐC',100004,100001);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(100005,'HP','MỸ',100005,100001);
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(100006,'APPLE','MỸ',100006,100001);

-- INSERT HÃNG RAM
-- SAMSUNG 
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(100007,'SAMSUNG','HÀN QUỐC',100007,100002);
-- Corsair
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(100008,'CORSAIR','MỸ',100008,100002);
-- Crucial
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(100009,'CRUCIAL','TRUNG QUỐC',100009,100002);
-- G.Skill
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000010,'G.SKILL','TRUNG QUỐC',1000010,100002);
-- Kingston
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000011,'KINGSTON','TRUNG QUỐC',1000011,100002);

-- INSERT HANG O CUNG
-- SAMSUNG
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000012,'SAMSUNG','HÀN QUỐC',1000012,100003);
-- CORSAIR
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000013,'CORSAIR','MỸ',1000013,100003);
-- CRUCIAL
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000014,'CRUCIAL','TRUNG QUỐC',1000014,100003);
-- GIGABYTE
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000015,'GIGABYTE','ĐÀI LOAN',1000015,100003);
-- INTEL
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000016,'INTEL','MỸ',1000016,100003);
-- KINGSTON
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000017,'KINGSTON','TRUNG QUỐC',1000017,100003);
-- WESTERN DIGITAL
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000018,'WESTERN DIGITAL','TRUNG QUỐC',1000018,100003);

-- INSERT CHUỘT
-- LOGITECH
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000019,'LOGITECH','THỤY SĨ',1000019,100005);
-- RAZER
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000020,'RAZER','MỸ',1000020,100005);
-- STEELSERIES
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000021,'STEELSERIES','MỸ',1000021,100005);
-- CORSAIR
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000022,'CORSAIR','MỸ',1000022,100005);
-- DARE U 
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000023,'KINGSTON','TRUNG QUỐC',1000023,100005);
-- FUHLEN
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000024,'DARE U ','TRUNG QUỐC',1000024,100005);
-- AKKO
INSERT INTO `laptopweb`.`manufacturer`(`id`,`name`,`national`,`id_image`,`id_product_type`)
VALUES
(1000025,'AKKO','TRUNG QUỐC',1000025,100005);
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2001,'https://www.google.com/url?sa=i&url=https%3A%2F%2Flaptop88.vn%2Fmoi-100-full-box-laptop-asus-vivobook-d409da-ek152t-amd-ryzen-5%2Fp4941.html&psig=AOvVaw2T-sbPd8C_QQ-IqKdVWFDf&ust=1606808201218000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPi8q53hqe0CFQAAAAAdAAAAABAF');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2001,100,'Siver- Bạc','MoTa','Bảo hành 24 tháng','D409DA - EK095T','Asus Vivobook D409DA',8990000,'Hàng chính hãng','1.5 kg','2020-1-1',
100002,
2001,
100002,
100001);
INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2001,'Windows','	
32 WHrs Polymer Battery','AMD Ryzen™ R5-3500U','VGA Nvidia Geforce MX350','	
1 x USB Type-C,
2 x USB 3.0,
2 x USB 2.0,
1 x HDMI,
1 x Combo audio jack,
1 x MicroSD card reader,
1 x FingerPrint,
1 x Webcam,
1 x SonicMaster Audio™','1 x RAM Onboard + 1 slot RAM','14.1 inch FHD (1920x1080), viền mỏng, chống chói','1 slot SSD M.2 PCIe + 1 slot 2.5 inch',2001);

--
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2002,'https://bizweb.dktcdn.net/100/372/934/products/asus-vivobook-a412-laptopnew-5-09f0bfb0-2caf-4a86-b9c1-b7b8f9d7e9fa.jpg?v=1593415956437');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2002,100,'Xanh','MoTa','Bảo hành 24 tháng','A412FA-EK1187T ','Asus Vivobook A412FA',11190000,'Hàng chính hãng','1.5 kg','2020-1-1',
100002,
2002,
100002, 
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2002,'Windows','Thời gian sử dụng 3-5 giờ (Theo thông tin hãng Asus)','Intel® 8th - Core™ i3-10110U (2.1Ghz upto 3.9GHz, 2 Cores, 4 Threads, 4MB Cache, FSB 4GT/s)','Intel® UHD Graphics 620','1 x USB Type-C™,
1 x USB 3.1,
2 x USB 2.0,
1 x HDMI,
1 x MicroSD card reader,
1 x FingerPrint,
1 x Combo audio jack,
1 x Sonic Master Sound','	4GB DDR4 2400MHz / 2666MHz (1 x 4GB Onboard + 1 slot Ram)','14.1 inch FHD (1920x1080) Anti-Glare','	SSD 256GB',2002);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2003,'https://bizweb.dktcdn.net/100/372/934/products/asus-vivobook-a412.jpg?v=1603424902403');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2003,100,'Trắng','MoTa','Bảo hành 24 tháng','TP412FA - EC599T','Asus Vivobook TP412FA', 12650000,'Hàng chính hãng','1.5 kg','2020-1-1',
100002,
2003,
100002,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2003,'Windows','3 Cells 42Whrs','Intel Core i3-10110U (2.1Ghz upto 4.10GHz, 2 Cores, 4 Threads, 4MB Cache, FSB 4GT/s)','Intel® UHD Graphics','1x HDMI 1.4 1x 3.5mm,
2x USB 2.0 Type-A ,
1x USB 3.2 Gen 1 Type-A ,
1x USB 3.2 Gen 1 Type-C','4GB DDR4 Bus 2666GHZ','14 inch FHD (1920 x 1080) Glare TP WV Cảm ứng đa điểm','SSD 512GB M.2 PCIe Gen 3*2',2003);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2004,'https://bizweb.dktcdn.net/100/372/934/products/asus-vivobook-a412-laptopnew-5-09f0bfb0-2caf-4a86-b9c1-b7b8f9d7e9fa.jpg?v=1593415956437');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2004,100,'Xanh','MoTa','Bảo hành 24 tháng','A412FA-EK1187T','Asus Vivobook A412FA',11190000,'Hàng chính hãng','1.5 Kg','2020-1-1',
100002,
2004,
100002,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2004,'Windows','Thời gian sử dụng 3-5 giờ (Theo thông tin hãng Asus)','ntel® 8th - Core™ i3-10110U (2.1Ghz upto 3.9GHz, 2 Cores, 4 Threads, 4MB Cache, FSB 4GT/s)','Intel® UHD Graphics 620','1 x USB Type-C™,
1 x USB 3.1,
2 x USB 2.0,
1 x HDMI,
1 x MicroSD card reader,
1 x FingerPrint,
1 x Combo audio jack,
1 x Sonic Master Sound','4GB DDR4 2400MHz / 2666MHz (1 x 4GB Onboard + 1 slot Ram)','14.1 inch FHD (1920x1080) Anti-Glare','SSD 256GB',2004);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2005,'https://bizweb.dktcdn.net/100/372/934/products/asus-a412fj-ek149t-5678b0ad-6d07-4fc5-9fd5-7985081055ae-2d821649-1f35-45d5-9809-93231f303df1-26b937e8-de78-48b5-ab60-154ebd5ce7f7.png?v=1593070593703');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2005,100,'Trắng','MoTa','Bảo hành 24 tháng','A412FJ-EK387T','Asus Vivobook A412FJ',16850000,'Hàng chính hãng','1.5 Kg','2020-1-1',
100002,
2005,
100002,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2005,'Windows','Thời gian sử dụng 3-5 giờ (Theo thông tin hãng Asus)','Intel Core i5-10210U Processor (4 x 1.60 GHz), Max Turbo Frequency : 4.20 GHz','NVIDIA GeForce MX230 2GB GDDR5 + Intel® UHD Graphics','1 x USB Type-C™,
1 x USB 3.1,
2 x USB 2.0,
1 x HDMI,
1 x MicroSD card reader,
1 x FingerPrint,
1 x Combo audio jack,
1 x Sonic Master Sound','8GB DDR4 2400MHz / 2666MHz','14.1 inch FHD (1920x1080) Anti-Glare','	SSD 512GB M.2 PCIe + 1 Slot SSD / HDD 2.5 inch',2005);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2006,'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FASUS-IPS-Type-GeForce-Gigabit-FA506IH-AS53%2Fdp%2FB0865THZCL&psig=AOvVaw3s2duvFL8cWtY98HGlQ_nG&ust=1606810252491000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMiM0OToqe0CFQAAAAAdAAAAABAD');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2006,100,'Xám xanh','MoTa','Bảo hành 24 tháng','A15 FA506IH - AL018T','Asus TUF GAMING A15 FA506IH', 18990000,'Hàng chính hãng','2.3 kg','2020-1-1',
100001,
2006,
100002,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2006,'Windows','	
Thời gian sử dụng 3-5giờ (Theo thông tin hãng Asus)','AMD Ryzen R5-4600H (3.0GHz upto 4.0GHz, 6 Cores, 12 Threads, 8MB Cache)','Nvidia GeForce GTX 1650 4GB GDDR6 + AMD Radeon™ Graphics','2 x USB 3.1,
1 x USB TypeC,
1 x HDMI,
1 x headphone / microphone combo jack,
1 x LAN RJ45,
1 x microSD Card Reader,
1 x Webcam HD 720p,
1 x DTS:X® Ultra Audio™,
1 x AC Power adapter jack','8GB DDR4 3200 (2 slot Ram)','15.6 FHD IPS (1920x1080) with 144Hz, viền mỏng, chống chói','SSD M.2 512GB PCIe + 1 slot 2.5 inch',2006);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2007,'https://bizweb.dktcdn.net/100/372/934/products/laptopnew-asus-tuf-gaming-f15-fx506-1-b9401d16-4b3a-4374-b147-20af04a54214.jpg?v=1606486869773');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2007,100,'Gun Metal','MoTa','Bảo hành 24 tháng','F15 FX506LI - HN039T','Asus TUF GAMING F15 FX506LI',20990000,'Hàng chính hãng','2.2 kg','2020-1-1',
100001,
2007,
100002,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2007,'Windows','48WHrs Li-ion Battery','Intel® i5-10300H Gen 10th (2.5GHz upto 4.5GHz, 4 Cores, 8 Threads, 8MB Cache, FSB 8GT/s)','Nvidia GeForce GTX 1650Ti 4GB GDDR6 + Inter UHD Graphics','2 x USB 3.1,
1 x USB TypeC,
1 x HDMI,
1 x headphone / microphone combo jack,
1 x LAN RJ45,
1 x microSD Card Reader,
1 x Webcam HD 720p,
1 x DTS:X® Ultra Audio™,
1 x AC Power adapter jack','8GB DDR4 2933MHz (2 slots)','15.6 FHD IPS (1920x1080) with 144Hz, viền mỏng, chống chói','	
SSD 512GB M.2 PCIe (1 slot SSD M.2 + 1 slot 2.5 inch)',2007);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2008,'https://bizweb.dktcdn.net/thumb/1024x1024/100/372/934/products/laptopnew-asus-rog-g531-2-3d45966e-9c5f-450d-a881-447221421afd.jpg?v=1605355692553');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2008,100,'Đen huyền','MoTa','Bảo hành 24 tháng','G512 - IAL001T','Asus ROG Strix G512',25990000,'Hàng chính hãng','2.3 kg','2020-1-1',
100001,
2008,
100002,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2008,'Windows','Thời gian sử dụng 3-5giờ (Theo thông tin hãng Asus)','Intel® i7-10750H Gen 10th (2.6GHz upto 5.0GHz, 6 Cores, 12 Threads, 12MB Cache, FSB 8GT/s)','Nvidia GeForce GTX 1650Ti 4GB GDDR6 + Intel® UHD Graphics','3 x USB 3.1,
1 x USB TypeC,
1 x HDMI,
1 x headphone / microphone combo jack,
1 x LAN RJ45,
1 x microSD Card Reader,
1 x Webcam HD 720p,
1 x Smart AMPart AMP Audio™,
1 x AC Power adapter jack','8GB DDR4 3200MHz (2 slot RAM)','15.6 FHD IPS (1920x1080) with 144Hz, viền mỏng, chống chói','SSD 512GB M.2 PCIe (3 slot SSD M.2)',2008);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2009,'https://bizweb.dktcdn.net/100/372/934/products/zenbook-duo-3.png?v=1589803200063');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2009,100,'Đen','MoTa','Bảo hành 24 tháng','UX481FL-BM048T','Asus Zenbook Duo UX481FL', 27990000,'Hàng chính hãng','1.9kg','2020-1-1',
100003,
2009,
100002,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2009,'Windows','Thời gian sử dụng 8-10 giờ (Theo thông tin hãng Asus)','Intel® Core™ i5-10210U (1.6GHz upto 4.2GHz, 4 Cores, 8 Threads, 6MB Cache, FSB 4GT/s)','NVIDIA Geforce MX250 2GB GDDR5 + Intel UHD Graphics','1x USB 3.1 Gen 2 Type-C™,
2 x USB 3.1','8GB LPDDR3 2133MHz','14.1 inch FHD IPS (1920 x 1080) IPS, 72% NTSC, 100% sRGB','SSD 512GB M.2 PCIe',2009);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2010,'https://bizweb.dktcdn.net/thumb/1024x1024/100/372/934/products/asus-rog-strix-g17-g712l-vev055t-7-8da17539-ec9b-4b53-966d-282d54cc478f.jpg?v=1605068174260');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2010,100,'Đen','MoTa','Bảo hành 24 tháng','G712L - UEV075T','ASUS ROG STRIX G17 G712L',32790000,'Hàng chính hãng','2.85 kg','2020-1-1',
100001,
2010,
100002,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2010,'Windows','Thời gian sử dụng 3-5giờ (Theo thông tin hãng Asus)','Intel® i7-10750H Gen 10th (2.6GHz upto 5.0GHz, 6 Cores, 12 Threads, 12MB Cache, FSB 8GT/s)','Nvidia GeForce GTX 1660Ti 6GB GDDR6 + Intel® UHD Graphics','3 x USB 3.1,
1 x USB TypeC,
1 x HDMI,
1 x headphone / microphone combo jack,
1 x LAN RJ45,
1 x microSD Card Reader,
1 x Webcam HD 720p,
1 x Smart AMPart AMP Audio™,
1 x AC Power adapter jack','16GB DDR4 3200MHz (2 slot RAM)','17.3 FHD IPS (1920x1080) with 144Hz, viền mỏng, chống chói','SSD 512GB M.2 PCIe (3 slot SSD M.2)',2010);
-- 
-- Laptop HP
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2011,'https://bizweb.dktcdn.net/100/372/934/products/hp-probook-430-g7.jpg?v=1587005256293');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2011,100,'Trắng','MoTa','Bảo hành 12 tháng','430 G7-9GQ10PA','HP Probook 430 G7',12900000,'Hàng chính hãng','1.49 kg','2020-1-1',
100002,
2011,
100005,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2011,'Windows','3-cell','Intel Core i3-10110U 2.10 GHz up to 4.1GHz, 4MB','Intel UHD Graphics 620','3 x USB 3.1','4GB DDR4','13.3" HD','256GB SSD',2011);

-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2012,'https://bizweb.dktcdn.net/100/372/934/products/637172701408666719hppavilionx3.png?v=1604153196857');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2012,100,'Bạc','MoTa','Bảo hành 12 tháng','x360 14 - dh1137TU','HP Pavilion x360',13290000,'Hàng chính hãng','1.58 kg','2020-1-1',
100002,
2012,
100005,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2012,'Windows','3 Cell 41.7WHr','Intel Core i3-10110U 2.1GHz up to 4.1GHz 4MB','Intel UHD Graphics','1x USB 3.1 Gen 1 Type-C™,
2x USB 3.1 Gen 1 Type-A,
1x AC smart pin,
1x HDMI 1.4,
1x headphone/microphone combo','4GB DDR4 2666MHz','14" FHD (1920 x 1080) IPS with 45% NTSC, Micro-Edge WLED-Backlit + Multi-Touch, 250nits','256GB PCIe® NVMe™ M.2 SSD',2012);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2013,'https://bizweb.dktcdn.net/100/372/934/products/085f669f855ce4fd2d6c6479e46aed75-99c487b3-8570-4962-b0ac-17ecc60db9bc-bbbaa96d-ee75-4d75-8d21-84dae38fe0f6.png?v=1604152847440');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2013,100,'Bạc','MoTa','Bảo hành 12 tháng','Pavilion 14 - ce3018TU','HP Pavilion',14750000,'Hàng chính hãng','	1.6 kg','2020-1-1',
100002,
2013,
100005,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2013,'Windows','3 cell','Intel Core i5-1035G1 1.0GHz-6MB','Intel Graphics UHD','1 USB 3.1 Gen 1 Type-C™ (Data Transfer Only, 5 Gb/s signaling rate); 2 USB 3.1 Gen 1 Type-A (Data Transfer Only); 1 AC smart pin; 1 HDMI 1.4b; 1 headphone/microphone combo; 1 RJ-45','4Gb (DDR4-2666 SDRAM)','14.0Inch Full HD','256GB SSD',2013);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2014,'https://bizweb.dktcdn.net/thumb/1024x1024/100/372/934/products/e94c02ef1ea65c896a832944f58cdcdd-c69ad1f2-b1a4-4082-914a-e1923c83520f-a10847a9-b252-4466-9970-22f72abc3307-3cfdeee5-0718-4260-9cb1-79f30ec69bbc-f014f3db-9455-49d9-b4c7-5043b36786dc-4ad59bef-3671-4d67-ba12-3e7495179f5f.png?v=1587010515233');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2014,100,'Bạc','MoTa','Bảo hành 12 tháng','Probook 450 G7-9GQ26PA','HP Probook 450',28200000,'Hàng chính hãng','2.0 kg','2020-1-1',
100002,
2014,
100005,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2014,'Windows','3 Cell 45WHr','Intel Core i7-10510U 1.8GHz up to 4.9GHz 8MB','NVIDIA GeForce MX250 2GB GDDR5 + Intel UHD Graphics','1x USB 3.1 Type-C™ Gen 1 (Power delivery, DisplayPort™),
2x USB 3.1 Gen 1,
1x USB 2.0 (powered port),
1x HDMI 1.4b,
1x RJ-45,
Finger Print,
1x headphone/microphone combo,
1x AC power','16GB DDR4 2666MHz','15.6" FHD (1920 x 1080) IPS anti-glare WLED-backlit, 250 nits, 45% NTSC','512GB SSD M.2 PCIe',2014);
-- 
-- ACER
--
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2015,'https://bizweb.dktcdn.net/thumb/1024x1024/100/372/934/products/laptopnew-acer-nitro-5-rgb-2-7aae1883-b96b-4498-8b29-c06c662d5ac0-0e71e1f4-40cc-4a0d-b23a-770c5f28fb2a.png?v=1602223376563');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2015,100,'Đen','MoTa','Bảo hành 12 tháng','AN515-55-5923','Acer Nitro 5 AN515',21890000,'Hàng chính hãng','2.30 kg','2020-1-1',
100001,
2015,
100003,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2015,'Windows','4 Cell 57.5WHr','Intel® i5-10300H Gen 10th (2.5GHz upto 4.5GHz, 4 Cores, 8 Threads, 8MB Cache, FSB 8GT/s)','NVIDIA GeForce GTX 1650Ti 4GB GDDR6 + Intel UHD Graphics','3x USB 3.1 Gen 1, 1x USB 3.2 Gen 2 Type C, 1x HDMI, RJ45','8GB DDR4 2933MHz (2x SO-DIMM socket, up to 32GB SDRAM)','15.6-inch FHD IPS (1920x1080), 144Hz, Anti-Glare','512GB SSD M.2 PCIE (Còn trống 1 khe SSD M.2 PCIE và 1 khe 2.5" SATA)',2015);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2016,'https://bizweb.dktcdn.net/100/372/934/products/laptopnew-acer-predator-helios-2020-4.jpg?v=1602244968533');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2016,100,'Đen','MoTa','Bảo hành 12 tháng','Predator Helios PH315-53-770L','ACER Predator Helios',34990000,'Hàng chính hãng','2.30 kg','2020-1-1',
100001,
2016,
100003,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2016,'Windows','4 Cell 57.5WHr','Intel Core i7-10750H 2.6GHz up to 5.0GHz 12MB','NVIDIA GeForce GTX 1660Ti 6GB GDDR6 + Intel UHD Graphics','3x USB 3.1 Gen 1, 1x USB 3.2 Gen 2 Type C, 1x HDMI, RJ45','8GB DDR4 3200MHz (2x SO-DIMM socket, up to 32GB SDRAM)','15.6-inch FHD IPS (1920x1080), 144Hz, Anti-Glare','512GB SSD M.2 PCIE (Còn trống 1 khe SSD M.2 PCIE và 1 khe 2.5" SATA)',2016);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2017,'https://bizweb.dktcdn.net/100/372/934/products/laptopnew-acer-predator-triton-500-2020-1-95bcfa51-b459-4211-93aa-c8354e02e8c5.png?v=1602226147477');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2017,100,'Đen','MoTa','Bảo hành 12 tháng','Predator Triton 500 PT515-52-78PN','Acer Predator Triton',64990000,'Hàng chính hãng','2.2 kg','2020-1-1',
100001,
2017,
100003,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2017,'Windows','87WHrs','Intel® i7-10875H Gen 10th (2.3GHz upto 5.1GHz, 8 Cores, 16 Threads, 16MB Cache, FSB 8GT/s)','NVIDIA GeForce RTX 2070 Super 8GB GDDR6 + Intel UHD Graphics','3x USB 3.1 Gen 1, 1x USB 3.2 Gen 2 Type C, 1x HDMI, RJ45','32GB DDR4 3200MHz (2x SO-DIMM socket, up to 32GB SDRAM)','15.6-inch FHD IPS (1920x1080), 300Hz, Anti-Glare','SSD 1TB M.2 PCIe',2017);
-- 
-- MACBOOK
--
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2018,'https://product.hstatic.net/1000283534/product/mauxam_1_7ceb7b2a851b4b33b52bef8f61cacd3c_grande.jpeg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2018,100,'Gray','MoTa','Bảo hành 12 tháng','MWTL2SA/A/A','MacBook Air 13-inch',25499000,'Hàng chính hãng','1.3kg','2020-1-1',
100002,
2018,
100006,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2018,'Mac OS','Thời gian dùng pin lên đến 11h lướt web, thời gian standby 30 ngày, sạc 30W USB-C Power Adapter.','1.1GHz dual-core Intel Core i3, Turbo Boost up to 3.2GHz, with 4MB L3 cache','Intel Iris Plus Graphics','2x Thunderbolt 3 (USB-C)',' 8GB of 3733MHz LPDDR4X onboard memory','Retina display 13.3-inch (diagonal) LED-backlit display with IPS technology',' 256GB PCIe-based SSD',2018);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2019,'https://product.hstatic.net/1000283534/product/maubac_2_95a394e9ba384182b7e72a6710aa6950_grande.jpeg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2019,100,'Gray','MoTa','Bảo hành 12 tháng','MXK52SA/A','MacBook Pro 13"',37999000,'Hàng chính hãng','1.4kg','2020-1-1',
100003,
2019,
100006,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2019,'Mac OS','Thời gian dùng pin lên đến 10h lướt web, thời gian chờ 30 ngày, sạc 61W USB-C Power Adapter','1.4GHz quad‑core 8th‑generation Intel Core i5, Turbo Boost up to 3.9GHz, with 128MB of eDRAM','Intel Iris Plus Graphics 645','02 cổng USB-C','8GB of 2133MHz LPDDR3 onboard memory','Retina display, 13.3‑inch (diagonal) LED-backlit display with IPS technology',' 512GB SSD',2019);
-- 
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(2020,'https://product.hstatic.net/1000283534/product/maubac_1_eeb4b55f831942b3b4774c8d6584b12d_grande.jpeg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(2020,100,'Bạc','MoTa','Bảo hành 12 tháng','MVVM2SA/A','MacBook Pro 16-inch',68999000,'Hàng chính hãng','2kg','2020-1-1',
100003,
2020,
100006,
100001);

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(2020,'Mac OS','Thời gian dùng pin lên đến 11h lướt web và sử dụng iTunes, thời gian chờ 30 ngày, sạc 96W USB-C Power Adapter','2.3GHz 8‑core Intel Core i9, Turbo Boost up to 4.8GHz, with 16MB shared L3 cache','AMD Radeon Pro 5500M with 4GB of GDDR6 memory and automatic graphics switching, Intel UHD Graphics 630','4 cổng Thunderbolt 3 (USB-C)','16GB of 2666MHz DDR4 onboard memory','16‑inch (diagonal) LED‑backlit display with IPS technology','1TB SSD',2020);

-- 1001 Dell Inspiron 7490 6RKVN1--
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1001,'https://bizweb.dktcdn.net/100/372/934/products/laptop-dell-inspiron-7490-d52ced64-0ab2-4f2d-95ca-1ac5a9bbcf30.png');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1001,100,'Bạc','','Bảo hành 12 tháng','6RKVN1','Dell Inspiron 7490',33990000,'Hàng chính hãng','1.095','2020-1-1',
100002, -- CATEGORY (GAMING VAN PHONG) --
1001, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1001,'Windows 10 Home SL','4 Cell 52WHr','Intel Core i7-10510U 1.8GHz up to 4.9GHz 8MB','NVIDIA GeForce MX250 2GB GDDR5 + Intel UHD Graphics 620','1x 3.5 mm Headphone/Microphone,2x USB 3.1 Gen 1,1x Thunderbolt 3 (DP/Power Delivery) Type-C,1x HDMI 2.0','16GB LPDDR3 2133MHz','14" FHD (1920 x 1080) 300nits 100%sRGB','512GB PCIe NVMe',1001);

-- 1002 Dell Inspiron 7490 N4I5106W --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1002,'https://bizweb.dktcdn.net/100/372/934/products/laptop-dell-inspiron-7490-1.png');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1002,100,'Bạc','','Bảo hành 12 tháng','N4I5106W','Dell Inspiron 7490',29490000,'Hàng chính hãng','1.095','2020-1-1',
100002, -- CATEGORY (GAMING, VAN PHONG) --
1002, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1002,'Windows 10 Home SL','4 Cell 52WHr','Intel Core i5-10210U 1.6GHz up to 4.2GHz 6MB','NVIDIA GeForce MX250 2GB GDDR5 + Intel UHD Graphics 620','1x 3.5 mm Headphone/Microphone,2x USB 3.1 Gen 1,1x Thunderbolt 3 (DP/Power Delivery) Type-C,1x HDMI 2.0','8GB LPDDR3 2133MHz','14" FHD (1920 x 1080)','512GB PCIe NVMe',1002);

-- 1003 Dell Inspiron 5593 N5I5513W --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1003,'https://hanoicomputercdn.com/media/product/52588_dell_inspiron_5593__6_.jpg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1003,100,'Bạc','','Bảo hành 12 tháng','N5I5513W','Dell Inspiron 5593',17990000,'Hàng chính hãng','1.95','2020-1-1',
100002, -- CATEGORY (GAMING, VAN PHONG) --
1003, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1003,'Windows 10 Home SL','3 cell - 42Whr','Intel Core™ i5-1035G1 1.00 GHz upto 3.60 GHz','Nvidia MX230 2GB GDDR5 + Intel UHD Graphics 620','1x 3.5 mm Headphone/Microphone,1x USB 2.0 2x USB 3.0,1x HDMI 2.0','8GB DRR4 2666MHz','15.6" FHD (1920 x 1080) 300nits 100%sRGB','256GB PCIe NVMe',1003);

-- 1004 Dell Vostro 3590 - GRMGK2 --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1004,'https://cdn.tgdd.vn/Products/Images/44/220718/dell-vostro-3590-i7-grmgk2-220718-220718-600x600.jpg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1004,100,'Đen','','Bảo hành 12 tháng','GRMGK2','Dell Vostro 3590',20990000,'Hàng chính hãng','2.17','2020-1-1',
100002, -- CATEGORY (GAMING, VAN PHONG) --
1004, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1004,'Windows 10 Home SL','3 cell - 42Whr','Intel i7-10510U Gen 10th','AMD Radeon 610 2GB GDDR5 + Intel® UHD Graphics 620','1x HDMI,1x USB Type-C,2x USB 3.1,1x Jack Audio','8GB DRR4 2666MHz','15.6" FHD (1920 x 1080) 300nits 100%sRGB','256GB PCIe NVMe',1004);

-- 1005 Dell Vostro 5490 - V4I3101W --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1005,'https://laptop123.com.vn/upload/product/dell-vostro-5490.png');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1005,100,'Xám','','Bảo hành 12 tháng','V4I3101W','Dell Vostro 5490',14490000,'Hàng chính hãng','1.5','2020-1-1',
100002, -- CATEGORY (GAMING, VAN PHONG) --
1005, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1005,'Windows 10 Home SL','3 cell - 42Whr','Intel i3 - 10110U Gen 10th','Intel UHD Graphics 620','1x HDMI,1x USB 3.1 Gen 1 Type C,1x USB 3.1,USB 2.0,1x Jack Audio','4GB DRR4 2666MHz','15.6" FHD (1920 x 1080)','128GB SSD SATA',1005);

-- 1006 Dell Vostro 3591 - V5I3308W --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1006,'https://anphat.com.vn/media/product/34086_184860.jpg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1006,100,'Đen','','Bảo hành 12 tháng','V5I3308W','Dell Vostro 3591',11490000,'Hàng chính hãng','2.17','2020-1-1',
100002, -- CATEGORY (GAMING, VAN PHONG) --
1006, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1006,'Windows 10 Home SL','3 cell - 42Whr','Intel i3-1005G1 Gen 10th ','Intel UHD Graphics 620','1x HDMI,1x USB 3.1 Gen 1 Type C,2x USB 3.1,1x Jack Audio','4GB DRR4 2666MHz','15.6" FHD (1920 x 1080)','SSD 256GB M.2 PCIe',1006);

-- 1007 Dell Gaming G3 3500 - 70223130 --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1007,'https://nguyenvu.store/wp-content/uploads/2020-1-1/05/dell-g3-inspiron-3590-n5i5517w_991eef3478fc4948a52c0142edd3e57b_master.jpg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1007,100,'Đen','','Bảo hành 12 tháng','70223130','Dell Gaming G3 3500',22490000,'Hàng chính hãng','2.5','2020-1-1',
100001, -- CATEGORY (GAMING, VAN PHONG) --
1007, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1007,'Windows 10 Home SL','51WHrs Li-ion Battery','Intel i5-10300H Gen 10th','Nvidia GeForce GTX 1650 4GB GDDR6 + Intel UHD Graphics 620','1x HDMI,1x USB 3.1 Gen 1 Type C,3x USB 3.1,1x Headphone/micro combo jack','8GB DDR4 2933MHz','15.6 FHD WVA (1920x1080) with 120Hz','SSD 256GB M.2 PCIe + HDD 1TB 5400rpm',1007);


-- 1008 Dell Gaming G7 7500 - G7500B --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1008,'https://www.ankhang.vn/media/product/18497-dell-gaming-g7-7500-g7500b-4.jpg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1008,100,'Đen','','Bảo hành 12 tháng','G7500B','Dell Gaming G7 7500',38990000,'Hàng chính hãng','2.5','2020-1-1',
100001, -- CATEGORY (GAMING, VAN PHONG) --
1008, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1008,'Windows 10 Home SL','86WHrs Li-ion Battery','Intel i7-10750H Gen 10th (2.6GHz upto 5.0GHz, 6 Cores, 12 Threads)','Nvidia GeForce GTX 1660Ti 6GB GDDR6 + Intel UHD Graphics 620','1x ThunderBolt3,1x Mini DisplayPort,3x USB 3.1,1x USB TypeC,1x HDMI,1x Headphone / microphone combo jack','8GB DDR4 2933MHz','15.6 FHD WVA (1920x1080) with 144Hz','SSD 512GB M.2 PCIe',1008);

-- 1009 Dell Gaming G7 7500 - G7500A --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1009,'https://laptop123.com.vn/upload/product/dell-g7-7500-i7.png');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1009,100,'Đen','','Bảo hành 12 tháng','G7500A','Dell Gaming G7 7500',41990000,'Hàng chính hãng','2.5','2020-1-1',
100001, -- CATEGORY (GAMING, VAN PHONG) --
1009, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1009,'Windows 10 Home SL','86WHrs Li-ion Battery','Intel i7-10750H Gen 10th (2.6GHz upto 5.0GHz, 6 Cores, 12 Threads)','Nvidia GeForce RTX 2060 6GB GDDR6 + Intel UHD Graphics 620','1x ThunderBolt3,1x Mini DisplayPort,3x USB 3.1,1x USB TypeC,1x HDMI,1x Headphone / microphone combo jack','16GB DDR4 2933MHz','15.6 FHD WVA (1920x1080) with 144Hz','SSD 512GB M.2 PCIe',1009);


-- 1010 Dell XPS 15 7590-70196707 --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1010,'https://anphat.com.vn/media/product/30823_laptop_dell_xps_15_7590_70196707_1.jpeg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1010,100,'Bạc','','Bảo hành 12 tháng','70196707','Dell XPS 15 7590',47990000,'Hàng chính hãng','1.9','2020-1-1',
100003, -- CATEGORY (GAMING, VAN PHONG) --
1010, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1010,'Windows 10 Home SL','6 Cells 97 Whrs Battery','Intel Core™ i7 9750H Processor','NVIDIA GeForce GTX1650 4GB GDDR5 + Intel UHD Graphics 620','2x Thunderbolt 3(Power Delivery & DisplayPort),2x USB-C 3.1 (Power Delivery & DisplayPort),1x Headset jack','16GB DDR4 2666Mhz','15.6 Full HD IPS (1920 x 1080) Infinity Edge, 100% sRGB 500 Nits','SSD 512GB M.2 PCIe',1010);

-- 1011 Dell XPS 15 7590-70196708 --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1011,'https://anphat.com.vn/media/product/30823_laptop_dell_xps_15_7590_70196707_1.jpeg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1011,100,'Bạc','','Bảo hành 12 tháng','70196708','Dell XPS 15 7590',54990000,'Hàng chính hãng','1.9','2020-1-1',
100003, -- CATEGORY (GAMING, VAN PHONG) --
1011, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1011,'Windows 10 Home SL','6 Cells 97 Whrs Battery','Intel Core i7 9750H Processor','NVIDIA GeForce GTX1650 4GB GDDR5 + Intel UHD Graphics 620','2x Thunderbolt 3(Power Delivery & DisplayPort),2x USB-C 3.1 (Power Delivery & DisplayPort),1x Headset jack','16GB DDR4 2666Mhz','15.6 4K Ultra HD (3840 x 2160) OLED Infinity Edge, 100% DCI P3 400 Nits','SSD 512GB M.2 PCIe',1011);

-- 1012 Dell XPS 15 9500 - 70221010 --
INSERT INTO `laptopweb`.`image`
(`id`,`image`)
VALUES
(1012,'https://phucanhcdn.com/media/product/39973_laptop_dell_xps_15_9500_ha3.jpg');

INSERT INTO `laptopweb`.`product`(`id`,`amount`,`color`,`description`,`guarantee`,`model_code`,`name`,`price`,`status`,`weight`,`year`,`id_category`,`id_image`,`id_manufacturer`,`id_product_type`)
VALUES
(1012,100,'Bạc','','Bảo hành 12 tháng','70221010','Dell XPS 15 9500',61990000,'Hàng chính hãng','1.78','2020-1-1',
100003, -- CATEGORY (GAMING, VAN PHONG) --
1012, -- ID IMAGE --
100001,-- DELL--
100001); -- PRODUCT TYPE : LAPTOP -- 

INSERT INTO `laptopweb`.`laptop`
(`id`,`os`,`battery`,`cpu`,`graphic_card`,`port`,`ram`,`screen`,`storage`,`id_product`)
VALUES
(1012,'Windows 10 Home SL','6 Cells 97 Whrs Battery','Intel i7-10750G Gen 10th','NVIDIA GeForce GTX 1650Ti 4GB + Intel UHD Graphics 620','2x Thunderbolt 3(Power Delivery & DisplayPort),1x USB-C 3.1 (Power Delivery & DisplayPort),1x Headset jack','16GB DDR4 2933MHz','15.6" FHD IPS (1920*1080) InfinityEgde','SSD 512GB M.2 PCIe',1012);








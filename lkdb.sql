DROP DATABASE IF EXISTS lkdb;
CREATE DATABASE lkdb CHARACTER SET utf8;
USE lkdb;

CREATE TABLE users( -- 前台用户
  id        INT AUTO_INCREMENT,
  name      VARCHAR(50) NOT NULL,
  pwd       VARCHAR(50) NOT NULL,
  realname  VARCHAR(50) NOT NULL,
  sex       VARCHAR(2),
  age       INT,
  card      VARCHAR(50),
  phone     VARCHAR(50),
  address   VARCHAR(100),
  email     VARCHAR(50),
  code      VARCHAR(50),
  type      VARCHAR(50),
  CONSTRAINT pk_userid PRIMARY KEY (id),
  CONSTRAINT ck_usersex CHECK (sex IN ('男','女')),
  CONSTRAINT ck_userage CHECK (age > 0)
)ENGINE = innodb;

CREATE TABLE admin(
  id        INT AUTO_INCREMENT,
  name      VARCHAR(50) NOT NULL,
  pwd       VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  CONSTRAINT pk_adminid PRIMARY KEY (id)
)ENGINE = innodb;

CREATE TABLE types( -- 菜品类别
  id        INT AUTO_INCREMENT,
  name      VARCHAR(50) NOT NULL,
  CONSTRAINT pk_typeid PRIMARY KEY (id)
)ENGINE = innodb;

CREATE TABLE menus( -- 菜单表
  id        INT AUTO_INCREMENT,
  name      VARCHAR(50) NOT NULL,
  typeid    INT NOT NULL, -- 菜品类别
  burden    VARCHAR(50), -- 原材料
  brief     VARCHAR(500),
  sum      INT,
  price    DOUBLE,
  imgpath    VARCHAR(100),
  CONSTRAINT pk_menuid PRIMARY KEY (id),
  CONSTRAINT fk_typeid FOREIGN KEY (typeid) REFERENCES types(id)
)ENGINE = innodb;

CREATE TABLE orders( -- 订单表
  id        INT AUTO_INCREMENT,
  userid    INT NOT NULL,
  total     DOUBLE NOT NULL,
  times     DATETIME NOT NULL,
  delivery  VARCHAR(1) NOT NULL, -- 状态（0/1）未支付，已支付
  CONSTRAINT pk_orderid PRIMARY KEY (id),
  CONSTRAINT fk_menuid FOREIGN KEY (menuid) REFERENCES menus(id),
  CONSTRAINT fk_userid FOREIGN KEY (userid) REFERENCES users(id)
)ENGINE = innodb;

CREATE TABLE orders_details( -- 订单详情表
  orderid        INT,
  menuid    INT NOT NULL,
  count     INT NOT NULL,
  price     DOUBLE NOT NULL,
  CONSTRAINT fk_oredersid FOREIGN KEY (orderid) REFERENCES orders(id),
  CONSTRAINT fk_menuodid FOREIGN KEY (menuid)REFERENCES menus(id)
)ENGINE = innodb;

CREATE TABLE notice(
  id        INT AUTO_INCREMENT,
  name      VARCHAR(50) NOT NULL,
  content   TEXT NOT NULL,
  times     DATETIME NOT NULL,
  CONSTRAINT pk_noticeid PRIMARY KEY (id)
)ENGINE = innodb;


-- 增加数据
-- admin表
INSERT INTO lkdb.admin (name, pwd, authority) VALUES ('admin', '5D41402ABC4B2A76B9719D911017C592', '""');

-- users表
INSERT INTO lkdb.users (name, pwd, realname, sex, age, card, phone, address, email, code, type) VALUES ('gss', '024743CF5C8D4C372DC312C74AABA64C', '高少帅', '男', 19, '321654', '132', '山东', 'xx@xx.com', null, null);
INSERT INTO lkdb.users (name, pwd, realname, sex, age, card, phone, address, email, code, type) VALUES ('ChengLong', '024743CF5C8D4C372DC312C74AABA64C', '成龙', '男', 65, '453433', '18713121564', '香港', 'xx@xx.com', null, null);
INSERT INTO lkdb.users (name, pwd, realname, sex, age, card, phone, address, email, code, type) VALUES ('LiYitong', '024743CF5C8D4C372DC312C74AABA64C', '李一桐', '女', 26, '123456', '13946548732', '中国', 'xx@xx.com', null, null);
INSERT INTO lkdb.users (name, pwd, realname, sex, age, card, phone, address, email, code, type) VALUES ('HongJinbao', '024743CF5C8D4C372DC312C74AABA64C', '洪金宝', '男', 62, '542514', '15205405578', '香港', 'xx@xx.com', null, null);
INSERT INTO lkdb.users (name, pwd, realname, sex, age, card, phone, address, email, code, type) VALUES ('ZhouRunfa', '024743CF5C8D4C372DC312C74AABA64C', '周润发', '男', 63, '875615', '13854065998', '中国', 'xx@xx.com', null, null);
INSERT INTO lkdb.users (name, pwd, realname, sex, age, card, phone, address, email, code, type) VALUES ('FanBingbing', '024743CF5C8D4C372DC312C74AABA64C', '范冰冰', '女', 32, '432155234234', '14789891564', '北京', 'qq@qq.com', null, null);
INSERT INTO lkdb.users (name, pwd, realname, sex, age, card, phone, address, email, code, type) VALUES ('LiuDehua', '024743CF5C8D4C372DC312C74AABA64C', '刘德华', '男', 59, '123456', '13946548732', '中国', 'xx@xx.com', null, null);
INSERT INTO lkdb.users (name, pwd, realname, sex, age, card, phone, address, email, code, type) VALUES ('LiuYifei', '024743CF5C8D4C372DC312C74AABA64C', '刘亦菲', '女', 32, '754151', '1265464687', '新疆', 'cc@cc.com', null, null);

-- types表
INSERT INTO lkdb.types (name) VALUES ('招牌美食');
INSERT INTO lkdb.types (name) VALUES ('川菜');
INSERT INTO lkdb.types (name) VALUES ('湘菜');
INSERT INTO lkdb.types (name) VALUES ('海鲜');
INSERT INTO lkdb.types (name) VALUES ('鲁菜');
INSERT INTO lkdb.types (name) VALUES ('主食');
INSERT INTO lkdb.types (name) VALUES ('汤粥');

-- menus表
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('腰果鸡丁', 2, '鸡肉、腰果、辣椒', '鸡脯肉起成小丁后，加入盐等调味，炒制时加入了点长寿养颜的白果、延缓衰老的腰果、祛压降脂的红萝卜、除烦解暑的黄瓜。', 12, 35, 'f2891ce1-73b9-4325-a29e-8687300fd831.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('酸辣土豆丝', 3, '土豆、辣椒、青椒', '主料土豆性平和，有美容、改善胃肠功能，预防高血压的功效。辅料辣椒富含维生素C，可增强体质、防止冠状动脉硬化。', 80, 15, '0beb547e-7185-4744-9e1c-330fb829130f.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('馋嘴牛蛙', 2, '牛蛙、姜、料酒', '蛙仔鲜滑细嫩，配以青花椒、干辣椒和重庆农家用山泉泡制的青泡椒、泡姜等二十多种调料烹制而成，麻辣烫嫩，鲜香适口。', 50, 42, '782de17a-00d1-45e1-83f5-86c6c1e60c29.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('糖醋排骨', 1, '排骨、冰糖、料酒等', '糖醋排骨是川菜糖醋味型中具有代表性的一道大众喜爱的传统菜,因为口味香脆酸甜,颇受江浙沪人士喜爱。', 14, 38, 'a25b15ba-2e4f-4ebd-9648-628ec46cee79.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('剁椒鱼头', 1, '鱼头（花鲢）、剁椒', '湘潭的剁椒鱼头是在大街小巷的大小餐馆酒店都可以吃到的,以鱼头的“味鲜”和剁辣椒的“辣”为一体,风味独具一格。', 50, 36, '20777559-37d7-49e8-8e6b-62f4c3030bac.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('香辣鸡脆骨', 1, '鸡脆骨、干辣椒、熟白芝麻', '鸡脆骨,它以其独特的口感而倍受食客青睐。常见的菜例有宫保鸡脆骨、椒盐鸡脆。', 12, 40, '9c8d34ce-9251-4066-a3ae-3eeab3a8491c.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('豆腐羹', 1, '内酯豆腐、葱姜末、鲜虾', '豆腐羹是淮安平桥创制的特色传统名菜,属于淮扬菜系。', 60, 35, 'f315ad19-8921-4894-bcba-fb144373bf4b.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('辣炒蛤蜊', 8, '蛤蜊、食用油、豆豉', '辣炒蛤蜊是一道海鲜菜，蛤蜊肉质鲜美无比，被称为“天下第一鲜”、“百味之冠”。', 25, 18, '29ca26cf-780e-4cd1-ad2c-6e7833b87ba1.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('可乐鸡翅', 8, '可乐、鸡翅、酱油（味极鲜）', '味道鲜美,色泽艳丽,鸡翅嫩滑,又保留了可乐的香气,深受广大食客喜爱。', 16, 28, '2f00f024-3c10-435f-9d8c-58fc93667ac3.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('捞汁素拼', 8, '黄瓜、紫甘蓝、胡萝卜、金针菇', '想要吃的清爽又过瘾,还不想长肉肉,不如做个素拼吧。', 30, 15, 'e3ff1fe6-961e-4272-897d-1b518def3289.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('蒜蓉辣椒蒸鸡翅', 3, '鸡翅中段、红辣椒、香油', '口味鲜美，黑木耳软糯入味，比鸡翅还好吃，如果有整鸡蒸更好吃。', 9, 26, 'd5599c6f-9f3d-4fb6-8cba-300966537f94.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('小炒豆腐干', 3, '豆腐干、姜丝、红椒、青椒、蒜', '口感爆炸、小嚼一口，宛如升天。', 3, 12, 'de08ee6a-efe0-421a-8df0-de7c9601e321.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('红烧肉', 3, '五花肉、老抽、大料等', '这道菜能体现出浓油赤酱的特色,靠火候功夫,可以做出肥而不腻、酥而不烂、甜而不粘、浓而不咸...', 12, 22, 'be547bb1-2c6f-43f5-87c1-55ffc08833d8.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('宫保鸡丁', 2, '整鸡腿、花生米、胡萝卜丁、鸡蛋、花椒等', '色泽棕红,散籽亮油,辣香酸甜,滑嫩爽口。', 14, 26, '2ad6738d-5a45-402c-a9a5-518f39fb68c1.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('蚂蚁上树', 2, '绿豆粉丝、猪肉（三肥七瘦）、豆瓣酱等', '口味清淡,爽滑美味,色泽红亮...', 18, 13, '01f83474-832c-46f9-8bed-9d6f50972122.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('五彩焖饭', 9, '大米、杏鲍菇、甜玉米、豌豆等', '外形美观，香甜可口，具有明目、降糖、抗衰老、润肠、安神、防癌和健脑等的功效。', 30, 3, 'f821ec3d-092d-4cd6-8b59-ce414cfe643d.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('鸡蛋饼', 9, '面粉、鸡蛋、小葱等', '口感润滑，细嫩，营养丰富，是早餐的最佳食品，不上火。', 30, 3, 'a15e0085-334f-449c-9aa6-a828f2193426.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('千层饼', 9, '中筋面粉、五香粉、鸡蛋、香葱碎等', '外酥脆,内软嫩,层薄且多,麦香纯正,口感筋道。', 25, 3, 'dbfe70c7-d7d7-454d-ad3a-c6f16cb399ac.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('香菇豆腐鲫鱼汤', 10, '鲫鱼、鲜香菇、豆腐、枸杞等', '肉味甜美,营养成分丰富,鲫鱼能补虚、温中下气、利水消肿,尤其是治疗产后乳少更有独到之处。', 20, 5, '21e3dd0c-978e-40b1-a9b9-f33036dab36d.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('开胃酸辣汤', 10, '豆腐、火腿、木耳、鸡蛋等', '口感酸辣爽口，饭后饮用，有醒酒去腻，助消化的作用。', 20, 3.5, '597dee6d-d648-4997-b3ee-be739d171f59.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('当归炖鸡汤', 10, '老母鸡、当归、枸杞等', '鸡肉白嫩酥烂，汤汁鲜咸适口，略有药香味，并具有补血，保肝之功效。', 10, 8, '3a63964d-d070-4f3a-bd88-46e4e3beaa1c.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('干锅香辣虾', 5, '鲜虾、干辣椒、大蒜等', '味道鲜美火辣，颜色红火讨喜，希望能象征着您的日子红红火火，最适合节假日丰富您的餐桌。', 6, 32, '64d68123-b2bb-4eac-a9f1-d729b2f42b2b.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('清蒸鲈鱼', 5, '鲈鱼、蒸鱼豉油、料酒等', '鲈鱼富含蛋白质、维生素、钙、镁等营养元素;具有补肝肾、益脾胃、化痰止咳之效，对肝肾不足的人有很好的补益作用 。鲈鱼还可治胎动不安、产生少乳等症。', 80, 27, '3efdcc95-db2b-4785-a665-89c9a1c5b799.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('清炒虾仁', 5, '虾、胡萝卜、豌豆等', '以虾仁为主要材料炒制的菜肴。清炒虾仁因其清淡爽口，易于消化，老幼皆宜，而深受食客欢迎，它的配料可以随个人喜好而变化，做法多样。', 80, 22, '8057da3e-99b0-4ace-acb9-bb3a6f220d36.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('蚝汁鲍鱼仔', 5, '鲍鱼、蚝油、生抽等', '鲍鱼中含有大量的蛋白质，有养肝明目、调经、润燥利肠之功效。鲍鱼虽补，但是不燥，很适合在夏天食用。', 60, 38, 'fe68328b-e11e-4777-a349-ef26a7ad437a.jpg');
INSERT INTO lkdb.menus (name, typeid, burden, brief, sum, price, imgpath) VALUES ('灌汤包', 9, '面粉、五花肉、鸡精等', '灌汤包子有了形式美，其内容精美别致，肉馅与鲜汤同居一室，吃之，便就将北国吃面、吃肉、吃汤三位一体化，是一种整合的魅力。', 100, 1, 'ffae6548-ec45-47da-bdbe-ac281466074d.jpg');

-- orders表
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (1, 15, '2017-08-31 18:22:36', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (4, 57, '2017-09-01 15:28:10', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (3, 46, '2017-09-01 22:27:52', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (6, 8, '2017-09-01 23:23:54', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (7, 76, '2017-09-03 17:13:09', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (7, 65, '2017-09-03 17:14:34', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (7, 49, '2017-09-03 17:15:38', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (6, 33, '2017-09-03 17:20:21', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (4, 24, '2017-09-03 23:21:55', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (4, 71, '2017-09-03 23:46:41', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (4, 210, '2017-09-03 23:51:25', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (4, 160, '2017-09-03 23:51:52', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (4, 222, '2017-09-03 23:55:45', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (3, 210, '2017-09-03 23:57:41', '1');
INSERT INTO lkdb.orders (userid, total, times, delivery) VALUES (3, 511, '2017-09-03 23:58:12', '1');

-- orders_details表
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (1, 2, 1, 15);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (2, 2, 1, 15);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (2, 3, 1, 42);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (4, 11, 1, 35);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (4, 21, 1, 3);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (4, 26, 1, 8);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (5, 26, 1, 8);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (8, 12, 1, 18);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (8, 14, 1, 28);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (8, 23, 1, 3);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (9, 18, 1, 22);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (9, 21, 2, 3);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (9, 24, 1, 5);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (10, 17, 2, 12);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (11, 27, 1, 32);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (11, 9, 1, 36);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (11, 21, 1, 3);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (12, 3, 5, 42);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (13, 27, 5, 32);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (14, 3, 3, 42);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (14, 27, 3, 32);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (15, 1, 6, 35);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (16, 8, 7, 38);
INSERT INTO lkdb.orders_details (orderid, menuid, count, price) VALUES (16, 1, 7, 35);

-- notice表
INSERT INTO lkdb.notice (name, content, times) VALUES ('菜品上新', '2017新菜品上市啦,只有想不到没有做不到。吃不腻的美味,口水要收不住啦,快来尝尝鲜吧。可乐鸡翅,蚂蚁上树。', '2017-09-03 21:02:14');
INSERT INTO lkdb.notice (name, content, times) VALUES ('新任主厨周冬雨上线', '继店长赵薇后,餐厅又出现了一位厨艺“难以捉摸”的大厨,她就是新任当班主厨周冬雨。周冬雨的厨艺“仿佛让人坐了过山车”，有时让客人大赞“好吃到爆炸”，有时则让客人面露难色。', '2017-09-03 21:39:22');
INSERT INTO lkdb.notice (name, content, times) VALUES ('阿婆与麦当劳达成合作', '“这一次就要燃”阿婆私房菜与麦当劳中国于2017年9月1日达成合作伙伴关系！', '2017-09-03 21:41:32');
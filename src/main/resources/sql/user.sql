CREATE TABLE `user` (
                        `userName` varchar(50) NOT NULL,
                        `email` varchar(50) DEFAULT NULL,
                        `password` varchar(50) DEFAULT NULL,
                        `img_src` varchar(100) DEFAULT './img/user_src/account.png',
                        `description` varchar(1000) DEFAULT NULL,
                        `authority` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'Merchant',
                        PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3

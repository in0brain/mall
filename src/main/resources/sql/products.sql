CREATE TABLE `products` (
                            `id` int NOT NULL,
                            `name` varchar(20) NOT NULL,
                            `price` float DEFAULT NULL,
                            `kind` varchar(100) DEFAULT NULL,
                            `message` varchar(1000) DEFAULT 'none',
                            `image_src` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'img/product_src/nothing.png',
                            `merchant_name` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3

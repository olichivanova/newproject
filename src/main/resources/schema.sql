CREATE TABLE `categories` (
                              `categoryID` integer NOT NULL AUTO_INCREMENT,
                              `category_name` varchar(255) NOT NULL,
                              `description` varchar(255) NOT NULL,
                              PRIMARY KEY (`categoryID`)
);

CREATE TABLE `clients` (
                           `clientID` integer NOT NULL AUTO_INCREMENT,
                           `client_last_name` varchar(50) NOT NULL,
                           `client_first_name` varchar(50) NOT NULL,
                           `age` integer NOT NULL,
                           `address` varchar(100) NOT NULL,
                           PRIMARY KEY (`clientID`),
                           CONSTRAINT `clients_chk_1` CHECK ((`age` >= 18))
) ;

CREATE TABLE products (
                            productID integer NOT NULL AUTO_INCREMENT,
                            product_name varchar(100) NOT NULL,
                            category_id integer,
                            unit varchar(100) NOT NULL,
                            price float DEFAULT NULL,
                            in_stock float DEFAULT NULL,
                            PRIMARY KEY (productID),
                             FOREIGN KEY (category_id) REFERENCES categories (categoryID)

);

CREATE TABLE `orders` (
                          `orderID` integer NOT NULL AUTO_INCREMENT,
                          `client_id` integer ,
                          `order_date` date DEFAULT NULL,
                          PRIMARY KEY (`orderID`),
                         FOREIGN KEY (`client_id`) REFERENCES `clients` (`clientID`)

);

CREATE TABLE `orderdetails` (
                                `order_detailid` integer NOT NULL AUTO_INCREMENT,
                                `order_id` integer ,
                                `product_id` integer ,
                                `quantity` float NOT NULL,
                                `price` float NOT NULL,
                                `total` float DEFAULT NULL,
                                PRIMARY KEY (`order_detailid`),

                              FOREIGN KEY (`order_id`) REFERENCES `orders` (`orderID`),
                                FOREIGN KEY (`product_id`) REFERENCES `products` (`productID`)
);

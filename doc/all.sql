drop table if exists `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
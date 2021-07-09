drop table if exists `ebook`;
CREATE TABLE `ebook` (
  `id` bigint NOT NULL comment 'id',
  `name` varchar(50),
  `category1` bigint,
  `category2` bigint,
  `description` varchar(200),
  `cover` varchar(200),
  `doc_count` int,
  `visit_count` int,
  `vote_count` int,
  primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;
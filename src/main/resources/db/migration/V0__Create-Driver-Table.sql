CREATE TABLE IF NOT EXISTS `driver` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `team` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `podiums` int NOT NULL,
  `world_championships` int NOT NULL,
  `grands_prix_entered` int NOT NULL,
  `points` double NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `driver` (id, name, team, country, podiums, world_championships, grands_prix_entered, points) VALUES
(1, 'Max Verstappen', 'Red Bull Racing', 'Netherlands', 76, 2, 161, 1973.5),
(2, 'Sergio Perez', 'Red Bull Racing', 'Mexico', 25, 0, 134, 1176),
(3, 'Charles Leclerc', 'Ferrari', 'Monaco', 23, 0, 101, 835),
(4, 'Carlos Sainz', 'Ferrari', 'Spain', 14, 0, 161, 748.5),
(5, 'George Russell', 'Mercedes', 'United Kingdom', 8, 0, 80, 250),
(6, 'Lewis Hamilton', 'Mercedes', 'United Kingdom', 190, 7, 308, 4381.5);

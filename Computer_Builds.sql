-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2019 at 10:08 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `computer_builds`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkconstraint` ()  NO SQL
SELECT 'yoohoo'$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dropbuild` ()  NO SQL
DELETE FROM `build` where id = (SELECT max(id) from build)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `totalprice` ()  NO SQL
SELECT pp.price+m.price+r.price+s.price+ps.price+c.price+pc.price as 'total' FROM build b,processor_products pp, motherboard m,ram r,storage s,power_supply ps,cooler c,case_products pc WHERE b.processor=pp.Name and b.motherboard=m.Name AND b.ram=r.name AND b.storage=s.name AND b.power_supply=ps.name AND b.cooler=c.name AND b.pc_case=pc.name AND id = (SELECT max(id) FROM build)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `build`
--

CREATE TABLE `build` (
  `Processor` varchar(20) NOT NULL,
  `Motherboard` varchar(20) NOT NULL,
  `RAM` varchar(20) NOT NULL,
  `Storage` varchar(20) NOT NULL,
  `Cooler` varchar(20) NOT NULL,
  `Power_Supply` varchar(20) NOT NULL,
  `PC_Case` varchar(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `build`
--

INSERT INTO `build` (`Processor`, `Motherboard`, `RAM`, `Storage`, `Cooler`, `Power_Supply`, `PC_Case`, `id`) VALUES
('Ryzen 9 3900X', 'MSI B450 Tomahawk', 'C Vengeance', 'Digital Blue', 'Asus Aorus', 'Amtek', 'Corsair Full Tower', 24),
('Ryzen 7 3700X', 'MSI B450 Tomahawk', 'C Vengeance', 'Digital Blue', 'Asus Aorus', 'Amtek', 'Corsair Full Tower', 25),
('Core i3 4700H', 'Asus Z97I', 'C Vengeance', 'Digital Blue', 'Asus Aorus', 'Amtek', 'Corsair Full Tower', 41),
('Athlon 200', 'MSI AM1I', 'C Vengeance', 'Digital Blue', 'Asus Aorus', 'Amtek', 'Corsair Full Tower', 54),
('Core i9 9900K', 'ASRock B365M', 'C Vengeance', 'Digital Blue', 'Asus Aorus', 'Amtek', 'Corsair Full Tower', 65),
('Ryzen 9 3900X', 'MSI B450 Tomahawk', 'G.Skill', 'Samsung', 'Asus ROG', 'ASRock II', 'NZXT Mid Tower', 68);

--
-- Triggers `build`
--
DELIMITER $$
CREATE TRIGGER `Ramcapacity` AFTER INSERT ON `build` FOR EACH ROW IF (SELECT 1 FROM build b, ram r,motherboard m WHERE b.Motherboard=m.name AND b.RAM=r.name AND m.ram_max<=r.memory AND b.id = (SELECT max(id) FROM build))
THEN
UPDATE compatibility SET ram_more='yes' WHERE id = (SELECT max(id) FROM compatibility);
ELSE
UPDATE compatibility SET ram_more='no' WHERE id = (SELECT max(id) FROM compatibility);
END IF
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `compatible` AFTER INSERT ON `build` FOR EACH ROW IF (SELECT 1 FROM build b,processor_products pp, motherboard m WHERE b.Processor=pp.Name AND b.Motherboard=m.name AND pp.Socket<>m.Socket AND Id = (SELECT max(id) FROM build))
THEN
INSERT INTO compatibility(compatibility) VALUE('no');
ELSE
INSERT INTO compatibility(compatibility) VALUE('yes');
END IF
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `case_products`
--

CREATE TABLE `case_products` (
  `Name` varchar(20) NOT NULL,
  `Form_Factor` varchar(20) NOT NULL,
  `Color` varchar(20) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `case_products`
--

INSERT INTO `case_products` (`Name`, `Form_Factor`, `Color`, `Price`) VALUES
('Corsair Full Tower', 'ATX', 'Black', 10000),
('Dome Mini', 'Mini ATX', 'White', 9000),
('NZXT Mid Tower', 'Micro ATX', 'Red', 7000);

-- --------------------------------------------------------

--
-- Table structure for table `compatibility`
--

CREATE TABLE `compatibility` (
  `ID` int(11) NOT NULL,
  `compatibility` varchar(20) NOT NULL,
  `ram_more` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cooler`
--

CREATE TABLE `cooler` (
  `Name` varchar(10) NOT NULL,
  `Type` varchar(10) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cooler`
--

INSERT INTO `cooler` (`Name`, `Type`, `Price`) VALUES
('Asus Aorus', 'Liquid', 10000),
('Asus ROG', 'Liquid', 12000),
('Noctua NH1', 'Air', 10000),
('Noctua UH3', 'Air', 8500);

-- --------------------------------------------------------

--
-- Table structure for table `form_factor`
--

CREATE TABLE `form_factor` (
  `form_factor` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `form_factor`
--

INSERT INTO `form_factor` (`form_factor`) VALUES
('ATX'),
('Micro ATX'),
('Mini ATX');

-- --------------------------------------------------------

--
-- Table structure for table `motherboard`
--

CREATE TABLE `motherboard` (
  `Name` varchar(20) NOT NULL,
  `Socket` varchar(20) NOT NULL,
  `RAM_no` varchar(20) NOT NULL,
  `RAM_max` varchar(20) NOT NULL,
  `Form_Factor` varchar(20) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `motherboard`
--

INSERT INTO `motherboard` (`Name`, `Socket`, `RAM_no`, `RAM_max`, `Form_Factor`, `Price`) VALUES
('ASRock B365M', 'LGA1151', '4', '64', 'Micro ATX', 7500),
('Asus M2N', 'AM2', '4', '8', 'Micro ATX', 5000),
('Asus Z97I', 'LGA1150', '2', '16', 'Mini ATX', 8000),
('MSI AM1I', 'AM1', '2', '32', 'Mini ATX', 2000),
('MSI B450 Tomahawk', 'AM4', '4', '64', 'ATX', 12000),
('MSI Z390-A Pro', 'LGA1151', '4', '128', 'ATX', 9000),
('MSI Z97', 'LGA1150', '4', '32', 'ATX', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `power_supply`
--

CREATE TABLE `power_supply` (
  `Name` varchar(20) NOT NULL,
  `Wattage` int(11) NOT NULL,
  `Efficiency` varchar(20) NOT NULL,
  `Modular` varchar(20) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `power_supply`
--

INSERT INTO `power_supply` (`Name`, `Wattage`, `Efficiency`, `Modular`, `price`) VALUES
('Amtek', 1000, 'Silver', 'Fully', 7000),
('ASRock', 500, 'Gold', 'Semi', 4500),
('ASRock II', 1000, 'Silver', 'Fully', 5500),
('Corsair', 1500, 'Bronze', 'Not', 6000),
('EVGA', 180, 'Bronze', 'Not', 3000);

-- --------------------------------------------------------

--
-- Table structure for table `processor`
--

CREATE TABLE `processor` (
  `Socket` varchar(20) NOT NULL,
  `Pin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `processor`
--

INSERT INTO `processor` (`Socket`, `Pin`) VALUES
('AM1', 721),
('AM2', 940),
('AM4', 1331),
('LGA1150', 1150),
('LGA1151', 1151);

-- --------------------------------------------------------

--
-- Table structure for table `processor_products`
--

CREATE TABLE `processor_products` (
  `Name` varchar(20) NOT NULL,
  `Socket` varchar(20) NOT NULL,
  `Clock_Speed` float(5,1) NOT NULL,
  `Cores` int(11) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `processor_products`
--

INSERT INTO `processor_products` (`Name`, `Socket`, `Clock_Speed`, `Cores`, `Price`) VALUES
('Athlon 200', 'AM1', 3.9, 3, 3500),
('Core i3 4700H', 'LGA1150', 3.2, 2, 6000),
('Core i5 4730H', 'LGA1150', 4.5, 4, 9000),
('Core i7 9700K', 'LGA1151', 5.0, 8, 16000),
('Core i9 9900K', 'LGA1151', 5.1, 8, 20000),
('Ryzen 7 3700X', 'AM4', 4.7, 12, 13000),
('Ryzen 9 3900X', 'AM4', 4.9, 12, 15000);

-- --------------------------------------------------------

--
-- Table structure for table `ram`
--

CREATE TABLE `ram` (
  `Name` varchar(20) NOT NULL,
  `Speed` varchar(20) NOT NULL,
  `Memory` int(10) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ram`
--

INSERT INTO `ram` (`Name`, `Speed`, `Memory`, `Price`) VALUES
('C Vengeance', 'DDR4', 8, 2000),
('C2 Vengeance', 'DDR4', 16, 2500),
('G.Skill', 'DDR4', 32, 3500),
('Trident', 'DDR4', 64, 4200);

-- --------------------------------------------------------

--
-- Table structure for table `storage`
--

CREATE TABLE `storage` (
  `Name` varchar(20) NOT NULL,
  `Size` varchar(11) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `storage`
--

INSERT INTO `storage` (`Name`, `Size`, `Type`, `Price`) VALUES
('Digital Blue', '256', 'SSD', 5000),
('HyperX', '256', 'M.2', 6000),
('Samsung', '512', 'M.2', 7000),
('Seagate', '1 TB', 'HDD', 6000),
('Seagate II', '2 TB', 'HDD', 9000),
('Western Digital', '512', 'SSD', 6500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `build`
--
ALTER TABLE `build`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Processor` (`Processor`),
  ADD KEY `Motherboard` (`Motherboard`),
  ADD KEY `RAM` (`RAM`),
  ADD KEY `Storage` (`Storage`),
  ADD KEY `Cooler` (`Cooler`),
  ADD KEY `Power Supply` (`Power_Supply`),
  ADD KEY `PC Case` (`PC_Case`);

--
-- Indexes for table `case_products`
--
ALTER TABLE `case_products`
  ADD PRIMARY KEY (`Name`),
  ADD KEY `Form_Factor` (`Form_Factor`);

--
-- Indexes for table `compatibility`
--
ALTER TABLE `compatibility`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cooler`
--
ALTER TABLE `cooler`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `form_factor`
--
ALTER TABLE `form_factor`
  ADD PRIMARY KEY (`form_factor`);

--
-- Indexes for table `motherboard`
--
ALTER TABLE `motherboard`
  ADD PRIMARY KEY (`Name`),
  ADD KEY `Socket` (`Socket`),
  ADD KEY `Form_Factor` (`Form_Factor`);

--
-- Indexes for table `power_supply`
--
ALTER TABLE `power_supply`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `processor`
--
ALTER TABLE `processor`
  ADD PRIMARY KEY (`Socket`);

--
-- Indexes for table `processor_products`
--
ALTER TABLE `processor_products`
  ADD PRIMARY KEY (`Name`),
  ADD KEY `Socket` (`Socket`);

--
-- Indexes for table `ram`
--
ALTER TABLE `ram`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `storage`
--
ALTER TABLE `storage`
  ADD PRIMARY KEY (`Name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `build`
--
ALTER TABLE `build`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT for table `compatibility`
--
ALTER TABLE `compatibility`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `build`
--
ALTER TABLE `build`
  ADD CONSTRAINT `build_ibfk_1` FOREIGN KEY (`Processor`) REFERENCES `processor_products` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `build_ibfk_2` FOREIGN KEY (`Motherboard`) REFERENCES `motherboard` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `build_ibfk_3` FOREIGN KEY (`RAM`) REFERENCES `ram` (`Name`),
  ADD CONSTRAINT `build_ibfk_4` FOREIGN KEY (`Storage`) REFERENCES `storage` (`Name`),
  ADD CONSTRAINT `build_ibfk_5` FOREIGN KEY (`Cooler`) REFERENCES `cooler` (`Name`),
  ADD CONSTRAINT `build_ibfk_6` FOREIGN KEY (`Power_Supply`) REFERENCES `power_supply` (`Name`),
  ADD CONSTRAINT `build_ibfk_7` FOREIGN KEY (`PC_Case`) REFERENCES `case_products` (`Name`);

--
-- Constraints for table `case_products`
--
ALTER TABLE `case_products`
  ADD CONSTRAINT `case_products_ibfk_1` FOREIGN KEY (`Form_Factor`) REFERENCES `form_factor` (`form_factor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `motherboard`
--
ALTER TABLE `motherboard`
  ADD CONSTRAINT `motherboard_ibfk_1` FOREIGN KEY (`Socket`) REFERENCES `processor` (`Socket`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `motherboard_ibfk_2` FOREIGN KEY (`Form_Factor`) REFERENCES `form_factor` (`form_factor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `processor_products`
--
ALTER TABLE `processor_products`
  ADD CONSTRAINT `processor_products_ibfk_1` FOREIGN KEY (`Socket`) REFERENCES `processor` (`Socket`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

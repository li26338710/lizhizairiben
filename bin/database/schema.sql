CREATE TABLE `attribute` (
  `idattribute` int(11) NOT NULL AUTO_INCREMENT,
  `idproduct` int(11) DEFAULT NULL,
  `idattributedefine` int(11) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `createuser` varchar(45) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `updateuser` varchar(45) DEFAULT NULL,
  `isactive` varchar(2) DEFAULT '1',
  PRIMARY KEY (`idattribute`),
  KEY `attdef_pk_idx` (`idattributedefine`)
);

CREATE TABLE `attributedefine` (
  `idattributedefine` int(11) NOT NULL AUTO_INCREMENT,
  `idcategory` int(11) DEFAULT NULL,
  `attributename` varchar(45) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `createuser` varchar(45) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `updateuser` varchar(45) DEFAULT NULL,
  `isactive` varchar(2) DEFAULT '1',
  PRIMARY KEY (`idattributedefine`)
);
CREATE TABLE `brand` (
  `idbrand` int(11) NOT NULL AUTO_INCREMENT,
  `brandName` varchar(45) DEFAULT NULL,
  `type` varchar(2) DEFAULT '0' COMMENT '官网  0\n电商  1\n官网 + 电商 2',
  `url` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `createuser` varchar(45) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `updateuser` varchar(45) DEFAULT NULL,
  `isactive` varchar(2) DEFAULT '1',
  PRIMARY KEY (`idbrand`)
);

CREATE TABLE `category` (
  `idcategory` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(45) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `createuser` varchar(45) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `updateuser` varchar(45) DEFAULT NULL,
  `isactive` varchar(2) DEFAULT '1',
  PRIMARY KEY (`idcategory`)
);
CREATE TABLE `customer` (
  `idcustomer` int(11) NOT NULL AUTO_INCREMENT,
  `customername` varchar(45) DEFAULT NULL,
  `WXID` varchar(45) DEFAULT NULL,
  `wxname` varchar(45) DEFAULT NULL,
  `tbname` varchar(45) DEFAULT NULL,
  `alipayname` varchar(45) DEFAULT NULL,
  `recommender` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `address3` varchar(255) DEFAULT NULL,
  `credit` varchar(2) DEFAULT '1',
  `comment` varchar(45) DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idcustomer`)
);

CREATE TABLE `discountsetting` (
  `iddiscountsetting` int(11) NOT NULL,
  `discountsettingname` varchar(45) DEFAULT NULL,
  `discountsettingcomment` varchar(45) DEFAULT NULL,
  `discount` double DEFAULT '1',
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`iddiscountsetting`)
);
CREATE TABLE `market` (
  `idmarket` int(11) NOT NULL AUTO_INCREMENT,
  `marketname` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isactice` varchar(45) DEFAULT '1',
  PRIMARY KEY (`idmarket`)
);
CREATE TABLE `orderdetail` (
  `idorderdetail` int(11) NOT NULL AUTO_INCREMENT,
  `idorder` int(11) DEFAULT NULL,
  `idproduct` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT '1',
  `bookdate` datetime DEFAULT NULL,
  `bookprice` double DEFAULT '0',
  `esticostprice` double DEFAULT '0',
  `costprice` double DEFAULT '0',
  `bookrate` double DEFAULT '0',
  `costrate` double DEFAULT '0',
  `profit` double DEFAULT '0',
  `status` varchar(45) DEFAULT '0',
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idorderdetail`)
);
CREATE TABLE `ordertable` (
  `idorder` int(11) NOT NULL AUTO_INCREMENT,
  `idcustomer` int(11) DEFAULT NULL,
  `bookdate` datetime DEFAULT NULL,
  `deposit` double DEFAULT '0',
  `payment` double DEFAULT '0',
  `deposittype` varchar(2) DEFAULT NULL,
  `paymenttype` varchar(2) DEFAULT NULL,
  `postprice` double DEFAULT '10',
  `remaindprice` double DEFAULT '0',
  `sumprofit` double DEFAULT '0',
  `sumprice` double DEFAULT '0',
  `status` varchar(2) DEFAULT '0',
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idorder`)
);
CREATE TABLE `product` (
  `idproduct` int(11) NOT NULL AUTO_INCREMENT,
  `productname` varchar(255) DEFAULT NULL,
  `productnamejapan` varchar(255) DEFAULT NULL,
  `idbrand` int(11) DEFAULT NULL,
  `idcategory` int(11) DEFAULT NULL,
  `officalprice` double DEFAULT '0',
  `recentlybookprice` double DEFAULT '0',
  `iddiscountsetting` int(11) DEFAULT NULL,
  `istax` varchar(2) DEFAULT '0',
  `taxfee` double DEFAULT '0',
  `discount` double DEFAULT '1',
  `weight` int(11) DEFAULT '0',
  `costPrice` double DEFAULT '0',
  `costPriceJpy` double DEFAULT '0',
  `saleprice` double DEFAULT '0',
  `createtime` datetime DEFAULT NULL,
  `createuser` varchar(45) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `updateuser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isactive` varchar(2) DEFAULT '1',
  PRIMARY KEY (`idproduct`),
  KEY `brand_fk_idx` (`idbrand`),
  KEY `cat_fk_idx` (`idcategory`)
);
CREATE TABLE `purchase` (
  `idpurchase` int(11) NOT NULL AUTO_INCREMENT,
  `idmarket` int(11) DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `purchasedate` datetime DEFAULT NULL,
  `purchasetype` varchar(2) DEFAULT NULL,
  `cardno` varchar(45) DEFAULT NULL,
  `usescore` int(11) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT '0',
  `isactive` varchar(45) DEFAULT '0',
  PRIMARY KEY (`idpurchase`)
);
CREATE TABLE `purchasedetail` (
  `idpurchasedetail` int(11) NOT NULL AUTO_INCREMENT,
  `idpurchase` int(11) DEFAULT NULL,
  `idbrand` int(11) DEFAULT NULL,
  `idproduct` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `singleprice` double DEFAULT NULL,
  `sumprice` double DEFAULT NULL,
  `getscore` int(11) DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idpurchasedetail`)
);
CREATE TABLE `status` (
  `idstatus` int(11) NOT NULL AUTO_INCREMENT,
  `statustype` varchar(45) DEFAULT NULL,
  `statuscode` varchar(45) DEFAULT NULL,
  `statusvalue` varchar(45) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idstatus`)
);
CREATE TABLE `stock` (
  `idstock` int(11) NOT NULL AUTO_INCREMENT,
  `idproduct` int(11) DEFAULT NULL,
  `idorderdetail` int(11) DEFAULT NULL,
  `idpurchasedetail` int(11) DEFAULT NULL,
  `stockcount` int(11) DEFAULT NULL,
  `stockdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idstock`)
);
CREATE TABLE `systemsetting` (
  `idsystemsetting` int(11) NOT NULL AUTO_INCREMENT,
  `propertiyname` varchar(45) DEFAULT NULL,
  `propertiyvalue` varchar(45) DEFAULT NULL,
  `setdate` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isactive` varchar(45) DEFAULT '1',
  PRIMARY KEY (`idsystemsetting`)
);

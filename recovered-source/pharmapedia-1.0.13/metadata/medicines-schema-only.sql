-- Schema definition extracted from application bytecode.
-- NO medicine records or populated database were recovered from this XAPK.

CREATE TABLE IF NOT EXISTS `medicines_table` (`docId` TEXT NOT NULL, `timeStamp` INTEGER NOT NULL, `saltName` TEXT NOT NULL, `brandName` TEXT NOT NULL, `contraIndications` TEXT NOT NULL, `overview` TEXT NOT NULL, `indications` TEXT NOT NULL, `companyName` TEXT NOT NULL, `countryName` TEXT NOT NULL, `isBrandFavourite` INTEGER NOT NULL, `isSaltFavourite` INTEGER NOT NULL, `block` TEXT NOT NULL, `availableForms` TEXT NOT NULL, `dosageDetail` TEXT NOT NULL, PRIMARY KEY(`docId`));

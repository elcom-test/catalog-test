--SUPPLIER SERVICES SCHEMA--

CREATE TABLE BUYER (
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	DEPARTMENTCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CODE VARCHAR2(64 CHAR) NOT NULL,
	LASTLOGIN TIMESTAMP (0) DEFAULT NULL,
	PASSWORD VARCHAR2(64 CHAR) DEFAULT NULL,
	LOGINNAME VARCHAR2(24 CHAR) DEFAULT NULL,
	TITLE VARCHAR2(16 CHAR) DEFAULT NULL,
	FIRSTNAME VARCHAR2(16 CHAR) DEFAULT NULL,
	SURNAME VARCHAR2(32 CHAR) DEFAULT NULL,
	JOBTITLE VARCHAR2(64 CHAR) DEFAULT NULL,
	PHONE VARCHAR2(32 CHAR) DEFAULT NULL,
	FAX VARCHAR2(32 CHAR) DEFAULT NULL,
	EMAIL VARCHAR2(200 CHAR) DEFAULT NULL,
	ROLECODE NUMBER(10) DEFAULT NULL,
	SAVINGSTARGET NUMBER(20, 2) DEFAULT NULL,
	DATAVISIBILITY NUMBER(10) DEFAULT NULL,
	ENABLETENDER NUMBER(10) DEFAULT '0',
	MODERATORROLE NUMBER(10) DEFAULT '0' NOT NULL,
	LIVE NUMBER(10) DEFAULT '1',
	REVIEWERROLE NUMBER(10) DEFAULT '0' NOT NULL,
	EVALUATORROLE NUMBER(10) DEFAULT '0' NOT NULL,
	APPROVERROLE NUMBER(10) DEFAULT '0' NOT NULL,
	BUYERROLE NUMBER(10) DEFAULT '0' NOT NULL,
	ADMINISTRATORROLE NUMBER(10) DEFAULT '0' NOT NULL,
	MOBILE VARCHAR2(32 CHAR) DEFAULT NULL,
	EXTENSION VARCHAR2(32 CHAR) DEFAULT NULL,
	CONSTRAINT PK_BUYER PRIMARY KEY (CODE)
	);
CREATE SEQUENCE BUYER_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_BUYER_ORGANIZATIONCODE ON BUYER (ORGANIZATIONCODE);
CREATE INDEX IDX_BUYER_DEPARTMENTCODE ON BUYER (DEPARTMENTCODE);

CREATE TABLE SUPPLIERCOMPANY (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	DUNS VARCHAR2(16 CHAR) DEFAULT NULL,
	CRN VARCHAR2(8) DEFAULT NULL,
	NAME VARCHAR2(128 CHAR) NOT NULL,
	LIVE NUMBER(10) DEFAULT '1',
	TRADING NUMBER(10) DEFAULT '1',
	ADDRESS1 VARCHAR2(100 CHAR) DEFAULT NULL,
	ADDRESS2 VARCHAR2(100 CHAR) DEFAULT NULL,
	ADDRESS3 VARCHAR2(100 CHAR) DEFAULT NULL,
	ADDRESS4 VARCHAR2(100 CHAR) DEFAULT NULL,
	CITY VARCHAR2(40 CHAR) DEFAULT NULL,
	COUNTY VARCHAR2(40 CHAR) DEFAULT NULL,
	POSTCODE VARCHAR2(20 CHAR) DEFAULT NULL,
	PHONE VARCHAR2(30 CHAR) DEFAULT NULL,
	FAX VARCHAR2(30 CHAR) DEFAULT NULL,
	EMAIL VARCHAR2(60 CHAR) DEFAULT NULL,
	WEB VARCHAR2(128 CHAR) DEFAULT NULL,
	DESCRIPTION CLOB,
	CATALOGSITE VARCHAR2(128 CHAR) DEFAULT NULL,
	CATALOGLASTINDEXED TIMESTAMP (0) DEFAULT NULL,
	CATALOGINDEXCOUNT NUMBER(10) DEFAULT NULL,
	CATALOGINDEXRESULT NUMBER(10) DEFAULT NULL,
	CATALOGAVERAGESCANTIME NUMBER(10) DEFAULT NULL,
	SIDID NUMBER(19) DEFAULT NULL,
	SME NUMBER(10) DEFAULT '0',
	REGISTRATIONNOTES CLOB,
	CREATIONDATE TIMESTAMP (0) DEFAULT SYSTIMESTAMP NOT NULL,
	ENABLEBI NUMBER(10) DEFAULT '0',
	CURRENCY VARCHAR2(3 CHAR) DEFAULT NULL,
	GLNCODE VARCHAR2(13 CHAR) DEFAULT NULL,
	TYPECODE VARCHAR2(64 CHAR) DEFAULT NULL,
	RESTRICTED RAW(1) DEFAULT '0' NOT NULL,
	LASTPRODUCTUPDATE TIMESTAMP (0) DEFAULT NULL,
	GCP VARCHAR2(64 CHAR) DEFAULT NULL,
	REGISTEREDNAME VARCHAR2(128 CHAR) DEFAULT NULL,
	NOLOGIN RAW(1) DEFAULT '1' NOT NULL,
	LASTMODIFIEDDATE TIMESTAMP (0) DEFAULT NULL,
	SUPPLIERCOMPANYID VARCHAR2(64 CHAR) NOT NULL,
	CONSTRAINT PK_SUPPLIERCOMPANY PRIMARY KEY (CODE)
	);
CREATE SEQUENCE SUPPLIERCOMPANY_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_SUPPLIERCOMPANY_POSTCODE ON SUPPLIERCOMPANY (POSTCODE);
CREATE INDEX IDX_SUPPLIERCOMPANY_NAME ON SUPPLIERCOMPANY (NAME);
CREATE INDEX IDX_SUPPLIERCOMPANY_CRN ON SUPPLIERCOMPANY (CRN);
CREATE INDEX IDX_SUPPLIERCOMPANY_DUNS ON SUPPLIERCOMPANY (DUNS);
CREATE INDEX IDX_SUPPLIERCOMPANY_LIVE ON SUPPLIERCOMPANY (LIVE);
CREATE INDEX IDX_SUPPLIERCOMPANY_TYPECODE ON SUPPLIERCOMPANY (TYPECODE);

CREATE TABLE SUPPLIER (
	COMPANYCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CODE VARCHAR2(64 CHAR) NOT NULL,
	LASTLOGIN TIMESTAMP (0) DEFAULT NULL,
	PASSWORD VARCHAR2(255 CHAR) DEFAULT NULL,
	LOGINNAME VARCHAR2(16 CHAR) DEFAULT NULL,
	TITLE VARCHAR2(8) DEFAULT NULL,
	FIRSTNAME VARCHAR2(16 CHAR) DEFAULT NULL,
	SURNAME VARCHAR2(32 CHAR) DEFAULT NULL,
	JOBTITLE VARCHAR2(64 CHAR) DEFAULT NULL,
	PHONE VARCHAR2(32 CHAR) DEFAULT NULL,
	FAX VARCHAR2(32 CHAR) DEFAULT NULL,
	EMAIL VARCHAR2(200 CHAR) DEFAULT NULL,
	ROLECODE NUMBER(10) DEFAULT NULL,
	TYPE NUMBER(10) DEFAULT '3',
	SECONDARYEMAIL VARCHAR2(200 CHAR) DEFAULT NULL,
	KEYWORDS CLOB,
	NATIONAL NUMBER(10) DEFAULT NULL,
	LIVE NUMBER(10) DEFAULT '1',
	RFQSRECEIVED NUMBER(19) DEFAULT '0',
	RFQRESPONSES NUMBER(19) DEFAULT '0',
	QUOTATIONSSENT NUMBER(19) DEFAULT '0',
	QUOTATIONSAWARDED NUMBER(19) DEFAULT '0',
	AVERAGEQUOTATIONTIME NUMBER(20, 2) DEFAULT NULL,
	AWARDEDRATIOSCORE BINARY_DOUBLE DEFAULT '0',
	RESPONSERATIOSCORE BINARY_DOUBLE DEFAULT '0',
	QUOTATIONSPEEDSCORE BINARY_DOUBLE DEFAULT '0',
	OVERALLSCORE BINARY_DOUBLE DEFAULT '0',
	CREATIONDATE TIMESTAMP (0) DEFAULT SYSTIMESTAMP NULL,
	NODIRECTMARKETING NUMBER(10) DEFAULT '0',
	MOBILE VARCHAR2(32 CHAR) DEFAULT NULL,
	EXTENSION VARCHAR2(32 CHAR) DEFAULT NULL,
	DIVISION VARCHAR2(128 CHAR) DEFAULT NULL,
	NOMINATORCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	SUPPLIERID VARCHAR2(64 CHAR) NOT NULL,
	CONSTRAINT PK_SUPPLIER PRIMARY KEY (CODE),
	CONSTRAINT FK_SUPPLIER_COMPANYCODE FOREIGN KEY (COMPANYCODE) REFERENCES SUPPLIERCOMPANY(CODE)
	);
CREATE SEQUENCE SUPPLIER_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_SUPPLIER_COMPANYCODE ON SUPPLIER (COMPANYCODE);
CREATE INDEX IDX_SUPPLIER_LIVE ON SUPPLIER (LIVE);

CREATE TABLE ORGANIZATION (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	NAME VARCHAR2(128 CHAR) DEFAULT NULL,
	ADDRESS1 VARCHAR2(80 CHAR) DEFAULT NULL,
	ADDRESS2 VARCHAR2(40 CHAR) DEFAULT NULL,
	ADDRESS3 VARCHAR2(40 CHAR) DEFAULT NULL,
	ADDRESS4 VARCHAR2(40 CHAR) DEFAULT NULL,
	CITY VARCHAR2(40 CHAR) DEFAULT NULL,
	COUNTY VARCHAR2(40 CHAR) DEFAULT NULL,
	POSTCODE VARCHAR2(20 CHAR) DEFAULT NULL,
	PHONE VARCHAR2(30 CHAR) DEFAULT NULL,
	FAX VARCHAR2(30 CHAR) DEFAULT NULL,
	EMAIL VARCHAR2(60 CHAR) DEFAULT NULL,
	WEB VARCHAR2(128 CHAR) DEFAULT NULL,
	DESCRIPTION VARCHAR2(255 CHAR) DEFAULT NULL,
	REFERENCE VARCHAR2(20 CHAR) DEFAULT NULL,
	TYPE NUMBER(10) DEFAULT NULL,
	HUB NUMBER(10) DEFAULT NULL,
	SUPPLIERURL VARCHAR2(128 CHAR) DEFAULT NULL,
	HUBCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	DOMAIN VARCHAR2(32 CHAR) DEFAULT NULL,
	ENABLEBUILDER NUMBER(10) DEFAULT '0' NOT NULL,
	LIVE NUMBER(10) DEFAULT '1' NOT NULL,
	ENABLESHARESAVE NUMBER(10) DEFAULT '0' NOT NULL,
	ENABLEADMIN NUMBER(10) DEFAULT '0' NOT NULL,
	ENABLEREPORTS NUMBER(10) DEFAULT '0' NOT NULL,
	LOCKRFQS NUMBER(10) DEFAULT '0' NOT NULL,
	PREFERREDSUPPLIERSCHECKED NUMBER(10) DEFAULT '0' NOT NULL,
	ENABLERFQADVERTS NUMBER(10) DEFAULT '0' NOT NULL,
	ENABLETENDER NUMBER(10) DEFAULT '0' NOT NULL,
	COUNTRYCODE CHAR(2) DEFAULT NULL,
	NUTSCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	DUNS VARCHAR2(16 CHAR) DEFAULT NULL,
	ACTIVITYCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	ENABLETRACKER NUMBER(10) DEFAULT '0' NOT NULL,
	FISCALYEARSTARTMONTH NUMBER(10) DEFAULT '4',
	FISCALYEARSTARTDAY NUMBER(10) DEFAULT '1',
	TYPECODE VARCHAR2(64 CHAR) DEFAULT NULL,
	OJEUTYPECODE VARCHAR2(255 CHAR) DEFAULT NULL,
	ENABLEMULTIQUOTE NUMBER(10) DEFAULT '0' NOT NULL,
	ENABLEDELIVERYCHARGE NUMBER(3) DEFAULT '1',
	CUSTOMERAUTHENTICATION NUMBER(3) DEFAULT '0',
	EXTERNALCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	MEMBERSHIPREFERENCE VARCHAR2(100 CHAR) DEFAULT NULL,
	ENABLEPRODUCTS NUMBER(10) DEFAULT '0',
	DISTRICTCODE VARCHAR2(32 CHAR) DEFAULT NULL,
	CUSTOMERADMINISTRATOR NUMBER(3) DEFAULT '0',
	CONSTRAINT PK_ORGANIZATION PRIMARY KEY (CODE)
	);
CREATE SEQUENCE ORGANIZATION_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_ORGANIZATION_POSTCODE ON ORGANIZATION (POSTCODE);

CREATE TABLE ORGANIZATIONGROUP (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	REFERENCEORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	PRESET NUMBER(3) DEFAULT NULL,
	NAME VARCHAR2(200 CHAR) DEFAULT NULL,
	DESCRIPTION VARCHAR2(2000 CHAR) DEFAULT NULL,
	ORGANIZATIONPROVIDERCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	EXPORTTYPE VARCHAR2(10 CHAR) DEFAULT 'CATALOG' CHECK( EXPORTTYPE IN ('CATALOG','SUPPLIER')),
	CREATIONDATE TIMESTAMP (0) DEFAULT NULL,
	LIVE NUMBER(3) DEFAULT '1',
	CONSTRAINT PK_ORGANIZATIONGROUP PRIMARY KEY(CODE)
	);
CREATE SEQUENCE ORGANIZATIONGROUP_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_ORGANIZATIONGROUP_REFERENCEORGANIZATIONCODE ON ORGANIZATIONGROUP (REFERENCEORGANIZATIONCODE);

CREATE TABLE ROLEGROUP (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	ENTITYCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	DEPARTMENTCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	DIVISIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	APPLICATIONTYPE NUMBER(10) DEFAULT NULL,
	CONSTRAINT PK_ROLEGROUP PRIMARY KEY(CODE),
	CONSTRAINT UQ_ROLEGROUP_ENTITYCODE UNIQUE (ENTITYCODE)
	);
CREATE SEQUENCE ROLEGROUP_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_ROLEGROUP_DIVISIONCODE ON ROLEGROUP (DIVISIONCODE);
CREATE INDEX IDX_ROLEGROUP_DEPARTMENTCODE ON ROLEGROUP (DEPARTMENTCODE);
CREATE INDEX IDX_ROLEGROUP_ORGANIZATIONCODE ON ROLEGROUP (ORGANIZATIONCODE);

CREATE TABLE ROLEGROUPMEMBER (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	ENTITYCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	REFERENCECODE VARCHAR2(64 CHAR) DEFAULT NULL,
	REVIEWERROLE RAW(1) DEFAULT NULL,
	BUYERROLE RAW(1) DEFAULT NULL,
	OWNERROLE RAW(1) DEFAULT NULL,
	ROLEGROUPCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	TYPE VARCHAR2(10 CHAR) DEFAULT 'USER' CHECK( TYPE IN ('USER','TEAM')),
	TEAMCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	USERCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CONSTRAINT PK_ROLEGROUPMEMBER PRIMARY KEY(CODE)
	);
CREATE SEQUENCE ROLEGROUPMEMBER_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_CONTRACTGROUPMEMBER ON ROLEGROUPMEMBER (ENTITYCODE);
CREATE INDEX IDX_ROLEGROUPMEMBER_ROLEGROUPCODE ON ROLEGROUPMEMBER (ROLEGROUPCODE);
CREATE INDEX IDX_ROLEGROUPMEMBER_OWNERROLE ON ROLEGROUPMEMBER (OWNERROLE);
CREATE INDEX IDX_ROLEGROUPMEMBER_REFERENCECODE ON ROLEGROUPMEMBER (REFERENCECODE);
CREATE INDEX IDX_ROLEGROUPMEMBER_TEAMCODE ON ROLEGROUPMEMBER (TEAMCODE);
CREATE INDEX IDX_ROLEGROUPMEMBER_USERCODE ON ROLEGROUPMEMBER (USERCODE);

CREATE TABLE TEAMGROUP (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	NAME VARCHAR2(256 CHAR) NOT NULL,
	DESCRIPTION CLOB,
	CREATIONDATE TIMESTAMP (0) NOT NULL,
	LIVE RAW(1) NOT NULL,
	CONSTRAINT PK_TEAMGROUP PRIMARY KEY(CODE)
	);
CREATE SEQUENCE TEAMGROUP_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE TEAMGROUPMEMBER (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	USERCODE VARCHAR2(64 CHAR) NOT NULL,
	TEAMGROUPCODE VARCHAR2(64 CHAR) NOT NULL,
	CREATIONDATE TIMESTAMP (0) NOT NULL,
	CONSTRAINT PK_TEAMGROUPMEMBER PRIMARY KEY(CODE),
	CONSTRAINT FK_TEAMGROUPMEMBER_TEAMGROUPCODE FOREIGN KEY (TEAMGROUPCODE) REFERENCES TEAMGROUP(CODE)
	);
CREATE SEQUENCE TEAMGROUPMEMBER_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_TEAMGROUPMEMBER_TEAMGROUPCODE ON TEAMGROUPMEMBER (TEAMGROUPCODE);

CREATE TABLE CONTRACTDEFINITION (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	REFERENCE VARCHAR2(64 CHAR) DEFAULT NULL,
	USERCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	TITLE VARCHAR2(1024 CHAR) DEFAULT NULL,
	TYPE NUMBER(10) DEFAULT NULL,
	SERVICECATEGORYCODE VARCHAR2(4 CHAR) DEFAULT NULL,
	TYPESUPPLIESCONTRACTTYPE NUMBER(10) DEFAULT NULL,
	LOCATION VARCHAR2(1024 CHAR) DEFAULT NULL,
	DESCRIPTION CLOB,
	DIVIDEDINTOLOTS RAW(1) DEFAULT NULL,
	QUANTITYORSCOPE CLOB,
	CURRENCY CHAR(3) DEFAULT NULL,
	VALUECOST NUMBER(20, 2) DEFAULT NULL,
	VALUELOW NUMBER(20, 2) DEFAULT NULL,
	VALUEHIGH NUMBER(20, 2) DEFAULT NULL,
	OPTIONS RAW(1) DEFAULT NULL,
	OPTIONSDESCRIPTION CLOB,
	OPTIONSTIMETABLEDAYS NUMBER(10) DEFAULT NULL,
	OPTIONSTIMETABLEMONTHS NUMBER(10) DEFAULT NULL,
	ESTIMATEDSTARTDATE DATE DEFAULT NULL,
	ESTIMATEDENDDATE DATE DEFAULT NULL,
	ESTIMATEDRECURRENT RAW(1) DEFAULT NULL,
	ESTIMATEDRECURRENTRENEWALSMIN NUMBER(10) DEFAULT NULL,
	ESTIMATEDRECURRENTRENEWALSMAX NUMBER(10) DEFAULT NULL,
	ESTIMATEDRECURRENTCONTRACTDAYS NUMBER(10) DEFAULT NULL,
	ESTIMATEDRECURRENTCONTRACTMONTHS NUMBER(10) DEFAULT NULL,
	DURATIONDAYS NUMBER(10) DEFAULT NULL,
	DURATIONMONTHS NUMBER(10) DEFAULT NULL,
	FRAMEWORKAGREEMENT RAW(1) DEFAULT NULL,
	STATE VARCHAR2(32 CHAR) DEFAULT NULL,
	AWARDEDDATE TIMESTAMP (0) DEFAULT NULL,
	CREATIONDATE TIMESTAMP (0) DEFAULT SYSTIMESTAMP NOT NULL,
	LIVE RAW(1) DEFAULT NULL,
	FINALVALUE NUMBER(20, 2) DEFAULT NULL,
	PUBLISHVALUE RAW(1) DEFAULT '0',
	STARTDATE TIMESTAMP (0) DEFAULT NULL,
	ENDDATE TIMESTAMP (0) DEFAULT NULL,
	RECURRENT RAW(1) DEFAULT NULL,
	RECURRENTCONTRACTMONTHS NUMBER(10) DEFAULT NULL,
	RECURRENTRENEWALSMIN NUMBER(10) DEFAULT NULL,
	RECURRENTRENEWALSMAX NUMBER(10) DEFAULT NULL,
	COLLABORATION RAW(1) DEFAULT NULL,
	INTERNALREFERENCE VARCHAR2(128 CHAR) DEFAULT NULL,
	DEFINITIONTYPE NUMBER(10) DEFAULT NULL,
	COMPETITIONCONTRACTCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CONTRACTDEFINITIONNUMBER NUMBER(10) DEFAULT NULL,
	ADDITIONALINFORMATION CLOB,
	DEFINED RAW(1) DEFAULT NULL,
	EDITORCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	SHORTDESCRIPTION VARCHAR2(1000 CHAR) DEFAULT NULL,
	ONEOFF RAW(1) DEFAULT '0',
	AGREEMENTTYPE NUMBER(10) DEFAULT '0',
	REVIEWDATE TIMESTAMP (0) DEFAULT NULL,
	REVIEWSTATE VARCHAR2(64 CHAR) DEFAULT 'NONE' NOT NULL,
	APPROVALSTATE VARCHAR2(32 CHAR) DEFAULT NULL,
	APPROVALNUMBER NUMBER(10) DEFAULT '0',
	PRODUCTS RAW(1) DEFAULT NULL,
	PROCUREMENTTYPE VARCHAR2(50 CHAR) DEFAULT NULL,
	LASTAPPROVALDATE TIMESTAMP (0) DEFAULT NULL,
	LASTEXPORTEDDATE TIMESTAMP (0) DEFAULT NULL,
	CONSTRAINT PK_CONTRACTDEFINITION PRIMARY KEY(CODE),
	CONSTRAINT FK_CONTRACTDEFINITION_ORGANIZATION_CODE FOREIGN KEY (ORGANIZATIONCODE) REFERENCES ORGANIZATION(CODE)
	);
CREATE INDEX IDX_CONTRACTDEFINITION_SERVICECATEGORYCODE ON CONTRACTDEFINITION (SERVICECATEGORYCODE);
CREATE INDEX IDX_CONTRACTDEFINITION_SHORTDESCRIPTION_DEFINITIONTYPE ON CONTRACTDEFINITION (SHORTDESCRIPTION,DEFINITIONTYPE);
CREATE SEQUENCE CONTRACTDEFINITION_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE CONTRACTSUPPLIER (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	CONTRACTDEFINITIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	SUPPLIERCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	VALUE NUMBER(20, 2) DEFAULT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CREATIONDATE TIMESTAMP (0) DEFAULT NULL,
	COMPANYCODE VARCHAR2(64 CHAR) NOT NULL,
	DEFINED RAW(1) DEFAULT '0' NOT NULL,
	CONSTRAINT PK_CONTRACTSUPPLIER PRIMARY KEY(CODE),
	CONSTRAINT FK_CONTRACTSUPPLIER_CONTRACTDEFINITION_CODE FOREIGN KEY (CONTRACTDEFINITIONCODE) REFERENCES CONTRACTDEFINITION(CODE),
	CONSTRAINT FK_CONTRACTSUPPLIER_SUPPLIER_CODE FOREIGN KEY (CONTRACTDEFINITIONCODE) REFERENCES SUPPLIER(CODE),
	CONSTRAINT FK_CONTRACTSUPPLIER_SUPPLIERCOMPANY_CODE FOREIGN KEY (CONTRACTDEFINITIONCODE) REFERENCES SUPPLIERCOMPANY(CODE)
	);
CREATE SEQUENCE CONTRACTSUPPLIER_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_CONTRACTSUPPLIER_CONTRACTDEFINITIONCODE ON CONTRACTSUPPLIER (CONTRACTDEFINITIONCODE);
CREATE INDEX IDX_CONTRACTSUPPLIER_SUPPLIERCODE_CONTRACTDEFINITIONCODE ON CONTRACTSUPPLIER (SUPPLIERCODE,CONTRACTDEFINITIONCODE);
CREATE INDEX IDX_CONTRACTSUPPLIER_SUPPLIERCODE ON CONTRACTSUPPLIER (SUPPLIERCODE);
CREATE INDEX IDX_CONTRACTSUPPLIER_COMPANYCODE ON CONTRACTSUPPLIER (COMPANYCODE);

CREATE TABLE CONTRACTCUSTOMER (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	CONTRACTDEFINITIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	ENTITYORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	REFERENCEORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CREATIONDATE TIMESTAMP (0) DEFAULT NULL,
	CONSTRAINT PK_CONTRACTCUSTOMER PRIMARY KEY(CODE),
	CONSTRAINT FK_CONTRACTCUSTOMER_CONTRACTDEFINITION_CODE FOREIGN KEY (CONTRACTDEFINITIONCODE) REFERENCES CONTRACTDEFINITION(CODE)
	);
CREATE SEQUENCE CONTRACTCUSTOMER_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_CONTRACTCUSTOMER_CONTRACTDEFINITIONCODE ON CONTRACTCUSTOMER (CONTRACTDEFINITIONCODE);

CREATE TABLE TAX (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	DESCRIPTION VARCHAR2(50 CHAR) NOT NULL,
	RATE NUMBER(10, 2) NOT NULL,
	FROMDATE DATE DEFAULT NULL,
	LIVE NUMBER(3) DEFAULT NULL,
	TAXCODE VARCHAR2(25 CHAR) DEFAULT NULL,
	CONSTRAINT PK_TAX PRIMARY KEY(CODE),
	CONSTRAINT UQ_TAX_RATE_CODE UNIQUE (RATE,CODE)
	);
CREATE SEQUENCE TAX_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE UNIT (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	NAME VARCHAR2(100 CHAR) DEFAULT NULL,
	DESCRIPTION VARCHAR2(200 CHAR) DEFAULT NULL,
	ANSIX12 VARCHAR2(100 CHAR) DEFAULT NULL,
	LIVE NUMBER(3) DEFAULT NULL,
	CONSTRAINT PK_UNIT PRIMARY KEY(CODE),
	CONSTRAINT UQ_UNIT_CODE_NAME UNIQUE (CODE,NAME),
	CONSTRAINT UQ_UNIT_NAME UNIQUE (NAME)
	);
CREATE SEQUENCE UNIT_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE CATEGORYTYPE (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	NAME VARCHAR2(50 CHAR) DEFAULT NULL,
	CREATIONDATE TIMESTAMP (0) DEFAULT NULL,
	LIVE NUMBER(10) DEFAULT NULL,
	CONSTRAINT PK_CATEGORYTYPE PRIMARY KEY(CODE)
	);
CREATE SEQUENCE CATEGORYTYPE_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE CATEGORY (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	TYPECODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CATEGORYCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	PARENTCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	DESCRIPTION VARCHAR2(255 CHAR) DEFAULT NULL,
	TIER NUMBER(10) DEFAULT NULL,
	LIVE NUMBER(10) DEFAULT '1',
	CREATIONDATE TIMESTAMP (0) DEFAULT NULL,
	LIGHTTOUCHREGIME NUMBER(10) DEFAULT '0',
	CONSTRAINT PK_CATEGORY PRIMARY KEY(CODE),
	CONSTRAINT FK_CATEGORY_CATEGORYTYPE_CODE FOREIGN KEY (TYPECODE) REFERENCES CATEGORYTYPE(CODE)
	);
CREATE SEQUENCE CATEGORY_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_CATEGORY_TYPECODE ON CATEGORY (TYPECODE);
CREATE INDEX IDX_CATEGORY_DESCRIPTION ON CATEGORY (DESCRIPTION);

CREATE TABLE ITEM (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	ITEM_SEQUENCE NUMBER(19) NOT NULL,
	PARENTCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CREATIONDATE TIMESTAMP (0) NOT NULL,
	EFFECTIVESTARTDATE TIMESTAMP (0) DEFAULT NULL,
	EFFECTIVEENDDATE TIMESTAMP (0) DEFAULT NULL,
	EXTERNALCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	PRODUCTCODE VARCHAR2(300) NOT NULL,
	COMPANYCODE VARCHAR2(64 CHAR) NOT NULL,
	BRAND VARCHAR2(70) DEFAULT NULL,
	TYPEDESCRIPTION VARCHAR2(500 CHAR) DEFAULT NULL,
	DESCRIPTION VARCHAR2(1000 CHAR) DEFAULT NULL,
	LONGDESCRIPTION CLOB,
	UOM VARCHAR2(80 CHAR) DEFAULT NULL,
	UOMDENOMINATOR NUMBER(10) NOT NULL,
	MAXIMUMORDERQUANTITY NUMBER(10) DEFAULT NULL,
	MINIMUMORDERQUANTITY NUMBER(10) DEFAULT NULL,
	SERVICE NUMBER(3) DEFAULT NULL,
	BASE NUMBER(3) DEFAULT NULL,
	GTIN VARCHAR2(14) DEFAULT NULL,
	DELIVERYDAYS NUMBER(10) DEFAULT NULL,
	DELIVERYDAYTYPE NUMBER(10) DEFAULT NULL,
	PRODUCTURL VARCHAR2(2500 CHAR) DEFAULT NULL,
	PICTUREURL VARCHAR2(2500 CHAR) DEFAULT NULL,
	TAXCODE VARCHAR2(64 CHAR) NOT NULL,
	LIVE NUMBER(3) DEFAULT '1' NOT NULL,
	ECLASS VARCHAR2(64 CHAR) NOT NULL,
	ORIGINALUOM VARCHAR2(256 CHAR) DEFAULT NULL,
	MADETOORDER NUMBER(3) DEFAULT NULL,
	TAXRATE NUMBER(3, 2) DEFAULT NULL CHECK (TAXRATE > 0),
	UOMCODE VARCHAR2(64 CHAR) NOT NULL,
	CATEGORYCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	VALIDATED NUMBER(3) DEFAULT '1',
	LASTMODIFIEDDATE TIMESTAMP (0) DEFAULT NULL,
	CONSTRAINT PK_ITEM PRIMARY KEY(ITEM_SEQUENCE,CODE),
	CONSTRAINT UQ_ITEM_CODE UNIQUE(CODE),
	CONSTRAINT UQ_ITEM_PRODUCT_COMPANYCODE UNIQUE(PRODUCTCODE,COMPANYCODE),
	CONSTRAINT FK_ITEM_SUPPLIERCOMPANY_CODE FOREIGN KEY (COMPANYCODE) REFERENCES SUPPLIERCOMPANY(CODE),
	CONSTRAINT FK_ITEM_TAX_CODE FOREIGN KEY (TAXCODE) REFERENCES TAX(CODE),
	CONSTRAINT FK_ITEM_UNIT_CODE FOREIGN KEY (UOMCODE) REFERENCES UNIT(CODE),
	CONSTRAINT FK_ITEM_CATEGORY_CODE FOREIGN KEY (CATEGORYCODE) REFERENCES CATEGORY(CODE)
	);
CREATE SEQUENCE ITEM_CODE_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE ITEM_SEQUENCE_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_ITEM_COMPANYCODE ON ITEM (COMPANYCODE);
CREATE INDEX IDX_ITEM_COMPANYCODE_DESCRIPTION ON ITEM (COMPANYCODE,DESCRIPTION);
CREATE INDEX IDX_ITEM_COMPANYCODE_GTIN ON ITEM(COMPANYCODE,GTIN);
CREATE INDEX IDX_ITEM_COMPANYCODE_PRODUCTCODE_DESCRIPTION ON ITEM(COMPANYCODE,PRODUCTCODE,DESCRIPTION);
CREATE INDEX IDX_ITEM_DESCRIPTION ON ITEM(DESCRIPTION);
CREATE INDEX IDX_ITEM_ITEM_SEQUENCE ON ITEM(ITEM_SEQUENCE);
CREATE INDEX IDX_ITEM_TAXCODE ON ITEM(TAXCODE);
CREATE INDEX IDX_ITEM_PRODUCTCODE ON ITEM(PRODUCTCODE);

CREATE TABLE ITEMSUPPLIER (
  CODE VARCHAR2(64 CHAR) NOT NULL,
  ITEMSUPPLIER_SEQUENCE NUMBER(19) NOT NULL,
  CREATIONDATE VARCHAR2(64 CHAR) NOT NULL,
  COMPANYCODE VARCHAR2(64 CHAR) NOT NULL,
  ITEMCODE VARCHAR2(64 CHAR) NOT NULL,
  PRODUCTCODE VARCHAR2(100 CHAR) NOT NULL,
  UOMCODE VARCHAR2(64 CHAR) NOT NULL,
  UOMDENOMINATOR NUMBER(10) NOT NULL,
  NOTES CLOB,
  LIVE NUMBER(3) DEFAULT '1' NOT NULL,
  MINIMUMORDERQUANTITY NUMBER(10) DEFAULT NULL,
  MAXIMUMORDERQUANTITY NUMBER(10) DEFAULT NULL,
  DELIVERYDAYS NUMBER(10) DEFAULT NULL,
  DELIVERYDAYSTYPE NUMBER(3) DEFAULT '0',
  VALIDATED NUMBER(3) DEFAULT '1',
  LASTMODIFIEDDATE TIMESTAMP(0) DEFAULT NULL,
  CONSTRAINT PK_ITEMSUPPLIER PRIMARY KEY(ITEMSUPPLIER_SEQUENCE,CODE),
  CONSTRAINT UQ_ITEMSUPPLIER_COMPANY_PRODUCT_ITEM_CODE UNIQUE (COMPANYCODE,PRODUCTCODE,ITEMCODE),
  CONSTRAINT UQ_ITEMSUPPLIER_CODE UNIQUE (CODE),
  CONSTRAINT UQ_ITEMSUPPLIER_PRODUCT_COMPANY_CODE UNIQUE (PRODUCTCODE,COMPANYCODE),
  CONSTRAINT FK_ITEMSUPPLIER_SUPPLIERCOMPANY_CODE FOREIGN KEY (COMPANYCODE) REFERENCES SUPPLIERCOMPANY(CODE),
  CONSTRAINT FK_ITEMSUPPLIER_ITEM_CODE FOREIGN KEY (ITEMCODE) REFERENCES ITEM (CODE),
  CONSTRAINT FK_ITEMSUPPLIER_UNIT_CODE FOREIGN KEY (UOMCODE) REFERENCES UNIT(CODE)
);
CREATE SEQUENCE ITEMSUPPLIER_CODE_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE ITEMSUPPLIER_SEQUENCE_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_ITEMSUPPLIER_ITEMCODE ON ITEMSUPPLIER (ITEMCODE);
CREATE INDEX IDX_ITEMSUPPLIER_COMPANYCODE ON ITEMSUPPLIER (COMPANYCODE);
CREATE INDEX IDX_ITEMSUPPLIER_PRODUCTCODE ON ITEMSUPPLIER (PRODUCTCODE);
CREATE INDEX IDX_ITEMSUPPLIER_UOMCODE ON ITEMSUPPLIER (UOMCODE);
CREATE INDEX IDX_ITEMSUPPLIER_UOMCODE_UOMDENOMINATOR ON ITEMSUPPLIER (UOMCODE,UOMDENOMINATOR);
CREATE INDEX IDX_ITEMSUPPLIER_UOMDENOMINATOR ON ITEMSUPPLIER (UOMDENOMINATOR);
CREATE INDEX IDX_ITEMSUPPLIER_COMPANYCODE_CODE ON ITEMSUPPLIER (COMPANYCODE,CODE);

CREATE TABLE CONTRACTDEFINITIONITEM (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	CONTRACTDEFINITIONCODE VARCHAR2(64 CHAR) NOT NULL,
	ITEMSUPPLIERCODE VARCHAR2(64 CHAR) NOT NULL,
	STATE VARCHAR2(100 CHAR) DEFAULT NULL,
	PRICE NUMBER(12, 6) NOT NULL,
	ESTIMATEDANNUALQUANTITY NUMBER(10) DEFAULT NULL CHECK (ESTIMATEDANNUALQUANTITY > 0),
	DELIVERYDAYS NUMBER(10) CHECK (DELIVERYDAYS > 0) NOT NULL,
	DELIVERYDAYTYPE NUMBER(10) NOT NULL,
	PRICEBANDED NUMBER(3) DEFAULT NULL,
	PRICEBANDMINQUANTITY NUMBER(10) CHECK (PRICEBANDMINQUANTITY > 0) NOT NULL,
	PRICEBANDMAXQUANTITY NUMBER(10) DEFAULT NULL CHECK (PRICEBANDMAXQUANTITY > 0),
	CREATIONDATE TIMESTAMP (0) NOT NULL,
	LIVE NUMBER(3) NOT NULL,
	APPROVALNUMBER NUMBER(10) DEFAULT '0' NOT NULL,
	APPROVALSTATE VARCHAR2(10 CHAR) DEFAULT NULL CHECK( APPROVALSTATE IN ('APPROVED', 'REJECTED', 'PENDING')),
	BAND NUMBER(11) DEFAULT NULL,
	LASTMODIFIEDDATE TIMESTAMP DEFAULT NULL,
	CONSTRAINT PK_CONTRACTDEFINITIONITEM PRIMARY KEY(CODE),
	CONSTRAINT UQ_CONTRACTDEFINITIONITEM_CDC_ISC_PAMQ_PRICE UNIQUE(CONTRACTDEFINITIONCODE, ITEMSUPPLIERCODE, PRICEBANDMINQUANTITY, PRICE),
	CONSTRAINT FK_CONTRACTDEFINITIONITEM_CONTRACTDEFINITIONCODE FOREIGN KEY (CONTRACTDEFINITIONCODE) REFERENCES CONTRACTDEFINITION(CODE),
	CONSTRAINT FK_CONTRACTDEFINITIONITEM_ITEMSUPPLIERCODE FOREIGN KEY (ITEMSUPPLIERCODE) REFERENCES ITEMSUPPLIER(CODE)
	);
CREATE SEQUENCE CONTRACTDEFINITIONITEM_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_CONTRACTDEFINITIONITEM_CONTRACTDEFINITIONCODE ON CONTRACTDEFINITIONITEM (CONTRACTDEFINITIONCODE);
CREATE INDEX IDX_CONTRACTDEFINITIONITEM_ITEMSUPPLIERCODE ON CONTRACTDEFINITIONITEM (ITEMSUPPLIERCODE);
CREATE INDEX IDX_CONTRACTDEFINITIONITEM_APPROVALSTATE ON CONTRACTDEFINITIONITEM (APPROVALSTATE);
CREATE INDEX IDX_CONTRACTDEFINITIONITEM_CDC_ISC ON CONTRACTDEFINITIONITEM (CONTRACTDEFINITIONCODE, ITEMSUPPLIERCODE);

CREATE TABLE CATALOG (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CONTRACTDEFINITIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	ORGANIZATIONGROUPCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	REFERENCEORGANIZATIONCODE VARCHAR2(64 CHAR) DEFAULT NULL,
	CREATIONDATE TIMESTAMP (0) DEFAULT NULL,
	LIVE NUMBER(3) DEFAULT '1',
	CONSTRAINT PK_CATALOG PRIMARY KEY(CODE),
	CONSTRAINT UQ_CATALOG_CDC_OGC_ROC UNIQUE (CONTRACTDEFINITIONCODE,ORGANIZATIONGROUPCODE,REFERENCEORGANIZATIONCODE),
	CONSTRAINT FK_CATALOG_CONTRACTDEFINITION_CODE FOREIGN KEY (CONTRACTDEFINITIONCODE) REFERENCES CONTRACTDEFINITION(CODE),
	CONSTRAINT FK_CATALOG_ORGANIZATIONGROUP_CODE FOREIGN KEY (ORGANIZATIONGROUPCODE) REFERENCES ORGANIZATIONGROUP(CODE)
	);
CREATE SEQUENCE CATALOG_SEQ START WITH 1 INCREMENT BY 1;
CREATE INDEX IDX_CATALOG_ORGANIZATIONGROUP_CODE_FK ON CATALOG (ORGANIZATIONGROUPCODE);
CREATE INDEX IDX_CATALOG_REFERENCEORGANIZATIONCODE_CONTRACTDEFINITIONCODE ON CATALOG (REFERENCEORGANIZATIONCODE,CONTRACTDEFINITIONCODE);
CREATE INDEX IDX_CATALOG_ORGANIZATIONCODE ON CATALOG (ORGANIZATIONCODE);
CREATE INDEX IDX_CATALOG_REFERENCEORGANIZATIONCODE ON CATALOG (REFERENCEORGANIZATIONCODE);

CREATE TABLE CATALOGITEM (
	CODE VARCHAR2(64 CHAR) NOT NULL,
	ORGANIZATIONCODE VARCHAR2(64 CHAR) NOT NULL,
	CATALOGCODE VARCHAR2(64 CHAR) NOT NULL,
	CONTRACTDEFINITIONITEMCODE VARCHAR2(64 CHAR) NOT NULL,
	CREATIONDATE TIMESTAMP (0) DEFAULT NULL,
	LIVE NUMBER(3) DEFAULT '1',
	CONSTRAINT PK_CATALOGITEM PRIMARY KEY(CODE),
	CONSTRAINT UQ_CATALOGITEM_CONTRACTDEFINITIONITEM_CATALOG_CODE UNIQUE (CONTRACTDEFINITIONITEMCODE,CATALOGCODE),
	CONSTRAINT FK_CATALOGITEM_CATALOG_CODE FOREIGN KEY (CATALOGCODE) REFERENCES CATALOG(CODE),
	CONSTRAINT FK_CATALOGITEM_CONTRACTDEFINITIONITEM_CODE FOREIGN KEY (CONTRACTDEFINITIONITEMCODE) REFERENCES CONTRACTDEFINITIONITEM(CODE)
	);
CREATE SEQUENCE CATALOGITEM_SEQ START WITH 1 INCREMENT BY 1;	
CREATE INDEX IDX_CATALOGITEM_CONTRACTDEFINITIONITEMCODE ON CATALOGITEM (CONTRACTDEFINITIONITEMCODE);
CREATE INDEX IDX_CATALOGITEM_CATALOGCODE ON CATALOGITEM (CATALOGCODE);

/
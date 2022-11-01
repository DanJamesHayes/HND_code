/*Clear existing tables*/
DROP TABLE customer CASCADE CONSTRAINTS;
DROP TABLE work_order CASCADE CONSTRAINTS;
DROP TABLE staff CASCADE CONSTRAINTS;
DROP TABLE items CASCADE CONSTRAINTS;
DROP TABLE line_item CASCADE CONSTRAINTS;
DROP VIEW staff_details_view;
DROP VIEW line_item_price_view;

/*Create customer table to hold customer name, address and unique ID*/
/*Cust_no is foreign key in job table*/
CREATE TABLE customer (
    cust_no         VARCHAR2(6)
        CONSTRAINT cus_cus_no_PK PRIMARY KEY
    , first_name    VARCHAR2(25)
        CONSTRAINT cus_fname_NN NOT NULL
    , surname       VARCHAR2(25)
        CONSTRAINT cus_surname_NN NOT NULL
    , address       VARCHAR2(25)
    , postcode      VARCHAR2(8)
    , phone_no      VARCHAR2(11)
        CONSTRAINT cus_phone_no_U UNIQUE
        CONSTRAINT cus_phone_no_NN NOT NULL
    ) ;
    
/*Create staff table to hold staff name, address, dob and unique ID*/
/*Staff_no is foreign key in job table*/
CREATE TABLE staff (
    staff_no        VARCHAR2(4)
    , first_name    VARCHAR2(25)
        CONSTRAINT stf_fname_NN NOT NULL
    , surname       VARCHAR2(25)
        CONSTRAINT stf_surname_NN NOT NULL
    , address       VARCHAR2(25)
    , postcode      VARCHAR2(8)
    , phone_no      VARCHAR2(11)
        CONSTRAINT staff_phone_no_U UNIQUE
        CONSTRAINT staff_phone_no_NN NOT NULL
	, dob			DATE
    ) ;

ALTER TABLE staff
ADD ( CONSTRAINT cus_staff_no_pk
        PRIMARY KEY (staff_no)
    ) ;
    
/*Create job table to store job details*/
/*Job_no forms part of a composite key in the line_item table*/
CREATE TABLE work_order (
    job_no	        NUMBER(8)
        CONSTRAINT wo_job_no_PK PRIMARY KEY
    , cust_no       VARCHAR2(6)
    , staff_no      VARCHAR2(4)
    , job_desc      VARCHAR2(50)
		CONSTRAINT wo_job_desc_NN NOT NULL
    , comp_date		DATE
    , garage_name	VARCHAR2(20)
        CONSTRAINT wo_gar_nam_NN NOT NULL
    , net_total     NUMBER(10,2)
    , vat			NUMBER(10,2)
    , total         NUMBER(10,2)
    ) ;

CREATE INDEX wo_cust_no_FK
ON work_order (cust_no);

CREATE INDEX wo_staff_no_FK
ON work_order (staff_no);

ALTER TABLE work_order
ADD ( CONSTRAINT check_job_no
        CHECK (job_no BETWEEN 00000001 AND 99999999)
    , CONSTRAINT wo_cust_no_FK
        FOREIGN KEY (cust_no)
        REFERENCES customer
    , CONSTRAINT wo_staff_no_FK
        FOREIGN KEY (staff_no)
        REFERENCES staff
        ON DELETE CASCADE
    ) ;

/*Create items table to record details about job items*/
/*Item_code forms part of a composite key in the line_item table*/
CREATE TABLE items (
    item_code           VARCHAR2(6)
    , item_desc			VARCHAR2(40)
    , item_cost_ex_vat	NUMBER(8,2)
    ) ;

ALTER TABLE items
ADD ( CONSTRAINT itm_item_code_PK
        PRIMARY KEY (item_code)
    ) ;

/*Create line_item table to establish relational integrity between the quote and
parts tables*/
CREATE TABLE line_item (
    item_code   VARCHAR2(6)
    , job_no    NUMBER(8)
    , qty       NUMBER(2)
        CONSTRAINT lin_itm_qty_NN NOT NULL
    ) ;

CREATE INDEX lin_item_code_FK
ON line_item (item_code);

CREATE INDEX lin_job_no_FK
ON line_item (job_no);

ALTER TABLE line_item
ADD ( CONSTRAINT line_item_CK
        PRIMARY KEY (item_code, job_no)
    , CONSTRAINT lin_item_code_FK
        FOREIGN KEY (item_code)
        REFERENCES items
        ON DELETE CASCADE
    , CONSTRAINT lin_job_no_FK
        FOREIGN KEY (job_no)
        REFERENCES work_order
        ON DELETE CASCADE
    ) ;

/*Create view restricted view of staff details*/  
CREATE OR REPLACE VIEW staff_details_view
    (staff_no,
    first_name,
    surname,
    phone_no)
AS SELECT
    s.staff_no,
    s.first_name,
    s.surname,
    s.phone_no
FROM
    staff s
WITH READ ONLY;

/* Create view to combine the line_item and items table to calculate
    the unit * quantity cost */
CREATE OR REPLACE VIEW line_item_price_view
    (job_no,
    item_code,
    qty,
    item_cost_ex_vat,
    qtyXcost)
AS SELECT
    l.job_no,
    l.item_code,
    l.qty,
    i.item_cost_ex_vat,
    l.qty * i.item_cost_ex_vat
FROM
    line_item l,
    items i
WHERE 
    l.item_code = i.item_code
WITH READ ONLY;   

COMMIT;

grant select, update, insert, delete on customer to username;

desc customer;

Select * from customer;

SELECT COUNT(*)
FROM customer
WHERE 'C00002' IN cust_no;

grant select, update, insert, delete on staff to username;

Select * from staff;

UPDATE sys.staff
SET first_name = 'fff', surname = 'fff', address = '', postcode = '', phone_no = '45612378945', dob = '' 
WHERE staff_no = 's002';

grant select, update, insert, delete on items to username;

DESC work_order;

DESC items;

INSERT INTO customer VALUES
    ( 'C00005'
    , 'Dan'
    , 'Hayes'
    , '72 Salmon Crecent'
    , 'SK16 5AH'
    , '07979123456'
    ) ;
    
SELECT * FROM sys.customer;

INSERT INTO work_order VALUES
    ( '12345888'
    , 'C00002'
    , 's001'
    , 'Service'
    , ''
    , 'Manchester'
    , '31.92'
    , '8.07'
    , '39.99'
    ) ;

SELECT * FROM sys.work_order;

grant select, update, insert, delete on work_order to username;

SELECT * FROM sys.work_order WHERE job_no IN 12345888;

DESC line_item;

INSERT INTO sys.work_order (job_no, cust_no, staff_no, job_desc, comp_date, garage_name, net_total, vat, total) 
VALUES 
    ( '12345655'
    , 'C00005'
    , 's007'
    , 'Service'
    , ''
    , 'Mank'
    , ''
    , ''
    , ''
    );
    
grant select, update, insert, delete on line_item to username;

SHOW USER;

SELECT * FROM sys.staff_details_view;

grant select on staff_details_view to username;

SELECT * FROM line_item_price_view;

UPDATE sys.line_item
SET qty = 2
WHERE job_no = 12345888 AND item_code = 'svc123';

SELECT SUM(qtyXcost) AS net_total, SUM(qtyXcost*0.2) AS vat, SUM(qtyXcost*1.2) AS total
FROM sys.line_item_price_view
WHERE job_no IN 12345888;

SELECT SUM(qtyXcost) AS net_total, SUM(qtyXcost*0.2) AS vat, SUM(qtyXcost*1.2) AS total
FROM sys.line_item_price_view
WHERE job_no IN (
    SELECT job_no
    FROM sys.line_item
    WHERE job_no = 12345888);
        
grant select on line_item_price_view to username;

SELECT * FROM sys.work_order WHERE job_no IN 12345655;

LOCK TABLE customer IN EXCLUSIVE MODE NOWAIT;
SELECT * FROM customer;
COMMIT;

DESC staff;
DESC items;


AUDIT SELECT, DELETE, UPDATE, INSERT ON sys.work_order;

SELECT sqltext FROM sys.aud$ WHERE obj$name = 'work_order';

LOCK TABLE line_item IN EXCLUSIVE MODE NOWAIT;
SELECT * FROM line_item;
COMMIT;

grant audit any to staff;

UPDATE sys.line_item
SET qty = 2
WHERE job_no = 00000001 AND item_code = 'svc123';

AUDIT SELECT, DELETE, UPDATE, INSERT ON sys.work_order;

AUDIT SELECT, DELETE, UPDATE, INSERT ON sys.work_order;

SELECT sqltext FROM sys.aud$ WHERE obj$name = 'work_order';

INSERT INTO sys.work_order (job_no, cust_no, staff_no, job_desc, comp_date, garage_name, net_total, vat, total) 
VALUES 
    ( '12345655'
    , 'C00004'
    , 'S001'
    , 'Service'
    , ''
    , 'Mank'
    , ''
    , ''
    , ''
    );
    
COMMIT; 

SELECT sqltext FROM sys.aud$ WHERE obj$name = 'work_order';

SELECT * FROM work_order;
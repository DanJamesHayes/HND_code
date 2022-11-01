/* Permissions granted to all staff members */
GRANT SELECT, UPDATE, INSERT, DELETE ON customer TO admin, staff;
GRANT SELECT, UPDATE, INSERT, DELETE ON work_order TO admin, staff;
GRANT SELECT, UPDATE, INSERT, DELETE ON line_item TO admin, staff;
GRANT SELECT, UPDATE, INSERT, DELETE ON line_item_price_view TO admin, staff;
GRANT SELECT, UPDATE, INSERT, DELETE ON staff_details_view TO admin, staff;

/* Permissions granted to admin only */
GRANT SELECT, UPDATE, INSERT, DELETE ON staff TO admin;
GRANT SELECT, UPDATE, INSERT, DELETE ON items TO admin;

COMMIT;
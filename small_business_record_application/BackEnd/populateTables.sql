/* Populate Customer table */
INSERT INTO customer VALUES
    ( 'C00001'
    , 'Dan'
    , 'Hayes'
    , '72 Salmon Crecent'
    , 'SK1 5AH'
    , '07900000001'
    ) ;
    
INSERT INTO customer VALUES
    ( 'C00002'
    , 'Vic'
    , 'Hayes'
    , '72 Salmon Crecent'
    , 'SK1 5AH'
    , '07900000002'
    ) ;
    
INSERT INTO customer VALUES
    ( 'C00003'
    , 'Leo'
    , 'Casillas'
    , '555 Stockport Road'
    , 'SK1 5DB'
    , '07900000003'
    ) ;
    
INSERT INTO customer VALUES
    ( 'C00004'
    , 'Helen'
    , 'Martin'
    , '590 Bury Road'
    , 'BU1 5TG'
    , '07900000004'
    ) ;
    
    
/* Populate Staff table */
INSERT INTO staff VALUES
    ( 'S001'
    , 'Rob'
    , 'Stroud'
    , '58 Dukinfield Road'
    , 'SK16 5DR'
    , '07900000005'
    , TO_DATE('01-JAN-1980', 'dd-MON-yyyy')
    ) ;
    
INSERT INTO staff VALUES
    ( 'S002'
    , 'Craig'
    , 'Fairfield'
    , '72 Davenport Road'
    , 'SK3 5LM'
    , '07900000006'
    , TO_DATE('20-FEB-1960', 'dd-MON-yyyy')
    ) ;
    
INSERT INTO staff VALUES
    ( 'S003'
    , 'Nic'
    , 'Antoniou'
    , '34 Hyde Road'
    , 'SK14 6KK'
    , '07900000007'
    , TO_DATE('30-MAR-1980', 'dd-MON-yyyy')
    ) ;
    
INSERT INTO staff VALUES
    ( 'S004'
    , 'Tony'
    , 'Unsworth'
    , '14 Wild Street'
    , 'SK6 4TH'
    , '07900000008'
    , TO_DATE('10-APR-1970', 'dd-MON-yyyy')
    ) ;
    

/* Populate items table */    
INSERT INTO items VALUES
    ( 'lab060'
    , 'Labour 1 hour'
    , 30.00
    ) ;
    
INSERT INTO items VALUES
    ( 'lab030'
    , 'Labour 30 mins'
    , 15.00
    ) ;

INSERT INTO items VALUES
    ( 'svc123'
    , 'Basic service'
    , 64.64
    ) ;

INSERT INTO items VALUES
    ( 'svc777'
    , 'Full service'
    , 140.14
    ) ;
    
INSERT INTO items VALUES
    ( 'mot001'
    , 'Standalone MOT'
    , 35.35
    ) ;
    
INSERT INTO items VALUES
    ( 'mot123'
    , 'MOT and basic service'
    , 89.89
    ) ;
    
INSERT INTO items VALUES
    ( 'mot777'
    , 'MOT and full service'
    , 165.16
    ) ;   
    
INSERT INTO items VALUES
    ( 'tyr234'
    , 'Basic tyre'
    , 56.56
    ) ;
    
INSERT INTO items VALUES
    ( 'tyr777'
    , 'Premium tyre'
    , 96.96
    ) ;
    
INSERT INTO items VALUES
    ( 'bat111'
    , 'Battery'
    , 143.43
    ) ;
    
COMMIT;    

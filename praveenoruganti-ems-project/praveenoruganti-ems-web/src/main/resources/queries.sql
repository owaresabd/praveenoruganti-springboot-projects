DROP TABLE IF EXISTS employeelogindb.user;

CREATE TABLE employeelogindb.USER (
  USER_ID INT AUTO_INCREMENT PRIMARY KEY,
  USER_NAME VARCHAR(45) NOT NULL,
  USER_PASS VARCHAR(45) NOT NULL
 );



INSERT INTO USER(USER_NAME, USER_PASS) 
            VALUES('praveen','welcome123'); 
            
   
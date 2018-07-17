-- product.sql
/*
Product adidas = new Product("S001", "슈퍼스타", 87200, 5);
*/
-- 1. PRODUCT 테이블 생성 구문
/* prodcode      VARCHAR2(4)
 * prodname      VARCHAR2(50)
 * price         NUMBER(12)
 * quantity      NUMBER(3)
 * regdate       DATE    DEFAULT sysdate
 * moddate       DATE
 * pk_product :  prodcode
 */
CREATE TABLE product
(  prodcode  VARCHAR2(4)
  ,prodname  VARCHAR2(50)
  ,price     NUMBER(12)
  ,quantity  NUMBER(3)
  ,regdate   DATE   DEFAULT sysdate
  ,moddate   DATE
  ,CONSTRAINT pk_product PRIMARY KEY (prodcode)
);


-- 2. isExists() : 동일 데이터가 존재하는지 선조회
SELECT p.prodcode
  FROM product p
 WHERE p.prodcode = ?
 

-- 3. add() : 신규 데이터 생성
INSERT INTO product(prodcode, prodname, price, quantity)
VALUES (?, ?, ?, ?)

-- 4. get() : 제품정보 조회
SELECT p.prodcode
      ,p.prodname
      ,p.price
      ,p.quantity
  FROM product p
 WHERE p.PRODCODE = ?


-- 5. set() : 제품정보 수정
UPDATE product p 
   SET p.prodname = ? 
     , p.price = ?
     , p.quantity = ?
 WHERE p.prodcode = ?


-- 6. remove() : 제품정보 삭제
DELETE FROM product p  
 WHERE p.prodcode = ?












































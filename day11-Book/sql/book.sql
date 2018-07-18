-- book.sql
/*
Book hesse = new Book("BK001", "데미안", "헤르만 헤세", 9800, "9783161484100", "더스토리");
*/
-- 1. Book 테이블 생성 구문
/* bookId        VARCHAR2(5)
 * title         VARCHAR2(200)
 * author        VARCHAR2(50)
 * price         NUMBER(10)
 * isbn          VARCHAR2(13)
 * publish       VARCHAR2(30)
 * regdate       DATE    DEFAULT sysdate
 * moddate       DATE
 * pk_book   :   bookId
 */
CREATE TABLE book
(  bookId        VARCHAR2(5)
  ,title         VARCHAR2(200)
  ,author        VARCHAR2(50)
  ,price         NUMBER(10)
  ,isbn          VARCHAR2(13)
  ,publish       VARCHAR2(30)
  ,regdate   DATE   DEFAULT sysdate
  ,moddate   DATE
  ,CONSTRAINT pk_book PRIMARY KEY (bookId)
)

-- 2. select() : 도서정보 조회
SELECT b.bookId 
     , b.title
     , b.author 
     , b.price
     , b.isbn
     , b.publish
  FROM book b
 WHERE b.bookId = ?
 
 
-- 3. insert() : 도서정보 추가
INSERT INTO book(bookId, title, author, price, isbn, publish)"
VALUES (?, ?, ?, ?, ?, ?)
            
 
-- 4. update() : 도서정보 수정
UPDATE book b
   SET b.title = ? 
     , b.author = ?
     , b.price = ?
     , b.isbn = ?
     , b.publish = ?
     , b.MODDATE  = sysdate
 WHERE b.bookId = ?
 
-- 5. delete() : 도서정보 삭제
DELETE book b         
 WHERE b.bookId = ?
                 
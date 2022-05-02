/*
*	지출내역서 테이블과 지출내역서구분 테이블에 데이터를 추가/수정/삭제 하는 작업을 진행 한다.
*		1. "지출내역구분" 에는 본인의 한 달치 분량의 생활비 내역을 참고하여 교통비, 식대, 수도세, 전기세 등의 구분명을 추가 한다.
*
*		2. "지출내역서" 에는 본인의 한 달치 분량의 실제 입출고 내역을 참고하여 가계부를 작성하듯 데이터를 추가한다. 
*
*		3. 테이블에 추가하는 데이터는 최소 5 ~ 10개 정도는 추가하도록 한다.
*
*
*	위 작업을 모두 마친 후에는 다음의 작업을 추가로 진행 한다.
*		1. 
*/

INSERT INTO 지출내역구분 VALUES(1, '용돈');
INSERT INTO 지출내역구분 VALUES(2, '급여');
INSERT INTO 지출내역구분 VALUES(3, '식비');
INSERT INTO 지출내역구분 VALUES(4, '월세');
INSERT INTO 지출내역구분 VALUES(5, '전기세');
INSERT INTO 지출내역구분 VALUES(6, '수도세');
INSERT INTO 지출내역구분 VALUES(7, '차량유지비');
INSERT INTO 지출내역구분 VALUES(8, '유류비');


INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			  1,			1, TO_DATE(20220305), 500000,       0,	   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			  2,			4, TO_DATE(20220315),      0,   15000,	   '');		
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			  3,			6, TO_DATE(20220319), 	   0,   45000,	   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			  4,			3, TO_DATE(20220320),      0,   30000,	   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			  5,			3, TO_DATE(20220325),      0,    7000,	   '');
		

		
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			  6,			1, TO_DATE(20220405), 500000,       0,	   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			  7,			7, TO_DATE(20220415),      0,   15000,	   '');		
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			  8,			7, TO_DATE(20220419), 	   0,   45000,	   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			  9,			3, TO_DATE(20220420),      0,   30000,	   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			 10,			5, TO_DATE(20220425),      0,    7000,	   '');		
		

		
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			 11,			1, TO_DATE(20220505), 500000,       0,	   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			 12,			7, TO_DATE(20220507),      0,   15000,	   '');		
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			 13,			5, TO_DATE(20220510), 	   0,   45000,	   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			 14,			2, TO_DATE(20220522),      0,   30000,	   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE, 				날짜,   입금액, 	출금액,    비고) 
			VALUES(			 15,			4, TO_DATE(20220526),      0,  107000,	   '');		
		

		
SELECT EXTRACT( YEAR FROM 날짜) AS 년
	  ,EXTRACT( MONTH FROM 날짜) AS 월
	  ,SUM(입금액) AS 입금액
	FROM 지출내역서
	WHERE 입금액 > 0
GROUP BY ROLLUP(EXTRACT( YEAR FROM 날짜), EXTRACT( MONTH FROM 날짜));

SELECT EXTRACT( YEAR FROM 날짜) AS 년
	  ,EXTRACT( MONTH FROM 날짜) AS 월
	  ,SUM(출금액) AS 출금액
	FROM 지출내역서
	WHERE 출금액 > 0
GROUP BY ROLLUP(EXTRACT( YEAR FROM 날짜), EXTRACT( MONTH FROM 날짜));

SELECT EXTRACT( YEAR FROM 날짜) AS 년
	  ,EXTRACT( MONTH FROM 날짜) AS 월
	  ,SUM(입금액) AS 입금액
	  ,SUM(출금액) AS 출금액
	FROM 지출내역서
GROUP BY ROLLUP(EXTRACT( YEAR FROM 날짜), EXTRACT( MONTH FROM 날짜));

	
CREATE TABLE 월별지출내역
	AS SELECT EXTRACT( YEAR FROM 날짜) AS 년
	  		 ,EXTRACT( MONTH FROM 날짜) AS 월
	  		 ,'입' AS 지출구분
	  		 ,입금액 AS 금액
	  	FROM 지출내역서
	  	WHERE 1 = 0;
	  
	  
	  
INSERT ALL INTO 월별지출내역 VALUES (년, 월, 지출구분, 금액)
	  SELECT EXTRACT( YEAR FROM 날짜) AS 년
	  ,EXTRACT( MONTH FROM 날짜) AS 월
	  ,CASE WHEN 입금액 > 0 THEN '입'
	  		WHEN 출금액 > 0 THEN '출'
	  	END  지출구분	
	  ,SUM(입금액 + 출금액) AS 금액
	FROM 지출내역서
GROUP BY EXTRACT( YEAR FROM 날짜), EXTRACT( MONTH FROM 날짜)
			  	,CASE WHEN 입금액 > 0 THEN '입'
	  			      WHEN 출금액 > 0 THEN '출'
	  	END;

/*
 * 지출내역서에 작성된 모든 지출을 기존 금액보다 10% 인상 시키고 이를 
 * 월별지출내역서에도 반영하도록 한다.
 */	  
	  
UPDATE 지출내역서	
	SET 출금액 = 출금액 * 1.1
 WHERE 출금액 > 0 ; 
	  
UPDATE 월별지출내역	
	SET 금액 = 금액 * 1.1
 WHERE 지출구분 = '출' ; 	  


SELECT * FROM 월별지출내역;		
SELECT * FROM 지출내역서;
SELECT * FROM 지출내역구분;


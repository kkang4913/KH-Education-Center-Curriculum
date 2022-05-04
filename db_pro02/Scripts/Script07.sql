/*
 *	VIEW : SELECT 실행 결과를 화면에 저장한 논리적 가상 테이블, 사용자는 테이블을 사용하는 것과 유사하게 사용 가능  
 *		   추가/수정/삭제 : 기존과 달리 제약이 존재한다.
 *
 *	DML명령어로 VIEW 조작이 불가능한 경우
 *		1. 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
 *		2. 뷰에 포함되지 않은 컬럼 중에 베이스가 되는 컬럼이 NOT NULL 제약조건이 지정된 경우
 *		3. 산술 표현식으로 정의된 경우
 *		4. 그룹함수 OR GROUP BY 절을 포함한 경우
 *		5. DISTINCT 중복을 제거 : 구분이 불가
 *  	6. JOIN을 이용해 여러 테이블을 연결한 경우 : 연결되어 있기에 조작이 불가능 하다
 */



DROP TABLE SAMPLE_T;

CREATE TABLE SAMPLE_T(
		ID NUMBER PRIMARY KEY
	   ,NAME VARCHAR(30) NOT NULL
	   ,GENDER CHAR(1) CHECK(GENDER IN ('F','M'))
	   ,AGE  NUMBER DEFAULT(0) NOT NULL
);

INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL,'홍길동', 'M',32);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL,'김수정', 'F',30);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL,'강승호', 'M',34);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL,'강승호', 'M',34);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL,'강승호', 'M',34);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL,'강승호', 'M',34);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL,'강승호', 'M',34);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL,'강승호', 'M',34);

	 -- 중복시 REPLACE 시키겠다는 뜻
CREATE OR REPLACE VIEW V_SAMPLE_T
		AS SELECT ID
				 ,NAME
				 ,GENDER
				 ,AGE
				FROM SAMPLE_T
WHERE AGE BETWEEN 30 AND 35
--WITH READ ONLY;
WITH CHECK OPTION;
				
SELECT *FROM V_SAMPLE_T;

SELECT *FROM USER_VIEWS;

INSERT INTO V_SAMPLE_T VALUES(4,'이기석','M',30);


UPDATE V_SAMPLE_T
	SET AGE = AGE + 2;
 
DELETE FROM V_SAMPLE_T;
COMMIT;
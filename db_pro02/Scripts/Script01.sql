/*
*	DDL
*		- Data Definition Language : 데이터 정의어
*		- 객체를 정의하기 위한 CREATE(생성), ALTER(수정), DROP(제거) 구문이 있다
*		- 오라크에서 사용하는 객체는 TABLE, VIEW, SEQUENCE, INDEX, FUNTION, PROCEDUAL, USER, ... 등이 있다.
*/


-- [제약조건] : 테이블에 데이터를 저장할 때 저장되는 데이터를 제한하기 위해 사용하는 조건
-- NOT NULL : NULL데이터 허용X / UNIQUE :  중복데이터 허용X, UK / 
-- PRIMARY KEY : NOT NULL + UNIQUE 결합된 조건, 기본키,PK라고하며 데이터 식별값으로 사용
-- FOREIGN KEY : 외래키, FK 라고하며 다른 테이블의 데이터를 참조하기 위한 참조값이 저장된 컬럼을 명시, 테이블간의 관계를 형성하기 위해 사용
-- 참조 대상이 되는 테이블의 데이터는 임의로 삭제할 수 없다, FK로 지정된 컬럼에 저장될 데이터는 반드시 참조 대상 테이블에 동일한 데이터가 존재해야한다 (참조대상)
-- CHECK : 미리 설정한 값만 저장할 수 있도록 검사
/*
CREATE TABLE 테이블명 (
	컬럼명 데이터타입(크기) [제약조건]
	, ... 반복해서 생성 가능 
);
*/

-- 컬럼 레벨 : 컬럼 옆에 직접 명시하여 작성
-- 테이블 레벨 : 컬럼 외의 영역에 명시하여 작성


 -- 대소문자가 섞어도 상관 없다
CREATE TABLE sample_t(   -- 생성
		 u_id NUMBER  		--PRIMARY KEY 
		,jumin CHAR(13) 	--UNIQUE
		,name VARCHAR2(50)  NOT NULL --컬럼레벨로만 가능 ,--데이터크기 CHAR(바이트) CHAR(10 CHAR)(한글->3BYTE 3자)
		,age NUMBER(3)		DEFAULT(0)
		,gender CHAR(1) 	CHECK(GENDER IN('M', 'F'))
		,birth_day DATE 	DEFAULT(SYSDATE)
		,ref_col NUMBER  	--REFERENCES ref_t(r_id)
 		,CONSTRAINT PK_SAMPLE_T_U_ID PRIMARY KEY(u_id)
 		,CONSTRAINT PK_SAMPLE_T_JUMIN UNIQUE(jumin)
 		,CONSTRAINT PK_SAMPLE_T_REF_COL FOREIGN KEY (ref_col) REFERENCES ref_t(r_id)
		);

CREATE TABLE ref_t(
	r_id NUMBER PRIMARY KEY
   ,note VARCHAR(100)
);

ALTER TABLE sample_t ADD(nickname VARCHAR2(100)); --추가
ALTER TABLE sample_t MODIFY(nickname VARCHAR2(200)); --수정
ALTER TABLE sample_t MODIFY(nickname NUMBER); -- 타입을 바꾸면 데이터값이 있을경우 문제가 생긴다. 크기만 변환해라
ALTER TABLE sample_t RENAME COLUMN nickname TO n_name;
ALTER TABLE sample_t DROP COLUMN n_name;

--제약조건 생성하고 이름을 바꾸는 과정
ALTER TABLE ref_t ADD UNIQUE(note);
ALTER TABLE ref_t ADD CONSTRAINT UK_REF UNIQUE(note); --생성시 이름을 같이 만드는 것이 좋다
ALTER TABLE ref_t RENAME CONSTRAINT UK_REF TO UK_REF_T_NOTE;

ALTER TABLE ref_t MODIFY note VARCHAR2(100) NOT NULL;  -- NOT NULL 제약으로 수정하여 제약조건 추가 
ALTER TABLE ref_t MODIFY note VARCHAR2(100) NULL;  	 -- NULL 로 수정하여 제약조건 제거
ALTER TABLE ref_t MODIFY note CHECK(note IN ('h','k'));
ALTER TABLE ref_t DROP CONSTRAINT SYS_C0022353;

-- 컬럼 레벨로만 제약 조건을 추가하는 NOT NULL, CHECK 는 MODIFY 로 추가/삭제
-- 테이블 레벨로 제약 조건을 추가할 수 있는 PRIMARY KEY, UNIQUE, FOREIGN KEY 는 ADD, DROP 을 사용
ALTER TABLE ref_t DROP CONSTRAINT UK_REF_T_NOTE 
				  DROP CONSTRAINT SYS_C0022342;
ALTER TABLE ref_t ADD PRIMARY KEY(r_id, note); -- 제약조건을 수정하기 위해서 기존 제약조건을 삭제 후 추가

DROP TABLE ref_t CASCADE CONSTRAINT;


SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'REF_T';
ALTER TABLE ref_t DROP CONSTRAINT 


DROP TABLE SAMPLE_T; -- 삭제
DROP TABLE REF_T;

COMMENT ON COLUMN sample_t.u_id IS '사용자 구분 아이디';
COMMENT ON COLUMN sample_t.name IS '사용자 이름';
COMMENT ON COLUMN sample_t.age IS '사용자 나이';
COMMENT ON COLUMN sample_t.gender IS '사용자 성별(M:남자, F:여자)';
COMMENT ON COLUMN sample_t.birth_day IS '사용자 생년월일';



SELECT * FROM SAMPLE_T; -- 조회 
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = 'SAMPLE_T'; -- 다른 조회 방법 (꼭 대문자 사용)
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'REF_T';






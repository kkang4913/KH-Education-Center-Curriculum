-- 사전작업으로 PUSER1, DEAVDMIN 계정에 SYNONYM 를 생성할 권한을 부여
GRANT CREATE SYNONYM TO PUSER1;
GRANT CREATE SYNONYM TO DEVADMIN;

-- 비공개 동의어(PUSER1 에서 만듬.)
CREATE SYNONYM EMP1 FOR EMPLOYEES; 

-- 공개동의어 (관리자 계정에서만 사용 가능)
CREATE PUBLIC SYNONYM EMP2 FOR PUSER1.EMPLOYEES; 

-- 비공개 /공개 동의어를 다른 계정에서 사용하기 위해 최고한 SELECT 권한은 필요하다
GRANT SELECT ON EMPLOYEES TO DEVADMIN;
GRANT SELECT ON 테이블명 TO 계정명;

-- PUSER1 이 생성한 비공개 동의어를 DEVADMIN 이 접근하여 사용.
SELECT * FROM PUSER1.EMP1;

-- 관리자가 생성한 공개 동의어를 DEVADMIN 이 접근하여 사용.
SELECT * FROM EMP2;


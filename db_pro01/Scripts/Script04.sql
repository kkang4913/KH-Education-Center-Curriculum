-- 단일행 함수
SELECT FIRST_NAME
	,LENGTH (FIRST_NAME)
	FROM EMPLOYEES;
	
--범위 데이터가 저장될 수 있는 테이블 = 임시 테이블
SELECT LENGTH('Hello') AS Col1
	,LENGTH('안녕') AS Col2
	,LENGTHB('Hello') AS Col3 --바이트형식 
	,LENGTHB('안녕') AS Col4  --한글은 3바이트
	FROM DUAL;

--어디 위치에 있는지 인덱스 번호로 알려준다 (1부터 시작)
-- -1 은 반대순서로 찾는다
SELECT INSTR('sample@example.com', '@') AS Col1
,INSTR('sample@example.com', '@', -1) AS Col2
,INSTR('sample@example.com', 'e') AS Col3
,INSTR('sample@example.com', 'e', -1) AS Col4
,INSTR('sample@example.com', 'e', 1,2) AS Col5 --두번째 특정값을 찾아준다
,INSTR('sample@example.com', 'e', -1,2) AS Col6 --두번째 특정값을 찾아준다
	FROM DUAL;  


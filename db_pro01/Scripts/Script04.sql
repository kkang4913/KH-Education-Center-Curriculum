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

--오른쪽에 지정된 문자열을 왼쪽문자열에서 제거하는 기능
--L : 왼쪽기준 R: 오른쪽 기준 TRIM : 양쪽 공백 모두 제거
SELECT LTRIM('    sample@example.com       ', ' ') AS Col1
	  ,RTRIM('    sample@example.com       ', ' ') AS Col2
	  , TRIM('    sample@example.com       ') AS Col3
	  , TRIM(LEADING '-' FROM '------sample@example.com-----') AS Col4
	  , TRIM(TRAILING '-' FROM '-----sample@example.com-----') AS Col5
	  , TRIM(BOTH '-' FROM '-----sample@example.com-----') AS Col6
	FROM DUAL;

-- 여백 생성
SELECT '!' || LPAD('A',4) AS Col1
	  ,'!' || LPAD('AB',4) AS Col2
	  ,'!' || LPAD('ABC',4) AS Col3
	  ,RPAD('A',4) || '!' AS Col4
	  ,RPAD('AB',4)  || '!' AS Col5
	  ,RPAD('ABC',4)  || '!' AS Col6
	  ,RPAD('A',4, '0')  || '!' AS Col7
	  ,RPAD('ABCDE',4)  || '!' AS Col8
	FROM DUAL;

-- 위치를 지정 원하는 글자수 까지 잘라내는 기능
SELECT SUBSTR('smaple@example.com',8,9) AS Col1
	  ,SUBSTR('smaple@example.com',8,7) AS Col2
	  ,SUBSTR('smaple@example.com',-18,6) AS Col3
	  ,SUBSTR('smaple@example.com',-11,7) AS Col4
	  ,SUBSTR('smaple@example.com',-11) AS Col5
	FROM DUAL;

--소문자, 대문자, 해당단어 첫글자 대분자 변환 기능
SELECT LOWER('smaple@example.com') AS Col1
	  ,UPPER('smaple@example.com') AS Col2
	  ,INITCAP('smaple@example.com') AS Col3
	  FROM DUAL;

--문자열 결합	 
SELECT CONCAT('sample', '@example.com') AS Col1
	FROM DUAL;

--				원본문자열				 찾을 문자열     변경할 문자열
SELECT REPLACE('sample@example.com','example.com','example.co.kr') AS Col1
	FROM DUAL;

-- 절대값
SELECT ABS(10) AS Col1
	  ,ABS(-10) AS Col2
	  FROM DUAL;
-- 나머지 계산	 
SELECT MOD(10,3) AS Col1
	  ,MOD(-10,3) AS Col2
	  ,MOD(10.5,3) AS Col3
	  ,MOD(-10.5,3) AS Col4
	  FROM DUAL;
	 
-- 반올림	 
SELECT ROUND(10.4) AS Col1
	  ,ROUND(10.5) AS Col2
	  ,ROUND(10.45) AS Col3
	  ,ROUND(10.45,1) AS Col4
	  ,ROUND(10.456,2) AS Col5
	  ,ROUND(18.5,-1) AS Col6
FROM DUAL;
	 
-- 올림 버림	 
SELECT FLOOR(10.34) AS Col1
	  ,CEIL(10.34) AS Col2
	  ,FLOOR(-10.34) AS Col3
	  ,CEIL(-10.34) AS Col4
	  FROM DUAL;

--절사	 
SELECT TRUNC(10.34)	AS Col1 
	  ,TRUNC(10.34,1)	AS Col2
	  ,TRUNC(10.3456,2)	AS Col3
	  ,TRUNC(1234,-1)	AS Col4
FROM DUAL;

--시스템 날짜 
SELECT SYSDATE AS Col1
	,ADD_MONTHS(SYSDATE,2) AS Col2
	,ADD_MONTHS(SYSDATE,-2) AS Col3
	, LAST_DAY(SYSDATE) AS Col4
	,NEXT_DAY(SYSDATE,6) AS Col5 -- 1:일요일, 2:월요일 ... 6: 금요일, 7:토요일
	,NEXT_DAY(SYSDATE,'토') AS Col6
FROM DUAL;

--차이를 구하는 기능 (개월 수 차이)
SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE,2)) AS Col1
	  ,MONTHS_BETWEEN(ADD_MONTHS(SYSDATE,2), SYSDATE) AS Col2
FROM DUAL;
	 
-- SYSDATE는 년도, 월 , 일  -- 시간은 SYSTIMESTAMP 사용
SELECT EXTRACT(YEAR FROM SYSDATE) AS Col1
	  ,EXTRACT(MONTH FROM SYSDATE) AS Col2
	  ,EXTRACT(DAY FROM SYSDATE) AS Col3
	  ,EXTRACT(HOUR FROM SYSTIMESTAMP) AS Col4
	  ,EXTRACT(MINUTE FROM SYSTIMESTAMP) AS Col5
	  ,EXTRACT(SECOND FROM SYSTIMESTAMP) AS Col6
	  FROM DUAL;

--날짜 관련 추가
SELECT SYSDATE + 1 AS Col1
	  ,SYSDATE + 2 AS Col2
	  ,SYSDATE - 2 AS Col3
	  ,SYSDATE - 1 AS Col4
	  ,SYSDATE + INTERVAL '1'DAY AS Col5
	  ,SYSDATE + INTERVAL '2'DAY AS Col6
	  ,SYSDATE + INTERVAL '1'DAY AS Col7
	  ,SYSDATE + INTERVAL '2'DAY AS Col8
	  ,SYSDATE + INTERVAL '1'MONTH AS Col9
	  ,SYSDATE + INTERVAL '1'YEAR AS Col10
	  ,SYSDATE + INTERVAL '1' HOUR AS Col11
	  ,SYSDATE + INTERVAL '1' MINUTE AS Col12
	  ,SYSDATE + INTERVAL '1' SECOND AS Col13
	  FROM DUAL;
	  
--형변환 TO CHAR
SELECT 1234 AS Col1
	,TO_CHAR(1234) AS Col2
	,TO_CHAR(10000000, 'L999,999,999') AS Col2
	,TO_CHAR(10000000, '000,000,000L') AS Col2
	,TO_CHAR(SYSDATE) AS Col3
	,TO_CHAR(SYSDATE,'YYYYMMDD') AS Col4
	,TO_CHAR(SYSDATE,'YYYY-MM-DD') AS Col5
	,TO_CHAR(SYSDATE,'YYYY/MM/DD') AS Col6
	,TO_CHAR(SYSDATE,'YYYY.MM.DD') AS Col7
	,TO_CHAR(SYSDATE,'YYYY"년" MM"월" DD"일"') AS Col8
FROM DUAL;
	 
--날짜로 변환
SELECT TO_DATE(20220425) AS Col1
	  ,TO_DATE('20220425') AS Col2
	  ,TO_DATE('2022/04/25') AS Col3
	  ,TO_DATE('2022.04.25') AS Col4
	  ,TO_DATE('2022년 04월 25일', 'YYYY"년" MM"월" DD"일"') AS Col5
FROM DUAL;
	 
-- 숫자변환
SELECT TO_NUMBER('12345') AS Col1
	  ,TO_NUMBER('123.45') AS Col2
	  ,TO_NUMBER('123,456', '999,999') AS Col3
	  ,TO_NUMBER('123,456', '000,000') AS Col4
	  ,TO_NUMBER('FF', 'XXXX') AS Col4
FROM DUAL;


SELECT TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDD')) AS Col1
FROM DUAL;

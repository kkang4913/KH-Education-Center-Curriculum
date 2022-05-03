
SELECT * 
 FROM EMPLOYEES E;
 
SELECT *
 FROM DEPARTMENTS D;

SELECT * 
 FROM JOBS J;
 
SELECT * 
 FROM LOCATIONS L;

SELECT *
 FROM COUNTRIES C;
 
SELECT *
 FROM REGIONS R;
 
/*
* EMPLOYEES 테이블을 조회 할 때 JOB_ID, DEPARTMENT_ID 가 ID가 아닌 
* NAME 으로 조회 될 수 있도록 JOIN 을 활용한다.
* (서브쿼리 사용 가능하기 때문에 서브쿼리로도 만들어 본다.)
*/
SELECT E.EMPLOYEE_ID
	  ,E.FIRST_NAME
	  ,E.LAST_NAME
	  ,E.EMAIL
	  ,E.PHONE_NUMBER
	  ,E.HIRE_DATE
	  ,J.JOB_TITLE AS "JOB_NAME"
	  ,E.SALARY
	  ,E.COMMISSION_PCT
	  ,E.MANAGER_ID
	  ,D.DEPARTMENT_NAME
	FROM EMPLOYEES E
	JOIN JOBS J 
		ON E.JOB_ID = J.JOB_ID
	JOIN DEPARTMENTS D
	  	ON E.DEPARTMENT_ID =D.DEPARTMENT_ID;

--서브쿼리 활용

SELECT EMPLOYEE_ID
	  ,FIRST_NAME
	  ,LAST_NAME
	  ,EMAIL
	  ,PHONE_NUMBER
	  ,HIRE_DATE
	  ,(SELECT JOB_TITLE FROM JOBS J WHERE E.JOB_ID = J.JOB_ID) AS JOB_NAME 
	  ,SALARY
	  ,COMMISSION_PCT
	  ,MANAGER_ID
	  ,(SELECT DEPARTMENT_NAME FROM DEPARTMENTS D WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID) AS DEPARTMENT_NAME
	  FROM EMPLOYEES E;
	  
/*
 * DEPARTMENTS 테이블과 LOCATIONS 테이블을 사용하여 각 부서가 어느 지역에 위치하고
 * 있는지 JOIN 을 활요하여 조회한다.
 * (서브쿼리로도 활용)
 */

SELECT D.DEPARTMENT_ID
	  ,D.DEPARTMENT_NAME
	  ,D.MANAGER_ID
	  ,L.LOCATION_ID
	  ,L.STREET_ADDRESS
	  ,L.POSTAL_CODE
	  ,L.CITY
	  ,L.STATE_PROVINCE
	  ,L.COUNTRY_ID
	FROM DEPARTMENTS D
	JOIN LOCATIONS L
	ON D.LOCATION_ID = L.LOCATION_ID;
	
-- 서브쿼리 활용
SELECT D.DEPARTMENT_ID
	  ,D.DEPARTMENT_NAME
	  ,D.MANAGER_ID
	  ,(SELECT STREET_ADDRESS FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS STREET_ADDRESS
	  ,(SELECT POSTAL_CODE FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS POSTAL_CODE
	  ,(SELECT CITY FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS CITY
	  ,(SELECT STATE_PROVINCE FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS STATE_PROVINCE
	  ,(SELECT COUNTRY_ID FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS COUNTRY_ID
	  FROM DEPARTMENTS D;
/*
 * LOCATIONS 테이블과 COUNTRIES, REGIONS 테이블을 사용하여 
 * 어느 나라에 그리고 어떤 대륙에 위치하고 있는지 JOIN 을 활용하여 조회한다.
*/
SELECT 	R.REGION_NAME
	   ,C.COUNTRY_NAME
	   ,L.CITY || ' ' || DECODE(L.STATE_PROVINCE,NULL,' ', CONCAT(L.STATE_PROVINCE, ' ')) || ' ' || L.STREET_ADDRESS AS ADDRESS
	   ,L.POSTAL_CODE
	FROM LOCATIONS L
		JOIN COUNTRIES C
	ON L.COUNTRY_ID = C.COUNTRY_ID
		JOIN REGIONS R
	ON C.REGION_ID = R.REGION_ID
	ORDER BY 1,2;
	 
/*
 * 대륙별 직원 수를 파악하기 위한 조회 쿼리를 만들어 본다.
 */
SELECT   R.REGION_NAME AS 대륙구분
		,COUNT(*) AS "직원수"
	FROM EMPLOYEES E
	JOIN DEPARTMENTS D
		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
	JOIN LOCATIONS L
		ON D.LOCATION_ID = L.LOCATION_ID
	JOIN COUNTRIES C
		ON L.COUNTRY_ID = C.COUNTRY_ID
	JOIN REGIONS R
		ON C.REGION_ID = R.REGION_ID
	GROUP BY R.REGION_NAME;




/*
 * 나라별 직원 수를 파악하기 위한 조회 쿼리를 만든다.
 */
SELECT   C.COUNTRY_NAME AS 나라구분
		,COUNT(*) AS "직원수"
	FROM EMPLOYEES E
	JOIN DEPARTMENTS D
		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
	JOIN LOCATIONS L
		ON D.LOCATION_ID = L.LOCATION_ID
	JOIN COUNTRIES C
		ON L.COUNTRY_ID = C.COUNTRY_ID
	JOIN REGIONS R
		ON C.REGION_ID = R.REGION_ID
	GROUP BY C.COUNTRY_NAME;
/*
 * 대륙별, 나라별 직원 수를 파악하기 위한 집계 쿼리를 만든다.
*/
SELECT   DECODE(GROUPING(R.REGION_NAME), 1, '총계', R.REGION_NAME) AS 대륙구분
		,DECODE(GROUPING(C.COUNTRY_NAME),1,DECODE(GROUPING(R.REGION_NAME),1, ' ', '소계'), C.COUNTRY_NAME) AS 나라구분
		,COUNT(*) AS "직원수"
	FROM EMPLOYEES E
	JOIN DEPARTMENTS D
		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
	JOIN LOCATIONS L
		ON D.LOCATION_ID = L.LOCATION_ID
	JOIN COUNTRIES C
		ON L.COUNTRY_ID = C.COUNTRY_ID
	JOIN REGIONS R
		ON C.REGION_ID = R.REGION_ID
	GROUP BY ROLLUP (R.REGION_NAME, C.COUNTRY_NAME);
	
/*
 * 부서별 최고참, 막내 사원 구하기
 */	

SELECT	E1.EMPLOYEE_ID
	   ,E1.DEPARTMENT_ID
	   ,E1.HIRE_DATE
	   ,CASE WHEN E2.MX = E1.HIRE_DATE THEN '막내'
	        WHEN E2.MN = E1.HIRE_DATE THEN '고참'
	     END AS 구분   
	FROM EMPLOYEES E1
	JOIN (SELECT DEPARTMENT_ID
			,MAX(HIRE_DATE) AS MX	
			,MIN(HIRE_DATE) AS MN
			FROM EMPLOYEES
			GROUP BY DEPARTMENT_ID
			) E2
	ON E1.DEPARTMENT_ID = E2.DEPARTMENT_ID
	AND(E1.HIRE_DATE = E2.MX OR E1.HIRE_DATE = E2.MN)
	ORDER BY 2;
			

/*
 * 국가별 최고액 급여자, 최저 급여자 구하기(커미션이 있는 경우 포함)
 */

SELECT E1.EMPLOYEE_ID
     , E1.FIRST_NAME
     , E1.LAST_NAME
     , E2.나라구분
     , CASE WHEN E2.최고급여 = E1.SALARY * (1 + NVL(E1.COMMISSION_PCT, 0)) THEN '최고급여'
            WHEN E2.최저급여 = E1.SALARY * (1 + NVL(E1.COMMISSION_PCT, 0)) THEN '최저급여'
        END AS 구분
     , E1.SALARY * (1 + NVL(E1.COMMISSION_PCT, 0)) AS 급여
  FROM EMPLOYEES E1
  JOIN (SELECT C.COUNTRY_NAME AS 나라구분
             , MAX(E.SALARY * (1 + NVL(E.COMMISSION_PCT, 0))) AS 최고급여
             , MIN(E.SALARY * (1 + NVL(E.COMMISSION_PCT, 0))) AS 최저급여
          FROM EMPLOYEES E
          JOIN DEPARTMENTS D
            ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
          JOIN LOCATIONS L
            ON D.LOCATION_ID = L.LOCATION_ID
          JOIN COUNTRIES C
            ON L.COUNTRY_ID = C.COUNTRY_ID
         GROUP BY C.COUNTRY_NAME
       ) E2
    ON E2.최고급여 = E1.SALARY * (1 + NVL(E1.COMMISSION_PCT, 0))
    OR E2.최저급여 = E1.SALARY * (1 + NVL(E1.COMMISSION_PCT, 0))
 ORDER BY 4;

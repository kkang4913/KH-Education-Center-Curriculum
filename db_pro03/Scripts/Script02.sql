DECLARE
	x NUMBER;
	y NUMBER :=0;
	z CONSTANT NUMBER :=20;
BEGIN
	x := 10;
	--z := 30; (상수는 바뀌지 않는다)
	DBMS_OUTPUT.PUT_LINE('변수 x ->' || x);
	DBMS_OUTPUT.PUT_LINE('변수 y ->' || y);
	DBMS_OUTPUT.PUT_LINE('상수 z ->' || z);
END;

DECLARE
	str VARCHAR2(10);
BEGIN
	str := 'Hi';
	DBMS_OUTPUT.PUT_LINE(str);
END;


-- 직접 크기를 지정해서 할당하는 방법
DECLARE
	EMP_ID 		NUMBER;
	EMP_NAME	VARCHAR2(100);
BEGIN
	SELECT  EMPLOYEE_ID
		   ,FIRST_NAME
      INTO EMP_ID, EMP_NAME	   
	  FROM EMPLOYEES  
	 WHERE EMPLOYEE_ID = 100;
	DBMS_OUTPUT.PUT_LINE(EMP_ID || '/' || EMP_NAME);
END;	

-- 참조하여 값을 넣은 방식 
DECLARE
	EMP_ID 		EMPLOYEES.EMPLOYEE_ID%TYPE;
	EMP_NAME	EMPLOYEES.FIRST_NAME%TYPE;
BEGIN
	SELECT  EMPLOYEE_ID
		   ,FIRST_NAME
      INTO EMP_ID, EMP_NAME	   
	  FROM EMPLOYEES  
	 WHERE EMPLOYEE_ID = 100;
	DBMS_OUTPUT.PUT_LINE(EMP_ID || '/' || EMP_NAME);
END;	


-- 1행 타입만 저장할 수 있는 방법
DECLARE
	EMP  EMPLOYEES%ROWTYPE;
BEGIN
	SELECT *
      INTO EMP	   
	  FROM EMPLOYEES  
	 WHERE EMPLOYEE_ID = 100;
	DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.FIRST_NAME);
	DBMS_OUTPUT.PUT_LINE(EMP.SALARY || '/' || EMP.PHONE_NUMBER);
END;	



-- 문법
DECLARE
	EMP  EMPLOYEES%ROWTYPE;
	ID NUMBER :=100;
BEGIN
	-- 반복문 (LOOP -END LOOP)
	LOOP
		SELECT *
      	  INTO EMP	   
	  	  FROM EMPLOYEES  
	 	  WHERE EMPLOYEE_ID = ID;
	 	 
		DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.FIRST_NAME);
	
	ID := ID + 1;
	--IF ....END IF
	IF(ID >= 150) THEN 
		EXIT;
	END IF;
	END LOOP;
END;	




-- 문법1 : IF문 여러번
DECLARE
	EMP  EMPLOYEES%ROWTYPE;
	ID NUMBER :=100;
BEGIN
	LOOP
		SELECT *
      	  INTO EMP	   
	  	  FROM EMPLOYEES  
	 	  WHERE EMPLOYEE_ID = ID;

	IF(NVL(EMP.COMMISSION_PCT, 0) =0) THEN
		DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY);
	ELSIF(NVL(EMP.COMMISSION_PCT, 0) >0) THEN
		DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY * (1+EMP.COMMISSION_PCT));
	END IF;
	 	 
	ID := ID + 1;

	IF(ID >= 150) THEN 
		EXIT;
	END IF;
	END LOOP;
END;




-- 문법2 : 반복문 수정 / REVERSE(역순)
DECLARE
	EMP  EMPLOYEES%ROWTYPE;
BEGIN
	FOR ID IN REVERSE 100..150 LOOP
		SELECT *
      	  INTO EMP	   
	  	  FROM EMPLOYEES  
	 	  WHERE EMPLOYEE_ID = ID;

	IF(NVL(EMP.COMMISSION_PCT, 0) =0) THEN
		DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY);
	ELSIF(NVL(EMP.COMMISSION_PCT, 0) >0) THEN
		DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY * (1+EMP.COMMISSION_PCT));
	END IF;

	END LOOP;
END;






--문법3 : WHILE문 
DECLARE
	EMP  EMPLOYEES%ROWTYPE;
	ID NUMBER :=100;
BEGIN
	WHILE ID < 150 LOOP
		SELECT *
      	  INTO EMP	   
	  	  FROM EMPLOYEES  
	 	  WHERE EMPLOYEE_ID = ID;

	IF(NVL(EMP.COMMISSION_PCT, 0) =0) THEN
		DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY);
	ELSIF(NVL(EMP.COMMISSION_PCT, 0) >0) THEN
		DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY * (1+EMP.COMMISSION_PCT));
	END IF;
	
	ID := ID + 1;
	END LOOP;
END;


BEGIN
	FOR R IN 1..3 LOOP	
		DBMS_OUTPUT_PUT_LINE(R);
	END LOOP;
END;



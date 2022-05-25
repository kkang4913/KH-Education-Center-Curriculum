package com.conn.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import oracle.net.aso.m;

public class DBConn {

	//공통된 부분의 기능 분리
	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String BASE_URL = "jdbc:oracle:thin:@";
	
	private String url_address;
	private Connection conn;
	//private Statement stat;
	private PreparedStatement pstat;
	
	public DBConn(File config) throws Exception {
			Map<String, String> map = new HashMap<String, String>();
			BufferedReader br =  new BufferedReader(new FileReader(config));
			
			while (br.ready()) {
				String[] kv = br.readLine().split("=");
				map.put(kv[0].strip(), kv[1].strip());
			}
			if (map.get("host") != null) {
				url_address = String.format("%s:%s/%s",map.get("host"),map.get("port"),map.get("service"));
				 
			}else if (map.get("tns_alias") !=null) {
				url_address = String.format("%S?TNS_ADMIN=%s",map.get("tns_alias"),map.get("wallet_path "));
			}else {
				System.out.println(config.getName() + "파일의 데이터베이스 연결 구성 정보가 잘못되었습니다.");
			}
			this.createConnection(map.get("username") ,map.get("password"));
		}
	
	public DBConn(String address, String port, String serviceName, String username, String password) throws Exception {
		url_address = String.format("%s:%s/%s", address, port, serviceName);
		this.createConnection(username, password);
	}
	
	public DBConn(String tnsAlias, String walletPath, String username, String password) throws Exception {
		url_address = String.format("%S?TNS_ADMIN=%s", tnsAlias, walletPath);
		this.createConnection(username, password);
	}
	
	private void createConnection(String username, String password) throws Exception {
		//1. Driver 등록
		Class.forName(DRIVER_NAME);
		
		//2. DBMS 연결
		conn = DriverManager.getConnection(BASE_URL + url_address, username, password);
		
		//3. Statement 생성
		//stat = conn.createStatement();
		
	}
	//필요 : 
	public PreparedStatement getPstat(String query) throws Exception {
		pstat = conn.prepareStatement(query);
		return pstat;
	}
	
	
	
	//PreparedStatement : SQL구문작성 쿼리로 구동이 되기 때문에 값을 넣어줄 필요가 없다.
	//SQL 질의문 전송 및 반환
	public ResultSet sendSelectQuery() throws Exception {
		return this.pstat.executeQuery();
	}
	public int sendInsertQuery( ) throws Exception {
		return this.pstat.executeUpdate();
	}
	public int sendUpdateQuery() throws Exception {
		return this.pstat.executeUpdate();
	}
	public int sendDeletetQuery() throws Exception {
		return this.pstat.executeUpdate();
	}
	
	//객체반환
	public void close() throws Exception {
		this.pstat.close();
		this.conn.close();
	}

}

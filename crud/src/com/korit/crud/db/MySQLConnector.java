package com.korit.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;

// JDBC (Java DataBase Connectivity) : Java 에서 데이터베이스 연결을 위한 표준 API

// 특징
// 1. 플랫폼 독립적 : 운영체제와 상관없이 사용 가능
// 2. 표준화 : 특정 DBMS에 종속되지 않고 공통으로 사용할 수 있음
// 3. 확장성 : DBMS에 따라 서로 다른 JDBC를 사용하여 확장 가능
// 4. 상호작용성 : SLQ 쿼리를 실행하고 결과를 처리할 수 있음
// 5. 유연성 : 다양한 DBMS를 지원
public class MySQLConnector {
	
	private static MySQLConnector instance = null;
	private Connection connection;
	
	private final String URL = "jdbc:mysql://127.0.0.1:3306/crud"; // 연결할 데이터베이스 지정
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	private MySQLConnector() {
		try {
			// JDBC MySQL 드라이버 로드 (SQL 워크벤치 여는 작업)
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 데이터베이스 연결 작업 (SQL 워크벤치에서 USER의 커넥터에 PASSWORD 입력하고 )
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	// 싱글톤 패턴
	public static MySQLConnector getInstance() {
		if (instance == null) {
			// synchronized : 비동기 처리(멀티 스레드)에 대해 동기 처리가 가능하도록 함 
			synchronized (MySQLConnector.class) {
				if (instance == null) {
					instance = new MySQLConnector();
				}
			}
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}

}

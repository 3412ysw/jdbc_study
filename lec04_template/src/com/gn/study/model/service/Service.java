package com.gn.study.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.vo.Car;


import static com.gn.study.common.JDBCTemplate.getConnection;
import static com.gn.study.common.JDBCTemplate.close;

// DB에 접속 -> Connection 객체 생성
public class Service {
	private Dao dao = new Dao();
	public int insertCarOne(Car car) {
		Connection conn = getConnection();
		int result = dao.insertCarOne(car, conn);
		close(conn);
		return result;
	}
	
	public List<Car> selectCarAll(){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarAll(conn);
		close(conn);
		return list;
		
	}
	
	public Car selectCarOne(String modelName) {
		Connection conn = getConnection();
	    Car car = dao.selectCarOne(modelName,conn);
	    close(conn);
	    return car;
	}
	
	public List<Car> searchCarName(int menu, Object obj){
		Connection conn = getConnection();
//		List<Car> list = dao.searchCarName(conn);
		close(conn);
		return null;
	}
	
    public int updateCarOne(int carNo, String modelName) {
    	Connection conn = getConnection();
    	int result = dao.updateCarOne(carNo, modelName,conn);
		close(conn);
		return result;
    }
	
	public int deleteCarOne(int carNo) {
		Connection conn = getConnection();
		int result = dao.deleteCarOne(carNo,conn);
		close(conn);
		return result;
	}
	
	
}

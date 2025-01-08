package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

//view로부터 전달받은 데이터 가공 -> Service 전달
public class Controller {
	private Service service = new Service(); 
	
	public int insertCarOne(String modelName,int price,String date) {
		Car car = new Car(modelName, price, date);
		int result = service.insertCarOne(car);
		return result;
	}
	
	public List<Car> selectCarAll(){
		return service.selectCarAll();
	}
	
	public Car selectCarOne(String modelName) {
		Car result = service.selectCarOne(modelName);
		return result;
	}
	
	public List<Car> searchCarName(int menu,Object obj){
		return service.searchCarName(menu,obj);
		
	}
	
	public int updateCarOne(int carNo, String modelName) {
		return service.updateCarOne(carNo, modelName);
	}
	
	public int deleteCarOne(int carNo) {
		return service.deleteCarOne(carNo);
	}
}

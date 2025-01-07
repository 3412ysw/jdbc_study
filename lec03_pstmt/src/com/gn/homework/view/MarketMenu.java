package com.gn.homework.view;

import java.util.Scanner;

import com.gn.homework.controller.MarketController;
import com.gn.homework.model.vo.MarkerVo;

public class MarketMenu {

	private Scanner sc= new Scanner(System.in);
	private MarketController mc = new MarketController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 우리 동네 슈퍼마켓 ===");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 :  break;
				case 2 :  break;
				default : System.out.println("메뉴를 잘못 입력하셨습니다.");
			}	
		}
	}
	
	
	public void printResult(int result, String menuName) {
		if(result > 0) {
			System.out.println(menuName+ "이 정상적으로 완료되었습니다.");
		}else {
			System.out.println(menuName+ "중 오류가 발생되었습니다.");
		}
	}
	
	public void insertUser() {
		System.out.println("=== 회원 가입 ===");
		System.out.print("아이디 입력 : ");
		String userId = sc.nextLine();
		MarkerVo result1 = mc.checkId(userId);
		if(result1 != null) {
			System.out.println("중복되는 아이디 입니다. 다시 입력해주세요.");
		}else {
			System.out.print("비밀번호 입력 : ");
			String userPw = sc.nextLine();
			System.out.print("닉네임 입력 : ");
			String userName = sc.nextLine();
			int resul2 = mc.insertUser(userId, userPw ,userName);
			printResult(resul2, "회원가입");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

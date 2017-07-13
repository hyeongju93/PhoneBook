package com.javaex.pb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {
	public static void main(String[] args) throws IOException {
		boolean flag = true;
		
		Scanner sc = new Scanner(System.in);
		List<PhoneBook> pbList = new ArrayList<PhoneBook>();
		PhoneDB pDB = new PhoneDB();

		System.out.println("*************************************");
		System.out.println("*         전화번호 관리 프로그램                   *");
		System.out.println("*************************************");

		pDB.ReadList(pbList);
		
		while (flag) {
			System.out.println("1.리스트\t2.등록\t3.삭제\t4.검색\t5.종료");
			System.out.println("-------------------------------------");
			System.out.print(">메뉴번호: ");

			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
				case 1:
					System.out.println("<1.리스트>");
					
					pbList.removeAll(pbList);
					pDB.ReadList(pbList);
					
					int i = 1;
					
					for(PhoneBook temp : pbList) {
						System.out.println(i+"."+temp.getName()+"\t"+temp.getHp()+"\t"+temp.getCompany());
						
						i++;
					}
					System.out.println();
					break;
				case 2:
					System.out.println("<2.등록>");
					
					System.out.print(">이름: ");
					String name = sc.nextLine();
				
					System.out.print(">휴대전화: ");
					String hp = sc.nextLine();
					
					System.out.print(">집전화: ");
					String company = sc.nextLine();
					
					pbList.add(new PhoneBook(name, hp, company));
					
					pDB.WriteList(pbList);
					
					System.out.println("[등록되었습니다.]");
					System.out.println();
					break;
				case 3:
					System.out.println("<3.삭제>");
					System.out.print(">번호: ");
					
					int j = sc.nextInt();
					
					pbList.remove(j-1);
					
					pDB.WriteList(pbList);
					
					System.out.println("[삭제되었습니다.]");
					System.out.println();
					break;
				case 4:
					System.out.println("<4.검색>");
					System.out.print(">이름: ");
					
					String searchName = sc.nextLine();
					
					for(int k = 0; k<pbList.size(); k++) {
						if(pbList.get(k).getName().contains(searchName)) {
							System.out.println((k+1)+"."+pbList.get(k).getName()+"\t"+pbList.get(k).getHp()+"\t"+pbList.get(k).getCompany());
						}
					}
					
					System.out.println();
					break;
				case 5:
					flag = false;
					break;
				default :
					System.out.println("다시 입력해주세요.");	
			}

		}
		
		
		System.out.println("*************************************");
		System.out.println("*               감사합니다                       *");
		System.out.println("*************************************");
		sc.close();
	}

}

package kr.hs.dgsw.java.c2.programming_test.AddressBook;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
			
		PhoneBook phoneBook = new DBPhoneBook();
		NameCard nameCard = null;
	
		int num1 = 0;

		Scanner scan = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 검색");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 학생 정보 사이즈");
			System.out.println("0. 프로그램 종료");
			System.out.println("------------");
			
			num1 = scan.nextInt();
			
			switch (num1) {
				case 0: {
					System.out.println("프로그램을 종료합니다.");
					scan.close();
					System.exit(0);
				}
				case 1: {
					
					System.out.println("이름을 입력하세요. ");
					String addName = scan.next();
					
					System.out.println("전화번호를 입력하세요. ");
					String addPhoneNumber = scan.next();

					scan.nextLine(); // 앞의 scan.next가 개행문자(\n)은 빼고 입력 받기 때문에 바로 아래의 문이 넘어가는 것을 방지하기 위해서 추가하였다.
					System.out.println("주소를 입력하세요. ");
					String addAddress = scan.nextLine();
					
					phoneBook.addCard(addName, addPhoneNumber, addAddress);
					
					TimeUnit.SECONDS.sleep(1);
					
					System.out.println("학생 정보가 추가되었습니다.");
					
					break;
				}
				case 2: {
					System.out.println("1. 이름으로 학생 정보 검색");
					System.out.println("2. ID으로 학생 정보 검색");
					System.out.println("3. 학생 정보 전체 검색");
					System.out.println("0. 뒤로가기");
					System.out.println("------------");
					
					System.out.println("위 번호 중 하나를 선택 해주세요. ");
					int num2 = scan.nextInt();
					
					switch (num2) {
						case 0: {
							break;
						}
						case 1: {
							System.out.println("검색할 학생 이름을 입력해주세요. ");
							String name = scan.next();
							
							List<NameCard> nameCard1 = phoneBook.getCard(name);
							System.out.println("가져오는 중....");
							for (NameCard card : nameCard1) {
								System.out.println(card.toString());
							}

							System.out.println("\n🎉 검색 완료! 🎉 \n");
							
							break;
						}
						case 2: {
							System.out.println("검색할 학생 id을 입력해주세요. ");
							int id = scan.nextInt();
							
							nameCard = phoneBook.getCard(id);
							System.out.println("가져오는 중....");
							System.out.println(nameCard.toString());

							System.out.println("\n🎉 검색 완료! 🎉 \n");
							
							break;
						}
						case 3: {
							List<NameCard> cards = phoneBook.getList();
							System.out.println("학생 검색 중...");
							for (NameCard card : cards) {
								System.out.println(card.toString());
							}
							System.out.println("\n🎉 검색 완료! 🎉 \n");
							break;
						}
						default: {
							System.out.println("존재하지 않는 선택 항목입니다. 맨 처음으로 돌아갑니다.");
							TimeUnit.SECONDS.sleep(1);
							break;
						}
					}
					break;
				}
				case 3: {
					System.out.println("수정할 학생의 id를 입력하세요. ");
					int id = scan.nextInt();
					
					System.out.println("변경될 학생의 이름을 입력하세요. ");
					String name = scan.next();
					
					System.out.println("변경될 학생의 전화번호를 입력하세요. ");
					String phoneNumber = scan.next();
					
					scan.nextLine(); // 앞의 scan.next가 개행문자(\n)은 빼고 입력 받기 때문에 바로 아래의 문이 넘어가는 것을 방지하기 위해서 추가하였다.
					System.out.println("변경될 학생의 주소를 입력하세요. ");
					String address = scan.nextLine();
					
					phoneBook.updateCard(id, name, phoneNumber, address);
					
					System.out.println("학생 정보가 수정되었습니다. ");
					nameCard = phoneBook.getCard(id);
					System.out.println(nameCard.toString());
					
					break;
				}
				case 4: {
					System.out.println("삭제할 학생의 id를 입력하세요. ");
					int id = scan.nextInt();
					
					phoneBook.removeCard(id);
					
					TimeUnit.SECONDS.sleep(1);
					
					System.out.println("학생의 정보가 성공적으로 삭제 되었습니다! ");
					break;
				}
				case 5: {
					System.out.println("사이즈: " + phoneBook.size());
					break;
				}
				default: {
					System.out.println("존재하지 않는 선택 항목입니다. 다시 선택해주세요.");
					TimeUnit.SECONDS.sleep(1);
					break;
				}
			}
		}
	}
	
}

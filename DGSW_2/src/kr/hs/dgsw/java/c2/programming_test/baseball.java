package kr.hs.dgsw.java.c2.programming_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baseball {

	private int myNumbers[];    // 내가 입력한 숫자가 들어갈 배열
	private int comNumbers[];   // 랜덤으로 생성된 숫자가 들어갈 배열
	BufferedReader in;
	int gameLength;             // 입력할 숫자 수를 정할 변수
	
	public baseball() {
		gameLength = 3;
		myNumbers = new int[gameLength];     // 배열의 길이를 3으로 설정
		comNumbers = new int[gameLength];    // 배열의 길이를 3으로 설정
		comRandom();                         // 랜덤한 값을 생성 함수 호출
        in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	private void comRandom() {
		comNumbers[0] = (int) (Math.random() * 9) + 1;    // 첫 번째 랜덤한 값 생성
		
		do {
			comNumbers[1] = (int) (Math.random() * 10);   // 첫 번째 랜덤한 값 생성
		} while (comNumbers[0] == comNumbers[1]);         // 첫 번째 랜덤한 값과 두 번쟤 랜덤한 값이 일치하지 않을 때 까지
		
		do {
			comNumbers[2] = (int) (Math.random() * 10);   // 첫 번째 랜덤한 값 생성
		} while (comNumbers[0] == comNumbers[2] || comNumbers[1] == comNumbers[2]);
		// 랜덤한 값이 잘 들어갔는지 확인하기 위한 출력
		// System.out.println("Computer: " + comNumbers[0] + comNumbers[1] + comNumbers[2]);
	}
	
	private void game() {
		int count = 0;
		int strike;
		int ball;
		
		while (true) {
			strike = 0;
			ball = 0;
			
			System.out.println("숫자 입력: ");
			int myNum = getNumber();
			myNumbers[0] = myNum / 100;
			myNumbers[1] = myNum / 10 % 10;
			myNumbers[2] = myNum % 10;
			
			for (int i = 0; i < gameLength; i++) {
				for (int j = 0; j < gameLength; j++) {
					if (myNumbers[i] == comNumbers[j]) {   // 두 숫자가 같다면
						if (i == j) {                      // 두 숫자의 위치가 같다면
							strike++;                      // 스트라이크 +1
						} else {                           // 그렇지 않다면
							ball++;                        // 볼 +1
						}
					}
				}
			}
			count++;                                       // 반복 횟수 +1
			
			if (strike == 3) {
				System.out.println("\n🎉 " + myNum + "(을)를 " + count + "번만에 맞추었습니다." + " 🎉\n");
				System.out.println("1: 게임 다시 시작\n0: 게임 종료\n====================");
				int num = getNumber();
				if (num == 1) {
					comRandom();
					count = 0;
				} else {
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}				
			} else {
				System.out.println(strike + "S " + ball + "B");
			}
		}
	}
	
	private int getNumber() {
		int num = 0;
		
		try {
			num = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		baseball BaseBallGame = new baseball();
		BaseBallGame.game();
	}
	
}

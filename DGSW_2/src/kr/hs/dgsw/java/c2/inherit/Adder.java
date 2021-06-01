package kr.hs.dgsw.java.c2.inherit;

import java.util.Scanner;

public class Adder {
	private int operand1;
	private int operand2;
	private Scanner scanner;
	
	public void execute() {
		// 스캐너를 생성한다.
		makeScanner();
		
		while(true) {
			// 수를 입력 받는다.
			inputNumbers();
			
			// 종료 조건을 검사하여, 부합할 경우 종료한다.
			if (checkTerminate()) {
				break;
			}
			
			// 계산해서 결과를 출력한다.
			display();
		}
		
		// 스캐너를 닫는다.
		closeScanner();
		System.out.println("프로그램 종료");
	}
	
	protected void makeScanner() {
		scanner = new Scanner(System.in);
	}
	
	protected void closeScanner() {
		scanner.close();
	}
	
	protected void inputNumbers() {
		System.out.println("두 정수를 입력하세요.");
		operand1 = scanner.nextInt();
		operand2 = scanner.nextInt();
	}
	
	protected boolean checkTerminate() {
		return ((0 == operand1) && (0 == operand2));
	}
	
	public int calculate() {
		return operand1 + operand2;
	}
	
	public void display() {
		String str = String.format("%d %s %d = %d", operand1, getOperator(), operand2, calculate());
		System.out.println(str);
	}
	
	public String getOperator() {
		return "+";
	}

	public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}

	public static void main(String[] args) {
		Adder adder = new Adder();
		adder.execute();
	}
}

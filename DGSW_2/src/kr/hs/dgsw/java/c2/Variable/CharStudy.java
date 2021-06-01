package kr.hs.dgsw.java.c2.Variable;

public class CharStudy {
	public static void main(String[] args) {
		char a = 66;
		char b = 'a';
		int c = b + 0;
		char d = '가';
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(b + " " + c);
		System.out.println(d + " " + ((int)d));
		
		for (char i = '가'; i < '힣'; i++) {
			System.out.println(i + " " + (int)i);
		}
		
		System.out.println("지원되는 한글의 개수: " + ('힣' - '가' + 1));
		
		char hanja = '天';
		
		System.out.println(hanja + " " + (int)hanja);
	}
}
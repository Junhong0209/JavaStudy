package kr.hs.dgsw.java.c2.Variable;

public class DoubleStudy {
	public static void main(String[] args) {
		
		double doubleValue = 3.14159265358979;
		float floatValue = 3.141592653589792F;
		
		System.out.println(doubleValue);
		System.out.println(floatValue);
		
		for (int i = 0; i <= 100; i++) {
			doubleValue += (double)i;
		}
		System.out.println(doubleValue);
	}
}

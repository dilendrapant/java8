package test;

public  class A {
	
	public static int m1(int a, int b){
		System.out.println("This is from m1 ");
		return true?4:5;

	}

	public static int m2(int a, long b){
		System.out.println("this is from m2");
		return true?4:5;
	}
	public static void main(String[] args) {
		m1(3,5);
	}
	
}


	
	
//	 
//	A(){
//		this(x:0);
//		System.out.println("A");
//	}
//	A(int x){
//		this(x:0, y:0);
//		System.out.println("A"+x);
//	}
//	A(int x, int y){
//		System.out.println("A"+x+"  "+y );
//	}
//
//	public static void main(String[] args) {
//		A obj = new A();
//	}
	
	
//	
//	 static void m() {
//		
//		System.out.println("This is private methods ");
//		
//	}


//class Test2 extends A{
//
// static void m() {
//		
//		System.out.println("This is private methods zz ");
//		
//	}
//	
//	public static void main(String[] args) {
//		A a= new Test2();
//		a.m();
//		
//		
//	}
//	
//}
	
	
	
//	public static void main(String[] args) {
//		 System.out.println("abc");
//		      String cde = "sggggggddcdze";
//		      System.out.println("abc" + cde);
//		      String x = "axffbffcd".substring(2,3);
//		      String y = cde.substring(1, 2);
//		      System.out.println(x+"  :"+y);
//	}
//	  private static  String s1 = "tutorialspoint";
//	  private static int x=9;
//	public static void main(String[] args) {

//		try {
//			Class cls = Class.forName("java.lang.String");
//			Object obj = cls.newInstance();
//			Field field[] = cls.getDeclaredFields();
//			for (int i = 0; i < field.length; i++) {
//				field[i].setAccessible(true);
//				System.out.println(
//						" :: " + field[i].getName() + "" + field[i].getType().getName() + " :: " + field[i].get(obj));
//
//			}
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}

		// System.out.println("hello");
//		String x1 = "dilendra";
//		char[] x2 = { 'd', 'i', 'l', 'e', 'n', 'd', 'r', 'a' };
//		String x3 = new String(x2);
//		String x4 = new String (x1);
////	System.out.println("X1 : "+x1+" :: "+"X2 : "+x2[1]+" :: "+"X3 : "+x3+" :::: "+x1.equals(x3));
//		System.out.println(x4.equals(x1));
		
		
		
//	   
//	      String s2 = "tutorialspoint";
//	      String s3 = new String ("tutorialspoint");
//	      String s4= new String("tutorialspoint");
//	      s1="ff";
//	      x++;
//	      System.out.println(s1 == s2);
//	      System.out.println(s2 == s3);
//	      System.out.println(s3 == s4);
//	      System.out.println(s3.equals(s4));
//	      run();
		
		
//		
//		 static  int count=0;
//		   public void increment()
//		   {
//		       count++;
//		   }
//		   public static void main(String args[])
//		   {
//			   Test2 obj1=new Test2();
//			   System.out.println("Obj1: count is="+obj1.count);
//			   Test2 obj2=new Test2();
//			   System.out.println("Obj1: count is="+obj1.count);
//		       obj1.increment();
//		       obj1.increment();obj1.increment();obj1.increment();
//		       System.out.println("Obj1: count is="+obj1.count);
//		       obj2.increment();
//		       System.out.println("Obj1: count is="+obj1.count);
//		       System.out.println("Obj2: count is="+obj2.count);
//		   }


	//}
//	static void run() {
//		System.out.println(s1+x);
//	}
	

//}
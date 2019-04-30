package demo;

import java.lang.reflect.Field;

public class GetData 
{
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("demo.Kyc");
			Object obj = cls.newInstance();
			Field field[] = cls.getDeclaredFields();
			for(int i=0;i<field.length;i++) {
				field[i].setAccessible(true);
				System.out.println(" :: "+field[i].getName()+" :: "
						+ ""+field[i].getType().getName()+ ""
								+ " :: "+field[i].get(obj));
				
			}
			
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}

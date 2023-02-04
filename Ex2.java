//sorting array in ascending order
import java.util.Scanner;
public class Ex2
{
		public static void main(String[] args)
		{
			Scanner kb=new Scanner(System.in);
			double[] sales={100,90,80,70,60,50,40,30,20,10,178,32,99,11,3,44,68,23};
			
			System.out.printf("%n%nBefore iteration:%n");
			for(int i=0;i<sales.length;i++)
			{
			
				//System.out.printf("sales[%d]=%.2f%n",i,sales[i]);
				System.out.printf("%.2f   " ,sales[i]);
			}

for(int outer=0;outer<(sales.length);outer++)
{	double temp=0;

			
			for(int i=0;i<(sales.length-outer);i++)
			{
				if(i!=(sales.length-1))

				{
					if(sales[i]>sales[i+1])
					{
						temp=sales[i];
						sales[i]=sales[i+1];
						sales[i+1]=temp;
					}
				}


			}
			System.out.printf("%n%nAfter iteration:%n");
			for(int i=0;i<sales.length;i++)
			{

				//System.out.printf("sales[%d]=%.2f%n",i,sales[i]);
				System.out.printf("%.2f   " ,sales[i]);
			}
		}


		}

}
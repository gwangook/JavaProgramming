package middle;

import java.util.Scanner;

/**
 * 두 수자로 서로 곱한 값중 작은것 부터 나열하기
 * @author ook
 *
 */

public class Test01 
{
	private static final int MAX_COUNT = 10;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		for(int test_case=1; test_case<=2; test_case++)
		{
			long answer = 0;
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			long min = A>B ? B : A;
			long max = A>B ? A : B;
			
			long[] arr1 =  new long[MAX_COUNT];
			long[] arr2 =  new long[MAX_COUNT];
			arr1[0] = min;
			
			for(int i=1; i<MAX_COUNT; i++)
			{
				arr1[i] = arr1[i-1]*min;
			}
			
			long iMax = max;
			for(int i=0; i<MAX_COUNT; i++)
			{
				long compare = iMax;
				int idx = 0;
				for(int j=0; j<MAX_COUNT; j++)
				{
					if(compare > arr1[idx])
					{
						arr2[j] = arr1[idx];
						idx++;
					}
					else if(compare < arr1[idx])
					{
						arr2[j] = compare;
						compare = compare * min;
					}
					else if(compare == arr1[idx])
					{
						arr2[j] = arr1[idx];
						compare = compare * min;
						idx++;
					}
				}
				
				long[] tempArr = arr1;
				arr1 = arr2;
				arr2 = tempArr;
				
				iMax = iMax * max;
			}
			
			answer = arr2[MAX_COUNT-1];
			
			System.out.println("#"+test_case + " " + answer);
		}
	}
}

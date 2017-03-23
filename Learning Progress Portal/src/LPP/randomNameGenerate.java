package LPP;

import java.util.Random;

public class randomNameGenerate {

	public void firstNameandLastNameGenerate() {
		String fName = null, lName = null;
		for (int k = 0; k < 2; k++) {
			if(k==0)
				fName=shuffle();
			else if(k==1)
				lName=shuffle();
		} 
		System.out.println(fName+" "+lName);
		
	}
		
	public String shuffle() {	
		
		char[] alphabets={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] names = new char[6];
		int ran;
		for (int i=0;i<6;i++)
		{
			ran=new Random().nextInt(alphabets.length);
			names[i]= alphabets[ran];
		}
		 
		
		int[] arrayIndex = new int[names.length];
		char[] backNamesIndexes = new char[arrayIndex.length];
		String backNames;
		int index, i, flag, k, flag1 = 0;

		for (i = 0; i < arrayIndex.length; i++) {
			arrayIndex[i] = -1;
		}

		for (i = 0; i < arrayIndex.length; i++) {
			index = new Random().nextInt(names.length);
			flag = 0;
			for (int j = 0; j <= i; j++) {
				for (k = 0; k < arrayIndex.length; k++) {		/* checking weather array is empty or not*/
					if (arrayIndex[k] == -1) 
					{
						flag1++;
					}
				}
				if (flag1 == arrayIndex.length) 
				{												/* if array is empty put value in first position*/
					arrayIndex[j] = index;
					break;
				} 
				else if (arrayIndex[j] == index) 				/* Array already have the same value*/
				{
					flag = 1;
					break;
				} 
				else 											/* Index is unique value*/
				{
					flag = 2;
				}
			}
			if (flag == 2) 
			{
				arrayIndex[i] = index;
			}
			if (flag == 1) 
			{
				i--;
			}
		}
		for (i = 0; i < arrayIndex.length; i++) {
			backNamesIndexes[i] = names[arrayIndex[i]];
		}
		backNames = String.valueOf(backNamesIndexes);
		return backNames;
	}
}

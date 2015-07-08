package com.fred.sort;

public class MaoPao {

	public static void sort(int[] data){
		for(int i = 0; i < data.length; i++){
			int temp = 0;
			for(int j = data.length -1; j>0 ;j--){
				if(data[j] < data[j-1]){
					temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		}
	}
	
	public static void print(int[] data){
		for(int i : data){
			System.out.print(i+"  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] data = {2,3,6,1,90,43};
		print(data);
		sort(data);
		print(data);
	}
}

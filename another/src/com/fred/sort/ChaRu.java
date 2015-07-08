package com.fred.sort;

public class ChaRu {

	public static void sort(int[] data){
		for(int i = 1; i < data.length; i++){
			int key = data[i];
			int j = i - 1;
			while (j >= 0 && data[j] > key){
				data[j+1] = data [j];
				j--;
			}
			data[j+1] = key;
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

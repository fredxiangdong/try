package com.fred.sort;

public class XuanZe {
	public static void sort(int[] data){
		for(int i=0; i < data.length; i++){
			int min = data[i];
			int temp;
			int index = i;
			for(int j = i+1; j <data.length; j++){
				if(data[j] < min){
					min = data[j];
					index = j;
				}
			}
			temp = data[i];
			data[i] = min;
			data[index] = temp;
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


public class Java_Sort {

	public static void main(String[] args) {
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		System.out.println("初始排序：");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ; ");
		}
		System.out.println();
		DirectInsertSort(a);
		int b[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		HillSort(b);
		int c[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		SimpleSelectSort(c);
		int d[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		BubbleSort(d);
		int e[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		QuickSort(e);
		int f[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		MergeSort(f);
	}
	
	//直接插入排序
	public static void DirectInsertSort(int[] a){
		int temp=0;
		int i=0;
		int j=0;
		for(i=1;i<a.length;i++){
			temp=a[i];
			j=i-1;
			while(j>=0&&temp<a[j]){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
		System.out.println("直接插入排序：");
		for(i=0;i<a.length;i++){
			System.out.print(a[i]+" ; ");
		}
		System.out.println();
	}
	
	//希尔排序
	public static void HillSort(int[] a){
		int i=0;
		int j=0;
		int temp=0;
		int d=a.length;
		while(true){
			d=d/2;

			for(int x=0;x<d;x++){
				//直接插入排序
				 for(i=x+d;i<a.length;i+=d){  
			          j=i-d;  
			          temp=a[i];  
			          while(j>=0&&temp<a[j]){
			        	  a[j+d]=a[j];
			        	  j-=d;
			          }
			          a[j+d]=temp; 
			       }  
			}
			if(d==1){break;}
		}
		
            System.out.println("希尔排序：");
			for(i=0;i<a.length;i++){
				System.out.print(a[i]+" ; ");
			}
			System.out.println();
   
			
		}
	
	//简单选择排序
	public static void SimpleSelectSort(int[] a){
			int temp=0;
			int i=0;
			int j=0;
			for(i=0;i<a.length-1;i++){
				for(j=i+1;j<a.length;j++){
					if(a[i]>a[j]){
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
				}
			}
			System.out.println("简单选择排序：");
			for(i=0;i<a.length;i++){
				System.out.print(a[i]+" ; ");
			}
			System.out.println();
		}
	
	//冒泡排序
	public static void BubbleSort(int[] a){
		int temp=0;
		int i=0;
		int j=0;
		//大的数往下沉，小的数往上冒，下次循环再排小的数
		for(i=0;i<a.length-1;i++){
			for(j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		System.out.println("冒泡排序：");
		for(i=0;i<a.length;i++){
			System.out.print(a[i]+" ; ");
		}
		System.out.println();
	}
	
	//快速排序
	public static void QuickSort(int[] a){
		Quick(a,0,a.length-1);
		System.out.println("快速排序：");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ; ");
		}
		System.out.println();
	}
	//取得中轴
	private static int GetMiddle(int[] a,int low,int high){
		int temp=a[low];
		while(low<high){
			while(low<high&&a[high]>=temp){
				high--;
			}
			a[low]=a[high];//比中轴小的移动到左端
			
			while(low<high&&a[low]<=temp){
				low++;
			}
			a[high]=a[low];//比中轴大的移动到右端
		}
		a[low]=temp;
		return low;
	}
	//分块快排
	private static void Quick(int[] a,int low,int high){
		if(low<high){
			int middle=GetMiddle(a,low,high);
			Quick(a,low,middle-1);
			Quick(a,middle+1,high);			
		}
	}
	
	
	//归并排序
	public static void MergeSort(int[] a){
		subSort(a,0,a.length-1);
		System.out.println("归并排序：");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ; ");
		}
		System.out.println();
	}	
	//分组
	private static void subSort(int[] a,int left,int right){
		if(left<right){
			int center=(left+right)/2;
			subSort(a,left,center);
			subSort(a,center+1,right);
			merge(a,left,center,right);
		}
	}
	//归并
	private static void merge(int[] a,int left,int center,int right){
		int[] tmp=new int[a.length];
		int point=left;
		int leftPoint=left;
		int rightPoint=center+1;
		
		while(leftPoint<=center&&rightPoint<=right){
			if(a[leftPoint]<a[rightPoint]){
				tmp[point++]=a[leftPoint++];
			}
			else{
				tmp[point++]=a[rightPoint++];
			}
		}
		
		while(leftPoint<=center){
			tmp[point++]=a[leftPoint++];
		}
		
		while(rightPoint<=right){
			tmp[point++]=a[rightPoint++];
		}
		
		while(left<=right){
			a[left]=tmp[left++];
		}
		
	}
}

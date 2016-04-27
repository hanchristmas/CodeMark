/*����ͷ�����Ե�һ��
A-Jƥ��0-9
�������£�
2
acb
cba
������ܵ�����ܺͣ�
1875

�����漰֪ʶ�㣺
stringתchar[]:str.toCharArray()
java�е������㣺Math.pow()
HashMap�ı���:Iterator
HashMap������Comparator

*/
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;
import java.util.*;


public class StringTest {  
    public static HashMap<String,Integer> scoreMap=new HashMap<String,Integer>();
	
    public static void main(String[] args) { 
    	Scanner in =new Scanner(System.in);
    	String temp=in.nextLine();
    	int lines=Integer.valueOf(temp);
    	String[] strs=new String[lines];
    	for(int i=0;i<lines;i++){
    		strs[i]=in.nextLine();
    	}
    	for(int j=0;j<strs.length;j++){
    		System.out.println(strs[j]);
    	}
    	ScoreCal(strs);
    	Iterator it=scoreMap.entrySet().iterator();
    	while(it.hasNext()){
    		System.out.println(it.next().toString());
    	}
    }  
    
    public static void ScoreCal(String[] strs){
    	for(int i=0;i<strs.length;i++){
    		char[] cArray=strs[i].toCharArray();
    		for(int j=0;j<cArray.length;j++){
    			String k =String.valueOf(cArray[j]);
    			if(!scoreMap.containsKey(k)){
    				scoreMap.put(k, (int)(Math.pow(10, cArray.length-j)));    				
    			}
    			else{
    				int oldScore=scoreMap.get(k);
    				scoreMap.put(k, (int)(oldScore+Math.pow(10, cArray.length-j)));
    			}
    			
    		}   		
    	}
    	List<Map.Entry<String, Integer>> list=new ArrayList<Map.Entry<String, Integer>>(scoreMap.entrySet());
    	Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
    		@Override
    		public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2){
    			return o2.getValue().compareTo(o1.getValue());
    		}   		
    	});
    	
    	for(Map.Entry<String, Integer> mapping:list){
    		System.out.println(mapping.getKey()+":"+mapping.getValue());
    	}
    	
    }
    
    
}  

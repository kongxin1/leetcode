import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.*;

public class DisplayTable {
	public static void main(String argc[]){

		List<String> l1=new ArrayList<String>();
		l1.add("David");l1.add("3");l1.add("Ceviche");
		List<String> l2=new ArrayList<String>();
		l2.add("Corina");l2.add("10");l2.add("Beef Burrito");
		
		List<String> l3=new ArrayList<String>();
		l3.add("David");l3.add("3");l3.add("Fried Chicken");
		List<String> l4=new ArrayList<String>();
		l4.add("Carla");l4.add("5");l4.add("Water");
		
		List<String> l5=new ArrayList<String>();
		l5.add("Carla");l5.add("5");l5.add("Ceviche");
		
		List<String> l6=new ArrayList<String>();
		l6.add("Rous");l6.add("3");l6.add("Ceviche");
		
		List<List<String>> orders =new ArrayList<List<String>>();
		orders.add(l1);orders.add(l2);orders.add(l3);orders.add(l4);orders.add(l5);orders.add(l6);
		DisplayTable s=new DisplayTable();
		s.displayTable(orders);
	}
    public List<List<String>> displayTable(List<List<String>> orders) {
    	
    	Set<String> food=new HashSet<String>();
    	Set<Integer> table=new HashSet<Integer>();
    	for(int i=0;i<orders.size();i++){
    		List<String> order =orders.get(i);
    		food.add(order.get(2));
    		table.add(Integer.valueOf(order.get(1)));
    	}
    	String[] foodList=food.toArray(new String[food.size()]);
    	Arrays.sort(foodList);
    	List<String> header=new ArrayList<String>(foodList.length+1);
    	header.add("Table");
    	for(String str:foodList){
    		header.add(str);
    	}
    	
    	Map<String,Integer> foodMap=new HashMap<String,Integer>();
    	for(int i=0;i<foodList.length;i++){
    		foodMap.put(foodList[i].toString(), i);
    	}
    	
    	Integer[] tableList=table.toArray(new Integer[table.size()]);
    	Arrays.sort(tableList);
    	Map<String,Integer> tableMap=new HashMap<String,Integer>() ;
    	for(int i=0;i<tableList.length;i++){
    		tableMap.put(tableList[i].toString(), i);
    	}
    	
    	List<List<String>> res=new ArrayList<List<String>>(tableList.length+1);
    	res.add(header);
    	
    	int[][] count=new int[tableList.length][foodList.length];
    	for(int i=0;i<orders.size();i++){
    		List<String> order=orders.get(i);
    		int j=tableMap.get(order.get(1));
    		int k=foodMap.get(order.get(2));
    		count[j][k]++;
    	}
    	
    	for(int i=0;i<tableList.length;i++){
    		List<String> list=new ArrayList();
    		list.add(tableList[i].toString());
    		
    		for(int j=0;j<foodList.length;j++){
    			list.add(String.valueOf(count[i][j]));
    		}
    		res.add(list);
    	}
    	
    	return res;
    }	

}

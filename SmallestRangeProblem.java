// Java progrm to demonstrate working of priority queue in Java 
import java.util.*; 
import java.util.Comparator;
class Example 
{ 
	public static void main(String args[]) 
	{ 
      int arr[][] = {
              {4, 7, 9, 12, 15}, 
                    {0, 8, 10, 14, 20}, 
                    {6, 12, 16, 30, 50}
                };
       findSmallestRange(arr,5,3);              
	} 
	
	public static void findSmallestRange(int arr[][], int n, int k)
    {
     PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
         
         public int compare(Node n1,Node n2){
             if(n1.data > n2.data)
             return 1;
             else if(n1.data < n2.data)
             return -1;
             else
             return 0;
         }
     });
     
     int range = Integer.MAX_VALUE;
     int min = Integer.MAX_VALUE;
     int max = Integer.MIN_VALUE;
     int start = -1,end = -1;
     
     for(int i = 0;i<k;i++){
         pq.add(new Node(arr[i][0],i,1));
         if(arr[i][0] > max)
         max = arr[i][0];
     }
     
     while(true){
        Node root = pq.poll();
        min = root.data;
        if(range > max - min + 1 ){
            range = max - min + 1 ;
            start = min;
            end = max;
        }
        if(range == k)
        break ;
        
        if(root.nextColNo < n){   
        pq.add(new Node(arr[root.listNo][root.nextColNo],root.listNo,root.nextColNo + 1));
        // System.out.println("New elemnt added " + arr[root.listNo][root.nextColNo]);
            if(arr[root.listNo][root.nextColNo] > max){
                max = arr[root.listNo][root.nextColNo];
            }
        }else
        break;
     }
     
     System.out.println(" [ " + start + " , " + end + " ] ");
    } 
   

}

class Node{
    Integer data;
    Integer listNo;
    Integer nextColNo;
    
    Node(int data,int listNo,int colNo){
        this.data = data;
        this.listNo = listNo;
        this.nextColNo = colNo;
    }
}



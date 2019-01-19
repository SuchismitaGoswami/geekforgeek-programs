
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
     {
        public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
          {
          ArrayList<Integer> result = new ArrayList<Integer>();
          PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
              public int compare(Integer a,Integer b){
                  if(a > b){
                      return 1;
                  }else if(a<b){
                      return -1;
                  }else
                  return 0;
              }
          });
          
          for(int i = 0;i<k;i++){
             for(int j=0;j<arrays.length;j++){
                 pq.add(arrays[i][j]);
             }
          }
          while(!pq.isEmpty()){
              result.add(pq.poll());
          }
          return result;
          
          }
}

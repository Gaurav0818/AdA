
 class FibonacciS{  
 int n1=0,n2=1,n3=0;    
 void pFibo(int a)
 {    
    if(a>0)
    {    
         n3 = n1 + n2;    
         n1 = n2;    
         n2 = n3;    
         System.out.print(" "+n3);   
         pFibo(a-1);    
     }    
 }    
 public static void main(String args[]){    
  int a=7;    
  System.out.print(n1+" "+n2);   
  pFibo(a-2);  
 }  
}



class KMP{
    public void stringMatch(String text , String patt)
    {
       int n=text.length();
       int m=patt.length();

       int[] lps = new int[m];
       int j=0;

       lpsArray(patt , m , lps);
       int i=0;

       while((n-i)>=(m-i))
       {
          if(text.charAt(i)==patt.charAt(j))
          {
            i++;
            j++;
           
          }
          if(j==m)
          {
            System.out.println("Found index of pattern"+" "+(i-j));
            j=lps[j-1];
            
          }
          else if(i<n && text.charAt(i)!=patt.charAt(j))
          {
            if(j!=0)
            {
                j=lps[j-1];
            }
            else {
                i=i+1;
            }

           
          }
          
       }
    }
    public void lpsArray(String patt , int m,int[] lps)
    {
        lps[0]=0;
        int i=1;
        int j=0;
        while(i<m)
        {
            if(patt.charAt(i)==patt.charAt(j)) 
            {
                j++;
                lps[i]=j;
                i++;

            }
            else if(j!=0)
            {
                j=lps[j-1];
            }
            else{
                lps[i]=j;
                i++;
            }
        }
    }
    public static void main(String args[])
    {
         String txt = "ABABDABACDABABCABAB";
          String pat = "ABABCABAB";

        //  new KMP().stringMatch(txt,pat);
		KMP k1=new KMP();
		k1.stringMatch(txt , pat);
    }

}


  





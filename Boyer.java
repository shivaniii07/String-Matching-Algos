class Boyer{

    public void badCharFind(char[] str , int size,int[] badChar)
    {
        for(int i=0;i<size;i++)
        {   int k=size-i-1;
            badChar[(int) str[i]]= k;
        }
    }
    public void search(char[] txt, char[] pat)
    {
        int m=pat.length;
        // int n=txt.length;

        int[] badChar=new int[256];

        badCharFind(pat,m,badChar);

        int s=0;
        int j=m-1;

        while(j>=0)
        {
            if(j>=0 && pat[j]==txt[s+j])
            j--;
            else if(j>=0 && pat[j]!=txt[s+j])
            {
               s+=badChar[txt[s+j]];
            }
        }
        if(j<0)
        {
            System.out.println("index found at"+" "+s);
        }
        

    }
    public static void main(String args[])
    {
          char txt[] = "ABAAABCD".toCharArray();
          char pat[] = "ABC".toCharArray();
          Boyer b1=new Boyer();
          b1.search(txt, pat);
    }
}
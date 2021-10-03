import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class SIM 
{
	    BufferedWriter output;
	    public String outputfilename;
	    StringBuilder result = new StringBuilder();
        ArrayList<String> ArrayListWords = new ArrayList<String>();
        
        public int readfiles(String file) throws IOException
        {
		FileInputStream fstream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		int count=0;
		while ((strLine = br.readLine()) != null)   
		{
		  ArrayListWords.add(strLine);
		  count++;
		}
		br.close();
	    return count;
        }
        
        HashMap<Integer, String> Dictionary = new HashMap<Integer,String>();
        String maxs, maxs1,maxs2,maxs3;
        public void constructdictionary(String file) throws IOException
        {
        	ArrayList<String> ArrayListWords = new ArrayList<String>();
            FileInputStream fstream = new FileInputStream(file);
            
     		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
     		String strLine;
     		int count=0;
     		while ((strLine = br.readLine()) != null)   
     		{
     		  ArrayListWords.add(strLine);
     		  count++;
     		}
     		br.close();
     	   
             ArrayList<String> ArrayListUnique = new ArrayList<String>();
             ArrayListUnique.add (ArrayListWords.get(0));
             for (int i=1; i<ArrayListWords.size();i++)
             {
             	if (ArrayListUnique.contains(ArrayListWords.get(i)))
             			{
             		
             			}
             	else {
             		ArrayListUnique.add(ArrayListWords.get(i));
             	}
             }
             
             int size = ArrayListUnique.size();
             int []array =new int [size];
             
             
             for ( int i=0; i<ArrayListWords.size();i++)
             {
             	
             	if (ArrayListUnique.contains(ArrayListWords.get(i)))
             	{
             		int c= ArrayListUnique.indexOf(ArrayListWords.get(i));
             		array[c]++;
             		c=0;
             	}
             	
             }
             
             
           
             
             
             int largest=0,index=0;
             for ( int i=0; i< size;i++)
             {
             	if (array[i] > largest)
             		{ largest= array[i];
             	 index = i;
             		}
             }
             
             
             
             maxs = ArrayListUnique.get(index);
             Dictionary.put(00,maxs);
             
             array[index]=-1;
             
             int largest1=0,index1=0;
             for ( int i=0; i< size;i++)
             {
             	if (array[i] > largest1)
             		{ largest1= array[i];
             	 index1 = i;} 
             }
             
             maxs1 = ArrayListUnique.get(index1);
             Dictionary.put(01,maxs1);
             
             array[index1]=-1;
             int largest2=0,index2=0;
             for ( int i=0; i< size;i++)
             {
             	if (array[i] > largest2)
             		{ largest2= array[i];
             	 index2 = i; }
             }
             maxs2 = ArrayListUnique.get(index2);
             Dictionary.put(10,maxs2);
             
             array[index2]=-1;
             int largest3=0,index3=0;
             for ( int i=0; i< size;i++)
             {
             	if (array[i] > largest3)
             		{ largest3= array[i];
             	 index3 = i;} 
             }
             maxs3 = ArrayListUnique.get(index3);
             Dictionary.put(11,maxs3);
             
         }
        
  
       
        public void sendtoxor(String file) throws IOException
        { 
          StringBuilder result = new StringBuilder(); 
          for (int i=0;i<ArrayListWords.size();i++)
        	{
        		
        	    String a = ArrayListWords.get(i);
        		char c[] = a.toCharArray();
        		int returnedarray[]= XOR(c);
        		int b;
        		for (b=0; b<35; b++)
        		{
        			if(returnedarray[b]==-1)
        				break;
        		}
        		int k = b-2;
        		
        		if (k<5)
        		{
        		
        		if (k==0)
        		{
        			// Direct Matching 
        			result.append("001");
        			String y = Integer.toString(returnedarray[0]);
        		    String z = Integer.toString(returnedarray[1]);
        		    result.append(y);
        		    result.append(z);
        		    
        		}
        		
        		else if (k==1)
        		{   
        			result.append("010");
        			int p= returnedarray[2];
        			String g= convertDecimaltoBinary(p);
        		    result.append(g);
        		    String y = Integer.toString(returnedarray[0]);
        		    String z = Integer.toString(returnedarray[1]);
        		    result.append(y);
        		    result.append(z);
        		    
        			
        		}
        		
        		else if (k==2)
        		{
        			int p= returnedarray[2];
        			int q= returnedarray[3];
        			if ( q-p != 1)
        			{
	        			// 2 bit anywhere mismatches 	
	        			String d = convertDecimaltoBinary(p);
	        			String f = convertDecimaltoBinary(q);
	        			String y = Integer.toString(returnedarray[0]);
	        		    String z = Integer.toString(returnedarray[1]);
	        		    result.append("011");
	        		    result.append(d);
	        		    result.append(f);
	        		    result.append(y);
	        		    result.append(z);
	        		    
        		     }
        			else if (q-p == 1)
        			{
        				String d = convertDecimaltoBinary(p);
	        			String y = Integer.toString(returnedarray[0]);
	        		    String z = Integer.toString(returnedarray[1]);
	        		    result.append("100");
	        		    result.append(d);
	        		    result.append(y);
	        		    result.append(z);
	        		    
        			}
        		}
        		
        		else if (k==3)
        		{
        			int p= returnedarray[2];
        			int q= returnedarray[3];
        			int r= returnedarray[4];
        			if ( r-q == 1  && q-p == 1)
        			{
	        		    String d = convertDecimaltoBinary(p);	
	        			String y = Integer.toString(returnedarray[0]);
	        		    String z = Integer.toString(returnedarray[1]);
	        		    result.append("101");
	        		    result.append(d);
	        		    result.append(y);
	        		    result.append(z);
	        		    
        			}
        			else
        				{
        				result.append("000");
        				String f= ArrayListWords.get(i);
        			    result.append(f);
        			    
        				}
        		}
        		
        		
        		else if (k==4)
        		{
        			int p= returnedarray[2];
        			int q= returnedarray[3];
        			int r= returnedarray[4];
        			int s= returnedarray[5];
        			if ( s-r == 1  && r-q == 1 && q-p == 1)
        			{
	        		    String d = convertDecimaltoBinary(p);	
	        			String y = Integer.toString(returnedarray[0]);
	        		    String z = Integer.toString(returnedarray[1]);
	        		    result.append("110");
	        		    result.append(d);
	        		    result.append(y);
	        		    result.append(z);
	        		    
        			}
        			
        		}
        		}
        		
        		else 
        		{   
        			result.append("000");
        			String f= ArrayListWords.get(i);
        			result.append(f);
        			
        		}
        		
        		}
          
                 String s1= result.toString();
                
                 int i=0;
                 while (s1.length() % 32 != 0) 
     	    	{
     	            s1 += "0";
     	        }
                 
                 File outputfile = new File(outputfilename);

              	if (!outputfile.exists()) {
              	 outputfile.createNewFile();
              	 }

             	FileWriter filewriter = new FileWriter(outputfile.getAbsoluteFile());
                BufferedWriter output= new BufferedWriter(filewriter);
                 
                 while (i < s1.length())
                 {
                	 output.write(s1.substring(i, i + 32));
                	 output.write('\n');
                	 i += 32;
                 }
     	    	 
                 
                 output.write("222");
                 output.write('\n');
                 output.write((Dictionary.get(00)));
                 output.write('\n');
                 output.write(Dictionary.get(01));
                 output.write('\n');
                 output.write(Dictionary.get(10));
                 output.write('\n');
                 output.write(Dictionary.get(11));
                 output.write('\n');
                 output.write("222");

                 // System.out.println(result);
	             String s= result.toString();
	           //s  System.out.println(s1.length()+" result length");
	                 
	             int co= readfiles(file);
                 double numberofinputbits=co*32;
        		 
                 int compressedLength = s1.length();
                 double k= compressedLength + (4*32.0);
                 Double CR = k / numberofinputbits;
                 DecimalFormat df = new DecimalFormat("##.##");
                 
                
                 output.write('\n');
                 output.write(df.format(CR*100));
                 
                 output.close();
                 
        }
        
        public int[] XOR ( char a[])
        {   
        	char g[] = a;
        	String p= Dictionary.get(00);
        	char d1[]= p.toCharArray();
        	String q= Dictionary.get(01);
        	char d2[]= q.toCharArray();
        	String r= Dictionary.get(10);
        	char d3[]= r.toCharArray();
        	String s= Dictionary.get(11);
        	char d4[]= s.toCharArray();
        	int diff1=0, diff2=0, diff3=0,diff4=0;
        	int []arr1 =new int[34];
        	for (int i=0; i<34;i++)
        	{
        		arr1[i]=-1;
        	}
        	int []arr2 =new int[34];
        	for (int i=0; i<34;i++)
        	{
        		arr2[i]=-1;
        	}
        	int []arr3 =new int[34];
        	for (int i=0; i<34;i++)
        	{
        		arr3[i]=-1;
        	}
        	int []arr4 =new int[34];
        	for (int i=0; i<34;i++)
        	{
        		arr4[i]=-1;
        	}
        	arr1[0]=0; arr1[1]=0;
        	arr2[0]=0; arr2[1]=1;
        	arr3[0]=1; arr3[1]=0;
        	arr4[0]=1; arr4[1]=1;
        	
        	/* ~~~~~~~~~~~ For Dictionary Index1 ~~~~~~~~~~~~ */
        	int j=2;
        	for (int i=0;i<32;i++)
        	{
        		if(g[i] != d1[i])
        		{
                    diff1++;
                    arr1[j]=i;
                    j++;
                }
        	}
        	
        	
        	/* ~~~~~~~~~~~ For Dictionary Index2 ~~~~~~~~~~~~ */
        	int k=2;
        	for (int i=0;i<32;i++)
        	{
        		if(g[i] != d2[i])
        		{
                    diff2++;
                    arr2[k]=i;
                    k++;
                }
        	}
        	
        	
        	/* ~~~~~~~~~~~ For Dictionary Index3 ~~~~~~~~~~~~ */
        	int m=2;
        	for (int i=0;i<32;i++)
        	{
        		if(g[i] != d3[i])
        		{
                    diff3++;
                    arr3[m]=i;
                    m++;
                }
        	}
        	
        	/* ~~~~~~~~~~~ For Dictionary Index4 ~~~~~~~~~~~~ */
        	int n=2;
        	for (int i=0;i<32;i++)
        	{
        		if(g[i] != d4[i])
        		{
                    diff4++;
                    arr4[n]=i;
                    n++;
                }
        	}
        	
        	int c1= Math.min(diff1,diff2);
        	int c2= Math.min(diff3, diff4);
            if (c1 < c2)
        	{
        		if (diff1<diff2)
        		{
        			return arr1;
        	    }
        		else return arr2;
        	}
            else
            {
            if(diff3<diff4)
            {
            	return arr3;
            }
            else return arr4;
            }
        }
        
       String convertDecimaltoBinary(int n) 
    	{
            String result = new String();
            String result1 = new String();
            int k;
            while (n!= 0) 
            {
                k = n % 2;
                result = "" + k;
                result += result1;
                result1 = result;
                n = n / 2;
            }
            while(result.length() %5!=0)
            {
            	result ="0"+result;
            }
            return result;
        }
       
       
       
   void constructdictionarydecomp(String file) throws IOException{
       	
       	    BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(file));
      	    String line = new String();
      		String readstring = new String();
      		line=reader.readLine();
      		
      		while(! (line.equals("222")))
           {
           	line=reader.readLine();
           }
      		
      		String d1= reader.readLine();
      		String d2= reader.readLine();
      		String d3= reader.readLine();
      		String d4= reader.readLine();
      		Dictionary.put(00, d1);
      		Dictionary.put(01, d2);
      		Dictionary.put(10, d3);
      		Dictionary.put(11, d4);
      		}
       
       public static int converBinaryStringttoDecimal(String p)
       {
   	    double j=0;
   	    for(int i=0;i<p.length();i++)
   	    {
   	        if(p.charAt(i)== '1')
   	        {
   	        	j=j+ Math.pow(2,p.length()-1-i);
   	        }
   	    }
   	    return (int) j;
   	   }
       
   	void readcompressedfiles (String file) throws IOException
       {
   	    	// FileInputStream fstream = new FileInputStream("compressed.txt");
   	   		// BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
   		    BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(file));
   	   		String line = new String();
   	   		String readstring = new String();
   	   		line=reader.readLine();
   	   		
   	   		 while(! (line.equals("222")))
   	        {
   	        	readstring=readstring + line;
   	        	line=reader.readLine();
   	        }
   	   		
   	   	 mydecompression1(readstring);
   	        
   	   }
       
        void mydecompression1(String readstr) throws IOException
   	       {
    	   int i=0;
    	   StringBuilder output = new StringBuilder ();
    	   String uncompressed = new String();
    	   while ( i < readstr.length())
    	   {
   	    	   
   	    	   String str1= readstr.substring(i,i+3);
   	    	   
    		   if (str1.equals("000"))
    		   {
    			   if(!(i+35>readstr.length()))
    			   {
    			   uncompressed = readstr.substring(i+3,i+35);
    			   i=i+35;
    			   output.append(uncompressed);
    			   output.append('\n');
    		
    			   }
    			   else
    			   {
    				   i = readstr.length();
    			   }
    		   }
    		    else if (str1.equals("001"))
    		   {   
    			   int j=i+3;
    			   uncompressed=readstr.substring(j,j+2);
    			   String value = new String();
    			   int k= Integer.parseInt(uncompressed);
    			   value= Dictionary.get(k);
    			   output.append(value);
    			   output.append('\n');
    			   i=i+5;
    		   }
    		   
    		   
    		   else if (str1.equals("010"))
    		   {
    			   int h=i+3, q=0;
    			   uncompressed = readstr.substring(h,h+5);
    			   q= converBinaryStringttoDecimal(uncompressed);
    			   String see= readstr.substring(h+5, h+7);
    			   int k= Integer.parseInt(see);
   			   String seeagain= Dictionary.get(k);
    			   char c[] = null;
    			   c= seeagain.toCharArray();
    			   if ( c[q]=='1')
    			   {
    				   c[q]='0';
    			   }
    			   else if ( c[q]=='0')
    			   {
    				   c[q]='1';
    			   }
    			   String g = String.valueOf(c);
    			   output.append(g);
    			   output.append('\n');
    			   i=i+10;
    			}
    		   
    		   
    		   else if (str1.equals("011"))
    		   {
    			   int j= i+3;
    			   uncompressed = readstr.substring(j,j+5);
    			   int q= converBinaryStringttoDecimal(uncompressed);
    			   j=i+8;
    			   String uncompressed1 = readstr.substring(j,j+5);
    			   int p= converBinaryStringttoDecimal(uncompressed1);
    			   j=i+13;
    			   String see = readstr.substring(j,j+2);
    			   int k= Integer.parseInt(see);
   			   String seeagain= Dictionary.get(k);
    			   char c[] = seeagain.toCharArray();
    			   
    			   if ( c[q]=='1')
    			   {
    				   c[q]='0';
    			   }
    			   else if ( c[q]=='0')
    			   {
    				   c[q]='1';
    			   }
    			   
    			   if (c[p]=='1')
    			   {
    				   c[p]='0';
    			   }
    			   else if (c[p]=='0')
    			   {
    				   c[p]='1';
    			   }
    			   
    			   String g = String.valueOf(c);
    			   output.append(g);
    			   output.append('\n');
    			   i=i+15;
    			}
    			
    			
    		   else if (str1.equals("100"))
    		   {
    			   
    			   int h=i+3, q=0;
    			   uncompressed = readstr.substring(h,h+5);
    			   q= converBinaryStringttoDecimal(uncompressed);
    			   String see= readstr.substring(h+5, h+7);
    			   int k= Integer.parseInt(see);
   			   String seeagain= Dictionary.get(k);
    			   char c[] = seeagain.toCharArray();
    			   int p=q+1; // since consecutive 
    			   if ( c[q]=='1')
    			   {
    				   c[q]='0';
    			   }
    			   else if ( c[q]=='0')
    			   {
    				   c[q]='1';
    			   }
    			   
    			   if ( c[p]=='1')
    			   {
    				   c[p]='0';
    			   }
    			   else if ( c[p]=='0')
    			   {
    				   c[p]='1';
    			   }
    			 
                  String g = String.valueOf(c);
    			   output.append(g);
    			   output.append('\n');
    			   i=i+10;
    			   }
    		   
    		   
    		   
    		   else if (str1.equals("101"))
    		   {
    			   
    			   int h=i+3, q=0;
    			   uncompressed = readstr.substring(h,h+5);
    			   q= converBinaryStringttoDecimal(uncompressed);
    			   String see= readstr.substring(h+5, h+7);
    			   int k= Integer.parseInt(see);
   			   String seeagain= Dictionary.get(k);
    			   char c[] = seeagain.toCharArray();
    			   int p=q+1; 
    			   int r=q+2;
    			   //since consecutive
    			   if ( c[q]=='1')
    			   {
    				   c[q]='0';
    			   }
    			   else if ( c[q]=='0')
    			   {
    				   c[q]='1';
    			   }
    			   
    			   if ( c[p]=='1')
    			   {
    				   c[p]='0';
    			   }
    			   else if ( c[p]=='0')
    			   {
    				   c[p]='1';
    			   }
    			   
    			   if ( c[r]=='1')
    			   {
    				   c[r]='0';
    			   }
    			   else if ( c[r]=='0')
    			   {
    				   c[r]='1';
    			   }
    			   
    			   String g = String.valueOf(c);
    			   output.append(g);
    			   output.append('\n');
    			   i=i+10;
    			  
    			 }
    		   
    		   
    		   else if (str1.equals("110"))
    		   {

    			   int h=i+3, q=0;
    			   uncompressed = readstr.substring(h,h+5);
    			   q= converBinaryStringttoDecimal(uncompressed);
    			   String see= readstr.substring(h+5, h+7);
    			   int k= Integer.parseInt(see);
   			   String seeagain= Dictionary.get(k);
    			   char c[] = seeagain.toCharArray();
    			   int p=q+1; 
    			   int r=q+2;
    			   int s=q+3;
    			   //since consecutive
    			   if ( c[q]=='1')
    			   {
    				   c[q]='0';
    			   }
    			   else if ( c[q]=='0')
    			   {
    				   c[q]='1';
    			   }
    			   
    			   if ( c[p]=='1')
    			   {
    				   c[p]='0';
    			   }
    			   else if ( c[p]=='0')
    			   {
    				   c[p]='1';
    			   }
    			   
    			   if ( c[s]=='1')
    			   {
    				   c[s]='0';
    			   }
    			   else if ( c[s]=='0')
    			   {
    				   c[s]='1';
    			   }
    			   
    			   if ( c[r]=='1')
    			   {
    				   c[r]='0';
    			   }
    			   else if ( c[r]=='0')
    			   {
    				   c[r]='1';
    			   }
    			   
    			  String g = String.valueOf(c);
                 output.append(g);
    			  output.append('\n');
    			  i=i+10;  
    			   
    		   }
    		   else if (str1.equals("111"))
    		   {
    			 i = i+6;  
    		   }
   	  }
    	   
    	   // System.out.println(output);
    	   
    	   File outputfile = new File(outputfilename);

         	if (!outputfile.exists()) {
         	 outputfile.createNewFile();
         	 }

           FileWriter filewriter = new FileWriter(outputfile.getAbsoluteFile());
           BufferedWriter output1= new BufferedWriter(filewriter);
           output1.write(output.toString());
           output1.close();
           
   	       }
        
        public static void main(String args[]) throws IOException
        {
        	SIM c = new SIM ();
        	if (args[0].equals("-c"))
        	{
            c.outputfilename = args[2];
        	c.readfiles(args[1]);
        	c.constructdictionary(args[1]);
        	c.sendtoxor(args[1]);
        	}
        	else if (args[0].equals("-d"))
        	{
        	c.outputfilename = args[2];
            c.constructdictionarydecomp(args[1]);
            c.readcompressedfiles(args[1]);
        	}
         
        }
	}
	

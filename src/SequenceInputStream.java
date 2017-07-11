/**
 * Created by bholar on 7/8/2017.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaio;

/**
 *
 * @author ADMIN
 */
import java.io.*;
class SequenceInputStreamDemo{
    public static void main(String[] args)throws Exception{

        //SequenceInputStream is used to combine multiple InputStreams
        //into a single stream
        FileInputStream fin1=new FileInputStream("f1.txt");
        FileInputStream fin2=new FileInputStream("f2.txt");
        FileInputStream fin3=new FileInputStream("f3.txt");

        FileOutputStream fout=new FileOutputStream("f4444.txt",false);
        //below overloaded constructor can also be used, to combine more than 2 streams
        //SequenceInputStream(Enumeration<? extends InputStream> e)

        SequenceInputStream sis =new SequenceInputStream(fin1,fin2);

        SequenceInputStream sis1 = new SequenceInputStream(sis,fin3);

   /*//DataInputStream dis = new DataInputStream(sis1);
   InputStreamReader isr = new InputStreamReader(sis1);
   BufferedReader br = new BufferedReader(isr);*/

        int i;
        while((i=sis1.read())!=-1)
        {
            fout.write(i);
            System.out.print((char)i);
        }
   /*String str;

   while(!((str = br.readLine()).equals("xyz")))
   {

      System.out.println(str);

   }*/

        //sis.close();
        sis1.close();
        fout.close();
        fin1.close();
        fin2.close();
        fin3.close();
    }
}

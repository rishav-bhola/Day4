/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaio;

import java.io.File;
import java.util.Date;

public class ListFilesFolders {

    final static String ROOT_PATH = "C:\\";
    public static void main(String[] argv)
            throws NullPointerException,Exception
    {
        File dir = new File(ROOT_PATH);
//lists files/folders in current execution directory
        String[] children = dir.list();
        //dir.listFiles(); returns File[]

        if (children == null) {
            System.out.println("does not exist or is not a directory");
        }
        else {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                System.out.print(filename+"         ");


                File tmp_file = new File(ROOT_PATH+filename);
                if(tmp_file.isDirectory())
                {
                    System.out.println(" <<Folder>> ");
                }
                else
                {
                    System.out.println(" <<File>> ");
                }

                long m_time = tmp_file.lastModified();
                Date dt = new Date(m_time);
                System.out.println("Modified on:"+dt);
                System.out.println("--------------------------");

                Thread.sleep(100);
            }
        }

       // System.exit(0);

        //Folder creation example
        File dir1 = new File("./dddddddddd/eeeeeee");
        if(dir1.mkdirs())
        {
            System.out.println("Directory created");
        }
        else
        {
            System.out.println("Directory not created");
        }


        /*dir1.delete();
        dir1.exists();
        dir1.createNewFile();
        */
    }
}

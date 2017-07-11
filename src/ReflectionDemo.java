/**
 * Created by bholar on 7/8/2017.
 */
import java.lang.reflect.*;

class Abcd
{
    /*In one case try to comment this constructor and run and see the exception thrown*/
    public Abcd()
    {
        System.out.println("This is Constructor");
    }

    public void met1()
    {
        System.out.println("This is met1()");
    }

    public void met2(String str)
    {
        System.out.println("This is met2(String) "+str);
    }

    public void met3(String str1,String str2)
    {
        System.out.println("This is met3(String, String) "+str1+" "+str2);
    }
    public void met4(String str3, String str4, String str5){
        System.out.println("This is met4(String, String, String ) "+str3+" "+str4 +" "+str5);
    }
}

public class ReflectionDemo {
    public static void main(String args[])
    {
        try
        {
            //no parameters
            Class no_params[] = {};
            Class c_no_params[] = {};
            Class one_params[] = {};

            //get the Class instance of Abcd
            Class c = Class.forName("Abcd");

            //get the Constructor instance
            Constructor cons = c.getConstructor(no_params);  // If there are multiple constructors, which construcor is this...The one with no parameters

            //create object, which is required for invoke() method
            Object obj = cons.newInstance();

            Method mta[] = c.getMethods();

            System.out.println("Below are the methods in Abcd class");

            for(Method mt:mta)
            {
                System.out.println(mt.getName());
                if(!mt.getName().startsWith("met"))
                {
                    continue;
                }
                Class mpt[] = mt.getParameterTypes();
                System.out.println("........................");
                Object params[] = new Object[mpt.length];             //We have to give dummy values for each of them
                int index = 0;
                for(Class cls:mpt)
                {
                    System.out.println("Parameter Type : "+cls.getName());
                 if(cls.getName().endsWith("String")){
                     params[index++]="str" + index;
                 }
                }
                System.out.println("........................");
                mt.invoke((Abcd)obj,params);
            }
/*
            Method method1 = c.getDeclaredMethod("met1",no_params);

            //Now, invoke method dynamically
            method1.invoke((Abcd)obj);

            //one String parameter
            Class str_params[] = {String.class};
            Method method2 = c.getDeclaredMethod("met2", str_params);

            Object obj11[] = new Object[1];
            obj11[0] = "fsdfsd";
            //Now, invoke method dynamically
            method2.invoke((Abcd)obj, obj11);

            //one String parameter
            Class str_str_params[] = {String.class, String.class};
            Method method3 = c.getDeclaredMethod("met3", str_str_params);
            //method3.
            //Now, invoke method dynamically
            method3.invoke((Abcd)obj, "First Param", "Second Param");


            Class str_str_params1[] = {String.class, String.class,String.class};
            Method method4 = c.getDeclaredMethod("met3", str_str_params1);
            //method3.
            //Now, invoke method dynamically
            method4.invoke((Abcd)obj, "First Param", "Second Param");

*/
        }catch(ClassNotFoundException cnf)
        {
            cnf.printStackTrace();
        }
        catch(NoSuchMethodException nsm)
        {
            nsm.printStackTrace();
        }
        catch(Exception ec)
        {
            ec.printStackTrace();
        }
    }
}

/**
 * Created by bholar on 7/8/2017.
 */
/**
 * Created by bholar on 7/8/2017.
 */
import java.lang.reflect.*;

class Abcd1
{
    /*In one case try to comment this constructor and run and see the exception thrown*/
    public Abcd1()
    {
        System.out.println("This is Constructor");
    }

    public void met1() throws InterruptedException, ArithmeticException
    {
        System.out.println("This is met1()");
    }

    public void met2(String str)  throws Exception
    {
            System.out.println("This is met2(String) " + str);


    }

    public void met3(String str1,String str2)
    {
        System.out.println("This is met3(String, String) "+str1+" "+str2);
    }
    public void met4(String str3, String str4, String str5){
        System.out.println("This is met4(String, String, String ) "+str3+" "+str4 +" "+str5);
    }
}

public class ReflectionDemo1 {
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


                Class mpt[] = mt.getParameterTypes();
                for(Class x : mpt) {
                    System.out.println(x.getName());
                }
                System.out.println("........................");
                Class npt[] = mt.getExceptionTypes();
                for(Class y : npt) {
                    System.out.println(y.getName());
                }
                Object params[] = new Object[mpt.length];             //We have to give dummy values for each of them
                int index = 0;

                System.out.println("........................");

            }

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


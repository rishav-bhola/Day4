/**
 * Created by bholar on 7/8/2017.
 */

class Wrapper1<T> {

    private T m;

    public Wrapper1()
    {
        System.out.println("Wrapper1() Constructor");
    }

    public void add(T m) {
        this.m = m;
    }

    public T get() {
        System.out.println("in get()");
        return m;
    }
}


class Sample extends Wrapper1<Float>
{
    public Sample()
    {
        System.out.println("Sample() Constructor");
    }

    public void met1()
    {
        System.out.println("met1() in Sample");
    }
}

class Example<K, L> extends Wrapper1<L>
{
    private K n;

    public void add1(K p,L q)
    {
        n = p;
        System.out.println("add1()");
    }

    public void get1()
    {
        L h = get();

        System.out.println(n);
        System.out.println(h);
    }
}

public class GenericInherit
{
    public static void main(String[] args) {
        Wrapper1<Integer> integerBox = new Wrapper1<Integer>();
        Sample obj = new Sample();
        Example<Integer, String> objEx = new Example<Integer, String>();

        obj.met1();

        objEx.add1(new Integer(10), new String("Hello World"));
        objEx.get1();
    }
}
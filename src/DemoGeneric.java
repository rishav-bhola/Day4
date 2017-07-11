/**
 * Created by bholar on 7/8/2017.
 */
class Student{
    String name;
    int age;
    Student (String name, int age){
        this.name=name;
        this.age=age;
    }
   public String toString(){
        return(this.name + "  "+ this.age);
   }
public void show2(){
       System.out.println(this.name + "  "+ this.age);
}
}
class Parent{
    private String name;
    int age;
    Parent (String name, int age){
        this.name=name;
        this.age=age;
    }
    public String toString(){
        return(this.name + "  "+ this.age);
    }

}
class Gen<H,V>{
    private H n1;
    private V n2;
    Gen(H n1,V n2){
        this.n1=n1;
        this.n2=n2;
    }
    public void show(){
        System.out.println("STUDENT  :  " + n1);
        System.out.println("PARENT  :  " + n2);
    if(n1 instanceof Student){
        Student xx = (Student)n1;
        xx.show2();
    }
    }


}
public class DemoGeneric {
    public static void main(String[] args){
    Student st = new Student("Rishav",22);
    Parent pa = new Parent("Ravi", 66);
    Gen<Student,Parent> ob = new Gen<Student,Parent>(st,pa);
    ob.show();
}
}
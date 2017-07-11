/**
 * Created by bholar on 7/8/2017.
 */
import java.util.ArrayList;
import java.util.List;
class A9{}
class SparePart{
    private String partName;
    private int partid;
    SparePart(String name,int id){
        partName=name;
        partid=id;
    }
    public String toString(){
        return (partName + "     " + partid);
    }
}
public class GenericWildcard {

    //list of any type can be sent as parameter
    static void displayListItems(List<?> list){
        for (Object listItem : list){
            System.out.println(listItem);
        }
    }

    public static void main(String args[]){

        //Arraylist of string type.
        List<String> list2 = new ArrayList<String>();
        list2.add("str1");
        list2.add("str2");
        list2.add("str3");

        displayListItems(list2);

        List<A9> list3 = new ArrayList<A9>();
        list3.add(new A9());
        list3.add(new A9());
        list3.add(new A9());

        displayListItems(list3);

        SparePart ob = new SparePart("Gear",45);

        SparePart ob1 = new SparePart("Handle",45);

        SparePart ob2 = new SparePart("jhsdf",45);

        List<SparePart> list4 = new ArrayList<SparePart>();
        list4.add(ob);
        list4.add(ob1);
        list4.add(ob2);

        displayListItems(list4);

    }
}
import java.util.ArrayList;

public class School extends Building {

    ArrayList<Person> peopleInSchool= new ArrayList<>();

    School(String name_) { name = name_; address  = addressPool; addressPool++;}
    public void addPersonToSchool(Person p)
    {
        peopleInSchool.add(p);
    }
    public void displayPeople()
    {
        for (int i =0; i < peopleInSchool.size(); i++)
        {
            peopleInSchool.get(i).display();
        }
    }

}

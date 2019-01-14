import java.util.ArrayList;
public class CityHall extends Building {

    ArrayList<Person> peopleInCityHall = new ArrayList<>();
    CityHall(String name_) { name = name_; address  = addressPool; addressPool++;}
    public void addPersonToCityHall(Person p)
    {
        peopleInCityHall.add(p);
    }
    public void displayPeople()
    {
        for (int i =0; i < peopleInCityHall.size(); i++)
        {
            peopleInCityHall.get(i).display();
        }
    }
}

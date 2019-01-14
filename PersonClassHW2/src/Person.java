abstract class Person {
    protected String age;
    protected String phoneNumber;
    protected String name;

    Person() {}
    Person(String name_, String phoneNumber_, String age_)
    {
        age = age_;
        phoneNumber = phoneNumber_;
        name = name_;
    }
    abstract String display();
    public String getName() {return name;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getAge() {return age;}
    public void setAge(String age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}

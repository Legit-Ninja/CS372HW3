public class Kid extends Person{
    private String favCandy;

    Kid() { favCandy = "not set";}
    Kid(String name_, String age_, String phoneNumber_, String candy)
    {
        name = name_;
        age = age_;
        phoneNumber = phoneNumber_;
        favCandy = candy;
    }
    public String getFavCandy() { return favCandy; }
    public void setFavCandy(String candy) {favCandy = candy; }
    public String display()
    {
        return (this.getName() + ", age " + this.getAge()+". Fav candy: " + getFavCandy());
    }

}

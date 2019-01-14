public class Building {
    protected String name;
    protected int address;
    static int addressPool = 1;
    Building() { name = "not named"; address  = addressPool; addressPool++; }       //default constructor
    public void setName(String name_) { name = name_; }

    public String getName() {
        return name;
    }
}

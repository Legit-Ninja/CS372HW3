import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CityMenu extends JFrame implements MouseMotionListener {
    private JPanel CityMenu;
    private JLabel menuLabel;
    private JLabel peopleMenuLabel;
    private JLabel buildingMenuLabel;
    private JPanel peopleOptions;
    private JPanel buildingOptions;
    private JLabel populationLabel;
    private JButton getPopulationButton;
    private JLabel addKidLabel;
    private JLabel addPolicemanLabel;
    private JLabel addTeacherLabel;
    private JPanel addOptionsKid;
    private JTextField teacherNameEnteredText;
    private JTextField teacherAgeEnteredTExt;
    private JTextField teacherPhoneNumberEnteredText;
    private JLabel enterPhoneNumberLabel;
    private JLabel enterAgeLabel;
    private JLabel enterNameLabel;
    private JLabel enterGradeLevelLabel;
    private JTextField teacherGradeLevelEnteredText;
    private JPanel addOptionsPolice;
    private JPanel addOptionsTeacher;
    private JLabel schoolLabel;
    private JLabel cityHallLabel;
    private JButton schoolButton;
    private JButton cityHallButton;
    private JButton kidSumbitButton;
    private JButton policemanSubmitButton;
    private JButton TeacherSubmitButton;
    private JTextField kidNameEnteredText;
    private JTextField kidAgeEnterText;
    private JTextField kidPhoneNumberEnteredText;
    private JTextField kidCandyEnteredText;
    private JTextField policemanNameEnteredText;
    private JTextField policemanAgeEnteredText;
    private JTextField policemanPhoneNumberEnteredText;
    private JTextField policemanRoleEnteredText;
    private JLabel policeRoleLabel;
    private JLabel policeNameLabel;
    private JLabel policeAgeLabel;
    private JLabel policePhoneNumberLabel;
    private JLabel kidNameLabel;
    private JLabel kidAgeLabel;
    private JLabel kidPhoneNumberLabel;
    private JLabel kidFavoriteCandyLabel;
    private JPanel mapPanel;
    private JLabel schoolBuildingLabel;
    private JLabel cityHallBuildingLabel;

    //creates arraylists to keep track of different classes
    JLayeredPane lpane = new JLayeredPane();        // is for the mapPanel and layering
    Point diffDrag;                                                  //tracks where labels are
    ArrayList<Building> buildings = new ArrayList<>();
    ArrayList<Person> population = new ArrayList<>();
    ArrayList<JLabel> moveableLabels = new ArrayList<>();

    public CityMenu() {
        buildings.add(new School("School"));                // constructor initializes the frame
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit(); //makes schoolPicture and stores it
            URL imgurl = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1CfBh35OeWcL6-y_djubTB7y6ET1szeCpmKlAvaRjuVBvGY0WXQ");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            schoolBuildingLabel.setIcon(icon);
            mapPanel.add(schoolBuildingLabel);
        } catch (Exception ex) {
        }
        buildings.add(new CityHall("City Hall"));
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes cityHallpicture and stores it
            URL imgurl = new URL("https://previews.123rf.com/images/yupiramos/yupiramos1301/yupiramos130100327/17349458-building-icons-city-hall-with-windows-and-bushes-on-blue-background.jpg");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            cityHallBuildingLabel.setIcon(icon);
            mapPanel.add(cityHallBuildingLabel);

        } catch (Exception ex) {
        }
        this.add(CityMenu);
        mapPanel.add(lpane);
        mapPanel.addMouseMotionListener(this);           //teelws computer to listen for this specific panel

        kidSumbitButton.addActionListener(new ActionListener() {          //makes a new kid based on entered text
            @Override
            public void actionPerformed(ActionEvent e) {
                Kid kid = new Kid(kidNameEnteredText.getText(), kidAgeEnterText.getText(), kidPhoneNumberEnteredText.getText(),
                        kidCandyEnteredText.getText());
                population.add(kid);
                School s = (School) buildings.get(0);
                s.addPersonToSchool(kid);
                try {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes addedLabel ans stores it
                    URL imgurl = new URL("https://www.clipartmax.com/png/middle/92-924903_boy-man-child-baby-kid-youngster-male-little-kid-icon-png.png");
                    Image img = toolkit.getImage(imgurl);
                    img = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(img);
                    JLabel kidLabel = new JLabel();
                    kidLabel.setIcon(icon);
                    mapPanel.add(kidLabel, 2);
                    moveableLabels.add(kidLabel);

                } catch (Exception ex) {
                }
            }
        });


        TeacherSubmitButton.addActionListener(new ActionListener() {                  //makes a new teacher based on entered text
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher teacher = new Teacher(teacherNameEnteredText.getText(), teacherAgeEnteredTExt.getText(), teacherPhoneNumberEnteredText.getText(),
                        teacherGradeLevelEnteredText.getText());
                population.add(teacher);
                School s = (School) buildings.get(0);
                s.addPersonToSchool(teacher);
                try {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes addedLabel ans stores it
                    URL imgurl = new URL("https://previews.123rf.com/images/djvstock/djvstock1710/djvstock171017475/88806507-cartoon-teacher-woman-icon-over-white-background-colorful-design-vector-illustration.jpg");
                    Image img = toolkit.getImage(imgurl);
                    img = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(img);
                    JLabel teacherLabel = new JLabel();
                    teacherLabel.setIcon(icon);
                    mapPanel.add(teacherLabel, 2);
                    moveableLabels.add(teacherLabel);

                } catch (Exception ex) {
                }
            }
        });

        policemanSubmitButton.addActionListener(new ActionListener() {                   //makes a new policeman based on entered text
            @Override
            public void actionPerformed(ActionEvent e) {
                Police police = new Police(policemanNameEnteredText.getText(), policemanPhoneNumberEnteredText.getText(),
                        policemanAgeEnteredText.getText(), policemanRoleEnteredText.getText());
                population.add(police);
                CityHall c = (CityHall) buildings.get(1);
                c.addPersonToCityHall(police);
                try {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes addedLabel ans stores it
                    URL imgurl = new URL("http://worldartsme.com/images/police-cartoon-free-clipart-1.jpg");
                    Image img = toolkit.getImage(imgurl);
                    img = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(img);
                    JLabel policeLabel = new JLabel();
                    policeLabel.setIcon(icon);
                    mapPanel.add(policeLabel, 3);
                    moveableLabels.add(policeLabel);
                } catch (Exception ex) {
                }
            }
        });
        getPopulationButton.addActionListener(new ActionListener() {                //displays everyone's info
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame populationDisplay = new JFrame();
                populationDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                populationDisplay.setLayout(new FlowLayout());
                populationDisplay.setSize(300, 500);
                populationDisplay.setVisible(true);

                for (Person p : population) {
                    JTextField info = new JTextField(p.display());
                    populationDisplay.add(info);
                }
            }
        });
        schoolButton.addActionListener(new ActionListener() {                              //displays teachers and kid informaaiton
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame populationDisplay = new JFrame();
                populationDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                populationDisplay.setLayout(new FlowLayout());
                populationDisplay.setSize(300, 500);
                populationDisplay.setVisible(true);

                for (Person p : population) {
                    JTextField info = new JTextField(p.display());
                    if (p instanceof Police)
                        System.out.printf("");
                    else
                        populationDisplay.add(info);
                }
            }
        });
        cityHallButton.addActionListener(new ActionListener() {                                 //displays police information
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame populationDisplay = new JFrame();
                populationDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                populationDisplay.setLayout(new FlowLayout());
                populationDisplay.setSize(300, 500);
                populationDisplay.setVisible(true);

                for (Person p : population) {
                    JTextField info = new JTextField(p.display());
                    if (p instanceof Police)
                        populationDisplay.add(info);
                    else
                        System.out.printf("");
                }
            }
        });

    }
        public void mouseDragged(MouseEvent e) {                                         //take care of which label was clicked on and dragged and moves it.
            // System.out.println("dragging");
            JLabel label = null;
            for (int i = 0; i < moveableLabels.size(); i++)
            {
                if (moveableLabels.get(i).getBounds().contains(e.getPoint())) {
                    label = moveableLabels.get(i);
                }
            }
            if (label != null) {
                if (diffDrag == null)
                    diffDrag = new Point(e.getX() - label.getBounds().x, e.getY() - label.getBounds().y);
                label.setBounds(e.getX() - diffDrag.x, e.getY()-diffDrag.y, label.getBounds().width, label.getBounds().height);
                //System.out.printf("moved label to <%d, %d>", e.getX() - diffDrag.x, e.getY()-diffDrag.y);
            }
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
            diffDrag = null;
        }

    public static void main(String[] args) {                                              //makes the JFrame, sets some settings.
        CityMenu frame = new CityMenu();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1440,720);
        frame.setVisible(true);

    }
}

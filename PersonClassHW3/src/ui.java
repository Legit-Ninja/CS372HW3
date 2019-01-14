import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.util.ArrayList;

public class ui extends JPanel implements MouseMotionListener {  //call constructor for ui() to just add to my frame
    private JLabel schoolLabel;
    private JLabel cityHallLabel;
    private JLabel addedLabel;
    private JButton kidImage;
        JLayeredPane lpane;
        ArrayList<JLabel> labels = new ArrayList<>();
        Point diffDrag;

        public ui() {
            makeLabels();
            make();
        }
        private void makeLabels()
        {

            try {
                Toolkit toolkit = Toolkit.getDefaultToolkit(); //makes schoolLabel and stores it
                URL imgurl = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1CfBh35OeWcL6-y_djubTB7y6ET1szeCpmKlAvaRjuVBvGY0WXQ");
                ImageIcon icon = new ImageIcon(imgurl);
                schoolLabel.setIcon(icon);
                labels.add(schoolLabel);
            }
            catch(Exception ex) {}

            try {
                Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes cityHallLabel ans stores it
                URL imgurl = new URL("data:image/png;base64,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");
                ImageIcon icon = new ImageIcon(imgurl);
                cityHallLabel.setIcon(icon);
                labels.add(cityHallLabel);
            }
            catch(Exception ex) {}

        }
        private void make() {
            lpane = new JLayeredPane();
            lpane.setPreferredSize(new Dimension(350,200));
            lpane.addMouseMotionListener(this);

            for (int i=0; i<labels.size(); i++) {
                JLabel l = labels.get(i);
                l.setBounds(30 * i +5, 30*i+5, 25, 25);   //does this fight layout managers?
                l.setBorder(BorderFactory.createLineBorder(Color.black));   //do I need this?
                lpane.add(l, new Integer(i));
            }
            this.add(lpane);
        }
        public void addPerson(Person p)
        {
            if (p instanceof Kid)
            {
                try {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes addedLabel ans stores it
                    URL imgurl = new URL("https://www.clipartmax.com/png/middle/92-924903_boy-man-child-baby-kid-youngster-male-little-kid-icon-png.png");
                    ImageIcon icon = new ImageIcon(imgurl);
                    addedLabel.setIcon(icon);
                    labels.add(addedLabel);

                }
                catch(Exception ex) {}
            }

            else if (p instanceof Teacher)
            {
                try {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes addedLabel ans stores it
                    URL imgurl = new URL("https://previews.123rf.com/images/djvstock/djvstock1710/djvstock171017475/88806507-cartoon-teacher-woman-icon-over-white-background-colorful-design-vector-illustration.jpg");
                    ImageIcon icon = new ImageIcon(imgurl);
                    addedLabel.setIcon(icon);
                    labels.add(addedLabel);
                }
                catch(Exception ex) {}
            }
            else
            {
                try {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes addedLabel ans stores it
                    URL imgurl = new URL("https://previews.123rf.com/images/pandavector/pandavector1702/pandavector170201337/71427785-police-officer-icon-in-cartoon-style-isolated-on-white-background-police-symbol-stock-vector-illustr.jpg");
                    ImageIcon icon = new ImageIcon(imgurl);
                    addedLabel.setIcon(icon);
                    labels.add(addedLabel);
                }
                catch(Exception ex) {}
            }

        }
        public void mouseDragged(MouseEvent e) {
           // System.out.println("dragging");
            JLabel label = null;
            for (int i=0; i<labels.size(); i++) {
                if ((labels.get(i)).getBounds().contains(e.getPoint())) {       //what does this do
                    label = labels.get(i);
                }
            }
            if (label != null) {
                if (diffDrag == null)
                    diffDrag = new Point(e.getX() - label.getBounds().x, e.getY() - label.getBounds().y);
                label.setBounds(e.getX() - diffDrag.x, e.getY()-diffDrag.y, label.getBounds().width, label.getBounds().height);
                System.out.printf("moved label to <%d, %d>", e.getX() - diffDrag.x, e.getY()-diffDrag.y);
            }
        }

        public void mouseMoved(MouseEvent e) {
            diffDrag = null;
        }

        public static void main(String[] args) {
            ui m = new ui();
        }
}

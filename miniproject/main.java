package connectmysql;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
class veg extends JFrame {
    JLabel imageLabel;
    JPanel tablePanel;
    JTextArea descriptionArea; 
    private Connection conn;
    public void setConnection(Connection conn) {
        this.conn = conn; 
    }
    veg() {
        setSize(700, 600);
        setTitle("Veg");
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton dosaRadio = new JRadioButton("Dosa");
        dosaRadio.setBounds(100, 100, 150, 30);
        dosaRadio.addActionListener(new 
RadioListener("Images\\Dosa.jpg", "Dosa"));
        JRadioButton vegBiriyaniRadio = new JRadioButton("Veg Biriyani");
        vegBiriyaniRadio.setBounds(100, 150, 150, 30);
        vegBiriyaniRadio.addActionListener(new 
RadioListener("Images\\Veg Biriyani.jpg", "VegBiriyani"));
        JRadioButton chappathiRadio = new JRadioButton("Chappathi");
        chappathiRadio.setBounds(100, 200, 150, 30);
        chappathiRadio.addActionListener(new 
RadioListener("Images\\Chappathi.jpg", "Chappathi"));
        buttonGroup.add(dosaRadio);
        buttonGroup.add(vegBiriyaniRadio);
        buttonGroup.add(chappathiRadio);
        JLabel label = new JLabel("Select your Favorite Dish:");
        label.setBounds(100, 50, 200, 30);
        imageLabel = new JLabel();
        imageLabel.setBounds(100, 280, 200, 200);
        tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(350, 50, 300, 200);
        tablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(460, 250, 100, 30);
        descriptionArea = new JTextArea();
        descriptionArea.setBounds(350, 280, 300, 250);
        descriptionArea.setEditable(false); 
        descriptionArea.setLineWrap(true); 
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        descriptionScrollPane.setBounds(350, 280, 300, 250);
        add(descriptionLabel);
        add(descriptionScrollPane);
        add(dosaRadio);
        add(vegBiriyaniRadio);
        add(chappathiRadio);
        add(label);
        add(imageLabel);
        add(tablePanel);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    class RadioListener implements ActionListener {
        String imageName;
        String tableName;
        RadioListener(String name, String table) {
            this.imageName = name;
            this.tableName = table;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            displayTableAndImage(tableName);
            loadTextContent(imageName);
            ImageIcon imageIcon = new ImageIcon(imageName);
            Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        }
    }
    private void loadTextContent(String imageName) {
        try {
            String textFilePath = "";
            switch (imageName) {
                case "Images\\Dosa.jpg":
                    textFilePath = "texts\\Dosa.txt";
                    break;
                case "Images\\Chappathi.jpg":
                    textFilePath = "texts\\Chappathi.txt";
                    break;
                case "Images\\Veg Biriyani.jpg":
                    textFilePath = "texts\\Vegbiriyani.txt";
                    break;
                default:
                    break;
            }
            if (!textFilePath.isEmpty()) {
                File file = new File(textFilePath);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String content = "";
                String line;
                while ((line = br.readLine()) != null) {
                    content += line + "\n";
                }
                br.close();
                descriptionArea.setText(content);
                descriptionArea.setCaretPosition(0);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void displayTableAndImage(String tableName) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            JTable table = new JTable(buildTableModel(rs));
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 0, tablePanel.getWidth(), tablePanel.getHeight());
            tablePanel.removeAll();
            tablePanel.add(scrollPane);
            tablePanel.revalidate();
            tablePanel.repaint();
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(rs.getObject(columnIndex));
            }
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames);
    }
    public static void main(String[] args) {
        veg vegInstance = new veg();
        Connection conn = null; 
        vegInstance.setConnection(conn); 
    }
}
class nonveg extends JFrame {
    JLabel imageLabel;
    JPanel tablePanel;
    JTextArea descriptionArea;
    private Connection conn;
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
    nonveg() {
        setSize(700, 600);
        setTitle("Non-Veg");
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton chickenBiriyaniRadio = new JRadioButton("Chicken Biriyani");
        chickenBiriyaniRadio.setBounds(100, 100, 150, 30);
        chickenBiriyaniRadio.addActionListener(new 
RadioListener("Images\\ChickenBiriyani.jpg", "ChickenBiriyani"));
        JRadioButton muttonBiriyaniRadio = new JRadioButton("Mutton Biriyani");
        muttonBiriyaniRadio.setBounds(100, 150, 150, 30);
        muttonBiriyaniRadio.addActionListener(new 
RadioListener("Images\\MuttonBiriyani.jpg", "MuttonBiriyani"));
        JRadioButton chicken65Radio = new JRadioButton("Chicken 65");
        chicken65Radio.setBounds(100, 200, 150, 30);
        chicken65Radio.addActionListener(new 
RadioListener("Images\\Chicken65.jpg", "Chicken65"));
        buttonGroup.add(chickenBiriyaniRadio);
        buttonGroup.add(muttonBiriyaniRadio);
        buttonGroup.add(chicken65Radio);
        JLabel label = new JLabel("Select your Favorite Dish:");
        label.setBounds(100, 50, 200, 30);
        imageLabel = new JLabel();
        imageLabel.setBounds(100, 280, 200, 200);
        tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(350, 50, 300, 200);
        tablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(460, 250, 100, 30);
        descriptionArea = new JTextArea();
        descriptionArea.setBounds(350, 280, 300, 250);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true); 
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        descriptionScrollPane.setBounds(350, 280, 300, 250);
        add(descriptionLabel);
        add(descriptionScrollPane);
        add(chickenBiriyaniRadio);
        add(muttonBiriyaniRadio);
        add(chicken65Radio);
        add(label);
        add(imageLabel);
        add(tablePanel);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    class RadioListener implements ActionListener {
        String imageName;
        String tableName;
        RadioListener(String name, String table) {
            this.imageName = name;
            this.tableName = table;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            displayTableAndImage(tableName);
            loadTextContent(imageName);
            ImageIcon imageIcon = new ImageIcon(imageName);
            Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        }
    }
    private void loadTextContent(String imageName) {
        try {
            String textFilePath = "";
            switch (imageName) {
                case "Images\\ChickenBiriyani.jpg":
                    textFilePath = "texts\\ChickenBiriyani.txt";
                    break;
                case " Images\\MuttonBiriyani.jpg":
                    textFilePath = "texts\\ MuttonBiriyani.txt";
                    break;
                case "Images\\Chicken65.jpg":
                    textFilePath = "texts\\Chicken65.txt";
                    break;
                default:
                    break;
            }
            if (!textFilePath.isEmpty()) {
                File file = new File(textFilePath);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String content = "";
                String line;
                while ((line = br.readLine()) != null) {
                    content += line + "\n";
                }
                br.close();
                descriptionArea.setText(content);
                descriptionArea.setCaretPosition(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void displayTableAndImage(String tableName) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            JTable table = new JTable(buildTableModel(rs));
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 0, tablePanel.getWidth(), tablePanel.getHeight());
            tablePanel.removeAll();
            tablePanel.add(scrollPane);
            tablePanel.revalidate();
            tablePanel.repaint();
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(rs.getObject(columnIndex));
            }
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames);
    }
    public static void main(String[] args) {
        nonveg nonvegInstance = new nonveg();
        Connection conn = null;
        nonvegInstance.setConnection(conn); 
    }
}
class welcome extends JFrame implements ActionListener{
    JLabel l1,vegLabel,nonvegLabel;
    JButton veg,nonveg;
    private Connection conn; 
    public void setConnection(Connection conn) {
        this.conn = conn; 
    }
    welcome(){
        Font f = new Font("TimesRoman",Font.BOLD,40);
        l1 = new JLabel("What You Prefer");
        l1.setBounds(100, 80, 500, 50);
        veg = new JButton("Veg");
        veg.setBounds(150, 380, 100, 50);
        ImageIcon vegIcon = new ImageIcon("Images\\veg.jpeg");
        vegLabel = new JLabel(vegIcon);
        vegLabel.setBounds(100, 160, 200, 200);  
        nonveg = new JButton("Non-Veg");
        nonveg.setBounds(450, 380, 100, 50);
        ImageIcon nonVegIcon = new ImageIcon("Images\\nonveg.jpeg");
        nonvegLabel = new JLabel(nonVegIcon);
        nonvegLabel.setBounds(400, 160, 200, 200);
        add(vegLabel);
        add(nonvegLabel);
        l1.setFont(new Font(f.getName(),Font.BOLD,24));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(null);
        add(l1);
        add(veg);
        add(nonveg);
        veg.addActionListener(this);
        nonveg.addActionListener(this);
        setSize(700, 600);
        setTitle("Welcome");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == veg) {
            veg vegScreen = new veg();
            vegScreen.setConnection(conn); 
        }else if (ae.getSource() == nonveg) {
        nonveg nonvegScreen = new nonveg(); 
        nonvegScreen.setConnection(conn); 
    }
    }
}
class Intro extends JFrame implements ActionListener {
    JLabel title;
    JButton enter;
    private Connection conn;
    public void setConnection(Connection conn) {
    this.conn = conn; 
    }
    Intro() {
        Font f = new Font("TimesRoman", Font.BOLD, 40);
        title = new JLabel("Recipe Explorer - Cooking Assistant");
        title.setBounds(100, 100, 500, 50);
        title.setFont(new Font(f.getName(), Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);
        ImageIcon imageIcon = new ImageIcon("Images\\main.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(250, 170, 200, 200);
        add(imageLabel);
        enter = new JButton("Explore now");
        enter.setBounds(250, 400, 200, 50);
        add(enter);
        enter.addActionListener(this);
        setLayout(null);
        setSize(700, 600);
        setTitle("Cooking Assistant");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == enter) {
            welcome welcomeScreen = new welcome(); 
            welcomeScreen.setConnection(conn);
        }
    }
}
public class ConnectMYSQL {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            System.out.println(conn); 
            Intro intro = new Intro();
            intro.setConnection(conn); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

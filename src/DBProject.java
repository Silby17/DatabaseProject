/**
 * Yossi Silberhaft 210028924 89-281-04
 * Daniel Blinick WN654676 89-281-04
 * Binyamin Greenberg 200220671 89-281-04
 * Steven Lapp 204785240 89-281-05
 */

import javax.swing.*;
import java.sql.*;

public class DBProject extends JFrame {


    public static Connection connect;

    public DBProject() {

    }

    //The main function that will start the running of the program
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        ReadConfig readConfigurationFile = new ReadConfig();
        DBConnectionInfo connectionInfo = readConfigurationFile.getConnectionInfoFromFile("config.txt");
        //Connect to the MySQL database reading from the test file
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(connectionInfo.getURL(), connectionInfo.getUserName(), connectionInfo.getPassword());
        } catch (Exception e) {
            //Displays a message telling the user that the connection couldn't be made.
            JOptionPane.showMessageDialog(frame, "Error Connecting to the server! Please restart the Program");
            e.printStackTrace();
        }
        //Starts and Displays the GUI called FrontPage
        FrontPage fp = new FrontPage();
        fp.setVisible(true);
        fp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
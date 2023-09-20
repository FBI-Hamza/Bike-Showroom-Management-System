
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class searchExpensiveGui extends JFrame {
    private JFrame frame;

    private JLabel icon;
    private ImageIcon i;

    private JLabel searchBike;
    private JLabel checkingAmount;

    private JTextField tCheckingAmount;
    private JTextArea tArea;

    private JButton check;
    private JButton back;


    public searchExpensiveGui() {
        ImageIcon i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(0, 0, 831, 551);

        frame = new JFrame("Bike Showroom");
        tArea = new JTextArea();

        frame.setBackground(Color.WHITE);

        searchBike = new JLabel("Check Availability");
        checkingAmount = new JLabel("Amount: ");

        tCheckingAmount = new JTextField(20);

        searchBike.setFont(new Font("Postmaster", Font.BOLD, 30));
        checkingAmount.setFont(new Font("Postmaster", Font.BOLD, 20));

        searchBike.setForeground(Color.RED);
        checkingAmount.setForeground(Color.RED);
        tArea.setBackground(new Color(0,0,0, 200));


        searchBike.setBounds(310, 30, 600, 100);
        checkingAmount.setBounds(225, 190, 200, 30);
        tCheckingAmount.setBounds(415, 190, 150, 30);
        tArea.setBounds(195,160,400, 150);


        check = new JButton("Check");
        back = new JButton("BACK");

        check.setBounds(280, 250, 100, 30);
        back.setBounds(420, 250, 100, 30);

        check.setBackground(Color.lightGray);
        back.setBackground(Color.lightGray);


        frame.add(searchBike);
        frame.add(checkingAmount);
        frame.add(tCheckingAmount);
        frame.add(check);
        frame.add(back);
        frame.add(tArea);
        frame.add(icon);


        frame.setTitle("Bike Showroom");
        frame.setSize(831, 551);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        MyActionListener a = new MyActionListener();
        check.addActionListener(a);
        back.addActionListener(a);
    }



    class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Check")) {
                if ((!(Vehicle.isPriceValid(Double.parseDouble(tCheckingAmount.getText())))|tCheckingAmount.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "Invalid Price.");
                    tCheckingAmount.setText(null);
                }
                else {
                    Bike b = Bike.SearchGreaterThanAmount(Double.parseDouble(tCheckingAmount.getText()));
                    if (b == null) {
                        JOptionPane.showMessageDialog(null,"Bike Not Found");
                    } else {
                        JOptionPane.showMessageDialog(null, b.toString());
                    }
                }
                frame.dispose();
                MainMenuGUI y = new MainMenuGUI();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("Back")){
                frame.dispose();
                MainMenuGUI x = new MainMenuGUI();
            }
        }
    }
}

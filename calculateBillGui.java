import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculateBillGui extends JFrame {
    private JFrame frame;

    private JLabel icon;
    private ImageIcon i;

    private JLabel customerName;
    private JLabel CalculateBill;

    private JTextField tCustomerName;
    private JTextArea tArea;

    private JButton calculate;
    private JButton back;


    public calculateBillGui() {

        ImageIcon i = new ImageIcon("BikeShowroom.png");
        icon = new JLabel(i);
        icon.setBounds(0, 0, 831, 551);

        frame = new JFrame("Bike Showroom");
        tArea = new JTextArea();


        CalculateBill = new JLabel("Calculate Bill");
        customerName = new JLabel("Customer Name: ");

        tCustomerName = new JTextField(20);


        customerName.setFont(new Font("Postmaster", Font.BOLD, 20));
        CalculateBill.setFont(new Font("Postmaster",Font.BOLD,30));


        customerName.setForeground(Color.RED);
        CalculateBill.setForeground(Color.RED);
        tArea.setBackground(new Color(0,0,0, 200));


        CalculateBill.setBounds(280,70,400,100);
        customerName.setBounds(225, 190, 200, 30);
        tCustomerName.setBounds(415, 190, 150, 30);
        tArea.setBounds(195,160,400, 150);


        calculate = new JButton("Calculate");
        back = new JButton("BACK");

        calculate.setBounds(280, 250, 100, 30);
        back.setBounds(420, 250, 100, 30);

        calculate.setBackground(Color.LIGHT_GRAY);
        back.setBackground(Color.LIGHT_GRAY);


        frame.add(CalculateBill);
        frame.add(customerName);
        frame.add(tCustomerName);
        frame.add(calculate);
        frame.add(back);
        frame.add(tArea);
        frame.add(icon);


        frame.setTitle("Bike Showroom");
        frame.setSize(831, 551);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        MyActionListener a = new MyActionListener();
        calculate.addActionListener(a);
        back.addActionListener(a);
    }


    class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Calculate")) {
                if (tCustomerName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Customer should have name.");
                    tCustomerName.setText(null);
                }
                else {
                    frame.dispose();
                    BikeOwner bO = BikeOwner.SearchByName(tCustomerName.getText());

                    Bike b = Bike.SearchInSold(bO.getPurchasedVehicle());
                    double bill = b.getPrice();
                    JOptionPane.showMessageDialog(null,"Bill = "+bill);
                    MainMenuGUI x = new MainMenuGUI();
                }
            }
            else if(ae.getActionCommand().equalsIgnoreCase("Back")){
                frame.dispose();
                MainMenuGUI y = new MainMenuGUI();
            }
        }
    }
}

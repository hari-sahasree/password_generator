import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI(){
        super("Password Generator");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerator = new PasswordGenerator();
        addGuiComponents();
    }
    private void addGuiComponents(){
        JLabel titleLabel = new JLabel("password generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0,10,540,39);
        add(titleLabel);
        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,479,78);
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        JLabel passwordLengthLabel = new JLabel("password length");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        JTextArea passLengthInputArea = new JTextArea();
        passLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passLengthInputArea.setBounds(310,215,192,39);
        add(passLengthInputArea);


        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 32));
        uppercaseToggle.setBounds(25,301,225,56);
        add(uppercaseToggle);

        JToggleButton lowercaseToggle = new JToggleButton("lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 32));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);

        JToggleButton numbersToggle = new JToggleButton("numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 32));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 32));
        symbolsToggle.setBounds(282,373,225,56);
        add(symbolsToggle);

        JButton generateButton = new JButton("generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(passLengthInputArea.getText().length()<=0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                uppercaseToggle.isSelected() ||
                numbersToggle.isSelected()||
                symbolsToggle.isSelected();

                int passwordLength = Integer.parseInt(passLengthInputArea.getText());
                if (anyToggleSelected){
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength, 
                    uppercaseToggle.isSelected(),
                    lowercaseToggle.isSelected(),
                    numbersToggle.isSelected(), 
                    symbolsToggle.isSelected());

                    passwordOutput.setText(generatedPassword);

                }

            }

           
        });
        add(generateButton);




        
    }
}

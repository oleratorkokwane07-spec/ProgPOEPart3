/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepartthree;

import javax.swing.JOptionPane;

/**
 *
 * @author Student
 */
public class PoePartThree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login register = new Login();
        Message msg = new Message();

        JOptionPane.showMessageDialog(null,
                "===== Register =====",
                "Registration",
                JOptionPane.INFORMATION_MESSAGE
        );

        String username = JOptionPane.showInputDialog(null, "Please enter your username");

        String password = JOptionPane.showInputDialog(null, "Please enter your password");

        String cellphone = JOptionPane.showInputDialog(null, "Please enter your cellphone");
        
        JOptionPane.showMessageDialog(null, register.registerUser(username, password, cellphone));

        if (!register.registerStatus(username,
                password, cellphone)) {
            return;
        }
        
        JOptionPane.showMessageDialog(null, "===== Login =====", 
                "Login", 
                JOptionPane.INFORMATION_MESSAGE);
        
        String loginUsername = JOptionPane.showInputDialog(null,"Enter username to login");
        
        String loginPassword = JOptionPane.showInputDialog(null, "Enter password to login");


        boolean status = register.loginUser(loginUsername, loginPassword);

        JOptionPane.showMessageDialog(null, register.returnLoginStatus(status));
        
        if (status = true) {

            int option;

            do {
                String menu = ("===== Select any of the options below ====="
                        + "1. Send message"
                        + "2. Message management"
                        + "3. Exit"
                        + "Select an option:");
                
                String input = JOptionPane.showInputDialog(null,
                        menu, 
                        "Main menu", 
                        JOptionPane.QUESTION_MESSAGE);

                if(input == null){
                    
                    option = 3;
                }else{
                    
                    
                    try{
                        
                        option = Integer.parseInt(input);
                        switch (option) {
                    case 1 ->
                        msg.sendingMessages();
                    case 2 ->
                        msg.messageManagementMenu();
                    case 3 ->
                        JOptionPane.showMessageDialog(null, "Good bye!!");
                    default ->
                        JOptionPane.showMessageDialog(null,
                                "Invalid option!!", 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);

                        
                    }
                        
                    }catch (NumberFormatException e){
                        option = 0;
                        JOptionPane.showMessageDialog(null, 
                              "Please enter a valid number",
                              "Input Error", 
                              JOptionPane.WARNING_MESSAGE);
                }    
                    

                                }

            } while (option != 3);
        }

    }

}
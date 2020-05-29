package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements ActionListener{



        JPanel panel;
        JMenu menu;
        JTextArea doliprane;
        JLabel doliprane_text;
        JButton rm_doliprane;
        JLabel test;





        public void supprime_nombre_medoc(JLabel nom_medicament, JTextArea medicament_area) {
            try {
                int medicament_nombre = Integer.parseInt(String.valueOf(medicament_area.getText()));
                if (medicament_nombre <  0) {
                    JOptionPane.showMessageDialog(panel, "Un nombre négatif ? Pourquoi ?", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    int x = Integer.parseInt(nom_medicament.getText());
                    x -= medicament_nombre;
                    System.out.println(x);
                    if(x < 0) {
                        JOptionPane.showMessageDialog(panel, "Impossible de descendre en-dessous de 0 !", "Erreur", JOptionPane.ERROR_MESSAGE);

                    } else {
                        String y = Integer.toString(x);
                        test.setText(y);
                        panel.add(nom_medicament);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(panel, "Veuillez préciser une valeur pour le médicament !", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

        }


        Client() {
            // Define
            panel = new JPanel(new GridLayout(3, 1));
            menu = new JMenu();
            doliprane = new JTextArea();
            doliprane_text = new JLabel("Doliprane :");
            rm_doliprane = new JButton("-");
            test = new JLabel("50");



            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            // Doliprane
            panel.add(doliprane_text);
            panel.add(doliprane);
            panel.add(rm_doliprane);
            panel.add(test);


            // Adding the listeners to components..
            add(panel, BorderLayout.CENTER);
            setTitle("Pharmatech - Client");
            setSize(400, 130);
            setVisible(true);


            rm_doliprane.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    supprime_nombre_medoc(test, doliprane);
                }
            });

        }




        public static void main(String[] args) {
            new Client();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JPanel panel;
    JMenu menu;
    JTextArea doliprane;
    JLabel doliprane_text;
    JButton add_doliprane;
    JButton rm_doliprane;
    JLabel test;

    /*
            === Ajout medoc ===
     */

    JLabel creation_text;
    JTextArea nom_nouveau_medoc;
    JTextArea nombre_nouveau_medoc;
    JLabel stock_nouveau_medoc;
    JButton creer;

    /*
        === Tests ===
    */
    JLabel nom_medicament;
    JButton nom_bouton_add;
    JButton nom_bouton_rm;
    volatile JTextArea medicament_text;


    public void Add_medicament(JLabel nom_medicament, JLabel stock_nouveau_medoc, JButton nom_bouton_add, JButton nom_bouton_rm, JTextArea medicament_text) {

        try {
            // Vérification
            int test_int = Integer.parseInt(String.valueOf(nombre_nouveau_medoc.getText()));    // Test si le input en stock de médicament est un nombre & si il est entier, si pas possible => bug du programme et donc renvois d'un message d'erreur
            if (test_int <  0) {
                JOptionPane.showMessageDialog(panel, "Avoir un stock négatif n'est  pas possible !", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                // Traitement
                nom_medicament.setText(nom_nouveau_medoc.getText() + " :");
                stock_nouveau_medoc.setText(nombre_nouveau_medoc.getText());

                // Ajout
                panel.add(nom_medicament);
                panel.add(medicament_text);
                panel.add(nom_bouton_add);
                panel.add(nom_bouton_rm);
                panel.add(stock_nouveau_medoc);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel, "Veuillez vérifier les données entrées !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void ajoute_nombre_medoc(JLabel nom_medicament, JTextArea medicament_area) {
        try {
            int medicament_nombre = Integer.parseInt(String.valueOf(medicament_area.getText()));
            if (medicament_nombre <  0) {
                JOptionPane.showMessageDialog(panel, "Un nombre négatif ? Pourquoi ?", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                int x = Integer.parseInt(nom_medicament.getText());
                x += medicament_nombre;
                System.out.println(x);
                String y = Integer.toString(x);
                test.setText(y);
                panel.add(nom_medicament);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel, "Veuillez préciser une valeur pour le médicament !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

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

    Dashboard() {
        // Define
        panel = new JPanel(new GridLayout(3, 1));
        menu = new JMenu();
        doliprane = new JTextArea();
        doliprane_text = new JLabel("Doliprane :");
        add_doliprane = new JButton("+");
        rm_doliprane = new JButton("-");
        test = new JLabel("1");
        creation_text = new JLabel("Ajouter un médicament : ");
        creer = new JButton("Ajouter");
        nom_nouveau_medoc = new JTextArea();


        // Création
        nombre_nouveau_medoc = new JTextArea();
        nom_medicament = new JLabel();
        medicament_text = new JTextArea();
        nom_bouton_add = new JButton("+");
        nom_bouton_rm = new JButton("-");
        stock_nouveau_medoc = new JLabel();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add to window
            // Ajout medoc
        panel.add(creation_text);
        panel.add(nom_nouveau_medoc);
        panel.add(nombre_nouveau_medoc);
        panel.add(creer);
            // Doliprane
        panel.add(doliprane_text);
        panel.add(doliprane);
        panel.add(add_doliprane);
        panel.add(rm_doliprane);
        panel.add(test);


        // Adding the listeners to components..
        add(panel, BorderLayout.CENTER);
        setTitle("Pharmatech - Dashboard");
        setSize(400, 130);
        setVisible(true);


        add_doliprane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajoute_nombre_medoc(test, doliprane);
            }
        });

        rm_doliprane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprime_nombre_medoc(test, doliprane);
            }
        });

        creer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_medicament(creation_text, stock_nouveau_medoc, nom_bouton_add, nom_bouton_rm, medicament_text);
            }
        });

        nom_bouton_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int medicament_nombre = Integer.parseInt(String.valueOf(medicament_text.getText()));
                    if (medicament_nombre <  0) {
                        JOptionPane.showMessageDialog(panel, "Un nombre négatif ? Pourquoi ?", "Erreur", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int x = Integer.parseInt(stock_nouveau_medoc.getText());
                        x += medicament_nombre;
                        if(x < 0) {
                            JOptionPane.showMessageDialog(panel, "Impossible de descendre en-dessous de 0 !", "Erreur", JOptionPane.ERROR_MESSAGE);

                        } else {
                        System.out.println(x);
                        String y = Integer.toString(x);
                        stock_nouveau_medoc.setText(y);
                        panel.add(stock_nouveau_medoc);
                        }
                    }
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(panel, "Veuillez préciser une valeur pour le médicament !", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        nom_bouton_rm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int medicament_nombre = Integer.parseInt(String.valueOf(medicament_text.getText()));
                    if (medicament_nombre <  0) {
                        JOptionPane.showMessageDialog(panel, "Un nombre négatif ? Pourquoi ?", "Erreur", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int x = Integer.parseInt(stock_nouveau_medoc.getText());
                        x -= medicament_nombre;
                        if(x < 0) {
                            JOptionPane.showMessageDialog(panel, "Impossible de descendre en-dessous de 0 !", "Erreur", JOptionPane.ERROR_MESSAGE);

                        } else {
                            System.out.println(x);
                            String y = Integer.toString(x);
                            stock_nouveau_medoc.setText(y);
                            panel.add(stock_nouveau_medoc);
                        }
                    }
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(panel, "Veuillez préciser une valeur pour le médicament !", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
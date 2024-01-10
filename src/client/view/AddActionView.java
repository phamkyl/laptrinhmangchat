package client.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class AddActionView {
    private GUI gui;
    private Border borderDefault;
    private Border borderCurrent;

    public AddActionView(GUI gui) {
        this.gui = gui;
        borderDefault = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(32, 178, 170));
        borderCurrent = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.WHITE);
    }

    public void changeLabelBackground(JLabel label) {

        for (JLabel menu : gui.menuLabels) {
            menu.setBackground(new Color(32, 178, 170));
            menu.setForeground(Color.white);
        }

        label.setBackground(Color.WHITE);
        label.setForeground(new Color(32, 178, 170));
    }

    public void changeClickPanel(JPanel panel) {
        for (JPanel menuPanel : gui.menuPanels) {
            menuPanel.setVisible(false);
        }

        panel.setVisible(true);
    }

    public void addToMenuLabel() {
        Component[] components = gui.panelLeft.getComponents();

        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;

                changeClickPanel(gui.panelRight);

                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        changeLabelBackground(label);

                        switch (label.getText().trim()) {
                            case "TRANG CHỦ":
                                changeClickPanel(gui.panelRight);
                                break;

                            case "TÌM KIẾM":
                                changeClickPanel(gui.panelSearch);
                                break;

                            case "BỆNH ÁN":
                                changeClickPanel(gui.panelManagement);
                                break;

                            case "THỐNG KÊ":
                                changeClickPanel(gui.panelChart);
                                break;
//                            default :
//                                break;

                        }

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label.setBorder(borderCurrent);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        label.setBorder(borderDefault);
                    }
                });
            }
        }
    }
}

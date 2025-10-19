package common;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Factory class for creating styled UI components
 * Reduces code duplication and ensures consistent styling
 */
public class UIComponentFactory {

    /**
     * Create styled JButton with primary color
     */
    public static JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(Constants.FONT_MEDIUM);
        button.setBackground(Constants.COLOR_PRIMARY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    /**
     * Create styled JButton with custom size
     */
    public static JButton createPrimaryButton(String text, int width, int height) {
        JButton button = createPrimaryButton(text);
        button.setPreferredSize(new Dimension(width, height));
        return button;
    }

    /**
     * Create styled text button (hyperlink style)
     */
    public static JButton createTextButton(String text) {
        JButton button = new JButton(text);
        button.setFont(Constants.FONT_SMALL);
        button.setForeground(Constants.COLOR_HYPERLINK);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    /**
     * Create styled JTextField
     */
    public static JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(Constants.FONT_REGULAR);
        textField.setPreferredSize(Constants.TEXTFIELD_SIZE);
        return textField;
    }

    /**
     * Create styled JTextField with placeholder
     */
    public static JTextField createTextField(String placeholder) {
        JTextField textField = createTextField();
        textField.setToolTipText(placeholder);
        return textField;
    }

    /**
     * Create styled JPasswordField
     */
    public static JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(Constants.FONT_REGULAR);
        passwordField.setPreferredSize(Constants.TEXTFIELD_SIZE);
        return passwordField;
    }

    /**
     * Create styled JLabel
     */
    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Constants.FONT_REGULAR);
        return label;
    }

    /**
     * Create styled title label
     */
    public static JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Constants.FONT_TITLE);
        label.setForeground(Constants.COLOR_PRIMARY);
        return label;
    }

    /**
     * Create styled section header label
     */
    public static JLabel createHeaderLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Constants.FONT_LARGE);
        label.setForeground(Constants.COLOR_PRIMARY);
        return label;
    }

    /**
     * Create JPanel with background color
     */
    public static JPanel createPanel(Color backgroundColor) {
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        return panel;
    }

    /**
     * Create JPanel with layout and background
     */
    public static JPanel createPanel(LayoutManager layout, Color backgroundColor) {
        JPanel panel = new JPanel(layout);
        panel.setBackground(backgroundColor);
        return panel;
    }

    /**
     * Create padded panel
     */
    public static JPanel createPaddedPanel(int padding) {
        JPanel panel = new JPanel();
        panel.setBackground(Constants.COLOR_BACKGROUND);
        panel.setBorder(new EmptyBorder(padding, padding, padding, padding));
        return panel;
    }

    /**
     * Create padded panel with layout
     */
    public static JPanel createPaddedPanel(LayoutManager layout, int padding) {
        JPanel panel = new JPanel(layout);
        panel.setBackground(Constants.COLOR_BACKGROUND);
        panel.setBorder(new EmptyBorder(padding, padding, padding, padding));
        return panel;
    }

    /**
     * Show error message dialog
     */
    public static void showErrorDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Show success message dialog
     */
    public static void showSuccessDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Show warning message dialog
     */
    public static void showWarningDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Show confirmation dialog
     */
    public static boolean showConfirmDialog(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    /**
     * Setup standard JFrame properties
     */
    public static void setupFrame(JFrame frame, String title) {
        frame.setTitle(title);
        frame.setSize(Constants.WINDOW_SIZE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Constants.COLOR_BACKGROUND);
    }

    private UIComponentFactory() {
        // Prevent instantiation
        throw new AssertionError("Cannot instantiate UIComponentFactory class");
    }
}

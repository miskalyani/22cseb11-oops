import javax.swing.*;
import java.awt.*;
public class ColorPaletteExample extends JFrame {

    private JTextArea textArea;
    private JCheckBox backgroundColorCheckBox;
    private JCheckBox foregroundColorCheckBox;

    public ColorPaletteExample() {
        setTitle("Color Palette Example");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeUI();
    }

    private void initializeUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());

     
        JPanel colorPalettePanel = createColorPalette();
        mainPanel.add(colorPalettePanel, BorderLayout.WEST);


        textArea = new JTextArea("Sample Text");
        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel checkboxPanel = createCheckboxPanel();
        mainPanel.add(checkboxPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createColorPalette() {
        JPanel colorPalettePanel = new JPanel(new GridLayout(3, 3));
        Color[] colors = {
                Color.RED, Color.GREEN, Color.BLUE,
                Color.YELLOW, Color.CYAN, Color.MAGENTA,
                Color.ORANGE, Color.PINK, Color.LIGHT_GRAY
        };

        for (Color color : colors) {
            JButton colorButton = new JButton();
            colorButton.setBackground(color);
            colorButton.addActionListener(new ColorButtonListener(color));
            colorPalettePanel.add(colorButton);
        }

        return colorPalettePanel;
    }

    private JPanel createCheckboxPanel() {
        JPanel checkboxPanel = new JPanel(new FlowLayout());

        backgroundColorCheckBox = new JCheckBox("Background Color");
        foregroundColorCheckBox = new JCheckBox("Foreground Color");

        backgroundColorCheckBox.addActionListener(new CheckBoxListener());
        foregroundColorCheckBox.addActionListener(new CheckBoxListener());

        checkboxPanel.add(backgroundColorCheckBox);
        checkboxPanel.add(foregroundColorCheckBox);

        return checkboxPanel;
    }

    private class ColorButtonListener implements ActionListener {
        private Color color;

        public ColorButtonListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (backgroundColorCheckBox.isSelected()) {
                textArea.setBackground(color);
            }
            if (foregroundColorCheckBox.isSelected()) {
                textArea.setForeground(color);
            }
        }
    }

    private class CheckBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!backgroundColorCheckBox.isSelected()) {
                textArea.setBackground(null);
            }
            if (!foregroundColorCheckBox.isSelected()) {
                textArea.setForeground(null);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ColorPaletteExample().setVisible(true);
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen {
    private JButton playButton;
    private ImageIcon backgroundImage;
    private Font arcadeFont;

    public SplashScreen() {
        // Load background image
        backgroundImage = new ImageIcon(getClass().getResource("/splash.jpeg"));

        // Load arcade font
        try {
            Font arcadeFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/arcade_font.ttf"));
            this.arcadeFont = arcadeFont.deriveFont(Font.PLAIN, 24);
        } catch (Exception e) {
            System.err.println("Failed to load arcade font");
            this.arcadeFont = new Font("Arial", Font.BOLD, 24);
        }

        // Set up the splash screen window
        JWindow splashWindow = new JWindow();
        splashWindow.getContentPane().setLayout(new BorderLayout());

        // Set up the background panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        splashWindow.getContentPane().add(backgroundPanel, BorderLayout.CENTER);

        // Set up the components
        JLabel headingLabel = createLabel("Game Hub", arcadeFont, Color.WHITE);
        JLabel madeByLabel = createLabel("Made by Suraj Bangade", arcadeFont.deriveFont(Font.PLAIN, 12), Color.WHITE);
        playButton = createButton("PLAY", arcadeFont.deriveFont(Font.BOLD, 24), Color.WHITE, Color.BLACK);

        // Set up the bottom panel for the button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(playButton);

        // Add the components to the background panel
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(headingLabel, BorderLayout.NORTH);
        backgroundPanel.add(madeByLabel, BorderLayout.CENTER);
        backgroundPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Set the size of the splash screen window
        splashWindow.pack();
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        splashWindow.setLocation(screenDim.width / 2 - splashWindow.getWidth() / 2, screenDim.height / 2 - splashWindow.getHeight() / 2);

        // Show the splash screen
        splashWindow.setVisible(true);
    }

    private JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JButton createButton(String text, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        button.setFocusPainted(false);
        button.addActionListener(new ButtonClickListener());
        return button;
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playButton) {
                // Handle PLAY button click
                // Call the appropriate method or class for the game to start
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SplashScreen splashScreen = new SplashScreen();
                // Perform any necessary initialization or loading before starting the game
                // Once ready, close the splash screen window and start the game
                splashScreen.disposeSplashWindow();
                // Start the game
            }
        });
    }

    // Method to close the splash screen window
    public void disposeSplashWindow() {
        Window splashWindow = SwingUtilities.getWindowAncestor(playButton);
        if (splashWindow != null) {
            splashWindow.dispose();
        }
    }
}

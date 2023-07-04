import jdk.jfr.Percentage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Quiz implements ActionListener {
    String[] questions = {
            "What is my name?",
            "Who is the most handsome man alive on this planet?",
            "Who is the most beautiful girl in the world?",
            "Where does the smartest man on earth live?"
    };
    String[][] options = {
            {"Sahil","Vipul","Suraj","Ryan Reynolds"},
            {"Robert Downey Jr.","Ryan Reynolds","Hugh Jackman","Suraj Bangade"},
            {"Deepika","Alia Bhatt","Prachi Dhomne","Chutki from Chota Bheem"},
            {"New York","Paris","Dubai","Chimur"}
    };
    char[] correctAnswers = {
            'C',
            'D',
            'D',
            'D'
    };
    char guess;
    char answer;
    char index;
    int correctGuess = 0;
    int totalQuestions = questions.length;
    int results;
    int seconds = 10;

    JFrame frame = new JFrame();
    JTextArea textArea = new JTextArea();
    JTextField textField = new JTextField();
    JLabel answerA = new JLabel();
    JLabel answerB = new JLabel();
    JLabel answerC = new JLabel();
    JLabel answerD = new JLabel();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel timerLabel = new JLabel();
    JLabel TimerSecondsLeft = new JLabel();
    JTextField numberRightLabel = new JTextField();
    JTextField percentage = new JTextField();
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            TimerSecondsLeft.setText(String.valueOf(seconds));
            if (seconds<=0){
                displayAnswer();
            }
        }
    });
    public Quiz(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        //for question number
        textField.setBounds(0,0,800,50);
        textField.setBackground(new Color(90,90,0));
        textField.setForeground(new Color(255,255,90));
        textField.setFont(new Font("Ink free",Font.BOLD,50));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        //for question statements
        textArea.setBounds(0,50,800,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(90,90,0));
        textArea.setForeground(new Color(255,255,90));
        textArea.setFont(new Font("MV Boli",Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        //options

        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,30 ));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,30) );
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,30 ));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,30 ));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        //answers

        answerA.setBounds(125,100,500,100);
        answerA.setBackground(new Color(50,50,50));
        answerA.setForeground(new Color(25,255,0));
        answerA.setFont(new Font("MV Boli",Font.BOLD,30 ));

        answerB.setBounds(125,200,500,100);
        answerB.setBackground(new Color(50,50,50));
        answerB.setForeground(new Color(25,255,0));
        answerB.setFont(new Font("MV Boli",Font.BOLD,30 ));

        answerC.setBounds(125,300,500,100);
        answerC.setBackground(new Color(50,50,50));
        answerC.setForeground(new Color(25,255,0));
        answerC.setFont(new Font("MV Boli",Font.BOLD,30 ));

        answerD.setBounds(125,400,500,100);
        answerD.setBackground(new Color(50,50,50));
        answerD.setForeground(new Color(25,255,0));
        answerD.setFont(new Font("MV Boli",Font.BOLD,30 ));
        answerD.setText("test");

        //timer

        TimerSecondsLeft.setBounds(530,510,100,100);
        TimerSecondsLeft.setBackground(new Color(25,25,100));
        TimerSecondsLeft.setForeground(new Color(255,25,100));
        TimerSecondsLeft.setFont(new Font("MV Boli",Font.BOLD,60));
        TimerSecondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        TimerSecondsLeft.setOpaque(true);
        TimerSecondsLeft.setHorizontalAlignment(JTextField.CENTER);
        TimerSecondsLeft.setText(String.valueOf(seconds));

        timerLabel.setBounds(530,475,100,25);
        timerLabel.setBackground(new Color(25,25,100));
        timerLabel.setForeground(new Color(255,25,100));
        timerLabel.setHorizontalAlignment(JTextField.CENTER);
        timerLabel.setFont(new Font("MV Boli",Font.BOLD,20));
        timerLabel.setBorder(BorderFactory.createBevelBorder(1));
        timerLabel.setOpaque(true);
        timerLabel.setText("Tik Tok");

        numberRightLabel.setBounds(255,255,200,100);
        numberRightLabel.setBackground(new Color(50,50,50));
        numberRightLabel.setForeground(new Color(25,255,0));
        numberRightLabel.setFont(new Font("MV Boli",Font.BOLD,30 ));
        numberRightLabel.setHorizontalAlignment(JTextField.CENTER);
        numberRightLabel.setBorder(BorderFactory.createBevelBorder(1));
        numberRightLabel.setEditable(false);

         percentage.setBounds(255,355,200,100);
         percentage.setEditable(false);
         percentage.setBackground(new Color(50,50,50));
         percentage.setForeground(new Color(25,255,0));
         percentage.setFont(new Font("MV Boli",Font.BOLD,30 ));
         percentage.setHorizontalAlignment(JTextField.CENTER);
         percentage.setBorder(BorderFactory.createBevelBorder(1));


        frame.add(timerLabel);
        frame.add(TimerSecondsLeft);
        frame.add(answerA);
        frame.add(answerB);
        frame.add(answerC);
        frame.add(answerD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }
    public void nextQuestion(){
        if (index>=totalQuestions){
            results();
        }
        else{
            textField.setText("Question"+(index+1));
            textArea.setText(questions[index]);
            answerA.setText(options[index][0]);
            answerB.setText(options[index][1]);
            answerC.setText(options[index][2]);
            answerD.setText(options[index][3]);

            timer.start();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource()==buttonA){
            answer = 'A';
            if (answer==correctAnswers[index]){
                correctGuess++;
            }
        }
        if (e.getSource()==buttonB){
            answer = 'B';
            if (answer==correctAnswers[index]){
                correctGuess++;
            }
        }
        if (e.getSource()==buttonC){
            answer = 'C';
            if (answer==correctAnswers[index]){
                correctGuess++;
            }
        }
        if (e.getSource()==buttonD){
            answer = 'D';
            if (answer==correctAnswers[index]){
                correctGuess++;
            }
        }
        displayAnswer();
    }
    public void displayAnswer(){

        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (correctAnswers[index]!='A'){
            answerA.setForeground(new Color(255,0,0));
        }
        if (correctAnswers[index]!='B'){
            answerB.setForeground(new Color(255,0,0));
        }
        if (correctAnswers[index]!='C'){
            answerC.setForeground(new Color(255,0,0));
        }
        if (correctAnswers[index]!='D'){
            answerD.setForeground(new Color(255,0,0));
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerA.setForeground(new Color(25,255,0));
                answerB.setForeground(new Color(25,255,0));
                answerC.setForeground(new Color(25,255,0));
                answerD.setForeground(new Color(25,255,0));

                answer=' ';
                seconds=10;
                TimerSecondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        results = (int)((correctGuess/(double)totalQuestions)*100);

        textField.setText("Results");

        if (correctGuess==4){
            textArea.setText("Smart Boi");
        }else{
            textArea.setText("Be Better");
        }

        answerA.setText("");
        answerB.setText("");
        answerC.setText("");
        answerD.setText("");

        numberRightLabel.setText(correctGuess+"/"+totalQuestions);
        percentage.setText(results+"%");

        frame.add(percentage);
        frame.add(numberRightLabel);
    }
}

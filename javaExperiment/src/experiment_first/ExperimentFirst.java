package experiment_first;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

public class ExperimentFirst extends JFrame {
    public ExperimentFirst() {
        setTitle("乘法计算");
        setBounds(400, 400, 1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel setPanel() {
        JMenuBar menuBar=new JMenuBar();
        JMenu difficulty=new JMenu("训练难度");
        JMenuItem simple=new JMenuItem("简单");
        JMenuItem complex=new JMenuItem("复杂");
        menuBar.add(difficulty);
        difficulty.add(simple);
        difficulty.add(complex);
        JPanel extra_panel=new JPanel();
        extra_panel.add(menuBar);
        JButton make_button = new JButton("生成题目");
        JTextField first_number = new JTextField(20);
        first_number.setEnabled(false);
        JLabel multi_label = new JLabel("*");
        JTextField second_number = new JTextField(20);
        second_number.setEnabled(false);
        JLabel equal_label = new JLabel("=");
        JTextField answer = new JTextField(25);
        JButton submit = new JButton("提交答案");
        JPanel input_panel = new JPanel();
        input_panel.add(first_number);
        input_panel.add(multi_label);
        input_panel.add(second_number);
        input_panel.add(equal_label);
        input_panel.add(answer);
        input_panel.add(submit);
        JLabel tip_label = new JLabel("请开始答题，并点击”提交按钮“，检查结果是否正确");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(extra_panel,BorderLayout.WEST);
        panel.add(make_button, BorderLayout.NORTH);
        panel.add(input_panel, BorderLayout.CENTER);
        panel.add(tip_label, BorderLayout.SOUTH);
        simple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty.setText(simple.getText());
            }
        });
        complex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty.setText(complex.getText());
            }
        });
        make_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int first = 0;
                int second =0;
                if(difficulty.getText().equals("简单")){
                   first = random.nextInt(10);
                   second = random.nextInt(10);
                }else if(difficulty.getText().equals("复杂")){
                    first = random.nextInt(20)+10;
                    second = random.nextInt(10);
                }
                first_number.setText(String.valueOf(first));
                second_number.setText(String.valueOf(second));
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!first_number.getText().equals("") && !second_number.getText().equals("")) {
                    if(!answer.getText().equals("")){
                        int first = Integer.parseInt(first_number.getText());
                        int second = Integer.parseInt(second_number.getText());
                        int answer_number=0;
                        try{
                           answer_number = Integer.parseInt(answer.getText().trim());
                        }catch(Exception ee){
                            tip_label.setText("请输入数字");
                        }
                        if (answer_number == first * second) {
                            tip_label.setText("答案正确!");
                        } else {
                            tip_label.setText("您输入的答案错误，请修改！");
                        }
                    }else{
                        tip_label.setText("请输入答案");
                    }
                }else{
                    tip_label.setText("请先生成题目");
                }
            }
        });
        return panel;
    }

    public static void main(String[] args) {
        ExperimentFirst experimentFirst = new ExperimentFirst();
        experimentFirst.add(experimentFirst.setPanel());
        experimentFirst.setVisible(true);
    }
}

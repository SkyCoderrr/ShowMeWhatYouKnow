import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.tools.JavaCompiler;
/**
 * Interface
 * @author Sky Wang
 *
 */
public class demo
{
    public static void main(String args[])throws Exception
    {
//        NewFrame frame1 = new NewFrame();
//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//一定要设置关闭
//
//        frame1.setVisible(true);

        MainFrame mf = new MainFrame();
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setVisible(true);
    }
}

class MainFrame extends JFrame
{

    //教学部分的内容
    private JLabel learning_title;
    private JButton start;
    private JButton next;
    private JButton previous;
    private JTextArea learning_area;
    private Content content;
    private int current =-1;

    //程序部分的内容
    private JLabel program_title;
    private JTextArea program_area;
    private JButton run;
    private JTextArea program_output;

    public MainFrame()
    {
        super();
        this.content = new Content();

        //界面函数相关
        this.setSize(1024,768);
        //先设置布局控制器为空
        this.getContentPane().setLayout(null);
        //自助学习部分。
        this.add(this.getLearning_title("Basic Java Knowledge"));
        this.add(this.getStart());
        this.add(this.getPrevious());
        this.add(this.getNext());
        this.add(this.getLearning_area());


        //编程部分
        this.add(this.getProgram_title());
        this.add(this.getProgram_area());
        this.add(this.getProgram_output());
        this.add(this.getRun());


        this.setTitle("Java Learning Program");

    }

    private JLabel getLearning_title(String s)
    {
        if(learning_title==null)
        {
            learning_title=new JLabel();
            learning_title.setBounds(30,50,500,50);
            learning_title.setText(s);
            learning_title.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }
        return learning_title;
    }

    private JTextArea getLearning_area()
    {
        if(learning_area==null)
        {
            learning_area = new JTextArea();
            learning_area.setCursor(null);
            learning_area.setEditable(false);
            learning_area.setOpaque(false);
            learning_area.setFocusable(false);
            learning_area.setLineWrap(true);
            learning_area.setBounds(30,100,500,500);
            learning_area.setBorder(BorderFactory.createLineBorder(Color.RED));
            learning_area.setText("Press Start to Begin the Lesson");

        }
        return learning_area;
    }

    private void set_LabelContent(JLabel label,String s){
        label.setText(s);
    }

    private void set_areaContent(JTextArea area,String s){
        area.setText(s);
    }

    private JButton getStart()
    {
        if(start==null)
        {
            start=new JButton();
            start.setBounds(30,650,80,40);
            start.setText("Start!");
            start.addActionListener(new startAction());
        }
        return start;
    }

    private class startAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Hello world!");
            set_areaContent(learning_area,content.title);
            current=-1;
        }
    }

    private JButton getPrevious()
    {
        if(previous==null)
        {
            previous=new JButton();
            previous.setBounds(150,650,80,40);
            previous.setText("Previous");
            previous.addActionListener(new previousAction());
        }
        return previous;
    }

    private class previousAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(current==-1){
                set_areaContent(learning_area,"This is already the first one");
            }
            else
            {
                set_areaContent(learning_area,content.content[--current]);
            }
        }
    }

    private JButton getNext()
    {
        if(next==null)
        {
            next=new JButton();
            next.setBounds(250,650,80,40);
            next.setText("Next");
            next.addActionListener(new nextAction());
        }
        return next;
    }
    private class nextAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (current == content.content.length - 1)
            {
                set_areaContent(learning_area, "This is already the last one");
            } else
            {

                set_areaContent(learning_area, content.content[++current]);
            }
        }
    }



    //自助写代码部分
    private JLabel getProgram_title()
    {
        if(program_title==null)
        {
            program_title= new JLabel();
            program_title.setBounds(530,50,600,50);
            program_title.setText("Enter your program below, then press run to compile and run the program");
            program_title.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }
        return program_title;
    }
    private JTextArea getProgram_area()
    {
        if(program_area==null)
        {
            program_area = new JTextArea();
            program_area.setCursor(null);
            program_area.setEditable(true);
            program_area.setOpaque(false);
            program_area.setFocusable(true);
            program_area.setLineWrap(true);
            program_area.setBounds(530,100,600,400);
            program_area.setText("public class program{\n" +
                    "     public static void main(String arg[]){\n" +
                    "\n" +
                    "\n" +
                    "     }\n" +
                    "}\n");
            program_area.setBorder(BorderFactory.createLineBorder(Color.RED));

        }
        return program_area;
    }
    private JTextArea getProgram_output()
    {
        if(program_output==null)
        {
            program_output = new JTextArea();
            program_output.setCursor(null);
            program_output.setEditable(false);
            program_output.setOpaque(false);
            program_output.setFocusable(false);
            program_output.setLineWrap(true);
            program_output.setBounds(530,500,500,180);
            program_output.setText("#Your result of your program  will be shown here");
            program_output.setBorder(BorderFactory.createLineBorder(Color.orange));

        }
        return program_output;
    }

    private JButton getRun()
    {
        if(run==null)
        {
            run=new JButton();
            run.setBounds(530,685,80,40);
            run.setText("Run");
            run.addActionListener(new runAction());
        }
        return run;
    }

    private class runAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //取出program_area的内容，利用javacompiler类编译，然后输出到program——output中
            program_output.setText("");
            int result=-1;
            String program = program_area.getText();
            //
            MyCompiler myCompiler = new MyCompiler(program);
            try
            {
                result=myCompiler.naive_compiler();
                if(result==0)
                {
                    program_output.append("#Compile Success!\n");
                }else
                {
                    program_output.append("#Compile Failed!\n");
                }
            } catch (Exception e1)
            {
                e1.printStackTrace();
            }
            try
            {
                program_output.append("#output your Program's answer:\n");
                 BufferedReader ouput_result;
                 ouput_result= myCompiler.run(result);
                 String output ="";
                 while((output = ouput_result.readLine())!=null)
                 {
                     program_output.append(output+"\n");
                 }
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }

        }
    }


}

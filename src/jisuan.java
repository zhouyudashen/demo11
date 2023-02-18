import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class jisuan extends JFrame implements ActionListener {
        private JPanel north = new JPanel();
        private JTextField text = new JTextField();
        private JButton button = new JButton("c");

        private JPanel center = new JPanel();

        public jisuan() throws HeadlessException{
            this.init();
            this.addnorth();
            this.addcenter();
        }
        public void init(){
            this.setTitle("计算器");
            this.setSize(400,400);
            this.setLayout(new BorderLayout());
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
        public void addnorth(){
            this.text.setPreferredSize(new Dimension(330,40));
            north.add(text);
            this.button.setForeground(Color.RED);
            north.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text.setFont(new Font("宋体",Font.BOLD,20));
                    text.setText("");
                }
            });
            this.add(north,BorderLayout.NORTH);
        }
        public void addcenter(){
            String tt = "123+456-789*0.=/";
            this.center.setLayout(new GridLayout(4,4));
            for(int i=0;i<16;i++){
                String temp = tt.substring(i,i+1);
                JButton but = new JButton();
                but.setText(temp);
                if(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/") || temp.equals(".") ||
                        temp.equals("=") ){
                    but.setFont(new Font("粗体",Font.BOLD,20));
                }
                but.addActionListener(this);
                this.center.add(but);
            }
            this.add(center,BorderLayout.CENTER);
        }
        public static void main(String[] args){
            jisuan jisuan = new jisuan();
            jisuan.setVisible(true);}
    private String first =null;
    private String operator = null;
    @Override
    public void actionPerformed(ActionEvent e) {
        String click = e.getActionCommand();
        if(".0123456789".indexOf(click)!=-1) {
            this.text.setText(text.getText()+ click);
            text.setFont(new Font("宋体",Font.BOLD,20));
            this.text.setHorizontalAlignment(JTextField.RIGHT);
        }else if(click.matches("[\\+\\-*/]{1}")){
            operator = click;
            first = this.text.getText();
            this.text.setText("");
        }else if(click.equals("=")){
            Double a = Double.valueOf(first);
            Double b = Double.valueOf(this.text.getText());
            Double result = null;
            switch (operator){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result=a-b;
                    break;
                case "*":
                    result=a*b;
                    break;
                case "/":
                    if(b!=0){
                    result=a/b;}
                    break;

            }
            this.text.setText(result.toString());
        }
    }
}


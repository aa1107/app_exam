package ch15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    Frame frame;
    Panel buttonPanel;
    Label display;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnClear,btnEqual,btnPlus,btnMinus,btnMulti,btnDivide;
    String susik="";
    int numOfInput=0;
    int firstNum=0;
    int secondNum=0;
    String result="";
    float res=0.0f;
    String operator="";

    public void makeFrame(){
        frame.add(display,"North");
        frame.add(buttonPanel,"Center");

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public Calculator(){
        frame=new Frame("계산기");
        buttonPanel=new Panel();
        buttonPanel.setLayout(new GridLayout(4,1));
        display=new Label();
        display.setAlignment(Label.RIGHT);
        btn0=new Button("0");
        btn1=new Button("1");
        btn2=new Button("2");
        btn3=new Button("3");
        btn4=new Button("4");
        btn5=new Button("5");
        btn6=new Button("6");
        btn7=new Button("7");
        btn8=new Button("8");
        btn9=new Button("9");
        btnClear=new Button("C");
        btnEqual=new Button("=");
        btnPlus=new Button("+");
        btnMinus=new Button("-");
        btnMulti=new Button("*");
        btnDivide=new Button("/");

        btn0.addActionListener(new ActionHandler());
        btn1.addActionListener(new ActionHandler());
        btn2.addActionListener(new ActionHandler());
        btn3.addActionListener(new ActionHandler());
        btn4.addActionListener(new ActionHandler());
        btn5.addActionListener(new ActionHandler());
        btn6.addActionListener(new ActionHandler());
        btn7.addActionListener(new ActionHandler());
        btn8.addActionListener(new ActionHandler());
        btn9.addActionListener(new ActionHandler());

        btnPlus.addActionListener(new ActionHandler());
        btnMinus.addActionListener(new ActionHandler());
        btnMulti.addActionListener(new ActionHandler());
        btnDivide.addActionListener(new ActionHandler());
        btnEqual.addActionListener(new ActionHandler());
        btnClear.addActionListener(new ActionHandler());

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);
        buttonPanel.add(btnPlus);

        buttonPanel.add(btn4);
        buttonPanel.add(btn5);
        buttonPanel.add(btn6);
        buttonPanel.add(btnMinus);

        buttonPanel.add(btn7);
        buttonPanel.add(btn8);
        buttonPanel.add(btn9);
        buttonPanel.add(btnMulti);

        buttonPanel.add(btn0);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnEqual);
        buttonPanel.add(btnDivide);
    }

    private class ActionHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String num=e.getActionCommand();
            Button btn=(Button)e.getSource();
            if(btn==btn0){
                /*System.out.println("btn0클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }else if(btn==btn1){
                /*System.out.println("btn1클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }else if(btn==btn2){
                /*System.out.println("btn2클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }else if(btn==btn3){
                /*System.out.println("btn3클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }else if(btn==btn4){
                /*System.out.println("btn4클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }else if(btn==btn5){
                /*System.out.println("btn5클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }else if(btn==btn6){
                /*System.out.println("btn6클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }else if(btn==btn7){
                /*System.out.println("btn7클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }else if(btn==btn8){
                /*System.out.println("btn8클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }else if(btn==btn9){
                /*System.out.println("btn9클릭");
                if(numOfInput==0){
                    firstNum=Integer.parseInt(num);
                    numOfInput++;
                }else{
                    secondNum=Integer.parseInt(num);
                    numOfInput++;
                }*/
                susik+=num;
                display.setText(susik);
            }

            //연산자 버튼을 클릭한 경우
            if(btn==btnPlus){
                susik+="+";
                operator="+";
                display.setText(susik);
            }else if(btn==btnMinus){
                susik+="-";
                operator="-";
                display.setText(susik);
            }else if(btn==btnMulti){
                susik+="*";
                operator="*";
                display.setText(susik);
            }else if(btn==btnDivide){
                susik+="/";
                operator="/";
                display.setText(susik);
            }else if(btn==btnClear){
                susik+="";
                operator="";
                display.setText("0");
            }else if(btn==btnEqual){
                /*if(numOfInput==2){
                    if(operator.equals("+")){
                        result=firstNum+secondNum;
                    }else if(operator.equals("-")){
                        result=firstNum-secondNum;
                    }else if(operator.equals("*")){
                        result=firstNum*secondNum;
                    }else if(operator.equals("/")){
                        res=((float)firstNum)/secondNum;
                    }

                    if(!operator.equals("/")){
                        susik=Integer.toString(result);
                    }else{
                        susik=Float.toString(res);
                    }*/
                result=calculate(susik,operator);
                    display.setText(susik);
                    susik="";
//                    numOfInput=0;

            }
        }
    }
    public static void main(String[] args){
        Calculator c=new Calculator();
        c.makeFrame();
    }
    private static String calculate(String str,String opr){
        String result=null;
        String[] num;
        String rg="\\"+opr;
        int firstNum=0,secondNum=0;
        num=str.split("["+opr+"]");
        firstNum=Integer.parseInt(num[0]);
        secondNum=Integer.parseInt(num[1]);

        if(opr.equals("+")){
            result=Integer.toString(firstNum+secondNum);
        }else if(opr.equals("-")){
            result=Integer.toString(firstNum-secondNum);
        }else if(opr.equals("*")){
            result=Integer.toString(firstNum*secondNum);
        }else if(opr.equals("/")){
            result=Float.toString(((float)firstNum)/secondNum);
        }

        return result;
    }
}

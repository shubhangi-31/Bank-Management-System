
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton sYes,sNo,eYes,eNo;
    JComboBox religion,category,income,occupation,education;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionalDetails=new JLabel("Page 1: Additional Details" );
        additionalDetails.setFont(new Font("Ralway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name=new JLabel("Religion: " );
        name.setFont(new Font("Ralway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        religion= new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
       
        
        JLabel fname=new JLabel("Category: " );
        fname.setFont(new Font("Ralway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[]={"General","OBC","SC","ST"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);
        
        
        JLabel dob=new JLabel("Income : " );
        dob.setFont(new Font("Ralway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomeCategory[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income=new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);
        
        
        JLabel gender=new JLabel("Educational : " );
        gender.setFont(new Font("Ralway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
        JLabel email=new JLabel("Qualification: " );
        email.setFont(new Font("Ralway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationCategory[]={"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        education=new JComboBox(educationCategory);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);
        
        
        JLabel marital=new JLabel("Occupation : " );
        marital.setFont(new Font("Ralway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String occupationValues[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Unemployed","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel address=new JLabel("PAN number: " );
        address.setFont(new Font("Ralway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan =new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city=new JLabel("AADHAR number: " );
        city.setFont(new Font("Ralway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar =new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state=new JLabel("Senior Citizen:" );
        state.setFont(new Font("Ralway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        sYes=new JRadioButton("YES");
        sYes.setBounds(300,540,100,30);
        sYes.setBackground(Color.white);
        add(sYes);
       
        sNo=new JRadioButton("NO");
        sNo.setBounds(450,540,100,30);
        sNo.setBackground(Color.white);
        add(sNo);
        
        
        ButtonGroup smaritalGroup=new ButtonGroup();
        smaritalGroup.add(sYes);
        smaritalGroup.add(sNo);
        
        JLabel pincode=new JLabel("Existing Account " );
        pincode.setFont(new Font("Ralway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eYes=new JRadioButton("YES");
        eYes.setBounds(300,590,100,30);
        eYes.setBackground(Color.white);
        add(eYes);
       
        eNo=new JRadioButton("NO");
        eNo.setBounds(450,590,100,30);
        eNo.setBackground(Color.white);
        add(eNo);
        
        
        ButtonGroup emaritalGroup=new ButtonGroup();
        emaritalGroup.add(eYes);
        emaritalGroup.add(eNo);
        
        
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        
        String seniorcitizen=null;
        if(sYes.isSelected()){
            seniorcitizen="Yes";
        }
        else if(sNo.isSelected()){
            seniorcitizen="No";
        }
        
        String existing=null;
        if(eYes.isSelected()){
            existing="Yes";
        }
        else if(eNo.isSelected()){
            existing="No";
        }
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        
        
        try{
            Conn c1 = new Conn();
            String q1 = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existing+"')";
            c1.s.executeUpdate(q1);
            
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}


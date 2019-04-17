/*import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.SubstanceAutumnLookAndFeel;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.title.FlatTitlePainter;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class Demo extends JFrame {
    JTextArea jta = new JTextArea();
    JTextField jtf1 = new JTextField(10);
    int count = 0;
    Vector<Package> packages = new Vector<Package>();
    Demo()
    {
        super();
        this.setTitle("南航行李托运");
        this.setSize(1000,800);

        //创建一个菜单栏
        JMenuBar menuBar=new JMenuBar();

        JMenu Menu=new JMenu("菜单");
        menuBar.add(Menu);
        JMenuItem addMenuItem=new JMenuItem("添加行李");
        Menu.add(addMenuItem);
        addMenuItem.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e) {
                dialog();
            }
        });
        this.setJMenuBar(menuBar);

        JPanel jp1 = new JPanel();

        JLabel jl1=new JLabel("航线");
        //JTextField jtf1 = new JTextField(10);
        String []path={
                "国内航班","美国","日本、美洲(不含美国)、澳新、迪拜(不含兰州/乌鲁木齐)、俄罗斯、新加坡始发至中国",
                "兰州/乌鲁木齐与迪拜","中西亚","内罗毕(不含毛利求斯)","其他航线(毛利求斯)","韩国始发与中国之间的"
        };
        final   JComboBox jcb1=new JComboBox(path);
        jcb1.setBounds(10,10,30,30);

       final JLabel jl3 = new JLabel("舱位");
        //JTextField jtf3 = new JTextField(10);
        String []path3={
                "头等舱","公务舱","明珠经济舱(国内和韩国始发没有相关舱)","经济舱"
        };
       final JComboBox jcb3=new JComboBox(path3);
        jcb3.setBounds(10,10,30,30);


        JLabel jl4 = new JLabel("旅客类型");
        //JTextField jtf4 = new JTextField(10);
        String []path4={
                "普通账户","南航明珠金卡会员、天合联盟超级精英",
                "南航明珠银卡会员、天合联盟精英","留学生、劳务、海员"
        };
       final JComboBox jcb4=new JComboBox(path4);
        jcb4.setBounds(10,10,30,30);

        JLabel jl5 = new JLabel("当日国内经济舱票价");

        final JCheckBox jcbox = new JCheckBox("是否携带婴儿");
        jcbox.setBounds(50,50,130,30);
        Box box = Box.createVerticalBox();
        box.add(jl1);
        box.add(jcb1);
        box.add(jl3);
        box.add(jcb3);
        box.add(jl4);
        box.add(jcb4);
        box.add(jl5);
        box.add(jtf1);
        box.add(jcbox);
        JButton jButton = new JButton("计算");
        JLabel jLabel = new JLabel("行李托运费用为:");
       final JTextField jTextField = new JTextField(10);
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int routes = jcb1.getSelectedIndex();   //获得所选航线信息
                int cabins = jcb3.getSelectedIndex();   //获取所选舱位信息
                int vips = jcb4.getSelectedIndex();     //获取旅客类型信息
                int cashs = Integer.parseInt(jtf1.getText());    //当日国内航线的经济舱票价
                int baby = 0;
                if(jcbox.isSelected())
                {
                    baby = 1;
                }
                Calculation cal = new Calculation();
                int money = cal.GetResult(routes,cabins,vips,cashs,packages,baby);
                jTextField.setText(String.valueOf(money));
            }
        });
        /*jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"托运费用为：" + money);
                int routes = jcb1.getSelectedIndex();   //获得所选航线信息
                int cabins = jcb3.getSelectedIndex();   //获取所选舱位信息
                int vips = jcb4.getSelectedIndex();     //获取旅客类型信息
                int cashs = Integer.parseInt(jtf1.getText());    //当日国内航线的经济舱票价
                int baby = 0;
                if( jcbox.isSelected())
                {
                    baby = 1;
                }
                Calculation cal = new Calculation();
                int money = cal.GetResult(routes,cabins,vips,cashs,packages,baby);
                jTextField.setText(String.valueOf(money));
            }
        });*/
        box.add(jButton);
        box.add(jLabel);
        box.add(jTextField);
        jp1.add(box);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        jp2.add(jta,BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp1,jp2);
        this.add(jsp,BorderLayout.CENTER);
        jsp.setDividerLocation(0.5);
        this.setVisible(true);
    }
    void dialog()
    {
        final   JFrame f=new JFrame("行李信息");
        f.setSize(400,300);
        f.setLocation(200,200);

        JPanel jp1=new JPanel();     //长
        JPanel jp2=new JPanel();     //宽
        JPanel jp3=new JPanel();     //高
        JPanel jp4=new JPanel();    //重量
        JPanel jp5=new JPanel();    //button

        JLabel jlb1=new JLabel("长    ");
        final JTextField jtf1=new JTextField(10);

        JLabel jlb2=new JLabel("宽    ");
        final   JTextField jtf2=new JTextField(10);

        JLabel jlb3=new JLabel("高   ");
       final JTextField jtf3=new JTextField(10);

        JLabel jlb4=new JLabel("重量");
       final   JTextField jtf4=new JTextField(10);

        JButton jb1=new JButton("保存");
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Box box = Box.createVerticalBox();
                double length = Double.valueOf(jtf1.getText());
                double width = Double.valueOf(jtf2.getText());
                double high = Double.valueOf(jtf3.getText());
                double weight = Double.valueOf(jtf4.getText());

                if(length == 0||width==0||high==0||weight==0)
                {
                    JOptionPane.showMessageDialog(null,"行李信息不可为0");
                }
                count++;

                Package pack = new Package();
                pack.AddPackage(length,width,high,weight);
                packages.add(pack);
                jta.append(count+" 长"+length+" 宽"+width+" 高"+high+" 重量"+weight+"\n");
                jta.setLineWrap(true);

            }
        });
        JButton jb2=new JButton("取消");
        jb2.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });
        f.setLayout(new GridLayout(5,1));
        jp1.add(jlb1);
        jp1.add(jtf1);
        jp2.add(jlb2);
        jp2.add(jtf2);
        jp3.add(jlb3);
        jp3.add(jtf3);
        jp4.add(jlb4);
        jp4.add(jtf4);
        jp5.add(jb1);
        jp5.add(jb2);
        f.add(jp1);
        f.add(jp2);
        f.add(jp3);
        f.add(jp4);
        f.add(jp5);

        f.setVisible(true);
    }
    public static void main(String[] args) {

        try {
           /* UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
            SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
            SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
            SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
            SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
            SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());*/
            Demo de=new Demo();
        } catch (Exception e) {
            System.err.println("Something went wrong!");
        }
    }


}


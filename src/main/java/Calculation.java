import javax.swing.*;
import java.util.Vector;

public class Calculation {
    int route = -1;    //用于判断航线类型
    int cabin = -1;    //判断舱位信息
    int viptype = -1;   //用于判断旅客VIP等级
    int cash = 0;
    int delivermoney = 0;
    int GetResult(int routes, int cabins, int viptypes, int cashs,Vector<Package> packages,int baby)
    {
        this.route = routes;
        this.cabin = cabins;
        this.viptype = viptypes;
        this.cash = cashs;
        this.delivermoney = 0;
        if(this.cash <= 0)
        {
            return 0;
        }
        int mark = -1;    //防止会员权力与婴儿权力的冲突
        //   判断旅客使用那条航线
        int allweight = 0;    //行李总重量
        int babyweight = 0;
        //boolean use = false;
        if(this.route == 0)     //国内航线
        {
            int len = packages.size();    //计算行李数目
            for(int i=0;i<len;i++)
            {
                if (packages.get(i).weight > 50 || packages.get(i).weight <= 0)
                {
                    // JOptionPane.showMessageDialog(null, "行李重量不合法");
                    return 0;
                } else if (packages.get(i).length > 60 || packages.get(i).width > 40 || packages.get(i).height > 100)
                {
                    // JOptionPane.showMessageDialog(null, "行李尺寸超出");
                    return 0;
                }
                allweight += packages.get(i).weight;
            }
            if(this.cabin==0)   //头等舱
            {
                if(baby == 1)
                {
                    babyweight = 10;
                }
                if(this.viptype == 1)
                {
                    if(allweight <= 60 + babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 60 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                        // return  delivermoney;
                    }
                }
                else if(this.viptype == 2)
                {
                    if(allweight <= 50 + babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 50 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                        // return  delivermoney;
                    }
                }
                else if(this.viptype == 3)
                {
                    if(allweight <= 80 + babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 80 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                        // return  delivermoney;
                    }
                }
                else {
                    if(allweight <= 40 + babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 40 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                        //  return  delivermoney;
                    }
                }
            }
            else if(this.cabin == 1)  //公务舱
            {
                if(this.viptype == 1)
                {
                    if(allweight <= 50 + babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 50 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                        // return  delivermoney;
                    }
                }
                else if(this.viptype == 2)
                {
                    if(allweight <= 40 + babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 40 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                        // return  delivermoney;
                    }
                }
                else if (this.viptype == 3)
                {
                    if(allweight <= 60 +babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 60 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                    }
                }
                else {
                    if(allweight <= 30 + babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 30 -babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                    }
                }
            }
            else if(this.cabin == 2)
            {
                //JOptionPane.showMessageDialog(null,"我没有高级经济舱");
                return  0;
            }
            else if(this.cabin == 3)//经济舱
            {
                if(this.viptype == 1)
                {
                    if(allweight <= 40 + babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 40 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                        // return  delivermoney;
                    }
                }
                else if(this.viptype == 2)
                {
                    if(allweight <= 30 + babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 30 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                        // return  delivermoney;
                    }
                }
                else if (this.viptype == 3)
                {
                    if(allweight <= 40 +babyweight)
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 40 -babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                    }
                }
                else {
                    if(allweight <= 20 + babyweight )
                    {
                        delivermoney = 0;
                    }
                    else {
                        double delmoney = (allweight - 20 - babyweight)*this.cash*0.015;
                        delivermoney = (int)Math.round(delmoney);
                    }
                }
            }
            return delivermoney;
        }
        else if(this.route == 1)    //涉及美国航线
        {

            int len = packages.size();    //计算行李数目
            for(int i=0;i<len;i++)
            {
                if (packages.get(i).weight > 45 || packages.get(i).weight <= 0)
                {
                    //JOptionPane.showMessageDialog(null, "行李重量不合法");
                    System.out.println("行李重量不合法");
                    return 0;
                }else if (packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 300)
                {
                   // JOptionPane.showMessageDialog(null, "行李尺寸超出");
                    System.out.println("行李尺寸超出");
                    return 0;
                }
            }
            int newlen =len;
            if(baby == 1)
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 115)
                    {
                        newlen--;
                        mark = i;
                        break;
                    }
                }
            }
            // len = newlen;

            //////////////减去会员权限的使用
            if(this.viptype == 1)   //南航明珠金卡会员、天合联盟超级精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 20 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 2)   //南航明珠银卡会员、天合联盟精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 3)   //留学生、劳务、海员
            {
                newlen--;
            }
            if (this.cabin == 0) //头等舱
            {
                if(newlen > 3)
                {
                    if(newlen - 3 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -4);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if(this.cabin == 1)   //公务舱
            {
                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -3);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if (this.cabin == 2 || this.cabin == 3)   //明珠经济舱 经济舱
            {
                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -3);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 23 && packages.get(i).weight <= 32 )
                    {
                        delivermoney += 2000;
                    }
                    else if (packages.get(i).weight > 32)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            return delivermoney;
        }
        else if(this.route == 2)    //区域1 航线   除美国外
        {
            int len = packages.size();    //计算行李数目
            for(int i=0;i<len;i++)
            {
                if (packages.get(i).weight > 32 || packages.get(i).weight <= 0)
                {
                   // JOptionPane.showMessageDialog(null, "行李重量不合法");
                    System.out.println("行李重量不合法");
                    return 0;
                } else if (packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 300)
                {
                    JOptionPane.showMessageDialog(null, "行李尺寸超出");
                    System.out.println("行李尺寸超出");
                    return 0;
                }
            }
            int newlen =len;
            if(baby == 1)
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 115)
                    {
                        newlen--;
                        mark = i;
                        break;
                    }
                }
            }
            // len = newlen;

            //////////////减去会员权限的使用
            if(this.viptype == 1)   //南航明珠金卡会员、天合联盟超级精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 20 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 2)   //南航明珠银卡会员、天合联盟精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 3)   //留学生、劳务、海员
            {
                newlen--;
            }
            if (this.cabin == 0) //头等舱
            {
                if(newlen > 3)
                {
                    if(newlen - 3 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -4);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if(this.cabin == 1)   //公务舱
            {
                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -3);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if (this.cabin == 2 || this.cabin == 3)   //明珠经济舱 经济舱
            {
                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -3);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 23 && packages.get(i).weight <= 32 )
                    {
                        delivermoney += 1000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            return delivermoney;
        }
        else if(this.route == 3)    //兰州 乌鲁木齐  --》  迪拜
        {
            int len = packages.size();    //计算行李数目
            for(int i=0;i<len;i++)
            {
                if (packages.get(i).weight > 32 || packages.get(i).weight <= 0)
                {
                    //JOptionPane.showMessageDialog(null, "行李重量不合法");
                    System.out.println("行李重量不合法");
                    return 0;
                } else if (packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 300)
                {
                    //JOptionPane.showMessageDialog(null, "行李尺寸超出");
                    System.out.println("行李尺寸超出");
                    return 0;
                }
            }
            int newlen =len;
            if(baby == 1)
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 115)
                    {
                        newlen--;
                        mark = i;
                        break;
                    }
                }
            }
            // len = newlen;

            //////////////减去会员权限的使用
            if(this.viptype == 1)   //南航明珠金卡会员、天合联盟超级精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 20 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 2)   //南航明珠银卡会员、天合联盟精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 3)   //留学生、劳务、海员
            {
                newlen--;
            }
            if (this.cabin == 0) //头等舱
            {
                if(newlen > 3)
                {
                    if(newlen - 3 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -4);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if(this.cabin == 1)   //公务舱
            {
                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -3);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if (this.cabin == 2)   // 明珠经济舱
            {
                if(newlen > 1)
                {
                    if(newlen - 1 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -2);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 23 && packages.get(i).weight <= 32 )
                    {
                        delivermoney += 1000;
                    }
                    else if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if (this.cabin == 3)   // 经济舱
            {
                if(newlen > 1)
                {
                    if(newlen - 1 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -2);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 23 && packages.get(i).weight <= 32 )
                    {
                        delivermoney += 1000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            return delivermoney;
        }
        else if(this.route == 4)    //中西亚
        {
            int len = packages.size();    //计算行李数目
            for(int i=0;i<len;i++)
            {
                if (packages.get(i).weight > 32 || packages.get(i).weight <= 0)
                {
                    //JOptionPane.showMessageDialog(null, "行李重量不合法");
                    System.out.println("行李重量不合法");
                    return 0;
                } else if (packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 300)
                {
                    //JOptionPane.showMessageDialog(null, "行李尺寸超出");
                    System.out.println("行李尺寸超出");
                    return 0;
                }
            }
            int newlen =len;
            if(baby == 1)
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 115)
                    {
                        newlen--;
                        mark = i;
                        break;
                    }
                }
            }
            // len = newlen;

            //////////////减去会员权限的使用
            if(this.viptype == 1)   //南航明珠金卡会员、天合联盟超级精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 20 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 2)   //南航明珠银卡会员、天合联盟精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 3)   //留学生、劳务、海员
            {
                newlen--;
            }
            if (this.cabin == 0) //头等舱
            {

                if(newlen > 3)
                {
                    if(newlen - 3 == 1 )
                    {
                        delivermoney += 450;
                    }
                    else {
                        delivermoney += 450 + 1300 * (newlen -4);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if(this.cabin == 1)   //公务舱
            {

                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 450;
                    }
                    else {
                        delivermoney += 450 + 1300 * (newlen -3);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if (this.cabin == 2 || this.cabin == 3)   // 明珠经济舱
            {

                if(newlen > 1)
                {
                    if(newlen - 1 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -2);
                    }
                }
                for(int i= 0;i < len ; i++)
                {

                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            return delivermoney;
        }
        else if(this.route == 5)       //内罗毕(不含毛里求斯)
        {
            int len = packages.size();    //计算行李数目
            for(int i=0;i<len;i++)
            {
                if (packages.get(i).weight > 32 || packages.get(i).weight <= 0)
                {
                    //JOptionPane.showMessageDialog(null, "行李重量不合法");
                    System.out.println("行李重量不合法");
                    return 0;
                }else if (packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 300)
                {
                    //JOptionPane.showMessageDialog(null, "行李尺寸超出");
                    System.out.println("行李尺寸超出");
                    return 0;
                }
            }
            int newlen =len;
            if(baby == 1)
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 115)
                    {
                        newlen--;
                        mark = i;
                        break;
                    }
                }
            }
            // len = newlen;

            //////////////减去会员权限的使用
            if(this.viptype == 1)   //南航明珠金卡会员、天合联盟超级精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 20 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 2)   //南航明珠银卡会员、天合联盟精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 3)   //留学生、劳务、海员
            {
                newlen--;
            }
            if (this.cabin == 0) //头等舱
            {
                if(newlen > 3)
                {
                    if(newlen - 3 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -4);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if(this.cabin == 1)   //公务舱
            {
                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -3);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if (this.cabin == 2 || this.cabin == 3)   //明珠经济舱 经济舱
            {
                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 1000;
                    }
                    else {
                        delivermoney += 1000 + 2000 * (newlen -3);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 23 && packages.get(i).weight <= 32 )
                    {
                        delivermoney += 2000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            return delivermoney;
        }
        else if (this.route == 6)      //其他航线(含毛里求斯)
        {
            int len = packages.size();    //计算行李数目
            for(int i=0;i<len;i++)
            {
                if (packages.get(i).weight > 32 || packages.get(i).weight <= 0)
                {
                   // JOptionPane.showMessageDialog(null, "行李重量不合法");
                    System.out.println("行李重量不合法");
                    return 0;
                } else if (packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 300)
                {
                   // JOptionPane.showMessageDialog(null, "行李尺寸超出");
                    System.out.println("行李尺寸超出");
                    return 0;
                }
            }
            int newlen =len;
            if(baby == 1)
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 115)
                    {
                        newlen--;
                        mark = i;
                        break;
                    }
                }
            }
            // len = newlen;

            //////////////减去会员权限的使用
            //////////////减去会员权限的使用
            if(this.viptype == 1)   //南航明珠金卡会员、天合联盟超级精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight < 20 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 2)   //南航明珠银卡会员、天合联盟精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight < 10 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 3)   //留学生、劳务、海员
            {
                newlen--;
            }
            if (this.cabin == 0) //头等舱
            {
                if(newlen > 3)
                {
                    if(newlen - 3 == 1 )
                    {
                        delivermoney += 450;
                    }
                    else {
                        delivermoney += 450 + 1300 * (newlen -4);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if(this.cabin == 1)   //公务舱
            {
                if(newlen > 3)
                {
                    if(newlen - 3 == 1 )
                    {
                        delivermoney += 450;
                    }
                    else {
                        delivermoney += 450 + 1300 * (newlen -4);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 23 && packages.get(i).weight <= 32 )
                    {
                        delivermoney += 1000;
                    }
                    else if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if (this.cabin == 2)   // 明珠经济舱
            {
                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 450;
                    }
                    else {
                        delivermoney += 450 + 1300 * (newlen -2);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 23 && packages.get(i).weight <= 32 )
                    {
                        delivermoney += 1000;
                    }
                    else if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if (this.cabin == 3)   // 经济舱
            {
                if(newlen > 1)
                {
                    if(newlen - 1 == 1 )
                    {
                        delivermoney += 450;
                    }
                    else {
                        delivermoney += 450 + 1300 * (newlen -2);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 23 && packages.get(i).weight <= 32 )
                    {
                        delivermoney += 1000;
                    }
                    else if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            return delivermoney;
        }
        else if (this.route == 7)      //韩国始发
        {
            int len = packages.size();    //计算行李数目
            for(int i=0;i<len;i++)
            {
                if (packages.get(i).weight > 32 || packages.get(i).weight <= 0)
                {
                   // JOptionPane.showMessageDialog(null, "行李重量不合法");
                    System.out.println("行李重量不合法");
                    return 0;
                }else if (packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 300)
                {
                    //JOptionPane.showMessageDialog(null, "行李尺寸超出");
                    System.out.println("行李尺寸超出");
                    return 0;
                }
            }
            int newlen =len;
            if(baby == 1)
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 115)
                    {
                        newlen--;
                        mark = i;
                        break;
                    }
                }
            }
            // len = newlen;

            //////////////减去会员权限的使用
            if(this.viptype == 1)   //南航明珠金卡会员、天合联盟超级精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 20 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 2)   //南航明珠银卡会员、天合联盟精英
            {
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).weight <= 10 && mark != i)
                    {
                        newlen--;
                        break;
                    }
                }
            }
            else if(this.viptype == 3)   //留学生、劳务、海员
            {
                newlen--;
            }
            if (this.cabin == 0) //头等舱
            {
                if(newlen > 3)
                {
                    if(newlen - 3 == 1 )
                    {
                        delivermoney += 450;
                    }
                    else {
                        delivermoney += 450 + 1300 * (newlen -4);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if(this.cabin == 1)   //公务舱
            {
                if(newlen > 2)
                {
                    if(newlen - 2 == 1 )
                    {
                        delivermoney += 450;
                    }
                    else {
                        delivermoney += 450 + 1300 * (newlen -3);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            else if (this.cabin == 2)
            {
                JOptionPane.showMessageDialog(null,"我没有高级经济舱");
            }
            else if (this.cabin == 3)   // 经济舱
            {
                if(newlen > 1)
                {
                    if(newlen - 1 == 1 )
                    {
                        delivermoney += 450;
                    }
                    else {
                        delivermoney += 450 + 1300 * (newlen -2);
                    }
                }
                for(int i= 0;i < len ; i++)
                {
                    if(packages.get(i).weight > 23 && packages.get(i).weight <= 32 )
                    {
                        delivermoney += 1000;
                    }
                    else if(packages.get(i).weight > 32 && packages.get(i).weight <= 45)
                    {
                        delivermoney += 3000;
                    }
                }
                for(int i = 0;i<len;i++)
                {
                    if(packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) > 158 && packages.get(i).getSum(packages.get(i).length,packages.get(i).width,packages.get(i).height) <= 300)
                    {
                        delivermoney += 1000;
                    }
                }
            }
            return delivermoney;
        }
        return  0;
    }
}

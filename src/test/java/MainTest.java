import org.testng.annotations.Test;

import java.util.Vector;

import static org.testng.Assert.assertEquals;

public class MainTest {
    int expectResult = 0;
    @Test
    public void CalculationTest()
    {
        //////////////国内航线可托运
        Vector<Package> allpackage = new Vector<Package>();
        Calculation cal =  new Calculation();
        Package pac1 = new Package();
        Package pac2 = new Package();
        Package pac3 = new Package();
        Package pac4 = new Package();
        Package pac5 = new Package();
        pac1.AddPackage(20,20,20,20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,800);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(80,20,20,20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(0,20,20,20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,80,20,20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,0,20,20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,80,20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,0,20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,0,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);
        /////////////////////////////////////////
        allpackage.clear();
        pac1.AddPackage(20,20,20,30);
        allpackage.add(pac1);
        //Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        //Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,0);
        assertEquals(450,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,30);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);
        expectResult = cal.GetResult(0,0,1,1000,allpackage,1);
        assertEquals(450,expectResult);
///////////////////////////////////////////////////
        allpackage.clear();
        pac1.AddPackage(20,20,20,30);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);
        pac5.AddPackage(20,20,20,10);
        allpackage.add(pac5);
        expectResult = cal.GetResult(0,0,2,1000,allpackage,0);
        assertEquals(900,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,30);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);
        pac5.AddPackage(20,20,20,10);
        allpackage.add(pac5);
        expectResult = cal.GetResult(0,0,2,1000,allpackage,1);
        assertEquals(750,expectResult);
/////////////////////////////////////////////////////
        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);
        /*pac5.AddPackage(20,20,20,10);
        allpackage.add(pac5);*/
        expectResult = cal.GetResult(0,0,3,1000,allpackage,0);
        assertEquals(450,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);
        /*pac5.AddPackage(20,20,20,10);
        allpackage.add(pac5);*/
        expectResult = cal.GetResult(0,0,3,1000,allpackage,1);
        assertEquals(300,expectResult);
        /////////////////////////////////
        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);
        /*pac5.AddPackage(20,20,20,10);
        allpackage.add(pac5);*/
        expectResult = cal.GetResult(0,0,0,1000,allpackage,0);
        assertEquals(1050,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);
        /*pac5.AddPackage(20,20,20,10);
        allpackage.add(pac5);*/
        expectResult = cal.GetResult(0,0,0,1000,allpackage,1);
        assertEquals(900,expectResult);

        ///////////////////////////////
        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);
        expectResult = cal.GetResult(0,1,0,1000,allpackage,1);
        assertEquals(1200,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);

        expectResult = cal.GetResult(0,2,0,1000,allpackage,1);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        // Package pac2 = new Package();
        pac2.AddPackage(20,20,20,40);
        allpackage.add(pac2);
        // Package pac3 = new Package();
        pac3.AddPackage(20,20,20,20);
        allpackage.add(pac3);
        pac4.AddPackage(20,2,20,10);
        allpackage.add(pac4);
        expectResult = cal.GetResult(0,3,0,1000,allpackage,1);
        assertEquals(1350,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,50);
        allpackage.add(pac1);
        expectResult = cal.GetResult(1,3,0,1000,allpackage,1);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(100,150,100,30);
        allpackage.add(pac1);
        expectResult = cal.GetResult(1,3,0,1000,allpackage,1);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,30);
        allpackage.add(pac1);
        expectResult = cal.GetResult(1,0,1,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,30);
        allpackage.add(pac1);
        expectResult = cal.GetResult(1,0,1,1000,allpackage,1);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,30);
        allpackage.add(pac1);
        expectResult = cal.GetResult(1,0,3,1000,allpackage,0);
        assertEquals(0,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(20,20,20,20);
        pac3.AddPackage(20,20,20,10);
        allpackage.add(pac2);
        allpackage.add(pac3);
        expectResult = cal.GetResult(1,0,1,1000,allpackage,0);
        assertEquals(3000,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(20,20,20,20);
        pac3.AddPackage(20,20,20,10);
        allpackage.add(pac2);
        allpackage.add(pac3);
        expectResult = cal.GetResult(1,0,1,1000,allpackage,0);
        assertEquals(3000,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(20,20,20,20);
        pac3.AddPackage(20,20,20,10);
        pac4.AddPackage(20,20,20,30);
        pac5.AddPackage(20,20,20,20);
        allpackage.add(pac2);
        allpackage.add(pac3);
        allpackage.add(pac4);
        allpackage.add(pac5);
        expectResult = cal.GetResult(1,0,1,1000,allpackage,0);
        assertEquals(4000,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(20,20,20,30);
        pac3.AddPackage(20,20,20,30);
        pac4.AddPackage(20,20,20,30);
        pac5.AddPackage(20,20,20,30);
        allpackage.add(pac2);
        allpackage.add(pac3);
        allpackage.add(pac4);
        allpackage.add(pac5);
        expectResult = cal.GetResult(1,0,1,1000,allpackage,1);
        assertEquals(6000,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(60,60,60,30);
        allpackage.add(pac2);
        expectResult = cal.GetResult(1,0,1,1000,allpackage,0);
        assertEquals(4000,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(20,20,20,20);
        pac3.AddPackage(20,20,20,10);
        //pac4.AddPackage(20,20,20,30);
        //pac5.AddPackage(20,20,20,20);
        allpackage.add(pac2);
        allpackage.add(pac3);
        //allpackage.add(pac4);
        //allpackage.add(pac5);
        expectResult = cal.GetResult(1,3,1,1000,allpackage,0);
        assertEquals(3000,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(20,20,20,20);
        pac3.AddPackage(20,20,20,10);
        //pac4.AddPackage(20,20,20,30);
        //pac5.AddPackage(20,20,20,20);
        allpackage.add(pac2);
        allpackage.add(pac3);
        //allpackage.add(pac4);
        //allpackage.add(pac5);
        expectResult = cal.GetResult(1,3,1,1000,allpackage,1);
        assertEquals(3000,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(20,20,20,20);
        pac3.AddPackage(20,20,20,20);
        pac4.AddPackage(20,20,20,30);
        //pac5.AddPackage(20,20,20,20);
        allpackage.add(pac2);
        allpackage.add(pac3);
        allpackage.add(pac4);
        //allpackage.add(pac5);
        expectResult = cal.GetResult(1,3,1,1000,allpackage,0);
        assertEquals(6000,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(20,20,20,20);
        pac3.AddPackage(20,20,20,10);
        pac4.AddPackage(20,20,20,30);
        pac5.AddPackage(20,20,20,20);
        allpackage.add(pac2);
        allpackage.add(pac3);
        allpackage.add(pac4);
        allpackage.add(pac5);
        expectResult = cal.GetResult(1,3,1,1000,allpackage,1);
        assertEquals(6000,expectResult);

        allpackage.clear();
        pac1.AddPackage(20,20,20,40);
        allpackage.add(pac1);
        pac2.AddPackage(20,20,20,30);
        pac3.AddPackage(20,20,20,10);
        pac4.AddPackage(20,20,20,30);
        pac5.AddPackage(20,20,20,30);
        allpackage.add(pac2);
        allpackage.add(pac3);
        allpackage.add(pac4);
        allpackage.add(pac5);
        expectResult = cal.GetResult(1,3,1,1000,allpackage,0);
        assertEquals(12000,expectResult);
    }
}

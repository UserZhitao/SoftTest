import org.testng.annotations.Test;

import java.util.Vector;

import static org.testng.Assert.assertEquals;

public class PackageTest {
    int expectResult = 0;
    @Test
    public void packagetoTest()
    {
        Calculation cal= new Calculation();
        //Vector<Package> pack = new Vector<Package>();
        Package pac = new Package();
        pac.AddPackage(10.0,10.0,10.0,10.0);
        assertEquals(10,(int)(pac.getLength()));

        Vector<Package> allpackage = new Vector<Package>();
        //Calculation cal =  new Calculation();
        Package pac1 = new Package();
        Package pac2 = new Package();
        Package pac3 = new Package();
        Package pac4 = new Package();
        Package pac5 = new Package();
        allpackage.clear();
        pac1.AddPackage(20,20,20,30);

        assertEquals(20,(int)(pac1.getLength()));

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
        System.out.println("测试成功");
    }
}

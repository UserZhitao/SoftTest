import org.testng.annotations.Test;

import java.util.Vector;

import static org.testng.Assert.assertEquals;

public class CalTest {
    int expectResult = 0;
    @Test
    public void CalculationTest() {
        //////////////国内航线可托运
        Vector<Package> allpackage = new Vector<Package>();
        Calculation cal = new Calculation();
        Package pac1 = new Package();
        Package pac2 = new Package();
        Package pac3 = new Package();
        Package pac4 = new Package();
        Package pac5 = new Package();
        pac1.AddPackage(20, 20, 20, 20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0, 0, 1, 1000, allpackage, 0);
        assertEquals(0, expectResult);

        allpackage.clear();
        pac1.AddPackage(20, 20, 20, 800);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0, 0, 1, 1000, allpackage, 0);
        assertEquals(0, expectResult);

        allpackage.clear();
        pac1.AddPackage(80, 20, 20, 20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0, 0, 1, 1000, allpackage, 0);
        assertEquals(0, expectResult);

        allpackage.clear();
        pac1.AddPackage(0, 20, 20, 20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0, 0, 1, 1000, allpackage, 0);
        assertEquals(0, expectResult);

        allpackage.clear();
        pac1.AddPackage(20, 80, 20, 20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0, 0, 1, 1000, allpackage, 0);
        assertEquals(0, expectResult);

        allpackage.clear();
        pac1.AddPackage(20, 0, 20, 20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0, 0, 1, 1000, allpackage, 0);
        assertEquals(0, expectResult);

        allpackage.clear();
        pac1.AddPackage(20, 20, 80, 20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0, 0, 1, 1000, allpackage, 0);
        assertEquals(0, expectResult);

        allpackage.clear();
        pac1.AddPackage(20, 20, 0, 20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0, 0, 1, 1000, allpackage, 0);
        assertEquals(0, expectResult);

        allpackage.clear();
        pac1.AddPackage(20, 20, 20, 20);
        allpackage.add(pac1);
        expectResult = cal.GetResult(0, 0, 1, 0, allpackage, 0);
        assertEquals(0, expectResult);
    }
}

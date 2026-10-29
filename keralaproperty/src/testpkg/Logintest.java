
package testpkg;

import org.testng.annotations.Test;
import base.Baseclass;
import pagepkg.Loginpage;

public class Logintest extends Baseclass {

    @Test
    public void Main() {

        Loginpage ob = new Loginpage(driver);

        ob.titleverification();
        ob.logoverification();

        ob.start(
            "YOUR_TEST_EMAIL",
            "YOUR_TEST_PASSWORD"
        );

        ob.login();
    }
}

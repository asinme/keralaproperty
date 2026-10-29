package testpkg;

import org.testng.annotations.Test;

import base.Baseclass;
import pagepkg.Registration;

public class Registrationtest extends Baseclass {

    @Test
    public void Main() {

        
        Registration ob = new Registration(driver);

        
        ob.titleverification();

        
        ob.logoverification();

        
        ob.registrationdetails(
                "Test User",
                "testuser123567@example.com",
                "TestPass123!"
        );

       
        ob.register();
    }
}

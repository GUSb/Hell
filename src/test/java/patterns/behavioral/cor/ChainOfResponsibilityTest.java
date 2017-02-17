package patterns.behavioral.cor;

import org.junit.Test;
import patterns.behavioral.cor.handler.Employee;

public class ChainOfResponsibilityTest {

    @Test
    public void testChainOfResponsibility() {

        Employee requirementManager = new RequirementManager();
        Employee javaDeveloper = new Developer();
        Employee tester = new Tester();

        requirementManager.setNextEmployee(javaDeveloper);
        javaDeveloper.setNextEmployee(tester);

        requirementManager.doTheJob();
    }
}

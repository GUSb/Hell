package patterns.behavioral.cor;

import patterns.behavioral.cor.handler.Employee;

public class RequirementManager extends Employee {

    @Override
    public void working() {
        System.out.println("RM is doing the job");
    }
}

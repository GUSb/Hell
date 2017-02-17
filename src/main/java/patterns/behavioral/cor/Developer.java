package patterns.behavioral.cor;

import patterns.behavioral.cor.handler.Employee;

public class Developer extends Employee {

    @Override
    protected void working() {
        System.out.println("Developer is doing the job");
    }
}

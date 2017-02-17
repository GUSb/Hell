package patterns.behavioral.cor;

import patterns.behavioral.cor.handler.Employee;

public class Tester extends Employee {

    @Override
    protected void working() {
        System.out.println("Tester is doing the job");
    }
}

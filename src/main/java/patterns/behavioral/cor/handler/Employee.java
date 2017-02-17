package patterns.behavioral.cor.handler;

/*
*  Gives more than one object an opportunity to handle a request by linking receiving objects together.
*
*  GOF : Gives more than one object an opportunity to handle a request by linking receiving objects together.
*
*  @ Use when :
*       Multiple objects may handle a request and the handler doesn’t have to be a specific object.
*       A set of objects should be able to handle a request with the handler determined at runtime.
*       A request not being handled is an acceptable potential outcome.
* */
public abstract class Employee {

    private Employee nextEmployee;

    public void setNextEmployee(Employee nextEmployee) {
        this.nextEmployee = nextEmployee;
    }


    /*
    *  In real life add some request/task as argument
    *
    * */
    public void doTheJob() {
        working();
        if (nextEmployee != null) {
            nextEmployee.doTheJob();
        }
    }

    protected abstract void working();
}

/*
public class BusinessMailHandler implements EmailHandler{
    private EmailHandler next;
    public void setNext(EmailHandler handler) {
        next = handler;
    }
    public void handleRequest(Email email) {
        if(!email.getFrom().endsWith("@businessaddress.com") {
            next.handleRequest(email);
        }
        else {
            handle request (move to correct folder)
        }
    }
}
*/

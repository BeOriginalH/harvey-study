package clone;

/**
 * @author harvey
 * @date 2020/12/8
 */
public class Student implements Cloneable{

    private String name;

    private Address address;

    @Override
    protected Student clone() throws CloneNotSupportedException {

       Student student = (Student) super.clone();
       student.setAddress((Address) this.address.clone());
       return student;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Address getAddress() {

        return address;
    }

    public void setAddress(Address address) {

        this.address = address;
    }


    public static void main(String[] args) throws CloneNotSupportedException {

        Address address = new Address();
        address.setCity("成都");
        address.setProvince("四川");

        Student student = new Student();
        student.setAddress(address);
        student.setName("harvey");

        Student clone = (Student) student.clone();
        System.out.println(student == clone);
        System.out.println(student.getAddress() == clone.getAddress());

    }
}

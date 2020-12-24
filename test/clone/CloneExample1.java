package clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author harvey
 * @date 2020/12/9
 */
public class CloneExample1{

    static class Address implements Serializable{

        private String city;

        protected String province;

        public Address(String city, String province) {

            this.city = city;
            this.province = province;
        }

        public String getCity() {

            return city;
        }

        public void setCity(String city) {

            this.city = city;
        }

        public String getProvince() {

            return province;
        }

        public void setProvince(String province) {

            this.province = province;
        }
    }

    static class Student implements Serializable{

        private String name;

        private Address address;

        public Student(String name, Address address) {

            this.name = name;
            this.address = address;
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
    }

    public static void main(String[] args) throws Exception {

        Address address = new Address("成都", "四川");

        Student student = new Student("harvey", address);

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bo);
        oos.writeObject(student);
        oos.close();

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        Student student1 = (Student) oi.readObject();

        System.out.println(student == student1);
        System.out.println(student.getAddress() == student1.getAddress());

    }

}

package clone;

/**
 * @author harvey
 * @date 2020/12/9
 */
public class CloneExample{

    static class Address{

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

    static class Student{

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

    public static void main(String[] args) {

        Address address = new Address("成都", "四川");

        Student student = new Student("harvey", address);

        Student student1 = new Student(student.getName(),
            new Address(student.getAddress().getCity(), student.getAddress().getProvince()));

        System.out.println(student == student1);
        System.out.println(student.getAddress() == student1.getAddress());

    }

}

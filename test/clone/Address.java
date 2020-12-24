package clone;

/**
 * @author harvey
 * @date 2020/12/8
 */
public class Address implements Cloneable{

    private String city;

    private String province;

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

    @Override
    protected Address clone() throws CloneNotSupportedException {

        return (Address) super.clone();
    }
}

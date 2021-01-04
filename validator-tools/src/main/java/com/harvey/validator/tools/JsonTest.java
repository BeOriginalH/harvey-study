package com.harvey.validator.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author harvey
 * @date 2020/12/25
 */
public class JsonTest{

    static class User implements Serializable{

        private static final long serialVersionUID = -246121557451169709L;

        private String name = "harvey";

        private int age = 10;

        private List<String> hobbby = Lists.newArrayList("lol", "nba");

        private Address address = new Address();

        private List<Address> addressList = Lists.newArrayList(new Address(), new Address());

        public List<Address> getAddressList() {

            return addressList;
        }

        public void setAddressList(List<Address> addressList) {

            this.addressList = addressList;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {

            this.name = name;
        }

        public int getAge() {

            return age;
        }

        public void setAge(int age) {

            this.age = age;
        }

        public List<String> getHobbby() {

            return hobbby;
        }

        public void setHobbby(List<String> hobbby) {

            this.hobbby = hobbby;
        }

        public Address getAddress() {

            return address;
        }

        public void setAddress(Address address) {

            this.address = address;
        }
    }

    static class Address implements Serializable{

        private static final long serialVersionUID = -8132438129935276839L;

        private String city = "成都";

        private String province = "四川";

        private List<Integer> list = Lists.newArrayList(1,2);

        public List<Integer> getList() {

            return list;
        }

        public void setList(List<Integer> list) {

            this.list = list;
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

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        User user = new User();

        String s = JSONObject.toJSONString(user);

        System.out.println(s);
        String s1 = parseJson(s, null);
        System.out.println(s1);

    }



    private static String parseJson(String jsonStr, String[] words) {

        if (jsonStr.startsWith("{") && jsonStr.endsWith("}")) {

            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            return parseJsonObject(jsonObject, words);
        } else if (jsonStr.startsWith("[") && jsonStr.endsWith("]")) {

            JSONArray objects = JSONObject.parseArray(jsonStr);
            return parseJsonArray(objects, words);
        } else {
            return jsonStr;
        }
    }

    private static String parseJsonObject(JSONObject jsonObject, String[] words) {

        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();

        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : entries) {

            Object value = entry.getValue();
            String key = entry.getKey();

            if (value instanceof JSONObject) {
                String str = parseJsonObject((JSONObject) value, words);
                sb.append(key).append("=").append(str).append(",");

            } else if (value instanceof JSONArray) {
                String str = parseJsonArray((JSONArray) value, words);
                sb.append(key).append("=").append(str).append(",");
            } else {
                sb.append(key).append("=").append(value).append(",");
            }
        }
        String substring = sb.substring(0, sb.lastIndexOf(","));

        return substring + "}";
    }

    private static String parseJsonArray(JSONArray jsonArray, String[] words) {

        Object[] objects = jsonArray.toArray();
        StringBuilder sb = new StringBuilder("[");
        for (Object object : objects) {
            if (object instanceof JSONObject) {
                String s = parseJsonObject((JSONObject) object, words);
                sb.append(s).append(",");
            } else {
                sb.append(object).append(",");
            }
        }
        String substring = sb.substring(0, sb.lastIndexOf(","));

        return substring + "]";
    }
}

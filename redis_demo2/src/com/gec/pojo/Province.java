package com.gec.pojo;

/**
 * @author yangxin
 * @功能描述：
 * @date 2020/12/21
 */
public class Province {

    private Integer id;
    private String name;

    public Province(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Province() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

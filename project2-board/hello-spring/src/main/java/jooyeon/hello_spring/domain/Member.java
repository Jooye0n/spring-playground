package jooyeon.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Member  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 알아서 생성
    private Long id;

    //@Column(name= "username") //컬럼명이 다를경우 어노테이션으로 매핑
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

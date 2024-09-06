package dooyaspring.boothello.cat.model;

public class Cat {
    private Long id;
    private String name;
    private String color;
    private int age;

    public Cat(Long id, String name, String color, int age) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}

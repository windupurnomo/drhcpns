package id.go.bkn.drhcpns.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Education {
    @Id
    private String id;
    private int level;
    private String name;
    private String year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

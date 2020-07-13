package bethlehem.springframework.sfgpetclinic.model;

public class Speciality extends BaseEntity {

    private String description;

    public Speciality(Long id) {
        super(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

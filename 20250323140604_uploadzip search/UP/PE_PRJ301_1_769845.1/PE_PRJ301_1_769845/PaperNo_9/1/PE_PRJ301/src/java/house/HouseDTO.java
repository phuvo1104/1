/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house;

/**
 *
 * @author ASUS
 */
public class HouseDTO {
    private String id ;
    private String name ;
    private String description ;
    private Float size ;
    private boolean status ;

    public HouseDTO() {
    }

    public HouseDTO(String id, String name, String description, Float size, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HouseDTO{" + "id=" + id + ", name=" + name + ", description=" + description + ", size=" + size + ", status=" + status + '}';
    }

  
    
            
}

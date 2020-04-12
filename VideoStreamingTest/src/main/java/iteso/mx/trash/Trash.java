package iteso.mx.trash;

import iteso.mx.trashLevels.TrashLevel;

public class Trash {
    String name;
    TrashLevel value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrashLevel getValue() {
        return value;
    }

    public void setValue(TrashLevel value) {
        this.value = value;
    }
}

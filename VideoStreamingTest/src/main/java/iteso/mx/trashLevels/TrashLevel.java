package iteso.mx.trashLevels;

public abstract class TrashLevel {
    //Depending on the level of the game, this value will vary between his beginner, medium and advanced value
    String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

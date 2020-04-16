package iteso.mx.trashLevels;

public abstract class TrashLevel {
    /**
     * Depending on the level of the game,
     * this value will vary between his beginner, medium and advanced value.
     * */
    private String value;

    /**
     *
     * @param value1 .
     */
    public void setValue(final String value1) {
        this.value = value1;
    }

    /**
     *
     * @return value.
     */
    public String getValue() {
        return value;
    }
}

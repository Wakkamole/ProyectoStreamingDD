package iteso.mx.trash;

import iteso.mx.trashLevels.TrashLevel;

public final class Trash {
    /** String name. */
    private String name;
    /** TrashLevel value. */
    private TrashLevel value;

    /**
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name1 .
     */
    public void setName(final String name1) {
        this.name = name1;
    }

    /**
     *
     * @return value.
     */
    public TrashLevel getValue() {
        return value;
    }

    /**
     *
     * @param value1 .
     */
    public void setValue(final TrashLevel value1) {
        this.value = value1;
    }
}

package iteso.mx.trash;


import java.util.ArrayList;

/**
 * Trash interface.
 */
public interface Trash {
    /** String name. */
    String NAME = "";
    /** TrashLevel value. */
    String VALUE = null;

    /**
     *
     * @return name.
     */
    String getName();

    /**
     *
     * @param name1 .
     */
    void setName(String name1);

    /**
     *
     * @return value.
     */
    String getValue();

    /**
     *
     * @param value1 .
     */
    void setValue(String value1);

    /**
     *
     * @return .
     */
    ArrayList<Trash> loadTrash();
}

package iteso.mx.trash;


import java.util.ArrayList;

public interface Trash {
    /** String name. */
    String name = "";
    /** TrashLevel value. */
    String value = null;

    /**
     *
     * @return name.
     */
    public String getName();

    /**
     *
     * @param name1 .
     */
    public void setName(final String name1);

    /**
     *
     * @return value.
     */
    public String getValue();

    /**
     *
     * @param value1 .
     */
    public void setValue(final String value1);

    public ArrayList<Trash> loadTrash();
}

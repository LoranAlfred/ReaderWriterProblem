/**
 * This class represents the data source.
 *
 * @author Alfred Loran
 * @version 1.0
 */
public class DataSource {

    private int[] data;

    private int pointer;

    /**
     * Constructor.
     *
     * @see 1.0
     */
    public DataSource () {
        pointer = 0;
        data = new int[ 10 ];
    }

    public void setPointer ( int pointer ) {
        this.pointer = pointer;
    }

    public int getPointer () {
        return this.pointer;
    }

    public int getValue ( int index ) {
        return data[ index - 1 ];
    }

    public void setValue ( int index, int value ) {
        data[ index - 1 ] = value;
    }

    /**
     * Main method.
     *
     * @param args The arguments may set.
     * @throws InterruptedException Not expected.
     * @since 1.0
     */
    public static void main ( String[] args )
                    throws InterruptedException {
        DataSource dataSource = new DataSource ();
        Writer writer = new Writer ( dataSource );
        Reader reader = new Reader ( dataSource );
        Thread.sleep ( 1500 );
        writer.interrupt ();
        reader.interrupt ();
    }
}

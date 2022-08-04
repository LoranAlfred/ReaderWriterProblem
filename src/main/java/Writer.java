/**
 * This class represents the writer.
 *
 * @author Alfred Loran
 * @version 1.0
 */
public class Writer extends Thread {

    private DataSource dataSource;

    private int value = 0;

    /**
     * Constructor.
     *
     * @param dataSource The {@link DataSource} to set.
     * @since 1.0
     */
    public Writer ( DataSource dataSource ) {
        this.dataSource = dataSource;
        super.start ();
    }

    @Override
    public void run () {
        try {
            while ( true ) {
                //synchronized ( dataSource ) {
                    int index = dataSource.getPointer ();
                    if ( index < 10 ) {
                        value++;
                        index++;
                        System.out.println ( "Schreiber schreibt:" + value );
                        dataSource.setValue ( index, value );
                        dataSource.setPointer ( index );
                    }
                //}
                Thread.sleep ( 1 );
            }
        } catch ( InterruptedException e ) {
            System.out.println ( "ABBRUCH SCHREIBER!" );
        }
    }
}

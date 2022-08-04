/**
 * This class represents the reader.
 *
 * @author Alfred Loran
 * @version 1.0
 */
public class Reader extends Thread {

    private DataSource dataSource;

    /**
     * Constructor.
     *
     * @param dataSource The {@link DataSource} to set.
     * @since 1.0
     */
    public Reader ( DataSource dataSource ) {
        this.dataSource = dataSource;
        super.start ();
    }

    @Override
    public void run () {
        try {
            while ( true ) {
                //synchronized ( dataSource ) {
                    int index = dataSource.getPointer ();
                    if ( index > 0 ) {
                        for ( int i = 1; i <= index; i++ ) {
                            System.out.println ( "Leser liest:" +
                                            dataSource.getValue ( i ) );
                            for ( int j = 0; j < 10000000; j++ ) {
                            } // Auswertung
                        }
                        dataSource.setPointer ( 0 );
                    }
                //}
                Thread.sleep ( 1 );
            }
        } catch ( InterruptedException e ) {
            System.out.println ( "ABBRUCH LESER!" );
        }
    }
}

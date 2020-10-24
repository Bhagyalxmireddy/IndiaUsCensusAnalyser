package csvbulider;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBulider<E> {

    public  Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuliderException;

    public List<E> getCSVFileList(Reader reader, Class csvClass) throws CSVBuliderException;

}

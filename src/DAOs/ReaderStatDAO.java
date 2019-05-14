package DAOs;

import Stats.ReaderStat;

import java.util.ArrayList;
import java.util.Date;

public class ReaderStatDAO extends DAO {
    public ReaderStatDAO() {
        getInstance();
    }

    public ArrayList<ReaderStat> getReaderStat(Date sd, Date ed){
        ArrayList<ReaderStat> readerStats = new ArrayList<>();
        String sql = "Select * from Borrowings where";


        return readerStats;
    }

}

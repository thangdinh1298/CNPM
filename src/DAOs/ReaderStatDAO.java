package DAOs;

import Entities.Reader;
import Stats.ReaderStat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class ReaderStatDAO extends DAO {
    public ReaderStatDAO() {
        getInstance();
    }

    public ArrayList<ReaderStat> getReaderStat(Date sd, Date ed){
        ArrayList<ReaderStat> readerStats = new ArrayList<>();
        System.out.println(sd);
        System.out.println(ed);
        String sqlBorrowingID = "Select ID, ReaderID from Borrowing where BorrowDate >= ?;";
        HashMap<Integer, Integer> readerNum = new HashMap<>();


        try{
            PreparedStatement ps = conn.prepareStatement(sqlBorrowingID);
            ps.setDate(1,  sd);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID");
//                System.out.println(id);
                String sqlNumBorrowed = "Select COUNT(*) As Total from BorrowingRecord where BorrowingID=?";
                PreparedStatement ps1 = conn.prepareStatement(sqlNumBorrowed);
                ps1.setInt(1, id);
                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
                int numBorrowed = rs1.getInt("Total");
                int readerID = rs.getInt("ReaderID");
                if(readerNum.containsKey(readerID)){
                    readerNum.put(readerID, readerNum.get(readerID) + numBorrowed);
                }
                else{
                    readerNum.put(readerID, numBorrowed);
                }
            }

            String sqlReaderInfo = "Select Fullname, TelephoneNum, Address from Member where ID=?";

            for(HashMap.Entry<Integer, Integer> entry: readerNum.entrySet()){
                PreparedStatement ps2 = conn.prepareStatement(sqlReaderInfo);
                ps2.setInt(1, entry.getKey());
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();

                ReaderStat stat = new ReaderStat(rs2.getString("Fullname")
                        , rs2.getString("Address")
                        , rs2.getString("TelephoneNum"), entry.getValue());

                readerStats.add(stat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return readerStats;
    }

}

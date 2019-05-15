package DAOs;

import Stats.DetailedBorrowingStat;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailedBorrowingDAO extends DAO {
    public DetailedBorrowingDAO() {
        DAO.getInstance();
    }

    public ArrayList<DetailedBorrowingStat> getReaderDetailedStat(Date sd, Date ed, int readerID) {
        ArrayList<DetailedBorrowingStat> stats = new ArrayList<>();

        String sqlBorrowingID = "Select ID, BorrowDate, ReturnDate from Borrowing where " +
                "                       BorrowDate >= ? and ReturnDate <= ? and readerID=?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlBorrowingID);
            ps.setDate(1, sd);
            ps.setDate(2, ed);
            ps.setInt(3, readerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int borrowingID = rs.getInt("ID");
                Date retDate = rs.getDate("ReturnDate");
                Date borrowDate = rs.getDate("BorrowDate");

                String sqlBorrowingRecord = "Select BookItemID from BorrowingRecord where BorrowingID=?";
                PreparedStatement ps1 = conn.prepareStatement(sqlBorrowingRecord);
                ps1.setInt(1, borrowingID);
                ResultSet rs1 = ps1.executeQuery();
                while(rs1.next()){
                    int bookID = rs1.getInt("BookItemID");

                    String sqlBookInfo = "Select Name from BookItem where ID=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlBookInfo);
                    ps2.setInt(1, bookID);
                    ResultSet rs2 = ps2.executeQuery();
                    rs2.next();
                    String bookName = rs2.getString("Name");

                    DetailedBorrowingStat stat = new DetailedBorrowingStat(bookID, bookName, borrowDate, retDate);
                    stats.add(stat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stats;
    }
}
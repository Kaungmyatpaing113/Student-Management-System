package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Teacher;

public class TeacherDAO extends DAO {
    
    // 1. ログイン (Login စစ်ဆေးရန် - မူလကတည်းက ပါပြီးသား)
    public Teacher login(int userId, String userName) throws Exception {
        Teacher teacher = null;
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM TEACHER WHERE USERID = ? AND USERNAME = ?");
        st.setInt(1, userId);
        st.setString(2, userName);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            teacher = new Teacher();
            teacher.setUserId(rs.getInt("USERID"));
            teacher.setUserName(rs.getString("USERNAME"));
            teacher.setMailAddress(rs.getString("MAILADDRESS"));
        }
        st.close(); con.close();
        return teacher;
    }

    // 2. 全件検索 (ဆရာအားလုံးဆွဲထုတ်ရန်)
    public List<Teacher> findAll() throws Exception {
        List<Teacher> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM TEACHER");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Teacher t = new Teacher();
            t.setUserId(rs.getInt("USERID"));
            t.setUserName(rs.getString("USERNAME"));
            t.setMailAddress(rs.getString("MAILADDRESS"));
            list.add(t);
        }
        st.close(); con.close();
        return list;
    }

    // 3. 検索 (နာမည်နဲ့ ရှာရန်)
    public List<Teacher> search(String keyword) throws Exception {
        List<Teacher> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM TEACHER WHERE USERNAME LIKE ?");
        st.setString(1, "%" + keyword + "%");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Teacher t = new Teacher();
            t.setUserId(rs.getInt("USERID"));
            t.setUserName(rs.getString("USERNAME"));
            t.setMailAddress(rs.getString("MAILADDRESS"));
            list.add(t);
        }
        st.close(); con.close();
        return list;
    }

    // 4. 1件検索 (ID နဲ့ တိတိကျကျဆွဲထုတ်ရန် - Update အတွက်)
    public Teacher findById(int userId) throws Exception {
        Teacher t = null;
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM TEACHER WHERE USERID = ?");
        st.setInt(1, userId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            t = new Teacher();
            t.setUserId(rs.getInt("USERID"));
            t.setUserName(rs.getString("USERNAME"));
            t.setMailAddress(rs.getString("MAILADDRESS"));
        }
        st.close(); con.close();
        return t;
    }

    // 5. 追加 (အသစ်ထည့်ရန်)
    public int insert(Teacher t) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("INSERT INTO TEACHER VALUES(?, ?, ?)");
        st.setInt(1, t.getUserId());
        st.setString(2, t.getUserName());
        st.setString(3, t.getMailAddress());
        int line = st.executeUpdate();
        st.close(); con.close();
        return line;
    }

    // 6. 更新 (ပြင်ဆင်ရန်)
    public int update(Teacher t) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("UPDATE TEACHER SET USERNAME=?, MAILADDRESS=? WHERE USERID=?");
        st.setString(1, t.getUserName());
        st.setString(2, t.getMailAddress());
        st.setInt(3, t.getUserId());
        int line = st.executeUpdate();
        st.close(); con.close();
        return line;
    }

    // 7. 削除 (ဖျက်ရန်)
    public int delete(int userId) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("DELETE FROM TEACHER WHERE USERID=?");
        st.setInt(1, userId);
        int line = st.executeUpdate();
        st.close(); con.close();
        return line;
    }
}
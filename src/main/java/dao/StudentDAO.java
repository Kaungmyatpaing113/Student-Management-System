package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {
    
    // 1. 全件検索 (အကုန်ဆွဲထုတ်ရန်)
    public List<Student> findAll() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENT");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Student s = new Student();
            s.setStudentId(rs.getInt("STUDENTID"));
            s.setStudentName(rs.getString("STUDENTNAME"));
            s.setCourse(rs.getString("COURSE"));
            list.add(s);
        }
        st.close(); con.close();
        return list;
    }

    // 2. 検索 (နာမည်နဲ့ ရှာရန်)
    public List<Student> search(String keyword) throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENT WHERE STUDENTNAME LIKE ?");
        st.setString(1, "%" + keyword + "%");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Student s = new Student();
            s.setStudentId(rs.getInt("STUDENTID"));
            s.setStudentName(rs.getString("STUDENTNAME"));
            s.setCourse(rs.getString("COURSE"));
            list.add(s);
        }
        st.close(); con.close();
        return list;
    }

    // 3. 1件検索 (ID နဲ့ တိတိကျကျဆွဲထုတ်ရန် - Update အတွက်)
    public Student findById(int studentId) throws Exception {
        Student s = null;
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENT WHERE STUDENTID = ?");
        st.setInt(1, studentId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            s = new Student();
            s.setStudentId(rs.getInt("STUDENTID"));
            s.setStudentName(rs.getString("STUDENTNAME"));
            s.setCourse(rs.getString("COURSE"));
        }
        st.close(); con.close();
        return s;
    }

    // 4. 追加 (အသစ်ထည့်ရန်)
    public int insert(Student s) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("INSERT INTO STUDENT VALUES(?, ?, ?)");
        st.setInt(1, s.getStudentId());
        st.setString(2, s.getStudentName());
        st.setString(3, s.getCourse());
        int line = st.executeUpdate();
        st.close(); con.close();
        return line;
    }

    // 5. 更新 (ပြင်ဆင်ရန်)
    public int update(Student s) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("UPDATE STUDENT SET STUDENTNAME=?, COURSE=? WHERE STUDENTID=?");
        st.setString(1, s.getStudentName());
        st.setString(2, s.getCourse());
        st.setInt(3, s.getStudentId());
        int line = st.executeUpdate();
        st.close(); con.close();
        return line;
    }

    // 6. 削除 (ဖျက်ရန်)
    public int delete(int studentId) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("DELETE FROM STUDENT WHERE STUDENTID=?");
        st.setInt(1, studentId);
        int line = st.executeUpdate();
        st.close(); con.close();
        return line;
    }
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Course;

public class CourseDAO extends DAO {

    // 1. 全件検索 (သင်တန်းအားလုံးဆွဲထုတ်ရန်)
    public List<Course> findAll() throws Exception {
        List<Course> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM COURSE");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Course c = new Course();
            c.setCourseId(rs.getInt("COURSEID"));
            c.setCourseName(rs.getString("COURSENAME"));
            list.add(c);
        }
        st.close(); con.close();
        return list;
    }

    // 2. 1件検索 (ID နဲ့ တိတိကျကျဆွဲထုတ်ရန် - Update အတွက်)
    public Course findById(int courseId) throws Exception {
        Course c = null;
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM COURSE WHERE COURSEID = ?");
        st.setInt(1, courseId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            c = new Course();
            c.setCourseId(rs.getInt("COURSEID"));
            c.setCourseName(rs.getString("COURSENAME"));
        }
        st.close(); con.close();
        return c;
    }

    // 3. 追加 (အသစ်ထည့်ရန်)
    public int insert(Course c) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("INSERT INTO COURSE VALUES(?, ?)");
        st.setInt(1, c.getCourseId());
        st.setString(2, c.getCourseName());
        int line = st.executeUpdate();
        st.close(); con.close();
        return line;
    }

    // 4. 更新 (ပြင်ဆင်ရန်)
    public int update(Course c) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("UPDATE COURSE SET COURSENAME=? WHERE COURSEID=?");
        st.setString(1, c.getCourseName());
        st.setInt(2, c.getCourseId());
        int line = st.executeUpdate();
        st.close(); con.close();
        return line;
    }

    // 5. 削除 (ဖျက်ရန်)
    public int delete(int courseId) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("DELETE FROM COURSE WHERE COURSEID=?");
        st.setInt(1, courseId);
        int line = st.executeUpdate();
        st.close(); con.close();
        return line;
    }
}
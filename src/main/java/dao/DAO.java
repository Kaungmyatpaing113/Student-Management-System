package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
    static DataSource ds;

    // Database နဲ့ ချိတ်ဆက်ဖို့ Connection တောင်းတဲ့ Method
    public Connection getConnection() throws Exception {
        if (ds == null) {
            InitialContext ic = new InitialContext();
            // context.xml ထဲက name="jdbc/kouka" ကို လှမ်းရှာတာပါ
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/kouka");
        }
        return ds.getConnection();
    }
}
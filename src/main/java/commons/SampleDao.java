package commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SampleDao {
    public List<SampleSqlModel> selectDetails(Integer testId) throws InterruptedException {
        final List<SampleSqlModel> entries = new ArrayList<>();


        String query = "Select * from sample";

        System.out.println("****" + query);
        getJdbcTemplate().query(query, new Object[] {testid},new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                do {
                    SampleSqlModel sampleSqlModel = new SampleSqlModel();
                    sampleSqlModel.settestID(resultSet.getInt("testID"));
                    sampleSqlModel.setTestname(resultSet.getString("Testname"));
                    sampleSqlModel.setTestage(resultSet.getInt("Testage"));

                    entries.add(sampleSqlModel);
                } while (resultSet.next());

            }
        });
        return entries;
    }

}

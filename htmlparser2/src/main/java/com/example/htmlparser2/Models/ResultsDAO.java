package com.example.htmlparser2.Models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.TreeMap;


@Component
public class ResultsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;


        public void saveResults(Map<String, Long> results) {
            for (Map.Entry<String, Long> entry :results.entrySet()) {
                jdbcTemplate.update("insert into results set quantity=?, word=?",
                        entry.getValue(), entry.getKey()
                );
            }
        }

    public Map<String,Long> getResultsMap() {
        return jdbcTemplate.query("select word,quantity from results", (ResultSetExtractor<Map>) rs -> {
            Map<String, Long> mapRet = new TreeMap<>();
            while (rs.next()) {
                mapRet.put(rs.getString("word"), rs.getLong("quantity"));
            }
            return mapRet;
        })
    ;}

    public void deleteAll() {
            jdbcTemplate.update("delete from results");
    }
}
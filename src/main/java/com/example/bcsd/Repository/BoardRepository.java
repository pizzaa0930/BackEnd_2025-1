package com.example.bcsd.Repository;

import com.example.bcsd.model.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Board> boardRowMapper = new RowMapper<Board>() {
        @Override
        public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
            Board board = new Board();
            board.setId(rs.getLong("id"));
            board.setName(rs.getString("name"));
            return board;
        }
    };

    public List<Board> findAll() {
        String sql = "SELECT * FROM board";
        return jdbcTemplate.query(sql, boardRowMapper);
    }

    public Board findById(Long id) {
        String sql = "SELECT * FROM board WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, boardRowMapper, id);
    }

    public void save(Board board) {
        String sql = "INSERT INTO board (name) VALUES (?)";
        jdbcTemplate.update(sql, board.getName());
    }

    public void update(Board board) {
        String sql = "UPDATE board SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, board.getName(), board.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM board WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

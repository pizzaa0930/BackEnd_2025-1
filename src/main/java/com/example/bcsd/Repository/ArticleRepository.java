package com.example.bcsd.Repository;

import com.example.bcsd.model.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArticleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ArticleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Article> articleRowMapper = new RowMapper<Article>() {
        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            Article article = new Article();
            article.setId(rs.getLong("id"));
            article.setAuthorID(rs.getLong("author_id"));
            article.setBoardID(rs.getLong("board_id"));
            article.setTitle(rs.getString("title"));
            article.setContent(rs.getString("content"));
            article.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
            article.setModifiedDate(rs.getTimestamp("modified_date").toLocalDateTime());
            return article;
        }
    };

    public List<Article> findAll() {
        String sql = "SELECT * FROM article";
        return jdbcTemplate.query(sql, articleRowMapper);
    }

    public Article findById(Long id) {
        String sql = "SELECT * FROM article WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, articleRowMapper, id);
    }

    public void save(Article article) {
        String sql = "INSERT INTO article (author_id, board_id, title, content, created_date, modified_date) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                article.getAuthorID(),
                article.getBoardID(),
                article.getTitle(),
                article.getContent(),
                article.getCreatedDate(),
                article.getModifiedDate());
    }

    public void update(Article article) {
        String sql = "UPDATE article SET author_id = ?, board_id = ?, title = ?, content = ?, modified_date = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                article.getAuthorID(),
                article.getBoardID(),
                article.getTitle(),
                article.getContent(),
                article.getModifiedDate(),
                article.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM article WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

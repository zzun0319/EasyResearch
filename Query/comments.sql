CREATE TABLE comments (
	comment_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    writer VARCHAR(14) NOT NULL,
    research_id INT NOT NULL,
    content VARCHAR(500),
    write_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
    FOREIGN KEY (writer) REFERENCES er_users(user_id) ON DELETE NO ACTION,
    FOREIGN KEY (research_id) REFERENCES research(research_id) ON DELETE CASCADE
);

DROP TABLE comments;

SELECT * FROM comments;

DESC comments;
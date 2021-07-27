CREATE TABLE research (
	research_id INT PRIMARY KEY AUTO_INCREMENT,
    research_type VARCHAR(20) NOT NULL,
    title VARCHAR(100) NOT NULL,
    purpose VARCHAR(500) NOT NULL,
    method VARCHAR(4000) NOT NULL,
    researcher VARCHAR(14) NOT NULL,
    reward_type VARCHAR(8) NOT NULL,
	reward_value INT NOT NULL,
    duration INT NOT NULL,
    permission BOOL NOT NULL,
    file_path VARCHAR(200) NOT NULL,
    FOREIGN KEY (researcher) REFERENCES er_users(user_id) ON DELETE RESTRICT
);
ALTER TABLE research MODIFY reward_type VARCHAR(8) NOT NULL;
-- DROP TABLE research;
DESC research;

-- INSERT INTO research (research_type, researcher, title, purpose, method, reward_type, reward_value, duration, permission, file_path)
-- VALUES ('설문', )

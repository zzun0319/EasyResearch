CREATE TABLE class (
	class_id INT PRIMARY KEY AUTO_INCREMENT,
    instructor_name VARCHAR(5) NOT NULL,
    instructor_id VARCHAR(30) NOT NULL,
    class_name VARCHAR(30) NOT NULL,
    class_schedule VARCHAR(20) NOT NULL,
    research_credit INT NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES er_users(user_id) ON DELETE CASCADE
);

-- DROP TABLE class;

SELECT * FROM class;
CREATE TABLE attendee (
	attendee_num INT PRIMARY KEY AUTO_INCREMENT,
    student_id VARCHAR(14) NOT NULL,
    class_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES er_users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (class_id) REFERENCES class(class_id) ON DELETE CASCADE
);

DESC attendee;

SELECT * FROM attendee;
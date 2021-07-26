CREATE TABLE participation(
	participation_num INT PRIMARY KEY AUTO_INCREMENT,
    student_id VARCHAR(14) NOT NULL,
    timeslot_num INT NOT NULL,
    participation_state VARCHAR(6) NOT NULL DEFAULT '대기중',
    FOREIGN KEY (student_id) REFERENCES er_users(user_id) ON DELETE RESTRICT,
    FOREIGN KEY (timeslot_num) REFERENCES timeslot(slot_num) ON DELETE CASCADE
);

DESC participation;

SELECT * FROM participation;
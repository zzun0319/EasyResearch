CREATE DATABASE easy_research;

CREATE USER 'ER_admin' IDENTIFIED BY 'abc1234';

USE easy_research;

ALTER TABLE univ_members ADD major VARCHAR(10);
ALTER TABLE univ_members ADD is_using BOOL NOT NULL DEFAULT FALSE;

UPDATE univ_members SET is_using=true WHERE id_number='200110001'; -- 트리거 걸어야겠다. 회원가입 완료시에 이거 true로 바뀌도록, ER_admin 이 계정에 UPDATE 권한을 줘야하는건가?
UPDATE univ_members SET is_using=true WHERE id_number='200110006';
UPDATE univ_members SET is_using=true WHERE id_number='200220011';
UPDATE univ_members SET is_using=true WHERE id_number='201730011';
UPDATE univ_members SET is_using=true WHERE id_number='202040011';
UPDATE univ_members SET is_using=true WHERE id_number='202050011';

SELECT * FROM univ_members;

GRANT SELECT ON easy_research.univ_members TO 'ER_admin';
GRANT UPDATE ON easy_research.univ_members TO 'ER_admin';
COMMIT;

CREATE TABLE comments (
	comment_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    writer VARCHAR(14) NOT NULL,
    research_id INT NOT NULL,
    content VARCHAR(500),
    FOREIGN KEY (writer) REFERENCES er_users(user_id) ON DELETE NO ACTION,
    FOREIGN KEY (research_id) REFERENCES research(research_id) ON DELETE CASCADE
);

SELECT * FROM comments;

GRANT ALL PRIVILEGES ON easy_research.er_users TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.research TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.class TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.attendee TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.research_place TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.timeslot TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.participation TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.comments TO 'ER_admin';
CREATE TABLE er_users (
	user_id VARCHAR(14) PRIMARY KEY,
    user_pw VARCHAR(20) NOT NULL,
    univ_id_num VARCHAR(10) NOT NULL UNIQUE,
    email VARCHAR(30) NOT NULL UNIQUE,
    tel VARCHAR(11) NOT NULL UNIQUE,
    major VARCHAR(20),
    user_type VARCHAR(10) NOT NULL,
    participation_right BOOL NOT NULL DEFAULT FALSE,
    setup_right BOOL NOT NULL DEFAULT FALSE,
    class_regi_right BOOL NOT NULL DEFAULT FALSE,
    permission_right BOOL NOT NULL DEFAULT FALSE,
    FOREIGN KEY (univ_id_num) REFERENCES univ_members(id_number) ON DELETE NO ACTION
);

ALTER TABLE er_users ADD email_hash VARCHAR(64);
ALTER TABLE er_users ADD email_verification BOOL NOT NULL DEFAULT FALSE;
ALTER TABLE er_users ADD user_name VARCHAR(5) NOT NULL;

ALTER TABLE er_users DROP userName;

TRUNCATE TABLE er_users;

-- DROP TABLE er_users;

DESC er_users;

SELECT * FROM er_users;

DELETE FROM er_users WHERE user_id='teacher5';
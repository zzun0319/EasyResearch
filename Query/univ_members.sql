
CREATE TABLE univ_members ( -- 학교 구성원들의 정보가 담긴 DB의 View라고 가정하고, 가입시 여기 정보와 비교해서 정보가 모두 일치하면 가입 성공됨
	id_number VARCHAR(14) PRIMARY KEY,
	registered_name VARCHAR(5) NOT NULL,
    univ_email VARCHAR(30) NOT NULL UNIQUE,
	sort VARCHAR(10) NOT NULL CHECK (sort in ('지도교수', '교수', '강사', '박사과정대학원생', '석사과정대학원생', '학부생'))
);

INSERT INTO univ_members VALUES ('200110001', '교수1', 'prof1@ajou.ac.kr', '지도교수');
INSERT INTO univ_members VALUES ('200110002', '교수2', 'prof2@ajou.ac.kr', '지도교수');
INSERT INTO univ_members VALUES ('200110003', '교수3', 'prof3@ajou.ac.kr', '지도교수');
INSERT INTO univ_members VALUES ('200110004', '교수4', 'prof4@ajou.ac.kr', '지도교수');
INSERT INTO univ_members VALUES ('200110005', '교수5', 'prof5@ajou.ac.kr', '지도교수');

INSERT INTO univ_members VALUES ('200110006', '교수6', 'prof6@ajou.ac.kr', '교수'), 
('200110007', '교수7', 'prof7@ajou.ac.kr', '교수'), ('200110008', '교수8', 'prof8@ajou.ac.kr', '교수'),
('200110009', '교수9', 'prof9@ajou.ac.kr', '교수'), ('200110010', '교수10', 'prof10@ajou.ac.kr', '교수');

INSERT INTO univ_members VALUES ('200220011', '강사1', 'instructor1@ajou.ac.kr', '강사'), 
('200320007', '강사2', 'instructor2@ajou.ac.kr', '강사'), ('201020008', '강사3', 'instructor3@ajou.ac.kr', '강사'),
('202020009', '강사4', 'instructor4@ajou.ac.kr', '강사'), ('201920010', '강사5', 'instructor5@ajou.ac.kr', '강사');

INSERT INTO univ_members VALUES ('201730011', '박사1', 'doctor1@ajou.ac.kr', '박사과정대학원생'), 
('201830015', '박사2', 'doctor2@ajou.ac.kr', '박사과정대학원생'), ('201830027', '박사3', 'doctor3@ajou.ac.kr', '박사과정대학원생'),
('202030019', '박사4', 'doctor4@ajou.ac.kr', '박사과정대학원생'), ('201930210', '박사5', 'doctor5@ajou.ac.kr', '박사과정대학원생');

INSERT INTO univ_members VALUES ('202040011', '석사1', 'master1@ajou.ac.kr', '석사과정대학원생'), 
('202040115', '석사2', 'master2@ajou.ac.kr', '석사과정대학원생'), ('202140057', '석사3', 'master3@ajou.ac.kr', '석사과정대학원생'),
('202140019', '석사4', 'master4@ajou.ac.kr', '석사과정대학원생'), ('202140210', '석사5', 'master5@ajou.ac.kr', '석사과정대학원생');

INSERT INTO univ_members VALUES ('202050011', '학부생1', 'student1@ajou.ac.kr', '학부생'), 
('202050115', '학부생2', 'student2@ajou.ac.kr', '학부생'), ('202150057', '학부생3', 'student3@ajou.ac.kr', '학부생'),
('202150019', '학부생4', 'student4@ajou.ac.kr', '학부생'), ('202150210', '학부생5', 'junhee0319@ajou.ac.kr', '학부생');

SELECT * FROM univ_members ORDER BY sort;
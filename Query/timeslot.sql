CREATE TABLE timeslot(
	slot_num INT PRIMARY KEY AUTO_INCREMENT,
    research_id INT NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    place_name VARCHAR(10) NOT NULL,
    FOREIGN KEY (research_id) REFERENCES research(research_id) ON DELETE CASCADE,
    FOREIGN KEY (place_name) REFERENCES research_place(place_name) ON DELETE NO ACTION
);

ALTER TABLE timeslot ADD apply_cnt INT NOT NULL DEFAULT 0;

DESC timeslot;

SELECT * FROM timeslot;

SELECT COUNT(*) FROM
(
	SELECT * FROM timeslot WHERE TIMESTAMP(start_time) >= TIMESTAMP("2021-08-09 03:07:00") AND place_name = '율곡관 371호'
)ts
WHERE ((TIMESTAMP("2021-08-11 02:05:00") < TIMESTAMP(start_time)) AND (TIMESTAMP("2021-08-11 02:51:00") < TIMESTAMP(start_time)) 
OR (TIMESTAMP("2021-08-11 02:05:00") > TIMESTAMP(end_time)) AND (TIMESTAMP("2021-08-11 02:51:00") > TIMESTAMP(end_time)));



SELECT COUNT(*) FROM
(
	SELECT * FROM timeslot WHERE TIMESTAMP(start_time) >= TIMESTAMP("2021-08-09 02:00:00") AND place_name = '율곡관 371호'
)ts;

SELECT COUNT(*) FROM timeslot WHERE TIMESTAMP(start_time) >= TIMESTAMP("2021-08-09 03:07:00") AND place_name = '율곡관 371호';

SELECT COUNT(*) FROM timeslot t JOIN research r ON t.research_id = r.research_id WHERE r.research_id=4;

SELECT t.*, r.*, FROM timeslot t JOIN research r ON t.research_id = r.research_id WHERE r.research_id=4	ORDER BY t.slot_num DESC LIMIT 10 OFFSET 0;

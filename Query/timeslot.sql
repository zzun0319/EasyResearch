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

SELECT * FROM
(
	SELECT * FROM timeslot WHERE TIMESTAMP(start_time) >= TIMESTAMP("2021-08-09 02:00:00") AND place_name = '율곡관 371호'
)
WHERE TIMESTAMP(start_time) < TIMESTAMP("2021-08-11 11:11:00");
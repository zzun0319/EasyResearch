CREATE TABLE timeslot(
	slot_num INT PRIMARY KEY AUTO_INCREMENT,
    research_id INT NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    place_name VARCHAR(10) NOT NULL,
    FOREIGN KEY (research_id) REFERENCES research(research_id) ON DELETE CASCADE,
    FOREIGN KEY (place_name) REFERENCES research_place(place_name) ON DELETE NO ACTION
);

DESC timeslot;

SELECT * FROM timeslot;
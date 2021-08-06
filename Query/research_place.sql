CREATE TABLE research_place (
	place_name VARCHAR(10) PRIMARY KEY,
    max_people INT NOT NULL
);

DESC research_place;
SELECT * FROM research_place;

INSERT INTO research_place VALUES ('율곡관 371호', 4);
INSERT INTO research_place VALUES ('종합관 101호', 2);
INSERT INTO research_place VALUES ('율곡관 412호', 6);
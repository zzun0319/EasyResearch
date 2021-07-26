CREATE DATABASE easy_research;

CREATE USER 'ER_admin' IDENTIFIED BY 'abc1234';

USE easy_research;

GRANT SELECT ON easy_research.univ_members TO 'ER_admin';

GRANT ALL PRIVILEGES ON easy_research.er_users TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.research TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.class TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.attendee TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.research_place TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.timeslot TO 'ER_admin';
GRANT ALL PRIVILEGES ON easy_research.participation TO 'ER_admin';